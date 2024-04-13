package com.frankaboagye.restdemojpamysql.repositories;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor(
                1L,
                "cloud-company-A",
                "Los Angeles",
                "+777 777 777"
        );

        cloudVendorRepository.save(cloudVendor);

    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // success test case
    @Test
    void testFindByVendorName_Found(){
        CloudVendor cloudVendorToCheck =  cloudVendorRepository.findByVendorName("cloud-company-A").get(0);
        assertThat(cloudVendorToCheck.getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());
        assertThat(cloudVendorToCheck.getVendorName()).isEqualTo(cloudVendor.getVendorName());

    }

    // failure test case
    @Test
    void testFindByVendorName_NOTFound(){
        List<CloudVendor> cloudVendorToCheck =  cloudVendorRepository.findByVendorName("GCP");
        assertThat(cloudVendorToCheck.isEmpty()).isTrue(); // because there is no GCP in the db
    }
}

/*
Something should be provided / given -> when it is executed -> there is some output
// given - when - then


// all initialization should go inside a method called - setUp() : e.g. like populating something
// after you are down - you will clear and doing other stuffs - it should go inside of -> tearDown() method

 */
