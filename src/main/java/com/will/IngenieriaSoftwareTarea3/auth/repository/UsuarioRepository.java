package com.will.IngenieriaSoftwareTarea3.auth.repository;

import com.will.IngenieriaSoftwareTarea3.auth.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);  // EL campo es "nombre"
    Usuario findByEmail(String email);
}