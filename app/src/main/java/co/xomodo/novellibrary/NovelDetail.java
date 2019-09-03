package co.xomodo.novellibrary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NovelDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_detail);

        Intent intent = getIntent();
        Novel novelItem = intent.getParcelableExtra("Paket NovelDetail");

        int novelPhoto = novelItem.getNovelPhoto();
        String novelTitle = novelItem.getNovelTitle();
        String novelWriter = novelItem.getNovelWriter();
        String judulResensi = novelItem.getJudulResensi();
        String resensiPg1 = novelItem.getResensiPg1();
        String resensiPg2 = novelItem.getResensiPg2();
        String resensiPg3 = novelItem.getResensiPg3();

        ImageView imageView = findViewById(R.id.img_novel_photo);
        imageView.setImageResource(novelPhoto);

        TextView textView1 = findViewById(R.id.tv_novel_title);
        textView1.setText(novelTitle);

        TextView textView2 = findViewById(R.id.tv_novel_writer);
        textView2.setText(novelWriter);

        TextView textView3 = findViewById(R.id.tv_judul_resensi);
        textView3.setText(judulResensi);

        TextView textView4 = findViewById(R.id.resensi_pg_1);
        textView4.setText(resensiPg1);

        TextView textView5 = findViewById(R.id.resensi_pg_2);
        textView5.setText(resensiPg2);

        TextView textView6 = findViewById(R.id.resensi_pg_3);
        textView6.setText(resensiPg3);
    }
}