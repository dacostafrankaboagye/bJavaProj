package com.frankaboagye.restdemojpamysql.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cloudVendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloudVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendorId")
    private Long vendorId;

    @Column(name="vendorName")
    private String vendorName;

    @Column(name="vendorAddress")
    private String vendorAddress;

    @Column(name = "vendorPhoneNumber")
    private String vendorPhoneNumber;
}
