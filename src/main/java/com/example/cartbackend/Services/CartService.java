package com.example.cartbackend.Services;

import com.example.cartbackend.DTO.FakeStoreCartDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartService {

    List<FakeStoreCartDTO> getAllCarts(String startdate, String enddate) throws Exception;
    FakeStoreCartDTO getProductById(Long id);
    List<FakeStoreCartDTO> getUserCart(Long id) throws Exception;
    FakeStoreCartDTO addNewCart(FakeStoreCartDTO newCart);
    void updateCart(Long id,FakeStoreCartDTO newCart);
    void deleteCart(Long id);

}
