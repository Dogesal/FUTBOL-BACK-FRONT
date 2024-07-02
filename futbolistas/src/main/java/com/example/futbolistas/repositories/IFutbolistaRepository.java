package com.example.futbolistas.repositories;

import com.example.futbolistas.models.FutbolistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IFutbolistaRepository extends JpaRepository<FutbolistaModel, Long> {

}
