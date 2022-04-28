package com.example.aprende_play.chat.especialistas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.R;

public class ValidaCedula extends AppCompatActivity {
    public String[] addresses;
    public String subject;
    public Uri attachment;
    //creamos la variables locales que utlizaremos
    //Editext
    EditText et2;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valida_cedula);
        et2= (EditText) findViewById(R.id.edtclave1);
    }

    //metodo de ingreso
    public void InicioSesion(View v){
        /*Creamos un objeto de la clase DBHelper e
        instanciamos el constructor y damos el nonbre de
         la base de datos y la version*/
        Bdsqlite admin=new Bdsqlite(this,"instituto",null,1);
        /*Abrimos la base de datos como escritura*/
        SQLiteDatabase db=admin.getWritableDatabase();
        /*Creamos dos variables string y capturamos los datos
         ingresado por el usuario y lo convertimos a string*/
        String contrasena=et2.getText().toString();
        /*inicializamos al cursor y llamamos al objeto de la base
        de datos para realizar un sentencia query where donde
         pasamos las dos variables nombre de usuario y password*/
        fila=db.rawQuery("select clave_user from userstable where clave_user='"+contrasena+"'",null);
        /*Realizamos un try catch para captura de errores*/
        try {
            /*Condicional if preguntamos si cursor tiene algun dato*/
            if(fila.moveToFirst()){
                //capturamos los valores del cursos y lo almacenamos en variable
                String pass=fila.getString(0);
                //preguntamos si los datos ingresados son iguales
                if (contrasena.equals(pass)){
                    //si son iguales entonces vamos a otra ventana
                    //Menu es una nueva actividad empty
                    Intent ven=new Intent(this, RegistraEspecialista.class);
                    //lanzamos la actividad
                    startActivity(ven);
                    //limpiamos las las cajas de texto
                    et2.setText("");
                }
            }//si la primera condicion no cumple entonces que envie un mensaje toast
            else {
                Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
                //mostramos el toast
                toast.show();
            }

        } catch (Exception e) {//capturamos los errores que ubieran
            Toast toast=Toast.makeText(this,"Error" + e.getMessage(),Toast.LENGTH_LONG);
            //mostramos el mensaje
            toast.show();
        }
    }
    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"AprendePlay01@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Validación Especialista");
        intent.putExtra(Intent.EXTRA_TEXT,"Adjunta tú cedula profesional o comprobante de especialidad en autismo," +
                "" +
                " formato PDF o JPG en su caso.");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void link(View view) {
        composeEmail();
    }
}