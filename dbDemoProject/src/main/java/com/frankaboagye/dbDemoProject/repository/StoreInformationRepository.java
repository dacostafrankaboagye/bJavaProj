package com.frankaboagye.dbDemoProject.repository;

import com.frankaboagye.dbDemoProject.entity.StoreInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreInformationRepository extends CrudRepository<StoreInformation, Integer> {

    // the name mapping should happen

    List<StoreInformation> findByStoreName(String storeName);
    List<StoreInformation> findByStoreDetail(String storeDetail);
    List<StoreInformation> findByStorePhoneNumber(String storePhoneNumber);


}
