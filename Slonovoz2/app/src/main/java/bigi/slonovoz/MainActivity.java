package bigi.slonovoz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "989-89-67"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(dialIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        imageButton = (ImageButton) findViewById(R.id.imageButtonbuttononas);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, ScrollingOnas.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.buttoninfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, ScrollingOnas.class);
                startActivity(intent);
            }
        });
        imageButton = (ImageButton) findViewById(R.id.imageButtonbuttonmani);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Rastenki.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.buttonmani);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Rastenki.class);
                startActivity(intent);
            }
        });
        imageButton = (ImageButton) findViewById(R.id.imageButtonbuttongaler);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Galerei.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.buttongaler);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Galerei.class);
                startActivity(intent);
            }
        });
        imageButton = (ImageButton) findViewById(R.id.imageButtonbuttonotziv);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, OrderRegistration.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.buttonotziv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, OrderRegistration.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actiongoogl) {
            Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=bigmeco"));
            startActivity(browseIntent);
        } else if (id == R.id.actionvk) {
            Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/slono_voz"));
            startActivity(browseIntent);
        } else if (id == R.id.actionweb) {
            Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.slonovoz.com/"));
            startActivity(browseIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}
