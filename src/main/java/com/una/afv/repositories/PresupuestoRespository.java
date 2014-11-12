package com.una.afv.repositories;

import com.una.afv.budget.Presupuesto;
import com.una.afv.profile.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
@Transactional
public interface PresupuestoRespository extends JpaRepository<Presupuesto, Integer> {

    public Presupuesto findByPresupuestoId(Integer presupuestoId);
    
    public List<Presupuesto> findByCliente(Cliente cliente);
}
