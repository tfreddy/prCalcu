package cr.ac.unadeca.prcalcu.database.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import cr.ac.unadeca.prcalcu.database.ToDoDatabase;

/**
 * Created by Freddy on 4/8/2018.
 */

@Table(database = ToDoDatabase.class)
public class TodoTable extends BaseModel {


    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String NumeroaMostrar;

    @Column
    public String NumeroaMostrar2;

    @Column
    public String Operador;

    @Column
    public String Resultado;





}

