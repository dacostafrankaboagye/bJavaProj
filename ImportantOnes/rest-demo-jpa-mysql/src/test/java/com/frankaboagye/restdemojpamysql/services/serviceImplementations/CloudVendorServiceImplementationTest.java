package com.frankaboagye.restdemojpamysql.services.serviceImplementations;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import com.frankaboagye.restdemojpamysql.repositories.CloudVendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplementationTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;

    private CloudVendorServiceImplementation cloudVendorServiceImplementation;

    CloudVendor cloudVendor;
    CloudVendor cloudVendor2;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorServiceImplementation = new CloudVendorServiceImplementation(cloudVendorRepository);
        cloudVendor = new CloudVendor(1L, "TESTER-CLOUD", "test-san-diego", "+022-33-4");
        cloudVendor2 = new CloudVendor(1L, "TESTER-CLOUD", "test-califonia", "+022-33-4");


    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorServiceImplementation.createCloudVendor(cloudVendor)).isEqualTo("created cloud vendor");

    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class);


        when(cloudVendorRepository.findById(1L)).thenReturn(Optional.ofNullable(cloudVendor));
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorServiceImplementation.updateCloudVendor(cloudVendor2, cloudVendor.getVendorId())).isEqualTo("updated cloud vendor");

    }

    @Test
    void testDeleteCloudVendor() {
        // note the delete method -> (the deleteByID() -> is void: does not return anything )
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class, Mockito.CALLS_REAL_METHODS);

        when(cloudVendorRepository.findById(1L)).thenReturn(Optional.ofNullable(cloudVendor));

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());

        assertThat(cloudVendorServiceImplementation.deleteCloudVendor(1L)).isEqualTo("deleted cloud vendor");
    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class);


        when(cloudVendorRepository.findById(1L)).thenReturn(Optional.ofNullable(cloudVendor));

        assertThat(cloudVendorServiceImplementation.getCloudVendor(1L).getVendorName()).isEqualTo(cloudVendor.getVendorName());

    }

    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class);
        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );

        assertThat(cloudVendorServiceImplementation.getAllCloudVendors().get(0).getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());


    }
}

/*

- We are not supposed to make the service layer talk to the database
- So how do we get database responses?
    - Answer: Mock it

    // So we mock the entire Repository Layer

close all the resources after the execution - > autocloseable

other calls to other layers needs to be mocked


//

void testGetByVendorName(){
    mock(CloudVendor.class);
    mock(CloudVendorRepository.class);

    when(cloudVendorRepository.findByVendorName("abc")).thenReturn(
        new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
    );

    assertThat(cloudVendorService.getByVendorName("abc").get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
}

 */