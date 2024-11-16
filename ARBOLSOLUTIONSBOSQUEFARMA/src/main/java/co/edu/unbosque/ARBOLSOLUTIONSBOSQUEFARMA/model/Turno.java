package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turnos") // Asocia la clase a la tabla 'turnos'
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria autogenerada
    @Column(name = "id_turno")
    private int idTurno;

    @Column(name = "doc_paciente")
    private long docPaciente;

    @Column(name = "caja")
    private int caja;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "num_turno")
    private int numTurno;

    // Constructor con parámetros
    public Turno(int idTurno, int numTurno, int caja, long docPaciente, String estado) {
        this.idTurno = idTurno;
        this.numTurno = numTurno;
        this.caja = caja;
        this.docPaciente = docPaciente;
        this.estado = estado;
    }

    // Constructor vacío para JPA
    public Turno() {}

    // Getters y Setters
    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public long getDocPaciente() {
        return docPaciente;
    }

    public void setDocPaciente(long docPaciente) {
        this.docPaciente = docPaciente;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumTurno() {
        return numTurno;
    }

    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
    }
}