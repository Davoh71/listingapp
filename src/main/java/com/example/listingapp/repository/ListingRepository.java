package com.example.listingapp.repository;

import com.example.listingapp.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing,Integer> {



}
