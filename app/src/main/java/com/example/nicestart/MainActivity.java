package com.example.nicestart;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView mycontext = findViewById(R.id.mytext);
        registerForContextMenu(mycontext);

        swipeLayout = findViewById(R.id.mySwipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    // MENU CONTEXT
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId() == R.id.item1){
            Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast.show();
        }else if(item.getItemId() == R.id.item2){
            Toast toast2 = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
            toast2.show();
        }
        return true;
    }

    // MENU APPBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.itemSettings){
            Toast toast = Toast.makeText(this, "Setting...", Toast.LENGTH_LONG);
            toast.show();
            return true;
        }else if(item.getItemId() == R.id.itemCopy){
            Toast toast = Toast.makeText(this, "key...", Toast.LENGTH_LONG);
            toast.show();
            return true;
        }
        return false;
    }

    // SWIPE REFRESH LAYOUT
    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(MainActivity.this, "Hi there! I don't exists.",Toast.LENGTH_LONG);
            toast.show();
            swipeLayout.setRefreshing(false);
        }
    };
}