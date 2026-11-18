package fr.ece.autoloc.controller;

import fr.ece.autoloc.domain.Vehicule;
import fr.ece.autoloc.service.VehiculeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    public List<Vehicule> obtenirTousLesVehicules() {
        return vehiculeService.obtenirTousLesVehicules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> obtenirVehiculeParId(@PathVariable Long id) {
        return vehiculeService.obtenirVehiculeParId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule modifierVehicule(@PathVariable Long id,
                                     @RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(id, vehicule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
        return ResponseEntity.noContent().build();
    }
}