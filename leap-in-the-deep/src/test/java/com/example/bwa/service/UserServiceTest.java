package com.example.bwa.service;

import com.example.bwa.enums.LogInSignUp;
import com.example.bwa.enums.UserType;
import com.example.bwa.repo.BookRepository;
import com.example.bwa.repo.UserRepository;
import com.example.bwa.user.User;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BookRepository bookRepository;
    private AutoCloseable autoCloseable;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UserService(userRepository, bookRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void registerSuccessfully() {   //more like addUser -> "add" to database
        //given
        User user1 = new User(
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        User user2 = new User(
                "AlexandruAlex1",
                "parolaaa",
                "alexa@gmail.com",
                UserType.WRITER
        );
        //when
        underTest.register(user2);
        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        AssertionsForClassTypes.assertThat(capturedUser).isEqualTo(user2);
    }

    @Test
    void registerFailure() {
        //given
        User user1 = new User(
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        User user2 = new User(
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        //when
        underTest.register(user2);
        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        AssertionsForClassTypes.assertThat(capturedUser).isNotEqualTo(user1);
    }

    /*@Test
    void registerFailure2() {
        //given
        User user1 = new User(
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        User user2 = new User(
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        given(user1.equals(user2)).willReturn(true);
        //then
        //when
        assertThatThrownBy(() -> underTest.register(user2)).isIn(LogInSignUp.ALREADY_EXISTS);
    }*/

    @Test
    void canGetUserById() {
        //when
        underTest.getUserById(1L);
        //then
        verify(userRepository).findById(1L);
    }

    @Test
    void cannotGetUserById() {
        //when
        underTest.getUserById(2L);
        //then
        verify(userRepository).findById(1L);
    }

    @Test
    void cannotGetUserById2() {
        //when
        underTest.getUserById(1L);
        //then
        verify(userRepository).findById(2L);
    }

    @Test
    void cannotGetUserById3() {
        //when
        underTest.getUserById(1L);
        //then
        verify(userRepository).deleteById(1L);
    }


    //continue from here
    @Test
    void canGetUserByName() {
        //given
        String username = "AlexandruAlex10";
        User user = new User(
                1L,
                "AlexandruAlex10"
        );
        //when
        underTest.getUserByUsername(username);
        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }
}