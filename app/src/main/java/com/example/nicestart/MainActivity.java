package com.example.nicestart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView mycontext;
    private SwipeRefreshLayout swipeLayout;
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mycontext = findViewById(R.id.mytext);
//        registerForContextMenu(mycontext);

        myWebView = (WebView) findViewById(R.id.wvVistaWeb);
        registerForContextMenu(myWebView);

        swipeLayout = findViewById(R.id.mySwipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        String html = "<html>" +
                "<head><style>" +
                "html, body { margin:0; padding: 0; height: 100%; overflow: hidden; }" +
                "img {width: 100%; height: 100%; object-fit: over }" +
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com/' />" +
                "</body></html>";

        myWebView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }

    // MENU CONTEXT
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Image copied", Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast = Toast.makeText(this, "Downloading image...", Toast.LENGTH_LONG);
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
            myWebView.reload();
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
//                        dialog.dismiss();
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