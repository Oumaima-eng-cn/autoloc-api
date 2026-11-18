package fr.ece.autoloc.service;

import fr.ece.autoloc.domain.Vehicule;
import fr.ece.autoloc.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<Vehicule> obtenirTousLesVehicules() {
        return vehiculeRepository.findAll();
    }

    public Optional<Vehicule> obtenirVehiculeParId(Long id) {
        return vehiculeRepository.findById(id);
    }

    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule modifierVehicule(Long id, Vehicule vehicule) {
        if (!vehiculeRepository.existsById(id)) {
            throw new RuntimeException("Véhicule introuvable : " + id);
        }
        vehicule.setIdVehicule(id);
        return vehiculeRepository.save(vehicule);
    }

    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}