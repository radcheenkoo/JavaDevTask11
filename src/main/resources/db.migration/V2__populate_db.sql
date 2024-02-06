INSERT INTO client (name) VALUES
  (1,'John'),
  (2,'Alice'),
  (3,'Bob'),
  (4,'Mary'),
  (5,'Sam'),
  (6,'Kate'),
  (7,'Bruce'),
  (8,'Amanda'),
  (9,'Nina'),
  (10,'Alex');

INSERT INTO planet (id, name) VALUES
  ('MARS', 'Mars'),
  ('EARTH', 'Earth'),
  ('VENUS', 'Venus'),
  ('JUPITER', 'Jupiter'),
  ('SATURN', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
  (CURRENT_TIMESTAMP, 1, 'MARS', 'EARTH'),
  (CURRENT_TIMESTAMP, 2, 'EARTH', 'VENUS'),
  (CURRENT_TIMESTAMP, 3, 'JUPITER', 'MARS'),
  (CURRENT_TIMESTAMP, 4, 'VENUS', 'EARTH'),
  (CURRENT_TIMESTAMP, 5, 'SATURN', 'JUPITER'),
  (CURRENT_TIMESTAMP, 6, 'MARS','SATURN'),
  (CURRENT_TIMESTAMP, 7, 'EARTH','VENUS'),
  (CURRENT_TIMESTAMP, 8, 'JUPITER','MARS'),
  (CURRENT_TIMESTAMP, 9, 'VENUS','EARTH'),
  (CURRENT_TIMESTAMP, 10, 'SATURN','MARS');