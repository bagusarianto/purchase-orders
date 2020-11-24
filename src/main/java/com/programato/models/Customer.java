package com.programato.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id", columnDefinition = "serial8 not null", nullable = false)
    public Long customerId;

    @Column(name = "customer_name")
    @JsonProperty("customer_name")
    public String customerName;


    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public LocalDateTime createdAt;
}
