package com.example.organizze.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.organizze.R;
import com.example.organizze.activity.config.ConfiguracaoFireBase;
import com.example.organizze.activity.helper.Base64Custom;
import com.example.organizze.activity.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoSenha;
    private Button btnCadastro;
    private FirebaseAuth auth;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        btnCadastro = findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtNome = campoNome.getText().toString();
                String txtEmail = campoEmail.getText().toString();
                String txtSenha = campoSenha.getText().toString();

                //Validar se os campos foram preenchidos
                if(!txtNome.equals("")){
                    if(!txtEmail.equals("")){
                        if(!txtSenha.equals("")){
                            usuario = new Usuario();
                            usuario.setNome(txtNome);
                            usuario.setEmail(txtEmail);
                            usuario.setSenha(txtSenha);
                            cadastrarUsuario();
                        }else{

                            Toast.makeText(CadastroActivity.this,
                                    "Preencha o campo Senha",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(CadastroActivity.this,
                                "Preencha o campo Email",
                                Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(CadastroActivity.this,
                            "Preencha o campo Nome",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void cadastrarUsuario(){
        auth = ConfiguracaoFireBase.getFireBaseAuth();
        auth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String idUsuario = Base64Custom.codificarBase64(usuario.getEmail());
                    usuario.setIdUsuario(idUsuario);
                    usuario.salvar();
                   finish();
                }else{

                    String msg = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        msg = "Digite uma senha mais forte";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        msg = "Digite um email válido";
                    }catch(FirebaseAuthUserCollisionException e){
                        msg = "Usuário já cadastrado";
                    }catch (Exception e){
                        msg = "Erro ao cadastrar usuário" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this,
                            msg,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}