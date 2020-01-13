package com.graphqldocs.dto;

import com.common.Location;
import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class SellerAddressProjection {

    private UUID id;
    private UUID sellerId;
    private DateTime created;
    private DateTime updated;
    private String street;
    private Integer houseNumber;
    private String houseNumberAdditive;
    private String address2;
    @NotBlank
    private String zipcode;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    private Location location;
}
