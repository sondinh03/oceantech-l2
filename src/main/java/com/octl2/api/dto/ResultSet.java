package com.octl2.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;

@JsonPropertyOrder({
        "locationId",
        "name",
        "code",
        "fulfilmentId",
        "fulfilmentName",
        "fulfilmentShortname",
        "lastmileId",
        "lastmileName",
        "lastmileShortname",
        "warehouseId",
        "warehouseName",
        "warehouseShortname"
})
public interface ResultSet {
    Long getLocationId();
    String getName();
    String getCode();
    Long getFulfilmentId();
    Long getLastmileId();
    Long getWarehouseId();
    String getFulfilmentName();
    String getLastmileName();
    String getWarehouseName();
    String getFulfilmentShortname();
    String getLastmileShortname();
    String getWarehouseShortname();

}
