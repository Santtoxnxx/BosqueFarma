package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioDAO extends JpaRepository<Funcionarios, Long> {
    Optional<Funcionarios> findByUsername(String username);
}