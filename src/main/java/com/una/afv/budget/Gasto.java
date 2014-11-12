package com.una.afv.budget;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
@Entity
@Table(name = "GASTO")
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GASTOID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer gastoId;

    @Column(name = "GASTONAME")
    @Expose
    private String nombre;

    @Column(name = "GASTOAMOUNT")
    @Expose
    private Long monto;
    
    @ManyToOne
    @JoinColumn(name = "CATEGORIA")
    private Categoria categoria;

    /**
     * 
     */
    public Gasto() {
    }
    
    /**
     * 
     * @param nombre
     * @param monto 
     */
    public Gasto(String nombre, Long monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    /**
     * @return the gastoId
     */
    public Integer getGastoId() {
        return gastoId;
    }

    /**
     * @param gastoId the gastoId to set
     */
    public void setGastoId(Integer gastoId) {
        this.gastoId = gastoId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the monto
     */
    public Long getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Long monto) {
        this.monto = monto;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
       
    
}
