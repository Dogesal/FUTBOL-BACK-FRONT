package com.example.futbolistas.services;

import com.example.futbolistas.models.PosicionModel;
import com.example.futbolistas.repositories.IPosicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PosicionService {

    @Autowired
    IPosicionRepository posicionRepository;

    // Obtener todas las posiciones
    public ArrayList<PosicionModel> getPosiciones() {
        return (ArrayList<PosicionModel>) posicionRepository.findAll();
    }

    // Crear una nueva posición
    public PosicionModel createPosicion(PosicionModel posicion) {
        return posicionRepository.save(posicion);
    }

    // Obtener una posición por ID
    public Optional<PosicionModel> getPosicionById(Long id) {
        return posicionRepository.findById(id);
    }

    // Actualizar una posición
    public PosicionModel updatePosicion(PosicionModel posicion) {
        return posicionRepository.save(posicion);
    }

    // Eliminar una posición por ID
    public boolean deletePosicionById(Long id) {
        try {
            posicionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
