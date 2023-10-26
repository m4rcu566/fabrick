CREATE TABLE IF NOT EXISTS account (
    account_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    enumeration VARCHAR(255),
    value_enum VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS history_transaction_type (
    id_type BIGINT PRIMARY KEY AUTO_INCREMENT,
    enumeration VARCHAR(255),
    value_enum VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS history_transaction (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    transaction_id VARCHAR(255),
    operation_id VARCHAR(255),
    accounting_date DATE,
    value_date DATE,
    id_type BIGINT,
    amount FLOAT,
    currency VARCHAR(255),
    description VARCHAR(255),
    FOREIGN KEY (id_type) REFERENCES history_transaction_type(id_type)
);

