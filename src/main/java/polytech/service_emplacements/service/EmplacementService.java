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
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2020-05/2MOsskov-shelter-229505_Shelters_ved_Store_kss.jpg",
                43.714158,
                4.003973,
                25.0,
                "2024-01-01",
                "2024-12-31"
        );

        Emplacement emplacement2 = new Emplacement(
                1L,
                "Bivouac La Garrigue",
                "Route de la Garrigue, Sussargues",
                "Idéal pour les amateurs de nature sauvage.",
                List.of("Toilettes sèches", "Barbecue"),
                "https://voyageforum.info/images/hd/posts/openmedium/1511769264-wO8nr2WXGVjDAki.jpg",
                43.712158,
                4.005973,
                30.0,
                "2024-02-01",
                "2024-11-30"
        );

        Emplacement emplacement3 = new Emplacement(
                1L,
                "Aire de Camping Les Vignes",
                "Rue des Vignes, Sussargues",
                "Proche des vignobles, parfait pour une escapade tranquille.",
                List.of("Wi-Fi", "Douche chaude"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2022-08/slaggaard-banke-shelter-naturlejrplads-hanne-nielsen-2021-6-1200px.jpg",
                43.711158,
                4.002973,
                35.0,
                "2024-03-01",
                "2024-10-31"
        );

        Emplacement emplacement4 = new Emplacement(
                2L,
                "Espace Nature",
                "Avenue de la Nature, Sussargues",
                "Un emplacement spacieux avec une vue dégagée.",
                List.of("Table de pique-nique", "Point d'eau"),
                "https://www.das-baumhaushotel.de/images/02_Wohnen/01_stadl/01_Stadl_Aussenansicht_fern.jpg",
                43.715158,
                4.004973,
                20.0,
                "2024-04-01",
                "2024-09-30"
        );

        Emplacement emplacement5 = new Emplacement(
                3L,
                "Aire de Repos Les Pins",
                "Impasse des Pins, Sussargues",
                "Idéal pour se reposer sous les pins ombragés.",
                List.of("Eau potable", "Parking gratuit"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2020-05/rorervig-centrets-shelter-01.jpg",
                43.713658,
                4.007973,
                15.0,
                "2024-05-01",
                "2024-08-31"
        );

        Emplacement emplacement6 = new Emplacement(
                3L,
                "Bivouac du Lac",
                "Chemin du Lac, Sussargues",
                "Proche d'un petit lac pour une expérience unique.",
                List.of("Pêche autorisée", "Barbecue"),
                "https://campspace.com/media/detail/uploads/space/hc/_d/f2/hc_df2797237efff3f1a547922516a3f7d1.jpeg",
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
