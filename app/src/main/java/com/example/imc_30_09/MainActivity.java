package com.example.imc_30_09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText textInputUsuario ;
    private EditText textInputSenha;
    private TextView textResultadoErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnEntrar);
        textInputSenha = findViewById(R.id.textInputSenha);
        textInputUsuario = findViewById(R.id.textInputUsuario);
        textResultadoErro = findViewById(R.id.textResultadoErro);


        btnEntrar.setOnClickListener(View ->{
            String usuarioInput = textInputUsuario.getText().toString();
            String senhaInput = textInputSenha.getText().toString();
            if(usuarioInput.equals("admin") && senhaInput.equals("admin")){
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
            }else{
                textResultadoErro.setText("Por Favor Digite seus Dados Corretamente...");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}