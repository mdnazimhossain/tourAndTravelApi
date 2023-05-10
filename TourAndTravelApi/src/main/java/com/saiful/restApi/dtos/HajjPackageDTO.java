package com.saiful.restApi.dtos;

import com.saiful.restApi.entity.HajjPackage;
import lombok.Data;

@Data
public class HajjPackageDTO {
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
