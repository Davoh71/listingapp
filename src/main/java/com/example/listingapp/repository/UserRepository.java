package com.example.listingapp.repository;

import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
