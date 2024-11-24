package polytech.service_emplacements.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.service_emplacements.model.Commodite;
import polytech.service_emplacements.service.CommoditeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commodites")
public class CommoditeController {

    private final CommoditeService commoditeService;

    @Autowired
    public CommoditeController(CommoditeService commoditeService) {
        this.commoditeService = commoditeService;
    }

    // Créer une commodité
    @PostMapping
    public ResponseEntity<Commodite> createCommodite(@RequestBody Commodite commodite) {
        Commodite newCommodite = commoditeService.createCommodite(commodite);
        return new ResponseEntity<>(newCommodite, HttpStatus.CREATED);
    }

    // Lire toutes les commodités
    @GetMapping
    public ResponseEntity<List<Commodite>> getAllCommodites() {
        List<Commodite> commodites = commoditeService.getAllCommodites();
        return new ResponseEntity<>(commodites, HttpStatus.OK);
    }

    // Lire une commodité par ID
    @GetMapping("/{id}")
    public ResponseEntity<Commodite> getCommoditeById(@PathVariable Long id) {
        Optional<Commodite> commodite = commoditeService.getCommoditeById(id);
        return commodite.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mettre à jour une commodité
    @PutMapping("/{id}")
    public ResponseEntity<Commodite> updateCommodite(@PathVariable Long id, @RequestBody Commodite commodite) {
        Optional<Commodite> updatedCommodite = commoditeService.updateCommodite(id, commodite);
        return updatedCommodite.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Supprimer une commodité
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommodite(@PathVariable Long id) {
        boolean isDeleted = commoditeService.deleteCommodite(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}