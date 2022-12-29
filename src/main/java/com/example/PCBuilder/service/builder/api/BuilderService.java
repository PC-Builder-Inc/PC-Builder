package com.example.PCBuilder.service.builder.api;

import com.example.PCBuilder.model.dto.*;
import com.example.PCBuilder.model.dto.builder.BuilderDto;
import com.example.PCBuilder.model.dto.builder.BuilderRequestDto;
import com.example.PCBuilder.model.entity.BaseData;

public interface BuilderService {


    BuilderDto pcBuilder(BuilderRequestDto builderRequestDto);

    //String pcBuild(BaseData accessory);

}
