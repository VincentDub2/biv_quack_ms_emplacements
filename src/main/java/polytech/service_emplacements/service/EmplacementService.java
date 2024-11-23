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

    public void PopulateDb() {
        emplacementRepository.deleteAll();

        Emplacement emplacement1 = new Emplacement(
                1L,
                "Camping Les Oliviers",
                "Chemin des Oliviers, Sussargues",
                "Un charmant emplacement entouré d'oliviers.",
                List.of("Eau potable", "Électricité"),
                null,
                43.714158,
                4.003973,
                25.0,
                "2024-01-01",
                "2024-12-31"
        );

        Emplacement emplacement2 = new Emplacement(
                2L,
                "Bivouac La Garrigue",
                "Route de la Garrigue, Sussargues",
                "Idéal pour les amateurs de nature sauvage.",
                List.of("Toilettes sèches", "Barbecue"),
                null,
                43.712158,
                4.005973,
                30.0,
                "2024-02-01",
                "2024-11-30"
        );

        Emplacement emplacement3 = new Emplacement(
                3L,
                "Aire de Camping Les Vignes",
                "Rue des Vignes, Sussargues",
                "Proche des vignobles, parfait pour une escapade tranquille.",
                List.of("Wi-Fi", "Douche chaude"),
                null,
                43.711158,
                4.002973,
                35.0,
                "2024-03-01",
                "2024-10-31"
        );

        Emplacement emplacement4 = new Emplacement(
                4L,
                "Espace Nature",
                "Avenue de la Nature, Sussargues",
                "Un emplacement spacieux avec une vue dégagée.",
                List.of("Table de pique-nique", "Point d'eau"),
                null,
                43.715158,
                4.004973,
                20.0,
                "2024-04-01",
                "2024-09-30"
        );

        Emplacement emplacement5 = new Emplacement(
                5L,
                "Aire de Repos Les Pins",
                "Impasse des Pins, Sussargues",
                "Idéal pour se reposer sous les pins ombragés.",
                List.of("Eau potable", "Parking gratuit"),
                null,
                43.713658,
                4.007973,
                15.0,
                "2024-05-01",
                "2024-08-31"
        );

        Emplacement emplacement6 = new Emplacement(
                6L,
                "Bivouac du Lac",
                "Chemin du Lac, Sussargues",
                "Proche d'un petit lac pour une expérience unique.",
                List.of("Pêche autorisée", "Barbecue"),
                null,
                43.710158,
                4.001973,
                40.0,
                "2024-06-01",
                "2024-07-31"
        );

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
