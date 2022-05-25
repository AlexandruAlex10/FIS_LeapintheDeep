package com.example.bwa.repo;

import com.example.bwa.enums.UserType;
import com.example.bwa.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void userNameShouldBePresent() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                name,
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected.isPresent()).isTrue();
    }

    @Test
    void userNameShouldNotBePresent() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected.isPresent()).isFalse();
    }

    @Test
    void userNameShouldMatch() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                name,
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);
    }

    @Test
    void userNameShouldMatch2() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                1L,
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com"
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);
    }

    @Test
    void userNameShouldMatch3() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                1L,
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.READER,
                true
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);
    }

    @Test
    void userNameShouldMatch4() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                1L,
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER,
                true
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);
    }

    @Test
    void userNameShouldMatch5() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                1L,
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.READER,
                false
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);
    }

    @Test
    void userNameShouldNotMatch() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);    //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch2() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "Alexandru",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch3() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlexandruAlex10 ",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch4() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                " AlexandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch5() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlexándruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch6() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlexndruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch7() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "ÄlexandruÄlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch8() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlexandruAlex10▲",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch9() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "ALEXandr⧹uAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch10() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "ALEXandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch11() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlexanⅆruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch12() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlḙxandruAlex10",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch13() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                "AlexandruAlex⑩",
                "parola",
                "alex@gmail.com",
                UserType.WRITER
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu regaseste numele "name" din "user"
    }

    @Test
    void userNameShouldNotMatch14() {
        //given
        String name = "AlexandruAlex10";
        User user = new User(
                100L,
                "AlexandruAlex10",
                "parola",
                "alex@gmail.com"
        );
        underTest.save(user);
        //when
        Optional<User> expected = underTest.findByUsername(name);
        //then
        assertThat(expected).contains(user);   //contains va returna un optional empty pentru ca nu id-urile nu sunt identice
    }
}
