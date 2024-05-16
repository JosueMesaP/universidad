package com.universidad.universidad.repositories;

import com.universidad.universidad.models.AsignaturasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsignaturasRepository extends JpaRepository<AsignaturasModel, Long> {
}
