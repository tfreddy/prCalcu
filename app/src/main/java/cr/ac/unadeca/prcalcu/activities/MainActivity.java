package cr.ac.unadeca.prcalcu.activities;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;

import cr.ac.unadeca.prcalcu.R;
import cr.ac.unadeca.prcalcu.database.models.TodoTable;
import cr.ac.unadeca.prcalcu.subclases.TodoViewHolder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;

    private static Context QuickContext;
    private RecyclerView lista;
    boolean decimalPoint =false;
    boolean Suma = false;
    boolean resta = false;
    boolean multi = false;
    boolean div = false;
    boolean porcentaje = false;
    double numero1;
    double numero2;
    String Operador;

    double resultado;

    private void guardar(){

        TodoTable registro = new TodoTable();
        registro.Resultado=  Double.toString(resultado);
        registro.NumeroaMostrar= Double.toString(numero1);
        registro.NumeroaMostrar2 =Double.toString(numero2);
        registro.Operador= Operador;
        registro.save();
    }
    private void update(){
        List<TodoTable> info = SQLite.select().from(TodoTable.class).queryList();
        lista.setAdapter(new CalcuAdapter(info));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuickContext = this;

        mp = MediaPlayer.create(this,R.raw.clic );

        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));
        List<TodoTable> info = SQLite.select().from(TodoTable.class).queryList();
        lista.setAdapter(new CalcuAdapter(info));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Botones
        Button btnAC = findViewById(R.id.numAC);
        btnAC.setOnClickListener(this);

        Button btn7 = findViewById(R.id.num7);
        btn7.setOnClickListener(this);

        Button btn4 = findViewById(R.id.num4);
        btn4.setOnClickListener(this);

        Button btn1 = findViewById(R.id.num1);
        btn1.setOnClickListener(this);

        Button btn0 = findViewById(R.id.num0);
        btn0.setOnClickListener(this);

        Button btnC = findViewById(R.id.numC);
        btnC.setOnClickListener(this);

        Button btn8 = findViewById(R.id.num8);
        btn8.setOnClickListener(this);

        Button btn5 = findViewById(R.id.num5);
        btn5.setOnClickListener(this);

        Button btn2 = findViewById(R.id.num2);
        btn2.setOnClickListener(this);

        Button btn00 = findViewById(R.id.num00);
        btn00.setOnClickListener(this);

        Button btnPorCentaje = findViewById(R.id.numPorCentaje);
        btnPorCentaje.setOnClickListener(this);

        Button btn9 = findViewById(R.id.num9);
        btn9.setOnClickListener(this);

        Button btn6 = findViewById(R.id.num6);
        btn6.setOnClickListener(this);

        Button btn3= findViewById(R.id.num3);
        btn3.setOnClickListener(this);

        Button btnPunto = findViewById(R.id.numPunto);
        btnPunto.setOnClickListener(this);

        Button btnEntre = findViewById(R.id.numEntre);
        btnEntre.setOnClickListener(this);

        Button btnPor = findViewById(R.id.numPor);
        btnPor.setOnClickListener(this);

        Button btnMenos = findViewById(R.id.nummMenos);
        btnMenos.setOnClickListener(this);

        Button btnMas = findViewById(R.id.numMas);
        btnMas.setOnClickListener(this);

        Button btnIgual = findViewById(R.id.numIgual);
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
        mp.start();
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
                Operador = "%";
                guardar();
                update();
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
                    Operador = "+";
                }else if (resta ){
                    resultado= numero1 - numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                    Operador = "-";
                }else if (div ){
                    resultado= numero1 / numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                    Operador = "/";
                }else if (multi ){
                    resultado= numero1 * numero2;
                    VistaTexto.setText(String.valueOf(resultado));
                    Operador = "x";
                }else if (porcentaje ){
                    resultado= numero1 * numero1/ 100;
                    VistaTexto.setText(String.valueOf(resultado));
                }

                guardar();
                update();

                decimalPoint=false;
                resta=false;
                Suma=false;
                multi=false;
                div=false;
                porcentaje=false;
                break;
            }
        } catch (Exception e){
            e.printStackTrace();
            VistaTexto.setText("¡Error!" );
//            TodoTable registro = new TodoTable();
//            registro.NumeroaMostrar = VistaTexto.getText().toString();
        }
    }

    public static class CalcuAdapter extends RecyclerView.Adapter<TodoViewHolder> {
        private final List<TodoTable> listCalculadoraTable;
        private final LayoutInflater inflater;

        public CalcuAdapter(List<TodoTable> listToDoTables) {
            this.inflater = LayoutInflater.from(QuickContext);
            this.listCalculadoraTable = listToDoTables;
        }
        @Override
        public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.objeto, parent, false);
            return new TodoViewHolder(view);
        }
        public void animateTo(List<TodoTable> models) {
            applyAndAnimateRemovals(models);
            applyAndAnimateAdditions(models);
            applyAndAnimateMovedItems(models);
        }

        private void applyAndAnimateRemovals(List<TodoTable> newModels) {
            for (int i = listCalculadoraTable.size() - 1; i >= 0; i--) {
                final TodoTable model = listCalculadoraTable.get(i);
                if (!newModels.contains(model)) {
                    removeItem(i);
                }
            }
        }

        private void applyAndAnimateAdditions(List<TodoTable> newModels) {
            for (int i = 0, count = newModels.size(); i < count; i++) {
                final TodoTable model = newModels.get(i);
                if (!listCalculadoraTable.contains(model)) {
                    addItem(i, model);
                }
            }
        }

        private void applyAndAnimateMovedItems(List<TodoTable> newModels) {
            for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
                final TodoTable model = newModels.get(toPosition);
                final int fromPosition = listCalculadoraTable.indexOf(model);
                if (fromPosition >= 0 && fromPosition != toPosition) {
                    moveItem(fromPosition, toPosition);
                }
            }
        }

        public TodoTable removeItem(int position) {
            final TodoTable model = listCalculadoraTable.remove(position);
            notifyItemRemoved(position);
            return model;
        }

        public void addItem(int position, TodoTable model) {
            listCalculadoraTable.add(position, model);
            notifyItemInserted(position);
        }

        public void moveItem(int fromPosition, int toPosition) {
            final TodoTable model = listCalculadoraTable.remove(fromPosition);
            listCalculadoraTable.add(toPosition, model);
            notifyItemMoved(fromPosition, toPosition);
        }
        @Override
        public void onBindViewHolder(final TodoViewHolder holder, final int position) {
            final TodoTable current = listCalculadoraTable.get(position);
            holder.html.setHtml(ActividadAString(current),
                    new HtmlResImageGetter(holder.html));

            holder.borrar.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    current.delete();
                    removeItem(position);
                    notifyDataSetChanged();
                }
            });

        }
        private  String ActividadAString(TodoTable todo){
            String html= "<a><big><b>" + todo.NumeroaMostrar + " "+ todo.Operador +" " + todo.NumeroaMostrar2 + " = "+todo.Resultado+ "</b></big>";
            return html;
        }
        @Override
        public int getItemCount() {
            return listCalculadoraTable.size();
        }
    }
}
