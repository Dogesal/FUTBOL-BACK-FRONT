package com.example.futbolistas.services;

import com.example.futbolistas.models.FutbolistaModel;
import com.example.futbolistas.models.PosicionModel;
import com.example.futbolistas.repositories.IFutbolistaRepository;
import com.example.futbolistas.repositories.IPosicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FutbolistaService {

    @Autowired
    IFutbolistaRepository futbolistaRepository;

    @Autowired
    PosicionService posicionService;

    // Obtener todos los futbolistas con paginación
    public Page<FutbolistaModel> getFutbolistas(Pageable pageable) {
        return futbolistaRepository.findAll(pageable);
    }

    // Crear un nuevo futbolista
    public FutbolistaModel createFutbolista(FutbolistaModel futbolista) {
        if (futbolista.getPosicion() != null && futbolista.getPosicion().getId() != null) {
            PosicionModel posicion = posicionService.getPosicionById(futbolista.getPosicion().getId()).orElse(null);
            if (posicion != null) {
                futbolista.setPosicion(posicion);
            } else {
                throw new IllegalArgumentException("Invalid PosicionModel ID");
            }
        } else {
            throw new IllegalArgumentException("PosicionModel is required");
        }
        return futbolistaRepository.save(futbolista);
    }

    // Obtener un futbolista por ID
    public Optional<FutbolistaModel> getFutbolistaById(Long id) {
        return futbolistaRepository.findById(id);
    }

    // Actualizar un futbolista
    public FutbolistaModel updateFutbolista(FutbolistaModel futbolista) {
        return futbolistaRepository.save(futbolista);
    }

    // Eliminar un futbolista por ID
    public boolean deleteFutbolistaById(Long id) {
        try {
            futbolistaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
