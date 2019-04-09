package com.example.motti.apphinovamobile.Util;

import android.graphics.BitmapFactory;
import android.util.Base64;
import android.graphics.Bitmap;

public class Bitmapteste {

    public static Bitmap convertStringToBitmap(String codeBitmap){

        byte[] decodedString = Base64.decode(codeBitmap, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;
    }
}
