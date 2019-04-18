package shesijie.bawei.com.ssj041701.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import shesijie.bawei.com.ssj041701.app.MyApp;

public class HttpVolley  {
    private static HttpVolley httpVollet = new HttpVolley ();
    StringRequest stringRequest;

    public static final  HttpVolley getInstance(){
        return httpVollet;
    }
    public void GetVolley(String url, final VolleyCallBack volleyCallBack){
        stringRequest = new StringRequest ( Request.Method.GET , url , new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                volleyCallBack.onSuccess ( response );
            }
        } , new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onError ( error );
            }
        } );
        stringRequest.setTag ( "testTag" );
        MyApp.getQueue ().add ( stringRequest );
    }
    public interface VolleyCallBack{
        void onSuccess(String result);
        void onError(VolleyError error);
    }
}
