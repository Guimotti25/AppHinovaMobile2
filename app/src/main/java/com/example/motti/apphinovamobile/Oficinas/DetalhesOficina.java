package com.example.motti.apphinovamobile.Oficinas;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.motti.apphinovamobile.Principal.MainActivity;
import com.example.motti.apphinovamobile.R;
import com.example.motti.apphinovamobile.Util.Bitmapteste;
import com.example.motti.apphinovamobile.Util.Google;
//import com.example.motti.apphinovamobile.MainActivity;

public class DetalhesOficina extends AppCompatActivity {

    ImageView imgOficina;
    ImageButton btnMaps , btnMail,bntCall;
    TextView txtNomeOficina, txtDescricaoCurta, txtDescricao,txtEndereco,txtEmail,txtTelefone;
    ListaOficinas oficinaDetalhe;

    //utilitarios
    Google googleUtils;

    //Detalhes da Oficina
    Bitmap fotoOficina;
    String nomeOficina;
    String descCurtaOficina;
    String descOficna;
    String enderecoOficina;
    String emailOficina;
    String telefoneOficina1;
    String telefoneOficina2;
    String telefonesOficina;
    String latitudeOficina;
    String longitudeOficina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_oficina);

        try{
        getOficinaSelecionada();
        getOficinaDetalhes();
        getFindViewById();
        setTxtView();
        googleUtils =  new Google(this);

        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionSetAdapter", e.getMessage());
        }


    }

    public void getOficinaSelecionada(){
        try{
        oficinaDetalhe = (ListaOficinas) getIntent().getExtras().getSerializable("OFICINA");
        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionSetAdapter", e.getMessage());
        }
        }

    public void getFindViewById(){

        try{
        imgOficina = (ImageView) findViewById(R.id.imgOficinaDetalhada);
        txtNomeOficina = (TextView)findViewById(R.id.txtNomeOficinaDetalhe);
        txtDescricaoCurta = (TextView)findViewById(R.id.txtDescricaoCurtaDetalhe);
        txtDescricao = (TextView)findViewById(R.id.txtDescricaoDetalhe);
        txtEndereco = (TextView) findViewById(R.id.txtEnderecoDetalhe);
        txtEmail = (TextView)findViewById(R.id.txtEmailDetalhe);
        txtTelefone = (TextView)findViewById(R.id.txtTelefoneDetalhe);
        //botoes

        btnMaps = (ImageButton)findViewById(R.id.imgBtnMaps);
        btnMail = (ImageButton)findViewById(R.id.imgBtnEmail);
        bntCall = (ImageButton)findViewById(R.id.imgBtnTel);
        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionSetAdapter", e.getMessage());
        }

    }

    public void getOficinaDetalhes(){
        try{
        fotoOficina = Bitmapteste.convertStringToBitmap(oficinaDetalhe.getFoto());
        nomeOficina = oficinaDetalhe.getNome();
        descCurtaOficina = oficinaDetalhe.getDescricaoCurta();
        descOficna = oficinaDetalhe.getDescricao();
        enderecoOficina = oficinaDetalhe.getEndereco();
        emailOficina = oficinaDetalhe.getEmail();
        telefoneOficina1 = verificaStringNull(oficinaDetalhe.getTelefone1());
        telefoneOficina2 = verificaStringNull(oficinaDetalhe.getTelefone2());
        telefonesOficina = telefoneOficina1 +" - "+ telefoneOficina2;
        latitudeOficina = oficinaDetalhe.getLatitude();
        longitudeOficina = oficinaDetalhe.getLongitude();
        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionSetAdapter", e.getMessage());
        }
    }

    public void setTxtView(){
        try{
        imgOficina.setImageBitmap(fotoOficina);
        txtNomeOficina.setText(verificaStringNull(nomeOficina));
        txtDescricaoCurta.setText(verificaStringNull(descCurtaOficina));
        txtDescricao.setText(verificaStringNull(descOficna));
        txtEndereco.setText(verificaStringNull(enderecoOficina));
        txtEmail.setText(verificaStringNull(emailOficina));
        txtTelefone.setText(verificaStringNull(telefonesOficina));
        }catch (Exception e){
            e.printStackTrace();
            Log.i("ExceptionSetAdapter", e.getMessage());
        }
    }

    public String verificaStringNull(String string){
        String retorno = null;
        if(string.contains("null") || string.contains("null - null")){
            retorno = "Não Informado";
        }
        else
            retorno = string;
        return retorno;
    }
}
