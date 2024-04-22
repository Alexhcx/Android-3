package com.example.exercicio_3_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HumorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humor_activity);

        ImageView imagemFeliz = findViewById(R.id.imagemFeliz);
        ImageView imagemPaz = findViewById(R.id.imagemPaz);
        ImageView imagemFurioso = findViewById(R.id.imagemFurioso);
        ImageView imagemTriste = findViewById(R.id.imagemTriste);
        Button bVoltar = findViewById(R.id.botaoVoltar);

        imagemFeliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Você selecionou o humor feliz.");
                enviarHumorSelecionado("Feliz", R.drawable.feliz);
            }
        });

        imagemPaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Você selecionou o humor em paz.");
                enviarHumorSelecionado("Em paz", R.drawable.paz);
            }
        });

        imagemFurioso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Você selecionou o humor furioso.");
                enviarHumorSelecionado("Furioso", R.drawable.furioso);
            }
        });

        imagemTriste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Você selecionou o humor triste.");
                enviarHumorSelecionado("Triste", R.drawable.triste);
            }
        });

        // Implementação do botão de voltar
        bVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chamando finish para encerrar esta atividade e voltar para MainActivity
                finish();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void enviarHumorSelecionado(String humor, int humorId) {
        Intent intent = new Intent();
        intent.putExtra("humor", humor);
        intent.putExtra("humorId", humorId);
        setResult(RESULT_OK, intent);
    }
}
