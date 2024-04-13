package com.frankaboagye.restdemojpamysql.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cloudVendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "This table holds frank's cloud vendor information")
public class CloudVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendorId")
    @Schema(description= "The vendor ID. Type is Long")
    private Long vendorId;

    @Column(name="vendorName")
    private String vendorName;

    @Column(name="vendorAddress")
    private String vendorAddress;

    @Column(name = "vendorPhoneNumber")
    private String vendorPhoneNumber;
}
