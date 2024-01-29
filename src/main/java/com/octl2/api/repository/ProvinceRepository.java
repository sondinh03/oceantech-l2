package com.octl2.api.repository;

import com.octl2.api.dto.DistrictDTO;
import com.octl2.api.dto.LocationDTO;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.dto.ResultSet;
import com.octl2.api.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    @Query(value = "SELECT " +
            "   p.province_id AS id " +
            "   , p.name " +
            "   , p.shortname " +
            "   , p.code " +
            "   , p.dcsr AS description " +
            " FROM lc_province AS p " +
            " WHERE " +
            "   p.province_id = :id "
            , nativeQuery = true)
    ProvinceDTO getDtoById(@Param("id") long id);

    @Query(value = "SELECT" +
            "   prv.province_id AS locationId" +
            "   ,prv.name" +
            "   ,prv.code" +
            "   ,deli.ffm_id AS FulfilmentId" +
            "   ,ffm.name AS fulfilmentName" +
            "   ,ffm.shortname AS fulfilmentShortname" +
            "   ,deli.lastmile_id AS lastmileId" +
            "   ,lm.name AS lastmileName" +
            "   ,lm.shortname AS lastmileShortname" +
            "   ,deli.warehouse_id AS warehouseId" +
            "   ,wh.warehouse_name AS warehouseName" +
            "   ,wh.warehouse_shortname AS warehouseShortname" +
            "   FROM" +
            "   lc_province AS prv" +
            "   LEFT JOIN" +
            "   cf_default_delivery AS deli" +
            "   ON" +
            "   deli.location_id = prv.province_id" +
            "   LEFT JOIN" +
            "   bp_partner AS ffm" +
            "   ON" +
            "   ffm.partner_id = deli.ffm_id" +
            "   LEFT JOIN" +
            "   bp_partner AS lm" +
            "   ON" +
            "   lm.partner_id = deli.lastmile_id" +
            "   LEFT JOIN" +
            "   bp_warehouse AS wh" +
            "   ON" +
            "   wh.warehouse_id = deli.warehouse_id" +
            "   ORDER BY" +
            "   prv.province_id", nativeQuery = true)
    Set<ResultSet> getAllProvince();


    @Query(value = "SELECT" +
            "   dtr.district_id AS locationId" +
            "   ,dtr.name" +
            "   ,dtr.code" +
            "   ,deli.ffm_id AS FulfilmentId" +
            "   ,ffm.name AS fulfilmentName" +
            "   ,ffm.shortname AS fulfilmentShortname" +
            "   ,deli.lastmile_id AS lastmileId" +
            "   ,lm.name AS lastmileName" +
            "   ,lm.shortname AS lastmileShortname" +
            "   ,deli.warehouse_id AS warehouseId" +
            "   ,wh.warehouse_name AS warehouseName" +
            "   ,wh.warehouse_shortname AS warehouseShortname" +
            "   FROM" +
            "   lc_district AS dtr" +
            "   LEFT JOIN" +
            "   cf_default_delivery AS deli" +
            "   ON" +
            "   deli.location_id = dtr.district_id" +
            "   LEFT JOIN" +
            "   bp_partner AS ffm" +
            "   ON" +
            "   ffm.partner_id = deli.ffm_id" +
            "   LEFT JOIN" +
            "   bp_partner AS lm" +
            "   ON" +
            "   lm.partner_id = deli.lastmile_id" +
            "   LEFT JOIN" +
            "   bp_warehouse AS wh" +
            "   ON" +
            "   wh.warehouse_id = deli.warehouse_id" +
            "   WHERE" +
            " dtr.province_id = :provinceId" +
            "   ORDER BY" +
            "   dtr.district_id", nativeQuery = true)
    Set<ResultSet> getAllDistrict(@Param("provinceId") Long provinceId);



    @Query(value = "SELECT" +
            "   dtr.district_id AS locationId" +
            "   ,dtr.name" +
            "   ,dtr.code" +
            "   ,deli.ffm_id AS fulfilmentId" +
            "   ,ffm.name AS fulfilmentName" +
            "   ,ffm.shortname AS fulfilmentShortname" +
            "   ,deli.lastmile_id AS lastmileId" +
            "   ,lm.name AS lastmileName" +
            "   ,lm.shortname AS lastmileShortname" +
            "   ,deli.warehouse_id AS warehouseId" +
            "   ,wh.warehouse_name AS warehouseName" +
            "   ,wh.warehouse_shortname AS warehouseShortname" +
            "   FROM" +
            "   lc_district AS dtr" +
            "   LEFT JOIN" +
            "   cf_default_delivery AS deli" +
            "   ON" +
            "   deli.location_id = dtr.district_id" +
            "   LEFT JOIN" +
            "   bp_partner AS ffm" +
            "   ON" +
            "   ffm.partner_id = deli.ffm_id" +
            "   LEFT JOIN" +
            "   bp_partner AS lm" +
            "   ON" +
            "   lm.partner_id = deli.lastmile_id" +
            "   LEFT JOIN" +
            "   bp_warehouse AS wh" +
            "   ON" +
            "   wh.warehouse_id = deli.warehouse_id" +
            "   ORDER BY" +
            "   dtr.district_id", nativeQuery = true)
    Set<ResultSet> getAllDistrict();

    @Query(value = "SELECT" +
            "   sbd.subdistrict_id AS locationId" +
            "   ,sbd.name" +
            "   ,sbd.shortname" +
            "   ,sbd.code" +
            "   ,deli.ffm_id AS FulfilmentId" +
            "   ,ffm.name AS fulfilmentName" +
            "   ,ffm.shortname AS fulfilmentShortname" +
            "   ,deli.lastmile_id AS lastmileId" +
            "   ,lm.name AS lastmileName" +
            "   ,lm.shortname AS lastmileShortname" +
            "   ,deli.warehouse_id AS warehouseId" +
            "   ,wh.warehouse_name AS warehouseName" +
            "   ,wh.warehouse_shortname AS warehouseShortname" +
            "   FROM" +
            "   lc_subdistrict AS sbd" +
            "   LEFT JOIN" +
            "   cf_default_delivery AS deli" +
            "   ON" +
            "   deli.location_id = sbd.subdistrict_id" +
            "   LEFT JOIN" +
            "   bp_partner AS ffm" +
            "   ON" +
            "   ffm.partner_id = deli.ffm_id" +
            "   LEFT JOIN" +
            "   bp_partner AS lm" +
            "   ON" +
            "   lm.partner_id = deli.lastmile_id" +
            "   LEFT JOIN" +
            "   bp_warehouse AS wh" +
            "   ON" +
            "   wh.warehouse_id = deli.warehouse_id" +
            "   ORDER BY" +
            "   sbd.subdistrict_id", nativeQuery = true)
    Set<ResultSet> getAllSubdistrict();
}


/*
 *  @Repository: đánh dấu một class là tầng giao tiếp với database. Nó giúp chuyển đổi các database exception sang
 * Spring-based unchecked exception, giúp cho việc xử lý exception trở nên dễ dàng hơn.
 *  @Param: để ánh xạ giá trị được truyền vào phương thức vào biến tương ứng trong câu lệnh sql native.
 */
