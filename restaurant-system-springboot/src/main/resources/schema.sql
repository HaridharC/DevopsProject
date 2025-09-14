
CREATE TABLE orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  item_name VARCHAR(255),
  quantity INT,
  customer_name VARCHAR(255),
  delivered BOOLEAN
);
