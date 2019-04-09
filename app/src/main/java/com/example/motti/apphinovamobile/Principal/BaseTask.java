package com.example.motti.apphinovamobile.Principal;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.motti.apphinovamobile.Oficinas.ListaOficinas;
import com.example.motti.apphinovamobile.Service.HTTPservice;
import com.example.motti.apphinovamobile.Service.Rest;

import org.json.JSONObject;

public class BaseTask extends AsyncTask<Object, Object, JSONObject> {

    private Context mContext;
    private Rest client;
    private BaseTaskDelegate taskReturn;
    private ProgressDialog progress;
    private String message;

    private String json = null;

    //Contrutor para executar tarega GET
    public BaseTask(Context pContext , BaseTaskDelegate pTaskReturn){
        this.mContext = pContext;
        this.taskReturn = pTaskReturn;
        this.message = "Carregando Oficinas...";
    }

    //Construtor para executar tarega POST
    public BaseTask(Context pContext , BaseTaskDelegate pTaskReturn , String pJson){
        this.mContext = pContext;
        this.taskReturn = pTaskReturn;
        this.json = pJson;
        this.message ="Enviando Indicação...";
    }

    @Override
    protected void onPreExecute(){
        // preparo o progressdialog
        progress = new ProgressDialog(mContext);
        progress.setMessage(message);
        progress.setCancelable(false);
        progress.show();
        try{
            client = new Rest();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected JSONObject doInBackground(Object... params) {

        publishProgress(message);
        try {
            if(json == null){
                return client.requestMethodGet();
            }else
                return client.requestMethodPost(json);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(JSONObject jsonOficina){
        progress.dismiss();
        taskReturn.afterRunTask(jsonOficina);
    }
}
