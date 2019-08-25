package com.toyota.faultdetection.dto;

import com.toyota.faultdetection.domain.Fault;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaultDTO {

    private Long id;

    private String registerDate;

    private String recorder;

    private String reporter;

    private String reporterTel;

    private String faultType;

    private String location;

    private String shop;

    private String assigned;

    private String emergency;

    private String explanation;

    private String endDay;

    private String kayitTuru;


    public static FaultDTO fromEntity(Fault fault) {
        return FaultDTO.builder()
                .id(fault.getId())
                .registerDate(fault.getRegisterDate())
                .recorder(fault.getRecorder())
                .reporter(fault.getReporter())
                .reporterTel(fault.getReporterTel())
                .faultType(fault.getFaultType())
                .location(fault.getLocation())
                .shop(fault.getShop())
                .assigned(fault.getAssigned())
                .emergency(fault.getEmergency())
                .explanation(fault.getExplanation())
                .endDay(fault.getEndDay())
                .kayitTuru(fault.getKayitTuru())
                .build();
    }

    public Fault toEntity() {
        return Fault.builder()
                .id(this.getId())
                .registerDate(this.getRegisterDate())
                .recorder(this.getRecorder())
                .reporter(this.getReporter())
                .reporterTel(this.getReporterTel())
                .faultType(this.getFaultType())
                .location(this.getLocation())
                .shop(this.getShop())
                .assigned(this.getAssigned())
                .emergency(this.getEmergency())
                .explanation(this.getExplanation())
                .endDay(this.getEndDay())
                .kayitTuru(this.getKayitTuru())
                .build();
    }
}
