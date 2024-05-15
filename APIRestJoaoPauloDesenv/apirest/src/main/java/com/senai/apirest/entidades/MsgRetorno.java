
package com.senai.apirest.entidades;
public class MsgRetorno {
    
    private String funcao;
    private String descrição;

    public String getFuncao() {
        return funcao;
    }
    public String getDescrição() {
        return descrição;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }    
}