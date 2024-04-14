package com.frankaboagye.restdemojpamysql.monitoring;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Controller
public class DummyServiceHealthCheck implements HealthIndicator, EnvironmentAware {


    private Environment env;
    @Override
    public Health health() {
        try {
            if(isServiceUp()){
                return Health.up().withDetail("Dummy Service", "is working").build();
            }else{
                return Health.down().withDetail("Dummy Service", "not working").build();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isServiceUp() throws IOException{
        String address = env.getProperty("dummyService.address");
        String port = env.getProperty("dummyService.port");
        System.out.println("Address: " + address + " Port: " + port);
        return isAddressReachable(address, Integer.parseInt(port), 3000);
    }

    private static boolean isAddressReachable(String address, int port, int timeout) throws IOException {
        try (Socket isSocket = new Socket()) {
            isSocket.connect(new InetSocketAddress(address, port), timeout);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Autowired
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
