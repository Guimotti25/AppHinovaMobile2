package com.example.motti.apphinovamobile.Service;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Rest {

    private static final String REST_HOST ="http://app.hinovamobile.com.br/";
    private static final String REST_PATH = "ProvaConhecimentoWebApi/Api/";
    private static final String REST_END_POINT_CARREGAR_OFICINA = "Oficina?codigoAssociacao=601&cpfAssociado=";
    private static final String REST_END_POINT_ENVIAR_INDICACAO = "Indicacao";
    private final int SEGUNDOS = 1000;
    private JSONObject json = null;
    private URL url = null;
    private HttpURLConnection connection;

    //Requisicao do tipo GET
    public JSONObject requestMethodGet(){

        try {
            url = new URL(getRestCarregarOficina());
            connection = (HttpURLConnection)url.openConnection();

            //Envia os cabeçalhos da requisição GET
            connection.setReadTimeout(10 * SEGUNDOS);
            connection.setConnectTimeout(15 * SEGUNDOS);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoInput(true);
            connection.setDoOutput(false);
            //Tenta conexao
            connection.connect();
            // Obtém o JSON de retorno
            InputStream is = connection.getInputStream();
            json = new JSONObject(bytesParaString(is));
            //Obtém status da conexao
            getResponseCode(connection.getResponseCode());

        } catch (ProtocolException e) {
            e.printStackTrace();
            Log.i("ProtocolException", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("IOException", e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("JSONException", e.getMessage());
        }
        return json;
    }

    //Requisicao do tipo POST
    public JSONObject requestMethodPost(String conteudo){

        try {
            url = new URL(getRestEndPointEnviarIndicacao());
            connection = (HttpURLConnection) url.openConnection();
            // Envia os cabeçalhos de requisição POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", "" + conteudo.getBytes().length);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //Tenta conexao
            connection.connect();
            // Envia o JSON da requisição
            connection.getOutputStream().write(conteudo.getBytes());
            // Obtém o JSON de retorno
            InputStream is = connection.getInputStream();
            json = new JSONObject(bytesParaString(is));
            //Obtém status da conexao
            getResponseCode(connection.getResponseCode());
        }catch (Exception e) {
            e.printStackTrace();
            Log.i("ExceptionRequestPost", e.getMessage());
        }
        return json;
    }

    //Recupero o codigo da resposta da conexao
    private void getResponseCode(int responseCode) throws IOException {

        if (responseCode != HttpURLConnection.HTTP_OK) {
            String desc = connection.getResponseMessage();
            throw new RuntimeException("Failed : HTTP error code : " + responseCode + ". " + desc);
        }
    }

    //Retirei esse metodo do livro - DOMINANDO ANDROID volume 2
    // transforma os byte para string de forma a recuperar o conteudo do json da resposta
    private static String bytesParaString(InputStream is) throws IOException {
        byte[] buffer = new byte[1024];
        // O bufferzao vai armazenar todos os bytes lidos
        ByteArrayOutputStream bufferzao = new ByteArrayOutputStream();
        // precisamos saber quantos bytes foram lidos
        int bytesLidos;
        // Vamos lendo de 1KB por vez...
        while ((bytesLidos = is.read(buffer)) != -1) {
            // copiando a quantidade de bytes lidos do buffer para o bufferzão
            bufferzao.write(buffer, 0, bytesLidos);
        }
        return new String(bufferzao.toByteArray(), "UTF-8");
    }
    // metodo que eu monto a url da requisicao GET
    private static String getRestCarregarOficina(){

        return REST_HOST+REST_PATH+REST_END_POINT_CARREGAR_OFICINA;
    }
    // metodo que eu monto a url da requisicao GET
    private static String getRestEndPointEnviarIndicacao(){
        return REST_HOST+REST_PATH+REST_END_POINT_ENVIAR_INDICACAO;
    }
}
