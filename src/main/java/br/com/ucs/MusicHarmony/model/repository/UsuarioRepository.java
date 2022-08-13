package br.com.ucs.MusicHarmony.model.repository;

import br.com.ucs.MusicHarmony.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    /**
     * Find persons by address.
     */
    // @Query(FIND_BY_ADDRESS_QUERY)
    public Usuario findByUsername(String username);
}

