-- Вставка даних для клієнтів
INSERT INTO client (name) VALUES
    ('Alice'),
    ('Bob'),
    ('Charlie'),
    ('David'),
    ('Elena'),
    ('Frank'),
    ('Grace'),
    ('Hannah'),
    ('Ian'),
    ('Julia');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VENUS', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUPITER', 'Jupiter'),
    ('SATURN', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'MARS', 'VENUS'),
    (2, 'EARTH', 'MARS'),
    (3, 'JUPITER', 'EARTH'),
    (4, 'VENUS', 'SATURN'),
    (5, 'SATURN', 'JUPITER'),
    (6, 'MARS', 'EARTH'),
    (7, 'EARTH', 'SATURN'),
    (8, 'MARS', 'JUPITER'),
    (9, 'VENUS', 'EARTH'),
    (10, 'JUPITER', 'VENUS');