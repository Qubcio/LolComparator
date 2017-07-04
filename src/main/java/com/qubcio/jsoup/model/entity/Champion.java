package com.qubcio.jsoup.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Champion {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ch_name")
    private String name;

    @OneToMany(mappedBy = "champion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stat> stats;

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
