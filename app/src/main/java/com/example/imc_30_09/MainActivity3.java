package com.example.imc_30_09;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView textResultadoImc;
    private ImageButton btnVoltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        textResultadoImc = findViewById(R.id.textResultadoImc);
        btnVoltar =findViewById(R.id.btnVoltar);

        textResultadoImc.setText("");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String resultado = bundle.getString("resultado");
            String nome = bundle.getString("nome");
            String resul = nome + "\n" + resultado;
            textResultadoImc.setText(resul);
        }

        btnVoltar.setOnClickListener(View ->{
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}