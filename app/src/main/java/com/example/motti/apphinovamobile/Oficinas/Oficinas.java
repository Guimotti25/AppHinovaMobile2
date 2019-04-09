package com.example.motti.apphinovamobile.Oficinas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.motti.apphinovamobile.AdapterOficina.Adapter;
import com.example.motti.apphinovamobile.Principal.BaseTaskDelegate;
import com.example.motti.apphinovamobile.Principal.MainActivity;
import com.example.motti.apphinovamobile.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Oficinas extends AppCompatActivity implements BaseTaskDelegate, Serializable {

  //  final TextView etOficina = findViewById(R.id.etOficina);

    private List<ListaOficinas> oficinas;
    private ListView oficinasCarregadas;
    private ArrayAdapter<ListaOficinas> adapter;
    private OficinaTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficinas);


     /*  //HTTPservice api = new HTTPservice();
        // Gson.respota.toString;

        HTTPservice service =  new HTTPservice(etOficina.getText().toString());
        try {
            ListaOficinas retorno = service.execute().get();
            etOficina.setText(retorno.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        try{
        oficinasCarregadas = (ListView)findViewById(R.id.listDeOficinas);
        runTask();
        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionSetAdapter", e.getMessage());
        }

        oficinasCarregadas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {





                ListaOficinas oficinaSelecionada = (ListaOficinas) oficinasCarregadas.getItemAtPosition(i);
                Intent intent = new Intent(view.getContext(), DetalhesOficina.class);
                intent.putExtra("OFICINA", (Parcelable) oficinaSelecionada);
                startActivity(intent);



            }
        });

    }


    private void setListView(){

        if(oficinas != null){
            adapter = new Adapter(this,oficinas);
            try {
                oficinasCarregadas.setAdapter(adapter);
                Log.i("Adapter", oficinasCarregadas.toString());
            }catch (Exception e){
                e.printStackTrace();
                Log.i("ExceptionSetAdapter", e.getMessage());
            }

        }
    }


    @Override
    public void afterRunTask(JSONObject jsonObject) {
        try {
            oficinas = new ArrayList<ListaOficinas>();
            oficinas.clear();
            oficinas.addAll(RetornoOficina.lerOficinaJson(jsonObject));
            setListView();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("ExceptionResposta", e.getMessage());
        }
    }

    private void runTask(){
        try {
            task = new OficinaTask(this,this);
            task.execute();
        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionExeTarefa", e.getMessage());
        }

    }
}
