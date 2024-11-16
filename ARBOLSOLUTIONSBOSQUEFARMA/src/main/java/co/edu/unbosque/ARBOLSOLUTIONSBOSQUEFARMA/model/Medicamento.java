package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model;

import javax.persistence.*;

@Entity
@Table(name = "medicamento") // Tabla en la base de datos
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento") // Se recomienda snake_case para columnas en SQL
    private int idMedicamento;

    @Column(name = "nombre_medicamento", nullable = false)
    private String nombreMedicamento;

    @Column(name = "presentacion", nullable = false)
    private String presentacion;

    @Column(name = "costo", nullable = false)
    private double costo;

    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidadDisponible;

    // Constructor vacío obligatorio para JPA
    public Medicamento() {}

    // Constructor con parámetros
    public Medicamento(String nombreMedicamento, String presentacion, double costo, int cantidadDisponible) {
        this.nombreMedicamento = nombreMedicamento;
        this.presentacion = presentacion;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y Setters
    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}