package com.example.demo.controller;

import com.example.demo.dao.CountryRepository;
import com.example.demo.entities.Country;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/country")
@RestController
public class CountryRestController {

    private final CountryRepository countryRepository;
    @Autowired
    public CountryRestController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @GetMapping
    public List<Country> getAll(){
        return countryRepository.findAll();
    }
    @GetMapping("/{id}")
    public Country getById(@PathVariable("id") UUID id){
        return countryRepository.findById(id).get();
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id")UUID id){countryRepository.deleteById(id);

    }
    public Country update(@RequestBody Country country){
        if(countryRepository.existsById(country.getId())){
            return countryRepository.save(country);
        }
        throw new EntityExistsException("Country with Id:"+country.getId()+"doesn't exists");
    }
    @PostMapping
    public Country create(@RequestBody Country country){
        UUID id = country.getId();
        if(id!=null){
            if(countryRepository.existsById(country.getId())){
                throw new EntityExistsException("Country already exists");
            }
        }
       return  countryRepository.save(country);
    }


}
