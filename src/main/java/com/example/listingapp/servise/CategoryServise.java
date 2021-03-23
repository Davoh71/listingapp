package com.example.listingapp.servise;

import com.example.listingapp.exeption.ResorsNotFaundExeption;
import com.example.listingapp.model.Category;
import com.example.listingapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServise {

    @Autowired
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return  categoryRepository.findAll();
    }

}
