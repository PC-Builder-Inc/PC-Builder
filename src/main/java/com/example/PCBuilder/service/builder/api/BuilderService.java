package com.example.PCBuilder.service.builder.api;

import com.example.PCBuilder.model.dto.*;
import com.example.PCBuilder.model.dto.builder.BuilderDto;
import com.example.PCBuilder.model.entity.BaseData;

public interface BuilderService {


    BuilderDto pcBuilder(ProcessorDto processorDto);

    BuilderDto pcBuilder(MotherboardDto motherboardDto);

    BuilderDto pcBuilder(RamDto ramDto);

    BuilderDto pcBuilder(VideoCardDto videoCardDto);

    BuilderDto pcBuilder(PowerSupplyUnitDto powerSupplyUnitDto);

    BuilderDto pcBuilder(CaseDto caseDto);

    //String pcBuild(BaseData accessory);

}
