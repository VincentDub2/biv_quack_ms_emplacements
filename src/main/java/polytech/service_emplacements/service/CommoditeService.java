package polytech.service_emplacements.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.service_emplacements.model.Commodite;
import polytech.service_emplacements.repository.CommoditeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommoditeService {

    private final CommoditeRepository commoditeRepository;

    @Autowired
    public CommoditeService(CommoditeRepository commoditeRepository) {
        this.commoditeRepository = commoditeRepository;
    }

    // Créer une commodité
    public Commodite createCommodite(Commodite commodite) {
        return commoditeRepository.save(commodite);
    }

    // Lire toutes les commodités
    public List<Commodite> getAllCommodites() {
        return commoditeRepository.findAll();
    }

    // Lire une commodité par ID
    public Optional<Commodite> getCommoditeById(Long id) {
        return commoditeRepository.findById(id);
    }

    // Mettre à jour une commodité
    public Optional<Commodite> updateCommodite(Long id, Commodite updatedCommodite) {
        return commoditeRepository.findById(id).map(commodite -> {
            commodite.setNom(updatedCommodite.getNom());
            return commoditeRepository.save(commodite);
        });
    }

    // Supprimer une commodité
    public boolean deleteCommodite(Long id) {
        if (commoditeRepository.existsById(id)) {
            commoditeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
