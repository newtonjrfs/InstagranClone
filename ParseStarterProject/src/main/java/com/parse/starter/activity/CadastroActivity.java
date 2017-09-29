package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.starter.R;
import com.parse.starter.util.ParseErros;

public class CadastroActivity extends AppCompatActivity {

    private TextView fazerLogin;
    private EditText textoUsuario;
    private EditText textoEmail;
    private EditText textoSenha;
    private Button  botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        fazerLogin = (TextView) findViewById(R.id.cadastrar_conta);
        textoUsuario = (EditText) findViewById(R.id.text_usuario);
        textoEmail = (EditText) findViewById(R.id.text_email);
        textoSenha = (EditText) findViewById(R.id.text_senha);
        botaoCadastrar = (Button) findViewById(R.id.button_cadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cadastrarUsuario();

            }
        });

        fazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroActivity.this,LoginActivity.class));
            }
        });
    }

        private void cadastrarUsuario(){

            //criar usuario no parser
            ParseUser usuario = new ParseUser();
            usuario.setUsername(textoUsuario.getText().toString());
            usuario.setEmail(textoEmail.getText().toString());
            usuario.setPassword(textoSenha.getText().toString());

            usuario.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null){//sucesso ao salvar
                        Toast.makeText(CadastroActivity.this,"Cadastro realizado com sucesso",Toast.LENGTH_LONG).show();
                        abrirTelaLogin();
                    }else{//erro ao salvar
                        ParseErros parseErros = new ParseErros();
                        String erro = parseErros.getErro(e.getCode());
                        Toast.makeText(CadastroActivity.this,erro,Toast.LENGTH_LONG).show();
                    }

                }
            });


        }

        public void abrirTelaLogin(){
            Intent intent = new Intent(CadastroActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }
}
