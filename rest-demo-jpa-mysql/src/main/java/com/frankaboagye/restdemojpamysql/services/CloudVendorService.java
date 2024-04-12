package com.frankaboagye.restdemojpamysql.services;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor, Long vendorId);
    public String deleteCloudVendor(Long vendorId);
    public CloudVendor getCloudVendor(Long vendorId);
    public List<CloudVendor> getAllCloudVendors();
}
