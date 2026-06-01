package br.com.dev.DockerTraining.repository;

import br.com.dev.DockerTraining.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {
}