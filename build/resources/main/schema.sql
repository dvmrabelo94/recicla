CREATE TABLE IF NOT EXISTS material (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    date_created TIMESTAMP,
    last_updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS purchase (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    material_id BIGINT,
    quantity DOUBLE,
    price DOUBLE,
    purchase_date TIMESTAMP,
    FOREIGN KEY (material_id) REFERENCES material(id)
);

CREATE TABLE IF NOT EXISTS sale (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    material_id BIGINT,
    quantity DOUBLE,
    total_price DOUBLE,
    sale_date TIMESTAMP,
    FOREIGN KEY (material_id) REFERENCES material(id)
);