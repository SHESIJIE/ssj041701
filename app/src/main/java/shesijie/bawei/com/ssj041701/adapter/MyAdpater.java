package shesijie.bawei.com.ssj041701.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import shesijie.bawei.com.ssj041701.bean.MyBean;
import shesijie.bawei.com.ssj041701.R;
import shesijie.bawei.com.ssj041701.bean.ShowBean;

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.holder> {
    private Context context;
   private List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list;
    private String names;
    private String iam;
    public MyAdpater(Context context , List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdpater.holder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.item_list,null );
        return new holder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdpater.holder holder , int i) {
        names = list.get ( i ).getCommodityName ();
        iam = list.get ( i ).getMasterPic ();
        holder.textView.setText ( names);
        Glide.with ( context ).load ( iam ).into ( holder.imageView );
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;

    }

    public class  holder extends RecyclerView.ViewHolder {
        private  TextView textView;
        private ImageView imageView;
        public holder(@NonNull View itemView) {

            super ( itemView );
            textView = itemView.findViewById ( R.id.list_name );
            imageView = itemView.findViewById ( R.id.list_ima );
        }
    }
}
