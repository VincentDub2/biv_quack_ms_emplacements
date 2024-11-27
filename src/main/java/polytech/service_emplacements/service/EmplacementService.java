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
                List.of("Eau potable", "Prise électrique"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2020-05/2MOsskov-shelter-229505_Shelters_ved_Store_kss.jpg",
                43.717158,
                3.920973,
                25.0,
                "2024-01-01",
                "2024-12-31"
        );

        Emplacement emplacement2 = new Emplacement(
                1L,
                "Bivouac La Garrigue",
                "Route de la Garrigue, Sussargues",
                "Idéal pour les amateurs de nature sauvage.",
                List.of("Barbecue", "Toilettes"),
                "https://voyageforum.info/images/hd/posts/openmedium/1511769264-wO8nr2WXGVjDAki.jpg",
                43.715158,
                3.945973,
                30.0,
                "2024-02-01",
                "2024-11-30"
        );

        Emplacement emplacement3 = new Emplacement(
                1L,
                "Aire de Camping Les Vignes",
                "Rue des Vignes, Sussargues",
                "Proche des vignobles, parfait pour une escapade tranquille.",
                List.of("Wi-Fi", "Douche"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2022-08/slaggaard-banke-shelter-naturlejrplads-hanne-nielsen-2021-6-1200px.jpg",
                43.710158,
                3.975973,
                35.0,
                "2024-03-01",
                "2024-10-31"
        );

        Emplacement emplacement4 = new Emplacement(
                2L,
                "Espace Nature",
                "Avenue de la Nature, Sussargues",
                "Un emplacement spacieux avec une vue dégagée.",
                List.of("Barbecue", "Eau potable"),
                "https://www.das-baumhaushotel.de/images/02_Wohnen/01_stadl/01_Stadl_Aussenansicht_fern.jpg",
                43.735158,
                3.995973,
                20.0,
                "2024-04-01",
                "2024-09-30"
        );

        Emplacement emplacement5 = new Emplacement(
                3L,
                "Aire de Repos Les Pins",
                "Impasse des Pins, Sussargues",
                "Idéal pour se reposer sous les pins ombragés.",
                List.of("Eau potable", "Toilettes"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2020-05/rorervig-centrets-shelter-01.jpg",
                43.740158,
                3.930973,
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
                43.745158,
                3.950973,
                40.0,
                "2024-06-01",
                "2024-07-31"
        );

        Emplacement emplacement7 = new Emplacement(
                4L,
                "Domaine de la Colline",
                "Montferrier-sur-Lez, Chemin de la Colline",
                "Un cadre paisible au cœur de la nature montpelliéraine.",
                List.of("Douche", "Wi-Fi", "Toilettes"),
                "https://voyageforum.info/images/hd/posts/openmedium/1511374020-WUl1MFhnXKjO52C.jpg",
                43.675158,
                3.870973,
                45.0,
                "2024-07-01",
                "2024-12-31"
        );

        Emplacement emplacement8 = new Emplacement(
                5L,
                "Camping Bord de Mer",
                "Carnon-Plage, Avenue des Dunes",
                "Emplacement avec accès direct à la plage.",
                List.of("Barbecue", "Douche"),
                "https://nosrevesdeboheme.com/wp-content/uploads/2021/03/20190516_193300.jpg?w=1024",
                43.550158,
                3.940973,
                60.0,
                "2024-05-01",
                "2024-09-30"
        );

        Emplacement emplacement9 = new Emplacement(
                1L,
                "Le Refuge du Pic",
                "Chemin du Pic Saint-Loup, Cazevieille",
                "Un endroit isolé au pied du Pic Saint-Loup.",
                List.of("Eau potable", "Wi-Fi"),
                "https://vacances-seasonova.com/wp-content/uploads/2020/03/bivouac-nomade.jpg",
                43.772158,
                3.819973,
                35.0,
                "2024-03-01",
                "2024-11-30"
        );

        Emplacement emplacement10 = new Emplacement(
                1L,
                "Aire de Camping du Levant",
                "Avenue des Tamaris, Palavas-les-Flots",
                "Proche de la mer, parfait pour les amateurs de baignade.",
                List.of("Prise électrique", "Douche"),
                "https://static.apidae-tourisme.com/filestore/objets-touristiques/images/200/51/6960072.jpg",
                43.529158,
                3.917973,
                40.0,
                "2024-06-01",
                "2024-08-31"
        );

        Emplacement emplacement11 = new Emplacement(
                2L,
                "Les Vignes du Soleil",
                "Chemin des Vignes, Saint-Georges-d'Orques",
                "Un cadre bucolique au milieu des vignes.",
                List.of("Wi-Fi", "Toilettes"),
                "https://www.expemag.com/media/show/657b13c3e4b02c1f5f34e9d9.jpg",
                43.609158,
                3.783973,
                30.0,
                "2024-05-01",
                "2024-10-31"
        );

        Emplacement emplacement12 = new Emplacement(
                2L,
                "Les Pins Bleus",
                "Chemin des Pins, Castries",
                "Un cadre ombragé idéal pour se reposer.",
                List.of("Eau potable", "Douche"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2020-05/rorervig-centrets-shelter-01.jpg",
                43.673658,
                3.943973,
                20.0,
                "2024-07-01",
                "2024-09-30"
        );

        Emplacement emplacement13 = new Emplacement(
                3L,
                "Les Hauts de la Garrigue",
                "Chemin du Bois, Prades-le-Lez",
                "Un emplacement sur les hauteurs, avec une vue panoramique.",
                List.of("Toilettes", "Barbecue"),
                "https://www.visitdenmark.fr/sites/visitdenmark.com/files/2020-05/2MOsskov-shelter-229505_Shelters_ved_Store_kss.jpg",
                43.722158,
                3.854973,
                25.0,
                "2024-06-01",
                "2024-10-31"
        );

        Emplacement emplacement14 = new Emplacement(
                3L,
                "La Clairière Enchantée",
                "Route des Bois, Saint-Mathieu-de-Tréviers",
                "Un emplacement en pleine nature, parfait pour les familles.",
                List.of("Eau potable", "Wi-Fi"),
                "https://voyageforum.info/images/hd/posts/openmedium/1511769264-wO8nr2WXGVjDAki.jpg",
                43.737158,
                3.847973,
                60.0,
                "2024-03-01",
                "2024-11-30"
        );

        Emplacement emplacement15 = new Emplacement(
                3L,
                "Les Aigues-Vives",
                "Chemin de l'Eau Vive, Fabrègues",
                "Un cadre relaxant près des sources naturelles.",
                List.of("Toilettes", "Prise électrique"),
                "https://campspace.com/media/detail/uploads/space/hc/_d/f2/hc_df2797237efff3f1a547922516a3f7d1.jpeg",
                43.561158,
                3.806973,
                50.0,
                "2024-04-01",
                "2024-09-30"
        );

        Emplacement emplacement16 = new Emplacement(
                4L,
                "Le Bois des Fées",
                "Route des Chênes, Lattes",
                "Un lieu magique au bord d'une forêt.",
                List.of("Eau potable", "Barbecue"),
                "https://www.das-baumhaushotel.de/images/02_Wohnen/01_stadl/01_Stadl_Aussenansicht_fern.jpg",
                43.580158,
                3.890973,
                35.0,
                "2024-05-01",
                "2024-08-31"
        );

        emplacementRepository.save(emplacement1);
        emplacementRepository.save(emplacement2);
        emplacementRepository.save(emplacement3);
        emplacementRepository.save(emplacement4);
        emplacementRepository.save(emplacement5);
        emplacementRepository.save(emplacement6);
        emplacementRepository.save(emplacement7);
        emplacementRepository.save(emplacement8);
        emplacementRepository.save(emplacement9);
        emplacementRepository.save(emplacement10);
        emplacementRepository.save(emplacement11);
        emplacementRepository.save(emplacement12);
        emplacementRepository.save(emplacement13);
        emplacementRepository.save(emplacement14);
        emplacementRepository.save(emplacement15);
        emplacementRepository.save(emplacement16);
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
