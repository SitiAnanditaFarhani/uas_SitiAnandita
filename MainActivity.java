package com.example.ptsii_sitiananditafarhani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

    //implementasi dari	onclicklistener
    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        //View Objects
        private Button buttonSave;
        private Button buttoncancel;
        private TextView textViewnama;
        private TextView textViewkelas;
        private TextView textViewNIK;

        //qr code scanner object
        private IntentIntegrator qrscan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

//View objects
            buttonSave = (Button) findViewById(R.id.buttonsave);
            buttoncancel = (Button) findViewById(R.id.buttoncancel);
            textViewnama = (TextView) findViewById(R.id.textViewNama);
            textViewkelas = (TextView) findViewById(R.id.textViewKelas);
            textViewNIK = (TextView) findViewById(R.id.textViewNik);
 //intialisasi scan object
           qrscan= new IntentIntegrator(this);

//implementasi onclick listener
            buttonSave.setOnClickListener(this);
            buttoncancel.setOnClickListener(this);
        }

        //untuk mendapatkan hasil scanning
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode,
                resultCode, data);
            if (result != null) {
//jika qrcode tidak ada sama sekali
                if (result.getContents() == null) {
                    Toast.makeText(this, "Hasil SCAN tidak ada", Toast.LENGTH_LONG).show();
                } else {
//jika qr ada/ditemukan data nya
                    try {
//konversi datanya ke json
                        JSONObject obj = new JSONObject(result.getContents());
//di set nilai datanya ke textviews
// textViewNama.setText(obj.getString("nama"));
// textViewKelas.setText(obj.getString("kelas"));
// textViewNim.setText(obj.getString("NIK));
                    } catch (JSONException e) { e.printStackTrace();
//jika kontolling ada di sini
//itu berarti format encoded tidak cocok
//dalam hal ini kita dapat menampilkan data apapun yg tesedia pada qrcode
//untuk di toast
                        Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
        @Override
        public void onClick(View view) {
//inisialisasi scanning qr code
          qrscan.initiateScan();
        }
    }
