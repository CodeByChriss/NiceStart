package com.example.nicestart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView mycontext;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mycontext = findViewById(R.id.mytext);
        registerForContextMenu(mycontext);

        swipeLayout = findViewById(R.id.mySwipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    // MENU CONTEXT
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
            toast.show();
        }
        return true;
    }

    // MENU APPBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemSettings) {
            showAlertDialogButtonClicked(this);
            return true;
        } else if (item.getItemId() == R.id.itemKey) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.itemKey), "Key collected", BaseTransientBottomBar.LENGTH_LONG);

            snackbar.setAction("Return the key", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mycontext.setText("Find the key...");
                }
            });

            mycontext.setText("You have the key...");
            snackbar.show();

            return true;
        }
        return false;
    }

    // SWIPE REFRESH LAYOUT
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(MainActivity.this, "Hi there! I don't exists.", Toast.LENGTH_LONG);
            toast.show();
            swipeLayout.setRefreshing(false);
        }
    };

    // DIALOGO MODAL
    public void showAlertDialogButtonClicked(MainActivity mainActivity) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(mainActivity);

        builder.setTitle("Exit!");
        builder.setMessage("Do you want to exit the app?");
        builder.setIcon(R.drawable.person);

        builder.setNeutralButton("Do nothing", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mainActivity, "Okay", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

        builder.setPositiveButton("Yes", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}