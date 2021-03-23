package com.example.listingapp.servise;

import com.example.listingapp.exeption.ResorsNotFaundExeption;
import com.example.listingapp.model.Category;
import com.example.listingapp.model.User;
import com.example.listingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServise {

    @Autowired
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(()->new ResorsNotFaundExeption("book does not exist"));
    }
    public void delete( int id){
        userRepository.delete(userRepository.findById(id).orElseThrow(()->new ResorsNotFaundExeption("book does not exist")));
    }
    public void create(User user){
        if (user.getId()>0){
            throw new RuntimeException();
        }
        userRepository.save(user);
    }
}
