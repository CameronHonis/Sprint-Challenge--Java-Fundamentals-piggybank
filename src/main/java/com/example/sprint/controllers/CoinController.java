package com.example.sprint.controllers;

import com.example.sprint.models.Coin;
import com.example.sprint.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinrepos;

    // http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listCoins(){
        List<Coin> returnList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(returnList::add);
        double total = 0;
        for (Coin c : returnList){
            System.out.println(c);
            total += c.getValue() * c.getQuantity();
        }
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
