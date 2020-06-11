CREATE TABLE IF NOT EXISTS TB_PLANO
(
    ID        BIGINT       NOT NULL AUTO_INCREMENT ,
    NOME      VARCHAR(200) NOT NULL ,
    PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_PLANO ( NOME ) VALUES ('PRATA');
INSERT INTO TB_PLANO ( NOME ) VALUES ('BRONZE');
INSERT INTO TB_PLANO ( NOME ) VALUES ('OURO');
