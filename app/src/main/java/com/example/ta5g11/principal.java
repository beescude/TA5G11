package com.example.ta5g11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        llenarLibros();
    }
    public void informacion(View view){


        Intent intent= getIntent();
        String message = intent.getStringExtra("datos");
        Intent i = new Intent(this, Informacion.class );
        System.out.println(message);
        i.putExtra("datos", message);
        startActivity(i);

    }


    public void consultarTerror (View view) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(  this,"administracion",  null,  1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.linearLayout1);
        myLayout.removeAllViewsInLayout();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,    LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor fila = bd.rawQuery("select nombre, categoria,descripcion from libros where " +
                    "categoria=" + "'Terror'",  null);
            if (fila.moveToFirst()) {
                String info="Nombre: "+fila.getString(0)+"\nCategoria: "+fila.getString(1)+"\nDescripcion: "+fila.getString(2);
                do{
                    TextView pel = new TextView(this );
                    pel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                    pel.setText(info);
                    myLayout.addView(pel);
                }while(fila.moveToNext());
            }
            bd.close();
    }
    public void consultarAccion (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(  this,"administracion",  null,  1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.linearLayout1);
        myLayout.removeAllViewsInLayout();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,    LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor fila = bd.rawQuery("select nombre, categoria,descripcion from libros where " +
                "categoria=" + "'Accion'",  null);
        if (fila.moveToFirst()) {
            String info="Nombre: "+fila.getString(0)+"\nCategoria: "+fila.getString(1)+"\nDescripcion: "+fila.getString(2);
            do{
                TextView pel = new TextView(this );
                pel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                pel.setText(info);
                myLayout.addView(pel);
            }while(fila.moveToNext());
        }
        bd.close();
    }
    public void consultarRomance (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(  this,"administracion",  null,  1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.linearLayout1);
        myLayout.removeAllViewsInLayout();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,    LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor fila = bd.rawQuery("select nombre, categoria,descripcion from libros where " +
                "categoria='" + "Romance'",  null);
        if (fila.moveToFirst()) {
            String info="Nombre: "+fila.getString(0)+"\nCategoria: "+fila.getString(1)+"\nDescripcion: "+fila.getString(2);
            do{
                TextView pel = new TextView(this );
                pel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                pel.setText(info);
                myLayout.addView(pel);
            }while(fila.moveToNext());
        }
        bd.close();
    }
    public void consultarTodos (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(  this,"administracion",  null,  1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.linearLayout1);
        myLayout.removeAllViewsInLayout();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,    LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor fila = bd.rawQuery("select nombre, categoria,descripcion from libros ",  null);
        if (fila.moveToFirst()) {
            String info="Nombre: "+fila.getString(0)+"\nCategoria: "+fila.getString(1)+"\nDescripcion: "+fila.getString(2);
            do{
                TextView pel = new TextView(this );
                pel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                pel.setText(info);
                myLayout.addView(pel);
            }while(fila.moveToNext());
        }
        bd.close();
    }

    public void llenarLibros(){
        try{
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(  this,"administracion",  null,  1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String n="AntMan";
        String c="Accion";

        String des="Robert Langdon, profesor de simbología e iconografía religiosa de la universidad de Harvard, acude al Museo Guggenheim Bilbao para asistir a un trascendental anuncio que «cambiará la faz de la ciencia para siempre». " +
                 "El anfitrión de la velada es Edmond Kirsch, un joven multimillonario cuyos visionarios inventos tecnológicos y audaces…";
        bd.execSQL("Insert into libros (nombre,categoria,descripcion) "
                + "values ('Origen','Accion','"+ des + "')");
         des="¿Cómo encajan unos poemas serbios con la supuesta construcción de un arma eléctrica clandestina? Algo se me escapa. Leo y releo el poema entre pequeños sorbos " +
                 "del whisky escocés, intentando darle sentido. Solo se me ocurre una idea. Envío un e-mail a la dirección del contacto de Kiryl diciendo que…";
        bd.execSQL("Insert into libros (nombre,categoria ,descripcion) "
                + "values ('" + "Torre tesla" + "','" + "Accion" + "','" + des + "')");
         des="Cuando despiertas en un laboratorio subterráneo abandonado, atrapada en un salón de experimentos rodeado por monstruos que quieren " +
                 "devorarte y en compañía de una incubadora de agua donde hay un hombre en mal estado, te das cuenta que todo está terriblemente mal.";
        bd.execSQL("Insert into libros (nombre,categoria ,descripcion) "
                + "values ('" + "Experimento rojo" + "','" + "Terror" + "','" + des + "')");
         des="Fiamma Hernández, saliendo de su trabajo como es habitual, toma un taxi para irse hacia la casa de sus padres. Un desconocido le ofrece de ir juntos y compartir el gasto" +
                 ", por lo que ella acepta ya que era lo más conveniente para ambos. No cruzan palabra, pero se nota un ambiente tenso y extraño...";
        bd.execSQL("Insert into libros (nombre,categoria ,descripcion) "
                + "values ('" + "Help me" + "','" + "Terror" + "','" + des + "')");
         des="ULa sombra que nos mira trata la historia de una familia, un matrimonio y sus dos hijas, que vive en una residencia de ancianos. Llevan una vida tranquila; los padres regentando" +
                 " la cafetería de la residencia, y las niñas acudiendo al colegio y siendo mimadas por todos los residentes. Pronto sus...";
        bd.execSQL("Insert into libros (nombre,categoria ,descripcion) "
                + "values ('" + "La sombra que nos mira" + "','" + "terror" + "','" + des + "')");
         des="Uno de los libros sobre amor orientados a un público joven más conocidos. Explica la historia de una pareja de adolescentes que, decididos a exprimir al máximo el tiempo que pasan juntos a causa de la influencia del cáncer que se " +
                 "les ha diagnosticado, emprenden juntos un viaje para conocer a un escritor. Cuenta con una versión adaptada al cine y estrenada en el año 2014...";
        bd.execSQL("Insert into libros (nombre,categoria ,descripcion) "
                + "values ('" + "Bajo la misma estrella" + "','" + "Romance" + "','" + des + "')");
         des="Uno de los libros de amor que no pueden faltar en cualquier selección de obras de literatura inglesadel siglo XIX. Se trata de un clásico no solo por la calidad de la construcción de los personajes" +
                 ", sino también por el modo en el que la faceta más turbulenta del amor es retratada...";
        bd.execSQL("Insert into libros (nombre,categoria ,descripcion) "
                + "values ('" + "Cumbres borrascosas" + "','" + "Romance" + "','" + des + "')");
        des="Uno de los libros de amor más conocidos, forma ya parte de los clásicos a pesar de que fue publicado a mediados de los años 80. Esta historia trata sobre la relación de una" +
                "joven proveniente de una familia arruinada recientemente y un hombre chino con buena posición económica...";
        bd.execSQL("Insert into libros(nombre,categoria ,descripcion) "
                + "values ('" + "El Amante" + "','" + "Romance" + "','" + des + "')");
        bd.execSQL("insert into libros (nombre,categoria,descripcion) values ('" + n + "','" + c + "','" + des + "')");
        bd.close();}
        catch (Exception e){
            System.out.println("La lista ya esta llena");
        }

    }
}