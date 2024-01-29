package com.octl2.api.controller;

import com.octl2.api.commons.OctResponse;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.dto.ResultSet;
import com.octl2.api.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/provinces")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ProvinceController {
    private final ProvinceService provinceService;

    @GetMapping("/{id}")
    public OctResponse<ProvinceDTO> getById(@PathVariable @Min(1) long id) {
        ProvinceDTO result = provinceService.getBybId(id);
        return OctResponse.build(result);
    }

    @GetMapping("/logistic")
    public OctResponse<Set<ResultSet>> getAllByLevel(@RequestParam int level) {
        Set<ResultSet> result = provinceService.getInforByLevel(level);
        return OctResponse.build(result);
    }
}


/*
 *  @RequiredArgsConstructor: tự động tạo contructor cho tất cả các trường cuối cùng và không null.
 *  @Validated: kích hoạt trình kiểm tra hợp lệ của spring AOP và kiểm tra các tham số phương thức xem chúng có bất kỳ
 * chú thích kiểm tra hợp lệ trên chúng hay không
 *  @Slf4j tự động tạo ra một trình ghi nhật ký (logger) cho lớp được chú thích. Chú thích này sẽ tự động tạo ra một
 * trình ghi nhật ký với tên lớp hiện tại. Vì vậy không cần khai báo logger trong lớp của mình.
 *
 */
