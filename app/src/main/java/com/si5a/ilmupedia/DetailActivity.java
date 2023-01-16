package com.si5a.ilmupedia;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import android.content.Intent;



public class DetailActivity extends AppCompatActivity {
    private Button btLokasi;
    private ImageView ivfoto;
    private TextView tvnama, tvtentang;
    private String ynama, ytentang, yfoto, ylokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivfoto = findViewById(R.id.iv_foto);
        tvnama = findViewById(R.id.tv_nama);
        tvtentang = findViewById(R.id.tv_tentang);
        btLokasi = findViewById(R.id.bt_lokasi);


        Intent terima = getIntent();
        ynama = terima.getStringExtra("xnama");
        ytentang = terima.getStringExtra("xtentang");
        yfoto = terima.getStringExtra("xfoto");
        ylokasi = terima.getStringExtra("xlokasi");

        tvnama.setText(ynama);
        tvtentang.setText(ytentang);
        Glide
                .with(DetailActivity.this)
                .load(yfoto)
                .into(ivfoto);

        btLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri lokasi = Uri.parse("geo:0,0?q=" + ylokasi);
                Intent bukalokasi = new Intent(Intent.ACTION_VIEW, lokasi);
                startActivity(bukalokasi);
            }
        });
    }

}
