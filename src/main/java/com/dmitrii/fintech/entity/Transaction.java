package com.dmitrii.fintech.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
public class Transaction extends PanacheEntity {
    public String fromAccount;
    public String toAccount;
    public BigDecimal amount;
    public LocalDateTime transactionDate;
}
