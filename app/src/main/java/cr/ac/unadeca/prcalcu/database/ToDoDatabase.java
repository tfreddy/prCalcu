package cr.ac.unadeca.prcalcu.database;

/**
 * Created by Freddy on 4/8/2018.
 */

import com.raizlabs.android.dbflow.annotation.Database;
@Database(name = ToDoDatabase.NAME, version = ToDoDatabase.VERSION)

public class ToDoDatabase {
    public static final String NAME = "Calcu";

    public static final int VERSION = 1;

}
