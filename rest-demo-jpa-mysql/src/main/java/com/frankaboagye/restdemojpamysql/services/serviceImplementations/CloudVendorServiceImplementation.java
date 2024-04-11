package com.frankaboagye.restdemojpamysql.services.serviceImplementations;

import com.frankaboagye.restdemojpamysql.exceptions.CloudVendorNotFoundException;
import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import com.frankaboagye.restdemojpamysql.repositories.CloudVendorRepository;
import com.frankaboagye.restdemojpamysql.services.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImplementation(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        this.cloudVendorRepository.save(cloudVendor);
        return "created cloud vendor";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor, Integer vendorId) {
        String message = "cannot update";

        Optional<CloudVendor> cloudVendorOptional=  this.cloudVendorRepository.findById(vendorId);
        if(cloudVendorOptional.isPresent()){
            CloudVendor c = cloudVendorOptional.get();
            c.setVendorName(cloudVendor.getVendorName());
            c.setVendorAddress(cloudVendor.getVendorAddress());
            c.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
            this.cloudVendorRepository.save(c);
            message = "updated cloud vendor";
        }

        return message ;
    }

    @Override
    public String deleteCloudVendor(Integer vendorId) {
        String message = "cannot delete vendor";
        Optional<CloudVendor> cloudVendorOptional = this.cloudVendorRepository.findById(vendorId);
        if(cloudVendorOptional.isPresent()){
            this.cloudVendorRepository.deleteById(vendorId);
            message = "deleted cloud vendor";
        }
        return message;

    }

    @Override
    public CloudVendor getCloudVendor(Integer vendorId) {
        Optional<CloudVendor> cloudVendorOptional =  this.cloudVendorRepository.findById(vendorId);
        // what of when we do not get a result??
        if(cloudVendorOptional.isEmpty()){
            throw new CloudVendorNotFoundException("Does not Exist");
        }
        return cloudVendorOptional.get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return this.cloudVendorRepository.findAll();
    }
}
