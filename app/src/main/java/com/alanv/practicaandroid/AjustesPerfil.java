package com.alanv.practicaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import static android.hardware.Camera.open;

public class AjustesPerfil extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    ImageButton camara;
    ImageView photo;
    EditText name;
//
//    Bundle savedData = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_perfil);

        name = (EditText) findViewById(R.id.username);

        photo = (ImageView) findViewById(R.id.photo);

//        if(savedData != null && savedData.getString("foto") != null){
//            byte [] encodeByte= Base64.decode(savedData.getString("foto"),Base64.DEFAULT);
//            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
//
//            photo.setImageBitmap(bitmap);
//        }

        camara = (ImageButton) findViewById(R.id.camera);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        //Restauracion de datos

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        String photoString = pref.getString("foto", "intento fallido");

        if(!photoString.equals("intento fallido")) {
            byte[] encodeByte = Base64.decode(photoString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

            photo.setImageBitmap(bitmap);
        }
    }
    @Override
    protected void onPause(){
        //Aqui guardamos datos

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = pref.edit();

        String nameText = name.getText().toString();

        ed.putString("username", nameText);
       // ed.putString("foto",bitMapToString((Bitmap) photo.getDrawable().));

        ed.commit();

       super.onPause();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photo.setImageBitmap(imageBitmap);

            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor ed = pref.edit();

            //savedData.putString("foto",bitMapToString(imageBitmap));

            ed.putString("foto",bitMapToString(imageBitmap));

            ed.commit();
            //System.out.println(savedData.getString("foto"));
        }
    }

    public String bitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}
