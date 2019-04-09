/*package com.example.motti.apphinovamobile.Service;


import android.os.AsyncTask;

import com.example.motti.apphinovamobile.Oficinas.ListaOficinas;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPservice extends AsyncTask<Void, Void, ListaOficinas> {

    private final String listaoficinas;

    public HTTPservice(String listaoficinas){
        this.listaoficinas = listaoficinas;
    }



    @Override
    protected ListaOficinas doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();


        try {
         URL url = new URL("http://app.hinovamobile.com.br/ProvaConhecimentoWebApi/Api/Oficina?codigoAssociacao=601&cpfAssociado=" + this.listaoficinas);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         connection.setRequestProperty("Accept","application/json");
         connection.setConnectTimeout(5000);
         connection.setDoInput(true);
         connection.setDoOutput(false);
         connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return null;
        return new Gson().fromJson(resposta.toString(), ListaOficinas.class);
    }

    public JSONObject requestMethodPost(String json) {
       return null;

    }

}
*/