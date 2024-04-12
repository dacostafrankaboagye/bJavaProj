package com.frankaboagye.restdemojpamysql.repositories;

import com.frankaboagye.restdemojpamysql.models.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, Long> {
    List<CloudVendor> findByVendorName(String vendorName);
}


// there is no need to write test cases - for those which we are directly using
// we can write a test of the findByVendorName