package com.example.motti.apphinovamobile.Principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.motti.apphinovamobile.Indicação.Indicacao;
import com.example.motti.apphinovamobile.Oficinas.Oficinas;
import com.example.motti.apphinovamobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*try {
        URL url = new URL('http://app.hinovamobile.com.br/ProvaConhecimentoWebApi/');

            HttpURLConnection client = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Button mBtn1 = (Button) findViewById(R.id.mBtn1);
        Button mBtn2 = (Button) findViewById(R.id.mBtn2);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Oficinas.class);

                startActivity(it);
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Indicacao.class);

                startActivity(it);
            }
        });
    }
}
