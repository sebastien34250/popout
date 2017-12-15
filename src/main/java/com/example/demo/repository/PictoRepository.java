package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pictogram;

public interface PictoRepository extends CrudRepository<Pictogram, Integer> {

}
