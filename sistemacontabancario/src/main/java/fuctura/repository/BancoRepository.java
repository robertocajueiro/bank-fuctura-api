package fuctura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fuctura.model.Usuario;

public interface BancoRepository extends JpaRepository<Usuario, Long> {

}
