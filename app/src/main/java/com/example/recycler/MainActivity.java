package com.example.recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.recycler.adapters.ItemAdapter;
import com.example.recycler.models.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private RecyclerView Items;
    private ItemAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Items = findViewById(R.id.rcv_item);
        Adapter = new ItemAdapter(this, getListItem());

        Items.setAdapter(Adapter);

        Adapter.notifyDataSetChanged();
        Items.setHasFixedSize(true);
        Items.setLayoutManager(new GridLayoutManager(this, 3));

        getCallPhonePermission();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    private static ArrayList<Item> getListItem() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.ic_home, "Home"));
        items.add(new Item(R.drawable.ic_pharmacy, "Pharmacy"));
        items.add(new Item(R.drawable.ic_taxi, "Taxi"));
        items.add(new Item(R.drawable.ic_registry, "Registry"));
        items.add(new Item(R.drawable.ic_patiogarden, "Garden"));
        items.add(new Item(R.drawable.ic_laptop, "Laptop"));
        items.add(new Item(R.drawable.ic_cartwheel, "Cartwheel"));
        items.add(new Item(R.drawable.ic_clothes, "Cloth"));
        items.add(new Item(R.drawable.ic_accessories, "Accessories"));
        items.add(new Item(R.drawable.ic_shoes, "Shoes"));




        return items;
    }

    public void  getCallPhonePermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }

        if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this, "Granted", Toast.LENGTH_LONG).show();
        }else{
            if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){

            }

            String[] permissions = {Manifest.permission.CALL_PHONE};
            requestPermissions(permissions, REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_PERMISSION_CODE: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else{

                }
                return;
            }
        }
    }}