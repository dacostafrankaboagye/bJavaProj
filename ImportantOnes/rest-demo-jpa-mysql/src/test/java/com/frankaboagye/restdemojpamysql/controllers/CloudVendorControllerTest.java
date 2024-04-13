package com.frankaboagye.restdemojpamysql.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import com.frankaboagye.restdemojpamysql.services.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*

We should be mocking all web related stuffs
we should check whether all those URLS are working fine or not
 */

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CloudVendorService cloudVendorService;

    List<CloudVendor> cloudVendorList = new ArrayList<>();
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor(1L, "Tester-Oracle", "Bay Area", "+67211 111");
        cloudVendorTwo = new CloudVendor(2L, "Tester-GCP", "Bornx", "+550 98 11");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor(1L)).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudVendor/getVendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllCloudVendorDetails() throws Exception{
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudVendor/getVendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void addCloudVendorDetails() throws Exception {
        //convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);


        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("created cloud vendor");
        this.mockMvc.perform(post("/cloudVendor/addVendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void updateCloudVendorDetails() throws Exception {
        //convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);


        when(cloudVendorService.updateCloudVendor(cloudVendorOne, 1L)).thenReturn("updated cloud vendor");
        this.mockMvc.perform(put("/cloudVendor/updateVendor/1").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void deleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor(1L)).thenReturn("deleted cloud vendor");
        this.mockMvc.perform(delete("/cloudVendor/deleteVendor/1")).andDo(print()).andExpect(status().isOk());

    }
}