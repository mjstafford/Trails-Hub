CREATE TABLE trails (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  distance NUMERIC NOT NULL,
  elevation_gain NUMERIC NOT NULL,
  difficulty VARCHAR(50) NOT NULL,
  zip_code VARCHAR(5) NOT NULL,
  img_url VARCHAR(255) NOT NULL,
);