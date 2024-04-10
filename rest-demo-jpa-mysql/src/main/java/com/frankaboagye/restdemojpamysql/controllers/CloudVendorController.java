package com.frankaboagye.restdemojpamysql.controllers;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import com.frankaboagye.restdemojpamysql.services.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/test")
    public String toTest(){
        return "working...";
    }

    @GetMapping("/getVendor/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") Integer vendorId){
        return this.cloudVendorService.getCloudVendor(vendorId);
    }

    @GetMapping("/getVendor/all")
    public List<CloudVendor> getAllCloudVendorDetails(){
        return this.cloudVendorService.getAllCloudVendors();
    }

    @PostMapping("/addVendor")
    public String addCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return this.cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping("/updateVendor/{vendorId}")
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor, @PathVariable("vendorId") Integer vendorId){
        return this.cloudVendorService.updateCloudVendor(cloudVendor, vendorId);
    }

    @DeleteMapping("/deleteVendor/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") Integer vendorId){
        return this.cloudVendorService.deleteCloudVendor(vendorId);
    }


}
