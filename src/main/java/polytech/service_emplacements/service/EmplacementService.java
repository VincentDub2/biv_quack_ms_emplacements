package polytech.service_emplacements.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.service_emplacements.model.Emplacement;
import polytech.service_emplacements.repository.EmplacementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmplacementService {

    private final EmplacementRepository emplacementRepository;

    @Autowired
    public EmplacementService(EmplacementRepository emplacementRepository) {
        this.emplacementRepository = emplacementRepository;
    }

    public void PopulateDb () {
        emplacementRepository.deleteAll();
        Emplacement emplacement1 = new Emplacement(1L, "Emplacement 1", "Adresse 1", "Description 1", List.of("Commodité 1", "Commodité 2"), null, 1.0, 1.0, 1.0, "2021-01-01", "2021-01-02");
        Emplacement emplacement2 = new Emplacement(2L, "Emplacement 2", "Adresse 2", "Description 2", List.of("Commodité 3", "Commodité 4"), null, 2.0, 2.0, 2.0, "2021-01-03", "2021-01-04");
        Emplacement emplacement3 = new Emplacement(3L, "Emplacement 3", "Adresse 3", "Description 3", List.of("Commodité 5", "Commodité 6"), null, 3.0, 3.0, 3.0, "2021-01-05", "2021-01-06");
        Emplacement emplacement4 = new Emplacement(1L, "Emplacement 4", "Adresse 1", "Description 1", List.of("Commodité 1", "Commodité 2"), null, 1.0, 1.0, 1.0, "2021-01-01", "2021-01-02");
        Emplacement emplacement5 = new Emplacement(2L, "Emplacement 5", "Adresse 2", "Description 2", List.of("Commodité 3", "Commodité 4"), null, 2.0, 2.0, 2.0, "2021-01-03", "2021-01-04");
        Emplacement emplacement6 = new Emplacement(3L, "Emplacement 6", "Adresse 3", "Description 3", List.of("Commodité 5", "Commodité 6"), null, 3.0, 3.0, 3.0, "2021-01-05", "2021-01-06");
        emplacementRepository.save(emplacement1);
        emplacementRepository.save(emplacement2);
        emplacementRepository.save(emplacement3);
        emplacementRepository.save(emplacement4);
        emplacementRepository.save(emplacement5);
        emplacementRepository.save(emplacement6);
    }

    // Récupérer tous les emplacements
    public List<Emplacement> getAllEmplacements() {
        return emplacementRepository.findAll();
    }

    // Récupérer un emplacement par ID
    public Optional<Emplacement> getEmplacementById(Long id) {
        return emplacementRepository.findById(id);
    }

    // Créer un nouvel emplacement
    public Emplacement createEmplacement(Emplacement emplacement) {
        return emplacementRepository.save(emplacement);
    }

    // Mettre à jour un emplacement existant
    public Optional<Emplacement> updateEmplacement(Long id, Emplacement updatedEmplacement) {
        return emplacementRepository.findById(id).map(emplacement -> {
            emplacement.setNom(updatedEmplacement.getNom());
            emplacement.setAdresse(updatedEmplacement.getAdresse());
            emplacement.setDescription(updatedEmplacement.getDescription());
            emplacement.setCommodites(updatedEmplacement.getCommodites());
            emplacement.setImage(updatedEmplacement.getImage());
            emplacement.setLatitude(updatedEmplacement.getLatitude());
            emplacement.setLongitude(updatedEmplacement.getLongitude());
            emplacement.setPrixParNuit(updatedEmplacement.getPrixParNuit());
            emplacement.setDateDebut(updatedEmplacement.getDateDebut());
            emplacement.setDateFin(updatedEmplacement.getDateFin());
            return emplacementRepository.save(emplacement);
        });
    }

    // Supprimer un emplacement
    public boolean deleteEmplacement(Long id) {
        if (emplacementRepository.existsById(id)) {
            emplacementRepository.deleteById(id);
            return true; // Retourne true si l'emplacement a été supprimé
        }
        return false; // Retourne false si l'emplacement n'existe pas
    }


    // Récupérer les emplacements par un hôte spécifique
    public List<Emplacement> getEmplacementsByHoteId(Long idHote) {
        return emplacementRepository.findByIdHote(idHote);
    }
}
