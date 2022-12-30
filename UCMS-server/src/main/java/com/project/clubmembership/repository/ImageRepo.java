package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Image;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<Image,Integer> {
}
