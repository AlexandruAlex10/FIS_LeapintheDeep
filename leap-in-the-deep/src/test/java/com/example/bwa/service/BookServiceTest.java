package com.example.bwa.service;

import com.example.bwa.repo.BookRepository;
import com.example.bwa.repo.ReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @Mock
    private ReviewRepository reviewRepository;
    private AutoCloseable autoCloseable;
    private BookService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new BookService(bookRepository, reviewRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetBookById() {
        //when
        underTest.getBookById(1L);
        //then
        verify(bookRepository).findById(1L);
    }

    @Test
    void cannotGetBookById() {
        //when
        underTest.getBookById(1L);
        //then
        verify(bookRepository).findById(2L);
    }

    @Test
    void cannotGetBookById2() {
        //when
        underTest.getBookById(2L);
        //then
        verify(bookRepository).findById(1L);
    }

    @Test
    void cannotGetBookById3() {
        //when
        underTest.getBookById(1L);
        //then
        verify(bookRepository).deleteById(1L);
    }
}