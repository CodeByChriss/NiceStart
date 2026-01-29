package com.example.nicestart;

import android.os.Bundle;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.example.nicestart.databinding.ActivityMainBabBinding;

public class MainBab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBabBinding binding = ActivityMainBabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);

        myfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(MainBab.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainBab.this, "Navigation Button Click", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item){
                if(item.getItemId() == R.id.heart){
                    Toast.makeText(MainBab.this, "Added to favourites", Toast.LENGTH_SHORT).show();
                    return true;
                }else if (item.getItemId() == R.id.search) {
                    Toast.makeText(MainBab.this, "Planet", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}