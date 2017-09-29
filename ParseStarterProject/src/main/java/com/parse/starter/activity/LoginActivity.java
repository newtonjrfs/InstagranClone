package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.starter.R;

public class LoginActivity extends AppCompatActivity {

    TextView cadastrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cadastrarUsuario = (TextView) findViewById(R.id.cadastrar_conta);

        //verificar se o usuario esta logado
        verificarUsuarioLogado();

        cadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrir tela de cadastro
                startActivity(new Intent(LoginActivity.this,CadastroActivity.class));
            }
        });

    }

    private void verificarUsuarioLogado(){
        if (ParseUser.getCurrentUser() != null){
            //Envia para tela principal se usuario tiver logado
            abrirAreaPrincipal();
        }
    }

    private void abrirAreaPrincipal(){
        //Inicia tela principal
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

}
