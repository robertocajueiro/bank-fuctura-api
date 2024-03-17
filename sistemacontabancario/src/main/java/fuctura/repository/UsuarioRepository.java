package fuctura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fuctura.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
