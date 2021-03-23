package com.example.listingapp.controller;


import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import com.example.listingapp.servise.ListingServise;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListingController {

    @Autowired
    private final ListingServise listingServise;

    @GetMapping("/listings")
    public List<Listing> getListing(){
        return listingServise.findAll();
    }

    @PostMapping("/lsitings")
    public Listing create(@RequestBody Listing listing) {
        return listingServise.create(listing);
    }

    @DeleteMapping("/listings/{id}")
    public void delete(@PathVariable int id){
        listingServise.delete(id);
    }

}
