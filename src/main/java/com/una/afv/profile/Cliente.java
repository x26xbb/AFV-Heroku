package com.una.afv.profile;

import com.google.gson.annotations.Expose;
import com.una.afv.budget.Presupuesto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CLIENTE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer clienteId;

    @Column(name = "CLIENTE_EMAIL")
    @Expose
    private String correo;

    @Column(name = "CLIENTE_PASS")
    private String password;

    @Column(name = "CLIENTE_NAME")
    @Expose
    private String nombre;

    @OneToMany(mappedBy = "cliente") //, fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Expose
    private List<Presupuesto> presupuestos;

    public Cliente(String correo, String password, String nombre) {
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
    }

    /**
     *
     */
    public Cliente() {
    }

    /**
     * @return the clienteId
     */
    public Integer getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the presupuestos
     */
    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    /**
     * @param presupuestos the presupuestos to set
     */
    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

}
