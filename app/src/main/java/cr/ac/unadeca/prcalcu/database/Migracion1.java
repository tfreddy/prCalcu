package cr.ac.unadeca.prcalcu.database;

import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

import cr.ac.unadeca.prcalcu.database.models.TodoTable;


/**
 * Created by Freddy on 4/8/2018.
 */

@Migration(version = 1, database = ToDoDatabase.class)
public class Migracion1 extends AlterTableMigration<TodoTable> {

    public Migracion1(Class<TodoTable> table) {
        super(table);
    }

    @Override
    public void onPreMigrate() {
        super.onPreMigrate();
        addColumn(SQLiteType.INTEGER,"estado");
    }
}
