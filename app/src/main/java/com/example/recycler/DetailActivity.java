package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycler.models.Item;

public class DetailActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private Item item;
    private TextView DetailWord;
    private TextView PhoneNumber;
    private ImageView DetailImg;
    private Button callStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailWord = findViewById(R.id.detail_word);
        DetailImg = findViewById(R.id.img_detail);
        PhoneNumber = findViewById(R.id.phone_number);
        callStore = findViewById(R.id.btn_call);


        item = (Item) getIntent().getSerializableExtra("item");

        DetailWord.setText(item.getItemText());
        DetailImg.setImageResource(item.getItemId());

        callStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callStore();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    private void callStore(){
        Uri uri = Uri.parse("tel:" + PhoneNumber.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

}
