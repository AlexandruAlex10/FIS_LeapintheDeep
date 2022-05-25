package com.example.bwa.service;

import com.example.bwa.repo.FavouriteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class FavouriteServiceTest {

    @Mock
    private FavouriteRepository favouriteRepository;
    private AutoCloseable autoCloseable;
    private FavouriteService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FavouriteService(favouriteRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canDeleteBookById() {
        //given
        long id = 1;
        given(favouriteRepository.existsById(id)).willReturn(true);
        //when
        underTest.deleteBookById(id);
        //then
        verify(favouriteRepository).deleteById(id);
    }

    @Test
    void willThrowWhenDeleteBookByIdNotFound() {
        //given
        long id = 1;
        given(favouriteRepository.existsById(id)).willReturn(false);
        //when
        //then
        assertThatThrownBy(() -> underTest.deleteBookById(id)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(("book with id " + id + " does not exists!"));
    }

    @Test
    void willThrowWhenDeleteBookByIdNotFound2() {
        //given
        long id = 1;
        given(favouriteRepository.existsById(id)).willReturn(false);
        //when
        //then
        assertThatThrownBy(() -> underTest.deleteBookById(id)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(("book with id " + id + " does in fact exists haha!!!"));
    }
}