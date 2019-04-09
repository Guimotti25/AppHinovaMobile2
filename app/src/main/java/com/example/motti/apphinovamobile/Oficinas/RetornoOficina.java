package com.example.motti.apphinovamobile.Oficinas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RetornoOficina {

    public static List<ListaOficinas> lerOficinaJson(JSONObject json) throws JSONException {
        List<ListaOficinas> listaDeOficina = new ArrayList<ListaOficinas>();
        JSONArray jsonOficina = json.getJSONArray("ListaOficinas");
        for (int i = 0; i < jsonOficina.length(); i++) {
            JSONObject jsonOficinas = jsonOficina.getJSONObject(i);
            ListaOficinas oficina = new ListaOficinas();
            oficina.setId(jsonOficinas.getString("Id"));
            oficina.setNome(jsonOficinas.getString("Nome"));
            oficina.setDescricao(jsonOficinas.getString("Descricao"));
            oficina.setDescricaoCurta(jsonOficinas.getString("DescricaoCurta"));
            oficina.setEndereco(jsonOficinas.getString("Endereco"));
            oficina.setLatitude(jsonOficinas.getString("Latitude"));
            oficina.setLongitude(jsonOficinas.getString("Longitude"));
            oficina.setFoto(jsonOficinas.getString("Foto"));
            oficina.setAvaliacaoUsuario(jsonOficinas.getString("AvaliacaoUsuario"));
            oficina.setCodigoAssociacao(jsonOficinas.getString("CodigoAssociacao"));
            oficina.setEmail(jsonOficinas.getString("Email"));
            oficina.setTelefone1(jsonOficinas.getString("Telefone1"));
            oficina.setTelefone2(jsonOficinas.getString("Telefone2"));
            oficina.setAtivo(jsonOficinas.getString("Ativo"));

            listaDeOficina.add(oficina);

        }
        return listaDeOficina;
    }
}
