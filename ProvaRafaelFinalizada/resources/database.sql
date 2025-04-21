DROP TABLE IF EXISTS venda_produtos;
DROP TABLE IF EXISTS vendas;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE
);

CREATE TABLE produtos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    valor REAL NOT NULL
);

CREATE TABLE vendas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    usuario_id INTEGER NOT NULL,
    forma_pagamento TEXT NOT NULL,
    valor_total REAL NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE venda_produtos (
    venda_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    PRIMARY KEY (venda_id, produto_id),
    FOREIGN KEY (venda_id) REFERENCES vendas (id),
    FOREIGN KEY (produto_id) REFERENCES produtos (id)
);


-- Inserção dos dados
INSERT OR IGNORE INTO usuarios (nome, email) VALUES ('Gabriel', 'gabriel@gmail.com');
INSERT OR IGNORE INTO usuarios (nome, email) VALUES ('Matheus', 'matheus@gmail.com');

INSERT OR IGNORE INTO produtos (id, nome, valor) VALUES (1, 'Arroz 5kg', 25.90);
INSERT OR IGNORE INTO produtos (id, nome, valor) VALUES (2, 'Feijão Carioca 1kg', 7.50);
INSERT OR IGNORE INTO produtos (id, nome, valor) VALUES (3, 'Macarrão Espaguete 500g', 4.20);
INSERT OR IGNORE INTO produtos (id, nome, valor) VALUES (4, 'Óleo de Soja 900ml', 6.30);
