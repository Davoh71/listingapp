package com.example.listingapp.servise;

import com.example.listingapp.exeption.ResorsNotFaundExeption;
import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingServise {

    @Autowired
    private final ListingRepository listingRepository;


    public List<Listing> findAll(){
        return listingRepository.findAll();
    }
    public Listing create(Listing listing){
        if (listing.getId()>0){
            throw new RuntimeException();
        }
        return listingRepository.save(listing);
    }
    public void delete( int id){
        listingRepository.delete(listingRepository.findById(id).orElseThrow(()->new ResorsNotFaundExeption("book does not exist")));
    }
}
