package com.example.ptsii_sitiananditafarhani;

import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static android.os.Build.VERSION_CODES.O;

public class Input_Data_Material extends AppCompatActivity {
    private EditText id, berat, tag_number, start, finish, total_time, result;
    String txtId, txtBerat, txtTag_number, txtStart, txtFinish, txtTotal_time, txtResult;
    private Object JSONObjectRequestListener;

    @Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        berat = findViewById(R.id.berat);
        tag_number = findViewById(R.id.tag_number);
        start = findViewById(R.id.start);
        finish = findViewById(R.id.finish);
        total_time = findViewById(R.id.total_time);
        result = findViewById(R.id.result);
    }

    public void simpanData(View view){

    }
    private void AksiSimpan(){
        txtId = id.getText().toString();
        txtBerat = berat.getText().toString();
        txtTag_number = tag_number.getText().toString();
        txtStart = start.getText().toString();
        txtFinish = finish.getText().toString();
        txtTotal_time = total_time.getText().toString();
        txtResult = result.getText().toString();

        if (txtId.equals("")) txtBerat.equals("") || txtTag_number.equals("") || txtStart.equals("") || txtFinish.equals("") ||txtTotal_time.equals("") || txtResult.equals("") )
    {
            Toast.makeText(this, "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
        }else
        {
            AndroidNetworking.post("http:192.168.43.211/rest/add.php")
                    .addBodyParameter("id","txtId")
                    .addBodyParameter("berat","txtBerat")
                    .addBodyParameter("tag_number","txtTag_number")
                    .addBodyParameter("start","txtStart")
                    .addBodyParameter("finish","txtFinish")
                    .addBodyParameter("total_time","txtTotal_time")
                    .addBodyParameter("result","txtResult")
                    .setTag("test")
                    .setPriority(RenderScript.Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(JSONObjectRequestListener);{
                @Override
                        public void onResponse(JSONObject Object response;response){
                    try {
                        if (response.getString("status") .equals("data berhasil disimpan")){
                        Toast.makeText(getApplicationContext(), "Data Berhasil Di Simpan",Toast.LENGTH_LONG).show();
                    }else{
                            Toast.makeText(getApplicationContext(), "Data Gagal Di Simpan",Toast.LENGTH_LONG).show();
                        }
                    }catch (JSONException e){
                        Toast.makeText(getApplicationContext(), "Data Gagal Di Simpan"+e,Toast.LENGTH_LONG).show();
                    }
            }

            @Override
                    public void onError(ANError Object error;
                    error){
                Toast.makeText(getApplicationContext(), "Data Gagal Di Simpan"+ error,Toast.LENGTH_LONG).show();
            
        }
        });
    }

   
    }
}
