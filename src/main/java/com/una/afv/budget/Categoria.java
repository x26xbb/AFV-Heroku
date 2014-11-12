package com.una.afv.budget;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CATEGORIA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer categoriaId;

    @Column(name = "CATEGORIA_NAME")
    @Expose
    private String nombre;

    @Column(name = "CATEGORIA_PERC")
    @Expose
    private Integer porcentaje;

    @OneToMany(mappedBy = "categoria") //, fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Expose
    private List<Gasto> gastos;

    @ManyToOne
    @JoinColumn(name = "PRESUPUESTO")
    private Presupuesto presupuesto;

    /**
     *
     */
    public Categoria() {
    }

    /**
     *
     * @param nombre
     * @param porcentaje
     */
    public Categoria(String nombre, Integer porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    /**
     * @return the categoriaId
     */
    public Integer getCategoriaId() {
        return categoriaId;
    }

    /**
     * @param categoriaId the categoriaId to set
     */
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
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
     * @return the gastos
     */
    public List<Gasto> getGastos() {
        return gastos;
    }

    /**
     * @param gastos the gastos to set
     */
    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    /**
     * @return the presupuesto
     */
    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * @return the porcentaje
     */
    public Integer getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

}
