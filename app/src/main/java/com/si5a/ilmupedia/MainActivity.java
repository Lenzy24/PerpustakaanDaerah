package com.si5a.ilmupedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPerpustakaan;
    private ArrayList<ModelPerpustakaan> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPerpustakaan = findViewById(R.id.rv_perpustakaan);
        rvPerpustakaan.setHasFixedSize(true);
        data.addAll(DataPerpustakaan.getDataPerpustakaan());
        tampilData();

    }

    public void tampilData(){
        rvPerpustakaan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard AC = new AdapterCard(data, MainActivity.this);
        rvPerpustakaan.setAdapter(AC);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tambahan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent pindah = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(pindah);
                break;
        }


        return super.onOptionsItemSelected(item);

    }
}