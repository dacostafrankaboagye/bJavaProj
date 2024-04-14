package com.frankaboagye.restdemojpamysql.controllers;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import com.frankaboagye.restdemojpamysql.responses.ResponseHandler;
import com.frankaboagye.restdemojpamysql.services.CloudVendorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return "working alright - perfectly...";
    }

    @GetMapping("/getVendor/{vendorId}")
    @Operation(
            summary = "gets a cloud vendor",
            description = "Gets a cloud vendor using an ID you provide"
    )
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") Long vendorId){
        return ResponseHandler.responseBuilder(
                "Here is the Vendor Details",
                HttpStatus.OK,
                this.cloudVendorService.getCloudVendor(vendorId)
        );
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
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor, @PathVariable("vendorId") Long vendorId){
        return this.cloudVendorService.updateCloudVendor(cloudVendor, vendorId);
    }

    @DeleteMapping("/deleteVendor/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") Long vendorId){
        return this.cloudVendorService.deleteCloudVendor(vendorId);
    }


}
