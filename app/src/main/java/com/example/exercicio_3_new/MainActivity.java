package com.example.exercicio_3_new;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;
    ArrayList<HumorData> dadosHumor;
    Button botaoHumor;

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.hasExtra("humor") && data.hasExtra("humorId")) {
                        String humorSelecionado = data.getStringExtra("humor");
                        int humorId = data.getIntExtra("humorId", -1);
                        adicionarHumor(humorSelecionado, humorId);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.moodRecycler);
        dadosHumor = new ArrayList<>();
        botaoHumor = findViewById(R.id.adicionar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemAdapter(this, dadosHumor);
        recyclerView.setAdapter(adapter);

        botaoHumor.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HumorActivity.class);
            launcher.launch(intent);
        });
    }

    private void adicionarHumor(String humor, int humorId) {
        dadosHumor.add(new HumorData(humorId, humor));
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Humor adicionado: " + humor, Toast.LENGTH_SHORT).show();
    }
}
