package com.example.listingapp.controller;

import com.example.listingapp.exeption.ResorsNotFaundExeption;
import com.example.listingapp.model.Category;
import com.example.listingapp.repository.CategoryRepository;
import com.example.listingapp.servise.CategoryServise;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {


    @Autowired
    private final CategoryServise categoryServise;
    @Autowired
    private final CategoryRepository categoryRepository;

    @GetMapping("/categorys")
    public List<Category> getCategory(){
        return categoryServise.findAll();
    }
    @GetMapping("/categorys/{id}")
    public Category findById(@PathVariable int id){
        return categoryRepository.findById(id).orElseThrow(()->new ResorsNotFaundExeption("Category does not exist"));
    }
    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable int id){
        categoryRepository.delete(categoryRepository.findById(id).orElseThrow(()->new ResorsNotFaundExeption("Category does not exist")));
    }
    @PostMapping("/categories")
    public Category create(@RequestBody Category category){
        if (category.getId()>0){
            throw new RuntimeException();
        }
        return categoryRepository.save(category);
    }

}
