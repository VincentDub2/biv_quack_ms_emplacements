package polytech.service_emplacements.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.service_emplacements.model.Emplacement;
import polytech.service_emplacements.service.EmplacementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmplacementController {

    private final EmplacementService emplacementService;

    @Autowired
    public EmplacementController(EmplacementService emplacementService) {
        this.emplacementService = emplacementService;
    }

    // Récupérer tous les emplacements
    @GetMapping
    public ResponseEntity<List<Emplacement>> getAllEmplacements() {
        List<Emplacement> emplacements = emplacementService.getAllEmplacements();
        return ResponseEntity.ok(emplacements);
    }

    // Créer un nouvel emplacement
    @PostMapping
    public ResponseEntity<Emplacement> createEmplacement(@RequestBody Emplacement emplacement) {
        Emplacement newEmplacement = emplacementService.createEmplacement(emplacement);
        return ResponseEntity.status(201).body(newEmplacement);
    }

    // Mettre à jour un emplacement
    @PutMapping("/{id}")
    public ResponseEntity<Emplacement> updateEmplacement(@PathVariable Long id, @RequestBody Emplacement emplacement) {
        Optional<Emplacement> updatedEmplacement = emplacementService.updateEmplacement(id, emplacement);
        return updatedEmplacement.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un emplacement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmplacement(@PathVariable Long id) {
        boolean deleted = emplacementService.deleteEmplacement(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
