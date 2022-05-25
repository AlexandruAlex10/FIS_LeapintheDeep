package com.example.bwa.service;

import com.example.bwa.repo.WishlistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;
    private AutoCloseable autoCloseable;
    private WishlistService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new WishlistService(wishlistRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canDeleteBookById() {
        //given
        long id = 1;
        given(wishlistRepository.existsById(id)).willReturn(true);
        //when
        underTest.deleteBookById(id);
        //then
        verify(wishlistRepository).deleteById(id);
    }

    @Test
    void willThrowWhenDeleteBookByIdNotFound() {
        //given
        long id = 1;
        given(wishlistRepository.existsById(id)).willReturn(false);
        //when
        //then
        assertThatThrownBy(() -> underTest.deleteBookById(id)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(("book with id " + id + " does not exists!"));
    }

    @Test
    void willThrowWhenDeleteBookByIdNotFound2() {
        //given
        long id = 1;
        given(wishlistRepository.existsById(id)).willReturn(false);
        //when
        //then
        assertThatThrownBy(() -> underTest.deleteBookById(id)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(("book with id " + id + " does in fact exists haha!!!"));
    }
}