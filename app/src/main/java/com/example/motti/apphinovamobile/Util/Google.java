package com.example.motti.apphinovamobile.Util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Google {

    private Context context;
    private Intent intent;
    private static final String PACKAGE_GOOGLEMAPS ="com.google.android.apps.maps";
    private static final String PACKAGEM_GOOGLEMAIL = "com.google.android.gm";

    public Google(Context context){
        this.context = context;
    }

    public void callPhone(String numeroTelefone){
        try{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+numeroTelefone));
            context.startActivity(intent);
        }catch (ActivityNotFoundException e){
            e.printStackTrace();
        }
    }

    public void callGmail(String email, String assunto, String textoEmail){
        try {
            intent = new Intent(Intent.ACTION_SEND);
            String[] strTo = { email };
            intent.putExtra(Intent.EXTRA_EMAIL, strTo);
            intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
            intent.putExtra(Intent.EXTRA_TEXT, textoEmail);
            intent.setType("message/rfc822");
            intent.setPackage(PACKAGEM_GOOGLEMAIL);
            if(intent.resolveActivity(context.getPackageManager())!= null){
                context.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void callGoogleMaps(String latitude, String longitude,String nome, String endereco){
        try{
            String googleMaps ="geo:"+latitude+","+longitude+"?q=";
            Uri gmmIntentUri = Uri.parse(googleMaps + Uri.encode(nome +","+endereco));
            intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            intent.setPackage(PACKAGE_GOOGLEMAPS);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }

        }catch (ActivityNotFoundException e){
            e.printStackTrace();

        }

    }
}
