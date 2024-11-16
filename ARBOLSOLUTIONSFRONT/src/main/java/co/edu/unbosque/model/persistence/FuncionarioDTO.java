package co.edu.unbosque.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class FuncionarioDTO {

    @Id
    @Column(name = "cedula")
    private double cedula;
    
    @Column(name = "nombre", length = 30)
    private String nombre;
    
    @Column(name = "clave", length = 20)
    private String clave;

    public FuncionarioDTO(double cedula, String nombre, String clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
    }

    public FuncionarioDTO() {}

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

