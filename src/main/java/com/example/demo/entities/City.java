package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cities")
public class City {
    @Id
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="population",nullable = false)
    private int Poulation;
    @ManyToOne
    @JoinColumn(name="country")
    private Country country;

}
