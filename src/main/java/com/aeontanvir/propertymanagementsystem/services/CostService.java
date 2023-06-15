package com.aeontanvir.propertymanagementsystem.services;

import com.aeontanvir.projectcosting.dtos.CostDto;

import java.util.List;

public interface CostService {
    public List<CostDto> getAll();

    public CostDto getById(Long id);

    public CostDto create(CostDto CostDto);

    public CostDto update(Long id, CostDto CostDto);

    public void delete(Long id);
}
