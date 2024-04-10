package com.frankaboagye.restdemojpamysql.services;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor, Integer vendorId);
    public String deleteCloudVendor(Integer vendorId);
    public CloudVendor getCloudVendor(Integer vendorId);
    public List<CloudVendor> getAllCloudVendors();
}
