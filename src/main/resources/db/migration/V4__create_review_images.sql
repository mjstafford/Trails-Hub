CREATE TABLE review_images (
  id SERIAL PRIMARY KEY,
  img_url VARCHAR(255) NOT NULL,
  review_id INTEGER NOT NULL REFERENCES reviews(id)
);