package com.programato.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder extends PanacheEntity {
    @Column(name = "customer_name", length = 200)
    @JsonProperty("customer_name")
    public String customerName;

    @Column(name = "payment_method")
    @JsonProperty("payment_method")
    public String paymentMethod;

    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public LocalDateTime createdAt;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    @JsonProperty("details")
    public List<PurchaseOrderDetail> details;
}
