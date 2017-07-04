package com.qubcio.jsoup.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatDto {

    public StatDto() {
    }

    private Integer id;
    private String name;
    private Double value;
    private Integer champion;
}
