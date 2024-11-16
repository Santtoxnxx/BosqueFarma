package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model;

import javax.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private int idInventario;

    @ManyToOne
    @JoinColumn(name = "id_medicamento", referencedColumnName = "idMedicamento")
    private Medicamento medicamento;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipo_movimiento", nullable = false)
    private String tipoMovimiento;

    // Constructor vacío para JPA
    public Inventario() {}

    // Constructor con parámetros
    public Inventario(Medicamento medicamento, int cantidad, String tipoMovimiento) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
    }

    // Getters y Setters
    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
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

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}