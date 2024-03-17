package fuctura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fuctura.model.ContaCorrente;

public interface ContaRepository extends JpaRepository<ContaCorrente, Long> {

}
