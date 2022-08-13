package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.Usuario;
import br.com.ucs.MusicHarmony.model.db.UsuarioDAO;
import br.com.ucs.MusicHarmony.model.dto.RequisicaoCadastro;
import br.com.ucs.MusicHarmony.model.dto.RequisicaoLogin;
import br.com.ucs.MusicHarmony.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Objects;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("Entrei login");
        return "login";
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String home(RequisicaoLogin request) {

            System.out.println("senha digitada: " + request.getPassword());

            Usuario user = usuarioRepository.findByUsername(request.getUsername());

            System.out.println("senha do banco: " + user.getPassword());

            return "redirect:/home";

//         // Implementar a logica do login
//         UsuarioDAO usuarioDAO = new UsuarioDAO();
//         Usuario usuario = new Usuario();

//         System.out.println(usuarioRepository.count());

//         System.out.println("Estou no loginController");

// //        Usuario usuarioCadastrado = usuarioDAO.getUsuario(usuario.getUsername(), usuario.getPassword());
// //        if ( (usuario.getUsername().equals(null) && usuario.getPassword().equals(null)) ||
// //                (usuario.getUsername().equals(usuarioCadastrado.getUsername()) &&
// //                        usuario.getPassword().equals(usuarioCadastrado.getPassword()))) {
// //            System.out.println("Usuário não encontrado!");
// //            return "redirect:/login";
// //        } else {
// //            System.out.println("Usuário encontrado!");
// //            return "redirect:/home";
// //        }


//         Usuario user = usuarioDAO.existeUsuario(usuario.getUsername(), usuario.getPassword());
//         if (user != null){
//             System.out.println("Usuario encontrado! " + usuario.getUsername());
//             HttpSession sessao = request.getSession();
//             sessao.setAttribute("usuarioLogado", usuario.getUsername());
//             return "redirect:/home";
//         } else {
//             System.out.println("Usuario não encontrado: " + usuario.getUsername());
//             return "redirect:/home";
//         }
// //        return "redirect:/home";
    }
}
// http://localhost:8080/login