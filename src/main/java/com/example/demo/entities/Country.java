package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="countrys")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private UUID id;
    @Column(nullable = false,length=25,name="name")
    private String name;
    @OneToOne
    @JoinColumn(name="capital")
    private City capital;

}
