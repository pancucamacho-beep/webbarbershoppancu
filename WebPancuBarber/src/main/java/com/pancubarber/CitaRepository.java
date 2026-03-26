package com.pancubarber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Esto servirá para contar cuántas veces ha venido un cliente por su teléfono
    long countByTelefono(String telefono);
}