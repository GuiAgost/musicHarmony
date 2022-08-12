package br.com.ucs.MusicHarmony.model.db;

import br.com.ucs.MusicHarmony.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("users");
    private final EntityManager em = factory.createEntityManager();

    private static List<Usuario> listaUsuarios = new ArrayList<>();

//    public Usuario getUsuario(String usuarioCadastrado, String senhaCadastrado) {
//        try {
//            return (Usuario) em.createQuery(
//                            "SELECT u from Usuario u where u.username =:username and u.password =:password")
//                    .setParameter("username", usuarioCadastrado)
//                    .setParameter("password", senhaCadastrado).getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }

    public Usuario existeUsuario(String usuarioCadastrado, String senhaCadastrado){
        System.out.println("Antes da comparação: UsuarioDAO: " + usuarioCadastrado);
        for (Usuario login :  listaUsuarios) {
            if (login.isEquals(usuarioCadastrado, senhaCadastrado)){
                System.out.println("Comparado com sucesso: UsuarioDAO: " + login);
                return login;
            }
        }
        System.out.println("Comparado insucesso: UsuarioDAO: " + usuarioCadastrado);
        return null;
    }
}
