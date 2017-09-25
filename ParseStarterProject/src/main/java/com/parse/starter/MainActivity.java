/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      /*
      //criacao de tabela
      ParseObject pontuacao = new ParseObject("Pontuacao");

      //insercao de dados na tabela
      pontuacao.put("nome","Alexandre");
      pontuacao.put("pontos",950);
      pontuacao.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {

              if(e==null){//nao temos erro
                  Log.i("salvarPontos","Salvo com sucesso");
              }else{
                  Log.i("salvarPontos","Erro ao salvar pontos");
              }

          }
      });
      
       */

      /*
      //alteracao de dados da tabela
      ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");
      consulta.getInBackground("2VQcmPBk2b", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {
              if(e==null){//nao temos erro
                  object.put("pontos",12545);
                  object.saveInBackground();
              }else{
                  Log.i("salvarPontos","Erro ao consultar objeto");
              }
          }
      });
       */

      //criacao de filtros para pesquisa
      ParseQuery<ParseObject> filtro = ParseQuery.getQuery("Pontuacao");

      //quando pesquisar algo maior que
      //filtro.whereGreaterThan("pontos",0);
      //quando pesquisar algo maior ou igual que
      //filtro.whereGreaterThanOrEqualTo("pontos",800);
      //quando pesquisar algo menor que
      //filtro.whereLessThan("pontos",800);
      //quando pesquisar algo menor ou igual que
      //filtro.whereLessThanOrEqualTo("pontos",9999);
      //quando pesquisar algo que termina com
      //filtro.whereEndsWith("nome","a");
      //quando pesquisar algo que inicia com
      //filtro.whereStartsWith("nome","J");
      //ordenar de baixo pra cima
      //filtro.addAscendingOrder("pontos");
      //ordenar de cima pra baixo
      //filtro.addDescendingOrder("pontos");
      //limitar quantidade de pesquisa
      //filtro.setLimit(10);



      //filtro.whereGreaterThanOrEqualTo("pontos",1000);
      //filtro.addDescendingOrder("pontos");

      filtro.findInBackground(new FindCallback<ParseObject>() {
          @Override
          public void done(List<ParseObject> objects, ParseException e) {

              if(e==null){//nao temos erro
                  for (ParseObject object : objects){
                      Log.i("listarDados","Objeto - "+ object.get("nome") +" pontuacao : "+ object.get("pontos"));
                  }
              }else{
                  Log.i("listarDados","Erro ao listar objetos - "+ e.getMessage());
              }

          }
      });



  }
}
