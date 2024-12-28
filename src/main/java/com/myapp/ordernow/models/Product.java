package com.myapp.ordernow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Size(max = 255, message = "You must supply a Product name value less than 255 characters.")
    String name;
    @Column(precision = 10, scale = 2)
    Double price;
    @NotEmpty(message = "You must supply a value for the description.")
    String description;
    Byte[] image;
    @Min(value = 0, message = "Quantity cannot be negative.")
    int stock_quantity;

}


//CREATE TABLE Product (
//        id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
//        name VARCHAR2(255) NOT NULL,
//description CLOB,
//price NUMBER(10, 2) NOT NULL,
//image TINYBLOB,
//stock_quantity NUMBER DEFAULT 0
//        );