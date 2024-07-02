package com.example.futbolistas.controllers;

import com.example.futbolistas.models.PosicionModel;
import com.example.futbolistas.services.PosicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posiciones")
@CrossOrigin(origins = "http://localhost:3000")
public class PosicionController {

    @Autowired
    private PosicionService posicionService;

    // Obtener todas las posiciones
    @GetMapping
    public List<PosicionModel> getAllPosiciones() {
        return posicionService.getPosiciones();
    }

    // Obtener una posición por ID
    @GetMapping("/{id}")
    public Optional<PosicionModel> getPosicionById(@PathVariable("id") Long id) {
        return posicionService.getPosicionById(id);
    }

    // Crear una nueva posición
    @PostMapping
    public PosicionModel createPosicion(@RequestBody PosicionModel posicion) {
        return posicionService.createPosicion(posicion);
    }

    // Actualizar una posición
    @PutMapping("/{id}")
    public PosicionModel updatePosicion(@PathVariable("id") Long id, @RequestBody PosicionModel posicion) {
        posicion.setId(id); // Suponiendo que PosicionModel tiene un método setId
        return posicionService.updatePosicion(posicion);
    }

    // Eliminar una posición por ID
    @DeleteMapping("/{id}")
    public boolean deletePosicionById(@PathVariable("id") Long id) {
        return posicionService.deletePosicionById(id);
    }
}
