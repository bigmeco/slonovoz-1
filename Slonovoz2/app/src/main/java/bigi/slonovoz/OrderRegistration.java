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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderRegistration extends AppCompatActivity {
    private RadioGroup radioGroup;
    private String maj, numberOfMovers, place, addressCity, addressStreet, addressTo, addressHome, address, additionalBoxes, additionalPolythene, additionalLivt, additionalUnloading, tel, comment, time, skyp;
    private int maj1 = 0, gruskol1 = 0, position = 0, dop1k = 0, dop2p = 0, dop3l = 0, otvet = 0, taim = 0;
    private TextView textView;
    private EditText editText1A;
    private EditText editText2A;
    private EditText editText3A;
    private EditText editText4A;
    private EditText editText5A;
    private EditText editText6D;
    private EditText editText7D;
    private EditText editText8KG;
    private EditText editText9OTDO;
    private EditText editText10T;
    private EditText editText11J;
    private EditText editText12KOM;
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private ImageButton imageButton;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oformzakaz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "989-89-67"));
                if (ActivityCompat.checkSelfPermission(OrderRegistration.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(dialIntent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = (TextView) findViewById(R.id.textView23);
        editText1A = (EditText) findViewById(R.id.editText5);
        editText2A = (EditText) findViewById(R.id.editText6);
        editText3A = (EditText) findViewById(R.id.editText7);
        editText4A = (EditText) findViewById(R.id.editText8);
        editText5A = (EditText) findViewById(R.id.editText9);
        editText6D = (EditText) findViewById(R.id.editText12);
        editText7D = (EditText) findViewById(R.id.editText13);
        editText8KG = (EditText) findViewById(R.id.editText3);
        editText9OTDO = (EditText) findViewById(R.id.editText11);
        editText10T = (EditText) findViewById(R.id.editText4);
        editText11J = (EditText) findViewById(R.id.editText14);
        editText12KOM = (EditText) findViewById(R.id.editText10);
        checkBox = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox3);
        radioGroup = (RadioGroup) findViewById(R.id.radiob);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        maj = " Газель 3м ";
                        maj1 = 490;
                        break;
                    case R.id.radioButton2:
                        maj = " Газель 4м ";
                        maj1 = 590;
                        break;
                }
            }
        });
        additionalLivt = " с ливтом ";
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {
                    additionalLivt = " без лифта ";
                    dop3l = 100;
                } else {
                    additionalLivt = " с ливтом ";
                    dop3l = 0;
                }
            }
        });
        additionalUnloading = " без разбора мебели ";
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox2.isChecked()) {
                    additionalUnloading = " разбор мебели ";
                } else {
                    additionalUnloading = " без разбора мебели ";
                }
            }
        });
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    dop1k = Integer.parseInt(editText6D.getText().toString());
                    dop2p = Integer.parseInt(editText7D.getText().toString());
                    gruskol1 = Integer.parseInt(editText8KG.getText().toString());
                    position = Integer.parseInt(editText9OTDO.getText().toString());
                    taim = Integer.parseInt(editText11J.getText().toString());

                } catch (NumberFormatException e) {
                    dop1k = 0;
                    dop2p = 0;
                    gruskol1 = 0;
                    position = 0;
                    taim = 0;
                }
                int km = 0;
                if (position <= 200) {
                    km = 30;
                }
                if (position >= 201 && position <= 500) {
                    km = 27;
                }
                if (position >= 501) {
                    km = 25;
                }
                int n1 = dop3l * taim;
                int n31 = gruskol1 * 400;
                int n32 = n31 * taim;
                int n2 = maj1 * taim;
                int b1 = position * km;
                int b2 = dop1k * 40;
                int b3 = dop2p * 250;
                otvet = n1 + n2 + n32 + b1 + b2 + b3;
                textView.setText("" + otvet);
                gruskol1 = 0;
                position = 0;
                dop1k = 0;
                dop2p = 0;
                taim = 0;

            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfMovers = editText8KG.getText().toString();
                place = editText9OTDO.getText().toString();
                addressCity = editText1A.getText().toString();
                addressStreet = editText2A.getText().toString();
                addressTo = editText3A.getText().toString();
                addressHome = editText4A.getText().toString();
                address = editText5A.getText().toString();
                additionalBoxes = editText6D.getText().toString();
                additionalPolythene = editText7D.getText().toString();
                tel = editText10T.getText().toString();
                time = editText11J.getText().toString();
                comment = editText12KOM.getText().toString();
                skyp = "машина-(" + maj + ") " + "количество грузчиков-(" + numberOfMovers + ") " +
                        "дальность поездки-(" + place + "км) " + "город-(" + addressCity + ") " + "улица-(" + addressStreet + ") " + "дом-(" + addressTo + ") "
                        + "квартира-(" + addressHome + ") " + "этаж-(" + address + ") " + "лифт-(" + additionalLivt + ") " + "разбор-(" + additionalUnloading + ") " +
                        "количество коробок-(" + additionalBoxes + ") " + "упаковок мебели-(" + additionalPolythene + ") " +
                        "телефон-(" + tel + ") " + "коментарий-(" + comment + ") " + "примерное время-(" + time + ") " + " цена(" + otvet + ").";
                Intent email = new Intent(Intent.ACTION_SEND);
//Указываем получателя
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"abmin@slonovoz.com"});
//Устанавливаем Тему сообщения
                email.putExtra(Intent.EXTRA_SUBJECT, "Заказ");
//Устанавливаем само сообщение
                email.putExtra(Intent.EXTRA_TEXT, skyp);
//тип отправляемого сообщения
                email.setType("message/rfc822");
//Вызываем intent выбора клиента для отправки сообщения
                startActivity(Intent.createChooser(email, "Выберите email клиент :"));
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
