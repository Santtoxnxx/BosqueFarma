package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Funcionarios;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginAPI {

    @Autowired
    private FuncionarioService funcionarioDetailsService;

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        try {
            Funcionarios funcionario = (Funcionarios) funcionarioDetailsService.loadUserByUsername(username);
            if (funcionario.getPassword().equals(password)) {
                return "Login exitoso: Bienvenido " + funcionario.getUsername();
            } else {
                return "Error: Contraseña incorrecta";
            }
        } catch (UsernameNotFoundException e) {
            return "Error: " + e.getMessage();
        }
    }
}
