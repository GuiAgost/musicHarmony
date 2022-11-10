package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.MusicHarmonyApplication;
import br.com.ucs.MusicHarmony.dto.RequestLogin;
import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { MusicHarmonyApplication.class })
//@WebMvcTest(controllers = { LoginController.class })
//@AutoConfigureDataJpa
//@EnableAutoConfiguration
@AutoConfigureMockMvc
@SpringBootTest
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void returnExistUser() throws Exception {
        // Cria um objeto que simula uma instância
        // Nesses 4 atributos não utilizo, porém o método home() exige ter esses parametros
        Model model = mock(Model.class);
        HttpServletRequest requestSession = mock(HttpServletRequest.class);
        BindingResult errors = mock(BindingResult.class);
        // O request é utilizado para busca do usuário e senha do banco de dados
        RequestLogin request = mock(RequestLogin.class);
        System.out.println("request: " + request);
        LoginController userTest = new LoginController(userRepository);
        System.out.println("userTest: " + userTest);
        //when(userTest.home(model, request, requestSession, errors)).thenReturn(request.getUsername());
        //System.out.println(when(userRepository.getReferenceById(1L)));
//        OngoingStubbing<User> user = when(userRepository.getReferenceById(1L));
//        System.out.println("User: " + user.toString());

        //when(userRepository.findByUsername(any()));

        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(request.getUsername()));
        System.out.println("User: " + user);

        String requestNome = objectMapper.writeValueAsString(user.stream().map(User::getUsername));
        System.out.print("requestNome: " + requestNome + "\n\n");
        //String requestSenha = objectMapper.writeValueAsString(user.getPassword());

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestNome))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) content().string("Guilherme"));
    }

    @Test
    public void returnExistUser(Model model, RequestLogin request, HttpServletRequest requestSession, BindingResult errors) {
        LoginController userTest = new LoginController(userRepository);
        userTest.home(model, request, requestSession, errors);
        String nome = request.getUsername();
        String senha = request.getPassword();

        assertEquals("Guilherme", nome);
        assertEquals("123", senha);
    }
}