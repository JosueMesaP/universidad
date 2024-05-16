package com.universidad.universidad.repositories;

import com.universidad.universidad.models.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepository extends JpaRepository<EstudianteModel, Long> {
}
