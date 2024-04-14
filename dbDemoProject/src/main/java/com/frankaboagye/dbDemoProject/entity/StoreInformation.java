package com.frankaboagye.dbDemoProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StoreInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storeId;
    private String storeName;
    private String storeDetail;
    private String storePhoneNumber;

    public StoreInformation(String storeName, String storeDetail, String storePhoneNumber) {
        this.storeName = storeName;
        this.storeDetail = storeDetail;
        this.storePhoneNumber = storePhoneNumber;
    }


}
