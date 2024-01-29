package com.octl2.api.dto;

import java.util.Set;

public class LocationDTO {
    private Long locationId;
    private String name;
    private String code;
    private LogisticDTO logisticDTO;
    private Set<DistrictDTO> districtDTOSet;
    private Set<SubdistrictDTO> subdistrictDTOSet;
}
