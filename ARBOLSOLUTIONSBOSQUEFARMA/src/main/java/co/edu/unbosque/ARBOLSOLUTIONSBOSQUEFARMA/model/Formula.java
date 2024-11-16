package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model;

import javax.persistence.*;

@Entity
@Table(name = "formula") // Nombre de la tabla en la base de datos
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formula")
    private int idFormula;

    @ManyToOne
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento", nullable = false)
    private Medicamento medicamento;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    // Constructor vacío para JPA
    public Formula() {}

    // Constructor con parámetros
    public Formula(Medicamento medicamento, int cantidad) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}