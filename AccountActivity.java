package com.example.ptsii_sitiananditafarhani;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountActivity extends Activity {
    private Button btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        btnmenu = findViewById(R.id.btn_home);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginMain();
            }
        });
    }
    public void openLoginMain(){
        Intent intent = new Intent(this, com.example.ptsii_sitiananditafarhani.MainActivity2.class);
        startActivity(intent);
    }
}

