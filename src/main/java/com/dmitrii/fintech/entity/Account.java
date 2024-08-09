package com.dmitrii.fintech.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Account extends PanacheEntity {
    public String name;
    public double balance;
}
