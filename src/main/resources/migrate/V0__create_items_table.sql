CREATE TABLE items (
    item_id           VARCHAR(36)  NOT NULL PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    description       TEXT         NOT NULL,
    price             INT          NOT NULL,
    quantity_in_stock INT          NOT NULL,
    created_at        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);