package com.example.motti.apphinovamobile.AdapterOficina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.motti.apphinovamobile.Oficinas.ListaOficinas;
import com.example.motti.apphinovamobile.R;

import com.example.motti.apphinovamobile.Util.Bitmapteste;

import java.util.List;

public class Adapter extends ArrayAdapter<ListaOficinas> {

    public Adapter(Context context, List<ListaOficinas> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListaOficinas listaOficinas = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_item_oficina, null);

            holder = new ViewHolder();
            holder.fotoOficina = (ImageView)convertView.findViewById(R.id.imgOficinaList);
            holder.txtNome = (TextView)convertView.findViewById(R.id.txtNomeOficinaDetalhe);
            holder.txtDescricaoCurta = (TextView)convertView.findViewById(R.id.txtDescricaoCurtaDetalhe);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.fotoOficina.setImageBitmap(Bitmapteste.convertStringToBitmap(listaOficinas.getFoto()));
        holder.txtNome.setText(listaOficinas.getNome());
        holder.txtDescricaoCurta.setText(listaOficinas.getDescricaoCurta());


        return convertView;
    }

    static class ViewHolder {
        ImageView fotoOficina;
        TextView txtNome;
        TextView txtDescricaoCurta;
    }
}
