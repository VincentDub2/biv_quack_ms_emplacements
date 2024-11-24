-- Création de la table Commodite
CREATE TABLE Commodite (
                           id_commodite BIGSERIAL PRIMARY KEY,
                           nom VARCHAR(255) NOT NULL UNIQUE -- Nom de la commodité
);

-- Création de la table Emplacement
CREATE TABLE Emplacement (
                             id_emplacement BIGSERIAL PRIMARY KEY,
                             id_hote BIGINT NOT NULL,
                             nom VARCHAR(255) NOT NULL,
                             adresse VARCHAR(255) NOT NULL,
                             description TEXT,
                             latitude DOUBLE PRECISION NOT NULL,
                             longitude DOUBLE PRECISION NOT NULL,
                             prix_par_nuit NUMERIC(10, 2) NOT NULL,
                             image BYTEA,
                             date_debut DATE NOT NULL,
                             date_fin DATE NOT NULL,
                             commodites TEXT[] -- Tableau contenant les noms des commodités
);

-- Insertion des commodités disponibles
INSERT INTO Commodite (nom)
VALUES
    ('WiFi'),
    ('Piscine'),
    ('Parking gratuit'),
    ('Climatisation'),
    ('Barbecue'),
    ('Toilettes sèches'),
    ('Eau potable');

-- Peuplement des emplacements
INSERT INTO Emplacement (id_hote, nom, adresse, description, latitude, longitude, prix_par_nuit, image, date_debut, date_fin, commodites)
VALUES
    (1, 'Chalet en montagne', '123 Rue des Alpes, Annecy', 'Chalet cosy avec vue sur les montagnes.',
     45.8995, 6.1286, 120.00, NULL, '2024-12-01', '2024-12-10', ARRAY['WiFi', 'Climatisation']),

    (2, 'Appartement en bord de mer', '45 Quai de la Mer, Nice', 'Appartement lumineux avec accès direct à la plage.',
     43.6954, 7.2656, 150.00, NULL, '2024-11-20', '2024-11-30', ARRAY['Piscine', 'WiFi', 'Parking gratuit']),

    (3, 'Cabane en forêt', 'Forêt de Fontainebleau, Ile-de-France', 'Une retraite paisible au cœur de la forêt.',
     48.4131, 2.6529, 80.00, NULL, '2024-05-01', '2024-09-30', ARRAY['Barbecue', 'Toilettes sèches', 'Eau potable']),

    (4, 'Villa avec vue sur le lac', '12 Chemin du Lac, Aix-les-Bains', 'Villa luxueuse avec une vue imprenable sur le lac.',
     45.6904, 5.9082, 200.00, NULL, '2024-07-01', '2024-07-31', ARRAY['Piscine', 'WiFi', 'Climatisation']),

    (5, 'Yourte mongole', 'Domaine La Prairie, Toulouse', 'Expérience unique dans une yourte traditionnelle.',
     43.6043, 1.4437, 60.00, NULL, '2024-06-01', '2024-09-01', ARRAY['Toilettes sèches', 'Barbecue', 'Eau potable']),

    (6, 'Tiny House écologique', '3 Rue des Ecolos, Bordeaux', 'Petite maison écologique avec un grand confort.',
     44.8378, -0.5792, 90.00, NULL, '2024-03-01', '2024-10-31', ARRAY['WiFi', 'Parking gratuit']),

    (7, 'Maison troglodyte', '5 Grotte de la Lune, Amboise', 'Une maison unique creusée dans la roche.',
     47.4138, 0.9823, 110.00, NULL, '2024-08-01', '2024-08-31', ARRAY['WiFi', 'Climatisation']),

    (8, 'Bivouac dans les dunes', 'Dunes du Pilat, La Teste-de-Buch', 'Un bivouac simple au cœur des dunes.',
     44.6165, -1.1688, 50.00, NULL, '2024-05-01', '2024-10-31', ARRAY['Toilettes sèches', 'Eau potable', 'Barbecue']);
