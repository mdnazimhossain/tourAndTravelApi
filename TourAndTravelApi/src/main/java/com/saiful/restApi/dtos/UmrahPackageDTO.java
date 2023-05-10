package com.saiful.restApi.dtos;

import lombok.Data;

@Data
public class UmrahPackageDTO {
    private Long id;
    private String name;
    private String type;
    private String price;
    private String startDate;
    private String endDate;
    private String description;
    private String location;
    private String imageLink;


}
