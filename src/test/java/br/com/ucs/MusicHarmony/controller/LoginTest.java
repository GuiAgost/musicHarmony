package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class LoginTest {

    public static final String USERNAME = "Guilherme";
    public static final String PASSWORD = "123";

    @InjectMocks
    LoginController login;

    @Mock
    private UserRepository userRepository;

    private User user;
    private Optional<User> optionalUser;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    public void returnExistUser() {
        when(userRepository.findByUsername(anyString())).thenReturn(optionalUser.get());

        User response = login.userRepository.findByUsername(USERNAME);
        System.out.println(response);

        //assertEquals(User.class, response.getClass());
        assertEquals(USERNAME, response.getUsername());
    }

    private void startUser(){
        user = new User(USERNAME, PASSWORD);
        optionalUser = Optional.of(new User(USERNAME, PASSWORD));
    }
}

// https://www.youtube.com/watch?v=hzwoATMU3EM
// https://www.youtube.com/c/DicasdeumDEV/about
// https://medium.com/cwi-software/testando-seu-c%C3%B3digo-java-com-o-mockito-framework-8bea7287460a