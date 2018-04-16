package cr.ac.unadeca.prcalcu.database;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Freddy on 4/8/2018.
 */

public class ToDoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
//FT