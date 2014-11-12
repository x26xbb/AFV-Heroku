package com.una.afv.repositories;

import com.una.afv.budget.Categoria;
import com.una.afv.budget.Presupuesto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
@Transactional
public interface CategoriaRespository extends JpaRepository<Categoria, Integer> {

    public Categoria findByCategoriaId(Integer categoriaId);

    public List<Categoria> findByPresupuesto(Presupuesto presupuesto);

}
