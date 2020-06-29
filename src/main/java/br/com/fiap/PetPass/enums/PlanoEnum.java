package br.com.fiap.PetPass.enums;

public enum PlanoEnum {
    BRONZE(0),
    PRATA(1),
    OURO(2);

    private Integer plano;

    private PlanoEnum(Integer plano) {
        this.plano = plano;
    }

    public Integer getPlano() {
        return plano;
    }

    public void setPlano(Integer plano) {
        this.plano = plano;
    }
}