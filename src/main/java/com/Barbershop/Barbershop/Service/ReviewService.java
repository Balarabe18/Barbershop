package com.Barbershop.Barbershop.Service;

import com.Barbershop.Barbershop.Entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review createReview(Review review);

    Optional<Review> getReviewById(Long id);

    List<Review> getAllReviews();

    List<Review> getReviewsByBarber(Long barberId);

    List<Review> getReviewsByCustomer(Long customerId);

    List<Review> getReviewsByShop(Long shopId);

    Review updateReview(Review review);

    void deleteReview(Long id);

    double getAverageRatingForBarber(Long barberId);

    double getAverageRatingForShop(Long shopId);
}