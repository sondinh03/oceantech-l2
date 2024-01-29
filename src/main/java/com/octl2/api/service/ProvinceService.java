package com.octl2.api.service;

import com.octl2.api.dto.LocationDTO;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.dto.ResultSet;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ProvinceService {
    ProvinceDTO getBybId(long id);

    Set<ResultSet> getInforByLevel(int levelMapping);
}
