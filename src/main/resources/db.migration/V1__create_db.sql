CREATE TABLE client (
  id INT PRIMARY KEY,
  name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200)
);

CREATE TABLE planet (
  id VARCHAR(10) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]+$'),
  name VARCHAR(500) CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500)
);

CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_id INT REFERENCES client(id),
    from_planet_id VARCHAR(10) REFERENCES planet(id),
    to_planet_id VARCHAR(10) REFERENCES planet(id),
);
