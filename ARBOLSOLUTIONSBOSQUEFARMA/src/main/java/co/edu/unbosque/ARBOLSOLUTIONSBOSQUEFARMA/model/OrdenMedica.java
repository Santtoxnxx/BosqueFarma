package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orden_medica") // Nombre de la tabla en la base de datos
public class OrdenMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_medica")
    private Long idOrdenMedica; // Se recomienda usar Long para claves primarias

    @Column(name = "id_entidad_salud", nullable = false)
    private int idEntidadSalud;

    @Column(name = "nombre_entidad_salud", nullable = false, length = 100)
    private String nombreEntidadSalud;

    @Column(name = "doc_paciente", nullable = false)
    private double docPaciente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_orden_medica") // Clave foránea en la tabla "formula"
    private List<Formula> formula; // Relación con la tabla "formula"

    // Constructor vacío para JPA
    public OrdenMedica() {}

    // Constructor con parámetros
    public OrdenMedica(int idEntidadSalud, String nombreEntidadSalud, double docPaciente, List<Formula> formula) {
        this.idEntidadSalud = idEntidadSalud;
        this.nombreEntidadSalud = nombreEntidadSalud;
        this.docPaciente = docPaciente;
        this.formula = formula;
    }

    // Getters y Setters
    public Long getIdOrdenMedica() {
        return idOrdenMedica;
    }

    public void setIdOrdenMedica(Long idOrdenMedica) {
        this.idOrdenMedica = idOrdenMedica;
    }

    public int getIdEntidadSalud() {
        return idEntidadSalud;
    }

    public void setIdEntidadSalud(int idEntidadSalud) {
        this.idEntidadSalud = idEntidadSalud;
    }

    public String getNombreEntidadSalud() {
        return nombreEntidadSalud;
    }

    public void setNombreEntidadSalud(String nombreEntidadSalud) {
        this.nombreEntidadSalud = nombreEntidadSalud;
    }

    public double getDocPaciente() {
        return docPaciente;
    }

    public void setDocPaciente(double docPaciente) {
        this.docPaciente = docPaciente;
    }

    public List<Formula> getFormula() {
        return formula;
    }

    public void setFormula(List<Formula> formula) {
        this.formula = formula;
    }
}