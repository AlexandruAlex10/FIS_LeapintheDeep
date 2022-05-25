package com.example.bwa.service;

import com.example.bwa.repo.ReviewRepository;
import com.example.bwa.user.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;
    private AutoCloseable autoCloseable;
    private ReviewService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReviewService(reviewRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    void canPostReview() {
        //given
        Review review = new Review(
                1L,
                5,
                "Nice!"
        );
        //when
        underTest.postReview(review);
        //then
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).save(reviewArgumentCaptor.capture());

        Review capturedReview = reviewArgumentCaptor.getValue();
        assertThat(capturedReview).isEqualTo(review);
    }
}