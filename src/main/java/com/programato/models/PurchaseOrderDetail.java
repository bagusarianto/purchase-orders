package com.programato.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetail extends PanacheEntity {
    @Column(name = "purchase_order_id", updatable = false, insertable = false, nullable = false)
    @JsonProperty("purchase_order_id")
    public Long purchaseOrderId;

    @Column(name = "item_name", length = 200, nullable = false)
    @JsonProperty("item_name")
    public String itemName;

    @Column(name = "quantity", nullable = false)
    public Long quantity;

    @Column(name = "item_price", nullable = false)
    @JsonProperty("item_price")
    public Long itemPrice;

    @Column(name = "item_total")
    @JsonProperty("item_total")
    public Long itemTotal;


    @CreationTimestamp
    @Column(name = "created_at")
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public LocalDateTime createdAt;
}
