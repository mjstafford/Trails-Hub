CREATE TABLE reviews (
  id SERIAL PRIMARY KEY,
  rating INTEGER NOT NULL,
  comment TEXT,
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  trail_id INTEGER NOT NULL REFERENCES trails(id),
  user_id INTEGER NOT NULL REFERENCES users(id)
);