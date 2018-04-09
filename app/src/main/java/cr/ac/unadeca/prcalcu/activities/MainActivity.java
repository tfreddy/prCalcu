package cr.ac.unadeca.prcalcu.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import cr.ac.unadeca.prcalcu.R;
import cr.ac.unadeca.prcalcu.database.models.TodoTable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView lista;
    boolean decimalPoint =false;
    boolean Suma = false;
    boolean resta = false;
    boolean multi = false;
    boolean div = false;
    boolean porcentaje = false;
    double numero1;
    double numero2;

    double resultado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//   //     FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//     //   fab.setOnClickListener(new View.OnClickListener() {
//  //          @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
    //        });
        //Botones
        Button btnAC = (Button)findViewById(R.id.numAC);
        btnAC.setOnClickListener(this);

        Button btn7 = (Button)findViewById(R.id.num7);
        btn7.setOnClickListener(this);

        Button btn4 = (Button)findViewById(R.id.num4);
        btn4.setOnClickListener(this);

        Button btn1 = (Button)findViewById(R.id.num1);
        btn1.setOnClickListener(this);

        Button btn0 = (Button)findViewById(R.id.num0);
        btn0.setOnClickListener(this);

        Button btnC = (Button)findViewById(R.id.numC);
        btnC.setOnClickListener(this);

        Button btn8 = (Button)findViewById(R.id.num8);
        btn8.setOnClickListener(this);

        Button btn5 = (Button)findViewById(R.id.num5);
        btn5.setOnClickListener(this);

        Button btn2 = (Button)findViewById(R.id.num2);
        btn2.setOnClickListener(this);

        Button btn00 = (Button)findViewById(R.id.num00);
        btn00.setOnClickListener(this);

        Button btnPorCentaje = (Button)findViewById(R.id.numPorCentaje);
        btnPorCentaje.setOnClickListener(this);

        Button btn9 = (Button)findViewById(R.id.num9);
        btn9.setOnClickListener(this);

        Button btn6 = (Button)findViewById(R.id.num6);
        btn6.setOnClickListener(this);

        Button btn3= (Button)findViewById(R.id.num3);
        btn3.setOnClickListener(this);

        Button btnPunto = (Button)findViewById(R.id.numPunto);
        btnPunto.setOnClickListener(this);

        Button btnEntre = (Button)findViewById(R.id.numEntre);
        btnEntre.setOnClickListener(this);

        Button btnPor = (Button)findViewById(R.id.numPor);
        btnPor.setOnClickListener(this);

        Button btnMenos = (Button)findViewById(R.id.nummMenos);
        btnMenos.setOnClickListener(this);

        Button btnMas = (Button)findViewById(R.id.numMas);
        btnMas.setOnClickListener(this);

        Button btnIgual = (Button)findViewById(R.id.numIgual);
        btnIgual.setOnClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        TextView VistaTexto = findViewById(R.id.numview);

        int select = v.getId();


        //variable que almacena los datos el numero mas otro
        String FRE = VistaTexto.getText().toString();
        //variable que permite la realizacion de suma
        Double[] num = new Double[30];



        //identificador del boton
        try {
        switch (select) {

            //Ac
            case R.id.numAC:
                VistaTexto.setText("");
                decimalPoint = false;
                break;
            //Numeros
            case R.id.num0:
                VistaTexto.setText(FRE + "0");

                break;

            case R.id.num00:
                VistaTexto.setText(FRE +"00");
                break;

            case R.id.num1:
                VistaTexto.setText(FRE +"1");
                break;

            case R.id.num2:
                VistaTexto.setText(FRE +"2");
                break;

            case R.id.num3:
                VistaTexto.setText(FRE +"3");
                break;

            case R.id.num4:
                VistaTexto.setText(FRE +"4");
                break;

            case R.id.num5:
                VistaTexto.setText(FRE +"5");
                break;

            case R.id.num6:
                VistaTexto.setText(FRE +"6");
                break;

            case R.id.num7:
                VistaTexto.setText(FRE +"7");
                break;

            case R.id.num8:
                VistaTexto.setText(FRE +"8");
                break;

            case R.id.num9:
                VistaTexto.setText(FRE +"9");
                break;

            case R.id.numC:
                if (!VistaTexto.getText().toString().equals("")){
                    VistaTexto.setText(VistaTexto.getText().subSequence(0,VistaTexto.getText().length()-1)+"");
                }

                break;
            case R.id.numPunto:
                if (!decimalPoint) {
                    VistaTexto.setText(FRE + ".");
                    decimalPoint=true;
                }else{return;}
                break;
            case R.id.numPorCentaje:
                numero1 = Double.parseDouble(FRE);
                porcentaje = true;
                decimalPoint = false;
                VistaTexto.setText(""); //borra y permite el inicio pureba
                resultado = numero1 /100;
                VistaTexto.setText(String.valueOf(resultado));
                break;
            case R.id.numEntre:
                numero1 = Double.parseDouble(FRE);
                div = true;
                decimalPoint = false;
                VistaTexto.setText("");
                break;
            case R.id.numPor:
                numero1 = Double.parseDouble(FRE);
                multi=true;
                decimalPoint = false;
                VistaTexto.setText("");
                break;
            case R.id.nummMenos:
                numero1 = Double.parseDouble(FRE);
                resta=true;
                decimalPoint = false;
                VistaTexto.setText("");
                break;
            case  R.id.numMas:
                numero1 = Double.parseDouble(FRE);
                Suma=true;
                decimalPoint = false;
                VistaTexto.setText("");
                break;

            case R.id.numIgual:

                numero2 = Double.parseDouble(FRE);
                if (Suma ){
                    resultado= numero1 + numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                }else if (resta ){
                    resultado= numero1 - numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                }else if (div ){
                    resultado= numero1 / numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                }else if (multi ){
                    resultado= numero1 * numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                }else if (porcentaje ){
                    resultado= numero1 * numero1/ 100;
                    VistaTexto.setText(String.valueOf(resultado));
                }
                decimalPoint=false;
                resta=false;
                Suma=false;
                multi=false;
                div=false;
                porcentaje=false;


                break;



            }
        } catch (Exception e){

            VistaTexto.setText("Error MORTAL" );
            TodoTable registro = new TodoTable();
            registro.NumeroaMostrar = VistaTexto.getText().toString();












        }
    }




}
