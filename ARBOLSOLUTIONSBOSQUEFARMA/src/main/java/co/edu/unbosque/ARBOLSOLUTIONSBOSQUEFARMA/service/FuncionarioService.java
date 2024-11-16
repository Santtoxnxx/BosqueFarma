package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.service;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.FuncionarioDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService implements UserDetailsService {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Funcionarios> funcionario = funcionarioDAO.findByUsername(username);
        return funcionario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}

