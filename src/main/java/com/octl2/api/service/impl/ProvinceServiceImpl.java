package com.octl2.api.service.impl;

import com.octl2.api.commons.exception.ErrorMessages;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.dto.ResultSet;
import com.octl2.api.repository.ProvinceRepository;
import com.octl2.api.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.octl2.api.consts.Const.*;

@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepo;

    @Override
    public ProvinceDTO getBybId(long id) {
        return provinceRepo.getDtoById(id);
    }

    @Override
    public Set<ResultSet> getInforByLevel(int levelMapping) {
        switch (levelMapping) {
            case LEVEL_MAPPING_PROVINCE:
                return provinceRepo.getAllProvince();
            case LEVEL_MAPPING_DISTRICT:
            {
                return provinceRepo.getAllDistrict();
            }
            case LEVEL_MAPPING_SUBDISTRICT:
                return provinceRepo.getAllSubdistrict();
            default:
                throw new IllegalArgumentException(ErrorMessages.INVALID_VALUE.getMessage());
        }
    }
}

/*
 *  @AllArgsConstructor: tự động tạo một hàm tạo với tất cả các tham số cho các thuộc tính của lớp.
 */
