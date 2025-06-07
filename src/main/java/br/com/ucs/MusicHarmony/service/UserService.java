package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.dto.RequestLogin;
import br.com.ucs.MusicHarmony.dto.RequestRegistration;
import br.com.ucs.MusicHarmony.mapper.UserMapper;
import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Injeção de dependência baseada em campo, que usa a instância do repository
    // isso permite que não há necessidade de declarar um construtor para a class
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public boolean userAlreadyExists (RequestRegistration request) {
        User user = userRepository.findByUsername(request.getUsername());
        return user != null;
    }

    // Salva o usuário e senha no banco de dados
    public void saveNewuser (RequestRegistration request) {
        User newUser = userMapper.toEntity(request);
        userRepository.save(newUser);
    }

    // Autentica o usuário
    public User userAuth(RequestLogin request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && request.getPassword().equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
