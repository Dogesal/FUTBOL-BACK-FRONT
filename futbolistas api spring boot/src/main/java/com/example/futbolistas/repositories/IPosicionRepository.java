package com.example.futbolistas.repositories;

import com.example.futbolistas.models.PosicionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPosicionRepository extends JpaRepository<PosicionModel, Long> {
    Optional<PosicionModel> findByNombre(String nombre);
}
