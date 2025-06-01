package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.dto.RequestRegistration;
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

    public boolean userAlreadyExists (RequestRegistration request) {
        User user = userRepository.findByUsername(request.getUsername());
        return user != null;
    }

    public void saveNewuser (RequestRegistration request) {
        User newUser = request.toUsuario();
        userRepository.save(newUser);
    }
}
