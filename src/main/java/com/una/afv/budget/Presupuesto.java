package com.una.afv.budget;

import com.google.gson.annotations.Expose;
import com.una.afv.profile.Cliente;
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
@Table(name = "PRESUPUESTO")
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRESUPUESTO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer presupuestoId;

    @Column(name = "PRESUPUESTO_NAME")
    @Expose
    private String nombre;

    @Column(name = "PRESUPUESTO_COMMENT")
    @Expose
    private String proposito;

    @Column(name = "PRESUPUESTO_INCOMING")
    @Expose
    private Long ingreso;

    @OneToMany(mappedBy = "presupuesto") //, fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Expose
    private List<Categoria> categorias;

    @ManyToOne
    @JoinColumn(name = "CLIENTE")
    private Cliente cliente;

    /**
     *
     */
    public Presupuesto() {
    }

    /**
     * 
     * @param nombre
     * @param proposito
     * @param ingreso 
     */
    public Presupuesto(String nombre, String proposito, Long ingreso) {
        this.nombre = nombre;
        this.proposito = proposito;
        this.ingreso = ingreso;
    }

    /**
     * @return the presupuestoId
     */
    public Integer getPresupuestoId() {
        return presupuestoId;
    }

    /**
     * @param presupuestoId the presupuestoId to set
     */
    public void setPresupuestoId(Integer presupuestoId) {
        this.presupuestoId = presupuestoId;
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
     * @return the proposito
     */
    public String getProposito() {
        return proposito;
    }

    /**
     * @param proposito the proposito to set
     */
    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    /**
     * @return the categorias
     */
    public List<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the ingreso
     */
    public Long getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(Long ingreso) {
        this.ingreso = ingreso;
    }

}
