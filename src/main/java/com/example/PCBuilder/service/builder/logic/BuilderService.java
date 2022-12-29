package com.example.PCBuilder.service.builder.logic;

import com.example.PCBuilder.model.dto.*;
import com.example.PCBuilder.model.dto.builder.BuilderDto;
import com.example.PCBuilder.model.dto.builder.BuilderRequestDto;
import com.example.PCBuilder.model.entity.*;
import com.example.PCBuilder.model.mapper.*;
import com.example.PCBuilder.repository.*;
import com.example.PCBuilder.service.builder.model.PcBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BuilderService implements com.example.PCBuilder.service.builder.api.BuilderService {

    private PcBuilder pcBuilder;

    private final ProcessorRepository processorRepository;
    private final MotherboardRepository motherboardRepository;
    private final VideoCardRepository videoCardRepository;
    private final RamRepository ramRepository;
    private final PowerSupplyUnitRepository powerSupplyUnitRepository;
    private final CaseRepository caseRepository;

    private final ProcessorMapper processorMapper;
    private final MotherboardMapper motherboardMapper;
    private final RamMapper ramMapper;
    private final VideoCardMapper videoCardMapper;
    private final PowerSupplyUnitMapper powerSupplyUnitMapper;
    private final CaseMapper caseMapper;

    @Override
    public BuilderDto pcBuilder(BuilderRequestDto builderRequestDto) {
        pcBuilder = transformBuilderRequestToBuilder(builderRequestDto);
        String result = null;
        if (isHaveProcessor()) {
            result = pcBuilderProcessor(pcBuilder.getProcessorId());
            if (StringUtils.isNotBlank(result)) return new BuilderDto(result);
        }
        if (isHaveMotherboard()) {
            result = pcBuilderMotherboard(pcBuilder.getMotherboardId());
            if (StringUtils.isNotBlank(result)) return new BuilderDto(result);
        }
        if (isHaveVideoCard()) {
            result = pcBuilderVideoCard(pcBuilder.getProcessorId());
            if (StringUtils.isNotBlank(result)) return new BuilderDto(result);
        }
        if (isHaveRam()) {
            result = pcBuilderRam(pcBuilder.getProcessorId());
            if (StringUtils.isNotBlank(result)) return new BuilderDto(result);
        }
        if (isHavePowerSupplyUnit()) {
            result = pcBuilderPowerSupplyUnit(pcBuilder.getProcessorId());
            if (StringUtils.isNotBlank(result)) return new BuilderDto(result);
        }
        return new BuilderDto(result);
    }

    public String pcBuilderProcessor(String id) {
        Processor processor = processorRepository.findById(id).get();
        String result = null;
        if (isHaveMotherboard() || isHaveVideoCard() || isHavePowerSupplyUnit()) {
            result = logicForProcessor(processor);
        }
        return result;
    }

    public String pcBuilderMotherboard(String id) {
        Motherboard motherboard = motherboardRepository.findById(id).get();
        String result = null;
        if (isHaveRam() || isHaveProcessor()) {
            result = logicForMotherboard(motherboard);
        }
        return result;
    }

    public String pcBuilderRam(String id) {
        RAM ram = ramRepository.findById(id).get();
        String result = null;
        if (isHaveMotherboard()) {
            result = logicForRam(ram);
        }
        return result;
    }

    public String pcBuilderVideoCard(String id) {
        VideoCard videoCard = videoCardRepository.findById(id).get();
        String result = null;
        if (isHavePowerSupplyUnit()) {
            result = logicForVideoCard(videoCard);
        }
        return result;
    }

    public String pcBuilderPowerSupplyUnit(String id) {
        PowerSupplyUnit powerSupplyUnit = powerSupplyUnitRepository.findById(id).get();
        String result = null;
        if (isHaveVideoCard() || isHaveProcessor()) {
            result = logicForPowerSupplyUnit(powerSupplyUnit);
        }
        return result;
    }

    public String pcBuilderCase(String id) {
        return null;
    }



    private int getProgressBarValue() {
        return pcBuilder.getProgressValue();
    }

    private boolean isHaveMotherboard() {
        return StringUtils.isNotBlank(pcBuilder.getMotherboardId());
    }

    private boolean isHaveRam() {
        return StringUtils.isNotBlank(pcBuilder.getRamId());
    }

    private boolean isHavePowerSupplyUnit() {
        return StringUtils.isNotBlank(pcBuilder.getPowerSupplyUnitId());
    }

    private boolean isHaveProcessor() {
        return StringUtils.isNotBlank(pcBuilder.getProcessorId());
    }

    private boolean isHaveVideoCard() {
        return StringUtils.isNotBlank(pcBuilder.getVideoCardId());
    }

    private String logicForProcessor(Processor processor) {
       if (isHaveMotherboard()) {
         Motherboard motherboard = motherboardRepository.findById(pcBuilder.getMotherboardId()).get();
         String result = equalsSocketProcessorAndMotherboard(processor, motherboard);
         if (StringUtils.isNotBlank(result)) return result;
       }
       if (isHavePowerSupplyUnit()) {
          PowerSupplyUnit powerSupplyUnit = powerSupplyUnitRepository.findById(pcBuilder.getPowerSupplyUnitId()).get();
          VideoCard videoCard = null;
          if (isHaveVideoCard()) {
            videoCard = videoCardRepository.findById(pcBuilder.getVideoCardId()).get();
          }
          String result = equalsTDPAndPower(processor, videoCard, powerSupplyUnit);
          if (StringUtils.isNotBlank(result)) return result;
       }
       return null;
    }

    private String logicForMotherboard(Motherboard motherboard) {
      if (isHaveProcessor()) {
         Processor processor = processorRepository.findById(pcBuilder.getProcessorId()).get();
         String result = equalsSocketProcessorAndMotherboard(processor, motherboard);
         if (StringUtils.isNotBlank(result)) return result;
      }
      if (isHaveRam()) {
        RAM ram = ramRepository.findById(pcBuilder.getRamId()).get();
        String result = equalsRamParams(ram, motherboard);
        if (StringUtils.isNotBlank(result)) return result;
      }
      return null;
    }

    private String logicForRam(RAM ram) {
      Motherboard motherboard = motherboardRepository.findById(pcBuilder.getMotherboardId()).get();
      return equalsRamParams(ram, motherboard);
    }

    private String logicForPowerSupplyUnit(PowerSupplyUnit powerSupplyUnit) {
      if (isHaveProcessor()) {
        Processor processor = processorRepository.findById(pcBuilder.getProcessorId()).get();
        VideoCard videoCard = null;
        if (isHaveVideoCard()) {
          videoCard = videoCardRepository.findById(pcBuilder.getVideoCardId()).get();
          return equalsTDPAndPower(processor, videoCard, powerSupplyUnit);
        }
      }
      if (isHaveVideoCard()) {
        VideoCard videoCard = videoCardRepository.findById(pcBuilder.getVideoCardId()).get();
        return equalsTDPAndPower(null, videoCard, powerSupplyUnit);
      }
      return null;
    }

    private String logicForVideoCard(VideoCard videoCard) {
      PowerSupplyUnit powerSupplyUnit = powerSupplyUnitRepository.findById(pcBuilder.getPowerSupplyUnitId()).get();
      Processor processor = null;
      if (isHaveProcessor()) {
        processor = processorRepository.findById(pcBuilder.getProcessorId()).get();
      }
      return equalsTDPAndPower(processor,videoCard, powerSupplyUnit);
    }

    private String equalsSocketProcessorAndMotherboard(Processor processor, Motherboard motherboard) {
      if (!processor.getSocket().equals(motherboard.getSocket())) {
          return "Чипсет процессора и материнской платы отличается";
      }
      return null;
    }

    private String equalsTDPAndPower(Processor processor, VideoCard videoCard, PowerSupplyUnit powerSupplyUnit) {
      if (ObjectUtils.isEmpty(processor)) {
          return (videoCard.getTdp() < powerSupplyUnit.getPower()) ? null : "Видеокарта потребляет больше мощности, чем можно";
      }
      if (ObjectUtils.isEmpty(videoCard)) {
          return (processor.getTdp() < powerSupplyUnit.getPower()) ? null : "Процессор потребляет больше мощности, чем можно";
      }
      return ((processor.getTdp() + videoCard.getTdp()) < powerSupplyUnit.getPower()) ? null : "БП не тянет";
    }

    private String equalsRamParams(RAM ram, Motherboard motherboard) {
       return ram.getFrequencyRAM().getCode() > motherboard.getFrequencyRAM().getCode() ?
               (ram.getRamTechnology().equals(motherboard.getRamTechnology()) ?
               (ram.getMemorySize() < motherboard.getMaxRam() ? null : "ОЗУ больше, чем поддерживаемой памяти у материнской платы") : "Технология ОЗУ не соответствует технологии ОЗУ материнской платы" ) :
               "Частота ОЗУ меньше частоты поддерживаемой ОЗУ материнской платы";
    }

    private void incrementProgressBar() {
      pcBuilder.incrementProgressValue();
    }

    private PcBuilder transformBuilderRequestToBuilder(BuilderRequestDto builderRequestDto) {
        return PcBuilder.builder()
                .motherboardId(builderRequestDto.getMotherboardId())
                .caseId(builderRequestDto.getCaseId())
                .powerSupplyUnitId(builderRequestDto.getPowerSupplyUnitId())
                .processorId(builderRequestDto.getProcessorId())
                .videoCardId(builderRequestDto.getVideoCardId())
                .ramId(builderRequestDto.getRamId())
                .build();
    }

    /**
     * Метод интересный
    public String pcBuild(BaseData accessory) {
        String id = accessory.getId();
        if (accessory instanceof Processor) {
            if (isHaveMotherboard() || isHaveVideoCard() || isHavePowerSupplyUnit()) {
                String result = logicForProcessor((Processor) accessory);
                if (StringUtils.isNotBlank(result)) return result;
            }
            pcBuilder.setProcessorId(id);
        } else if (accessory instanceof Motherboard) {
            if (isHaveRam() || isHaveProcessor()) {
                String result = logicForMotherboard((Motherboard) accessory);
                if (StringUtils.isNotBlank(result)) return result;
            }
            pcBuilder.setMotherboardId(id);
        } else if (accessory instanceof RAM) {
            if (isHaveMotherboard()) {
                String result = logicForRam((RAM) accessory);
                if (StringUtils.isNotBlank(result)) return result;
            }
            pcBuilder.setRamId(id);
        } else if (accessory instanceof PowerSupplyUnit) {
            if (isHaveVideoCard() || isHaveProcessor()) {
                String result = logicForPowerSupplyUnit((PowerSupplyUnit) accessory);
                if (StringUtils.isNotBlank(result)) return result;
            }
            pcBuilder.setPowerSupplyUnitId(id);
        } else if (accessory instanceof VideoCard) {
            if (isHavePowerSupplyUnit()) {
                String result = logicForVideoCard((VideoCard) accessory);
                if (StringUtils.isNotBlank(result)) return result;
            }
            pcBuilder.setVideoCardId(id);
        } else if (accessory instanceof Case) {
            pcBuilder.setCaseId(id);
        }
        incrementProgressBar();
        return null;
    }
     */
}
