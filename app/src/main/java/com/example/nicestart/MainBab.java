package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
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
                showBottomSheetDialog();
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

    private void showBottomSheetDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, null);

        // Creamos el BottomSheetDialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

        // Recogemos los text view
        TextView option1 = view.findViewById(R.id.option01);
        TextView option2 = view.findViewById(R.id.option02);
        TextView option3 = view.findViewById(R.id.option03);

        // Acción para Opción 1
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
                System.exit(0);
            }
        });

        // Acción para Opción 2
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
                Intent intent = new Intent(MainBab.this, Profile.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        // Acción para Opción 3
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
    }
}