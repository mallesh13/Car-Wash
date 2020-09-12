package com.carwash.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.entity.RatingsAndReviews;

@Repository
public interface RatingsAndReviewsDao extends MongoRepository<RatingsAndReviews, String>{

}
