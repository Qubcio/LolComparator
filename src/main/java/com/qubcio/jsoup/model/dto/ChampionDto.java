package com.qubcio.jsoup.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ChampionDto {

    public ChampionDto(){
    }

    private Integer id;
    private String name;
    private List<StatDto> stats;
}
