package com.example.sin_project.repository;

import com.example.sin_project.entity.PublishingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Long> {
    List<PublishingHouse> findAll();
}
