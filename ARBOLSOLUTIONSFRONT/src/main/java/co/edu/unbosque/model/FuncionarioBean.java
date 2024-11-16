package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.FuncionarioDAO;
import co.edu.unbosque.model.persistence.FuncionarioDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class FuncionarioBean {
    private FuncionarioDTO funcionario = new FuncionarioDTO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private List<FuncionarioDTO> listaFuncionarios;
    private boolean editando = false;  // Bandera para saber si estamos en modo edición

    public FuncionarioBean() {
        listaFuncionarios = funcionarioDAO.listar();
    }

    public String guardar() {
        try {
            if (editando) {
                funcionarioDAO.modificar(funcionario.getCedula(), funcionario);
                editando = false;
            } else {
                funcionarioDAO.agregar(funcionario);
            }
            listaFuncionarios = funcionarioDAO.listar();  // Actualizamos la lista
            return "funcionario.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "error.xhtml?faces-redirect=true";
        }
    }

    public void seleccionarParaEditar(FuncionarioDTO funcionarioSeleccionado) {
        this.funcionario = funcionarioSeleccionado;
        this.editando = true;
    }

    public String eliminar(FuncionarioDTO funcionario) {
        try {
            funcionarioDAO.eliminar(funcionario.getCedula());
            listaFuncionarios = funcionarioDAO.listar();  // Actualizamos la lista
            return "funcionario.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "error.xhtml?faces-redirect=true";
        }
    }

    // Getters y setters
    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public List<FuncionarioDTO> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<FuncionarioDTO> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}