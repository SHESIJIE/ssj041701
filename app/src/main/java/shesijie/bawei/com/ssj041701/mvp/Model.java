package shesijie.bawei.com.ssj041701.mvp;

import com.android.volley.VolleyError;

import shesijie.bawei.com.ssj041701.net.HttpVolley;

public class Model implements Constantr.IModel {
   /* private String url = "http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";
   */
   private String url = "http://172.17.8.100/small/commodity/v1/commodityList";
   @Override
    public void show(final ModelCallBack modelCallBack) {
        HttpVolley.getInstance ().GetVolley ( url , new HttpVolley.VolleyCallBack () {
            @Override
            public void onSuccess(String result) {
                modelCallBack.onSuccess ( result );
            }
            @Override
            public void onError(VolleyError error) {
            }
        } );
    }
}
