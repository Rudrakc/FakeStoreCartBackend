package com.example.cartbackend.Controller;

import com.example.cartbackend.DTO.FakeStoreCartDTO;
import com.example.cartbackend.Services.CartService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;
    CartController(CartService cartServiceObject) {
        this.cartService = cartServiceObject;
    }

    @GetMapping("/carts")
    public List<FakeStoreCartDTO> getAllCarts(@RequestParam HashMap<String, String> map) throws Exception {
        String startdate = "";
        if(map.containsKey("startdate")){
            startdate = map.get("startdate");
        }
        String enddate = "";
        if(map.containsKey("enddate")) {
            enddate = map.get("enddate");
        }
        return cartService.getAllCarts(startdate, enddate);
    }

    @GetMapping("/carts/{id}")
    public FakeStoreCartDTO getProductById(@PathVariable("id") Long id){
        return cartService.getProductById(id);
    }

    @GetMapping("/carts/user/{id}")
    public List<FakeStoreCartDTO> getUserCart(@PathVariable("id") Long id) throws Exception {
        return cartService.getUserCart(id);
    }

    @PostMapping("/carts")
    public FakeStoreCartDTO addNewCart(@RequestBody FakeStoreCartDTO newCart){
        return cartService.addNewCart(newCart);
    }

    @PutMapping("/carts/{id}")
    public void updateCart(@PathVariable("id") Long id, @RequestBody FakeStoreCartDTO newCart) {
        cartService.updateCart(id,newCart);
    }

    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable("id") Long id){
        cartService.deleteCart(id);
    }

}
