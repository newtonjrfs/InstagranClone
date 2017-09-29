package com.parse.starter.util;

import java.util.HashMap;

/**
 * Created by Newton on 29/09/2017.
 */

public class ParseErros {

    private HashMap<Integer,String> erros;

    public ParseErros() {
        this.erros = new HashMap<>();
        this.erros.put(202,"Email ja cadastrado");
    }

    public String getErro(int codErro){
        return this.erros.get(codErro);
    }

}
