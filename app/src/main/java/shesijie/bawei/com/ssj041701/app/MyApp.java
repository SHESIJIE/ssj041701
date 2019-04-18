package shesijie.bawei.com.ssj041701.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MyApp extends Application {

    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate ();
        queue = Volley.newRequestQueue ( getApplicationContext () );
    }


    public static RequestQueue getQueue() {
        return queue;
    }
}
