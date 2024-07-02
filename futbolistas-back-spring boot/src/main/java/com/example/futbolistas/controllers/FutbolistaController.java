package com.example.futbolistas.controllers;

import com.example.futbolistas.models.FutbolistaModel;
import com.example.futbolistas.services.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/futbolistas")
@CrossOrigin(origins = "http://localhost:3000")
public class FutbolistaController {

    @Autowired
    private FutbolistaService futbolistaService;

    // Obtener todos los futbolistas con paginación
    @GetMapping
    public Page<FutbolistaModel> getAllFutbolistas(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return futbolistaService.getFutbolistas(PageRequest.of(page, size));
    }

    // Obtener un futbolista por ID
    @GetMapping("/{id}")
    public Optional<FutbolistaModel> getFutbolistaById(@PathVariable("id") Long id) {
        return futbolistaService.getFutbolistaById(id);
    }

    // Crear un nuevo futbolista
    @PostMapping
    public FutbolistaModel createFutbolista(@RequestBody FutbolistaModel futbolista) {
        return futbolistaService.createFutbolista(futbolista);
    }

    // Actualizar un futbolista
    @PutMapping("/{id}")
    public FutbolistaModel updateFutbolista(@PathVariable("id") Long id, @RequestBody FutbolistaModel futbolista) {
        futbolista.setId(id); // Suponiendo que FutbolistaModel tiene un método setId
        return futbolistaService.updateFutbolista(futbolista);
    }

    // Eliminar un futbolista por ID
    @DeleteMapping("/{id}")
    public boolean deleteFutbolistaById(@PathVariable("id") Long id) {
        return futbolistaService.deleteFutbolistaById(id);
    }
}
