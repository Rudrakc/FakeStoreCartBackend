package com.example.cartbackend.Services;

import com.example.cartbackend.DTO.FakeStoreCartDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCartService implements CartService{
    RestTemplate restTemplate = new RestTemplate();
    private final String url = "https://fakestoreapi.com/carts";

    @Override
    public List<FakeStoreCartDTO> getAllCarts(String startdate, String enddate) throws Exception {
        FakeStoreCartDTO[] response = restTemplate.getForObject(
                url+"?startdate="+startdate+"&enddate="+enddate,
                FakeStoreCartDTO[].class
        );

        if(response!=null) return Arrays.asList(response);
        else throw new Exception("No data received");
    }

    @Override
    public FakeStoreCartDTO getProductById(Long id){
        return restTemplate.getForObject(
                url+"/"+id,
                FakeStoreCartDTO.class
        );
    }

    @Override
    public List<FakeStoreCartDTO> getUserCart(Long id) throws Exception {
        FakeStoreCartDTO[] response = restTemplate.getForObject(
                url+"/user/"+id,
                FakeStoreCartDTO[].class
        );
        if(response!=null) return Arrays.asList(response);
        else throw new Exception("No data received");
    }

    @Override
    public FakeStoreCartDTO addNewCart(FakeStoreCartDTO newCart){
        return restTemplate.postForObject(
                url,
                newCart,
                FakeStoreCartDTO.class
        );
    }

    @Override
    public void updateCart(Long id,FakeStoreCartDTO newCart) {
        restTemplate.put(
                url+"/"+id,
                newCart
        );
    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete(
                url+"/"+id
        );
    }

}
