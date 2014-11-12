
package com.una.afv.repositories;

import com.una.afv.profile.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin Villalobos</a>
 */
@Transactional
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {
    
    public Cliente findByClienteId(Integer clienteId);
    
    public Cliente findByCorreoAndPassword(String correo, String password);
    
}
