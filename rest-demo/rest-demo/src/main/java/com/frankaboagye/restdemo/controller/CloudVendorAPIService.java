package com.frankaboagye.restdemo.controller;

import com.frankaboagye.restdemo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;


// hardcoding stuffs

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendor(@PathVariable("vendorId") String vendorId){
        return cloudVendor;
    }

    @PostMapping("/add")
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud Vendor Created";

    }

    @PutMapping("/update")
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud Vendor Updated";

    }

    @DeleteMapping("/delete/{vendorId}")
    public String updateCloudVendor(@PathVariable String vendorId){
        this.cloudVendor = null;
        return "Cloud Vendor Deleted";

    }
}
