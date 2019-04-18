 package shesijie.bawei.com.ssj041701.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import shesijie.bawei.com.ssj041701.adapter.MyAdpater;
import shesijie.bawei.com.ssj041701.adapter.ShowAdapter;
import shesijie.bawei.com.ssj041701.bean.MyBean;
import shesijie.bawei.com.ssj041701.R;
import shesijie.bawei.com.ssj041701.bean.ShowBean;

 public class MainActivity extends AppCompatActivity implements Constantr.IView {

     RecyclerView recyclerView;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
         recyclerView = findViewById ( R.id.recycler );
         recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        Presenter presenter = new Presenter ();
        presenter.onAttch ( this );
    }
     @Override
     public void getPresenter(String data) {
         Gson gson = new Gson ();
         ShowBean showBean = gson.fromJson ( data , ShowBean.class );
         MyAdpater myAdpater = new MyAdpater ( MainActivity.this ,showBean.getResult ().getMlss ().getCommodityList ());
         ShowAdapter adapter = new ShowAdapter ( MainActivity.this,showBean );
         recyclerView.setAdapter ( adapter );
     }
 }
