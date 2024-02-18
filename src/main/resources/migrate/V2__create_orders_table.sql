CREATE TABLE orders (
    id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id    VARCHAR(36)  NOT NULL,
    user_id     VARCHAR(36)  NOT NULL,
    product_id  VARCHAR(36)  NOT NULL,
    quantity 　 INT          NOT NULL,
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);