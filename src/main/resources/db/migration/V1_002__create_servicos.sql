CREATE TABLE IF NOT EXISTS TB_SERVICOS
(
    ID        BIGINT       NOT NULL AUTO_INCREMENT ,
    NOME      VARCHAR(200) NOT NULL ,
    PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_SERVICOS ( NOME ) VALUES ('Banho');
INSERT INTO TB_SERVICOS ( NOME ) VALUES ('Tosa');
INSERT INTO TB_SERVICOS ( NOME ) VALUES ('Vacina AntiRábica');
INSERT INTO TB_SERVICOS ( NOME ) VALUES ('Hospedagem');
INSERT INTO TB_SERVICOS ( NOME ) VALUES ('Castração');
