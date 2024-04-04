CREATE TABLE BENEFICIARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    endereco VARCHAR(255),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(8)
);

CREATE TABLE DOCUMENTO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(50) NOT NULL,
    descricao VARCHAR(255),
    data_inclusao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    beneficiario_id INT,
    FOREIGN KEY (beneficiario_id) REFERENCES BENEFICIARIO(id)
);