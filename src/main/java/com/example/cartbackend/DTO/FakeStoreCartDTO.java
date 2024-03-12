package com.example.cartbackend.DTO;

import com.example.cartbackend.Models.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCartDTO {
    private long id;
    private long userId;
    private String date;
    private Products[] products;
}
