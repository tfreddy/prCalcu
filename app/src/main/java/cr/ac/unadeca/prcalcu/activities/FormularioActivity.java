package cr.ac.unadeca.prcalcu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cr.ac.unadeca.prcalcu.R;
import cr.ac.unadeca.prcalcu.database.models.TodoTable;


public class FormularioActivity extends AppCompatActivity {

    private TextView Nombre;
    private Button numIgual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//R.recursos de la aplicacion un enlace
        // setContentView que disenio se va utilizar en el desarollo de la aplicaion
        Nombre=findViewById(R.id.numIgual);


        numIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

    }

    private boolean validacion(){
        boolean send = true;
        if(Nombre.getText().toString().isEmpty()){
            send= false;

        }


        return  send;

    }
    private void guardar(){
        if (validacion()){
            TodoTable registro = new TodoTable();
            registro.NumeroaMostrar = Nombre.getText().toString();

            registro.save();
            finish();

        }else{
            Toast.makeText(this, getResources().getString(R.string.error_valid), Toast.LENGTH_SHORT).show();//llamada estatica llamar un objeto sin hacer uno nuevo
        }
    }

}
