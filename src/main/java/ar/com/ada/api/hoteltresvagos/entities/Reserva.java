package ar.com.ada.api.hoteltresvagos.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="reserva")
public class Reserva {

    
    //identificador unico y poner notacion @Id justo arriba del atributo
    @Id
    @Column(name="reserva_id") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservaId ;
    @Column(name="fecha_reserva")
    private Date fechaReserva; //objeto Date soporta la hora tmb. Date tiene como 4 variantes. (Java.util) La mas generica Java(sql) LocalDate - Instant
    @Column(name="fecha_ingreso")
    private Date fechaIngreso;
    @Column(name="fecha_egreso") 
    private Date fechaEgreso; 
    private Integer habitacion; //no le pongo anotacion porque se llaman igual en la db 
    @Column(name= "importe_reserva")
    private BigDecimal importeReserva;
    @Column(name= "importe_total") 
    private BigDecimal importeTotal;
    @Column(name= "importe_pagado")
    private BigDecimal importePagado; 
    @Column(name= "importe_a_pagar") 
    private BigDecimal importeAPagar;
    @Column(name="estado_id") 
    private int tipoEstadoPagoId;  //Por ahora vamos a crear este como int

    @ManyToOne
    @JoinColumn(name ="huesped_id", referencedColumnName = "huesped_id")
    private Huesped huesped;

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
    }

    public BigDecimal getImporteReserva() {
        return importeReserva;
    }

    public void setImporteReserva(BigDecimal importeReserva) {
        this.importeReserva = importeReserva;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }

    public BigDecimal getImporteAPagar() {
        return importeAPagar;
    }

    public void setImporteAPagar(BigDecimal importeAPagar) {
        this.importeAPagar = importeAPagar;
    }

    public int getTipoEstadoPagoId() {
        return tipoEstadoPagoId;
    }

    public void setTipoEstadoPagoId(int tipoEstadoPagoId) {
        this.tipoEstadoPagoId = tipoEstadoPagoId;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
        this.huesped.getReservas().add(this); //agregar el huesped a lista de reservas en huesped.
    }


    // Sirve para debugear, no usar para mostrar en la terminal(usar .getAlgo())
     @Override
    public String toString() {
        return " [reservaid = " + this.getReservaId() + ", importe = " + this.getImporteTotal() + "] ";
    }

    //double importe = 0; 
    //double importe2 = 1; 
    //double importe3 = importe  + importe2; 

    //BigDecimal importe = new BigDecimal(0); 
    //BigDecimal importe2 =  new BigDecimal(1); 
    //BigDecimal importe3 =  importe.add(importe2); 

    //double importe = (var1 * 10 / 365) + 50 + var3*8 

    //double importe = 10 / 3;  3.33333333333333333333
    //BigDecimal: 3.33 o 3.34 
    
}