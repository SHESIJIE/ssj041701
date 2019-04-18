package shesijie.bawei.com.ssj041701.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import shesijie.bawei.com.ssj041701.R;
import shesijie.bawei.com.ssj041701.bean.ShowBean;
import shesijie.bawei.com.ssj041701.mvp.MainActivity;



public class ShowAdapter extends RecyclerView.Adapter{
    Context context;
    ShowBean showBean;
    private ShowBean.ResultBean.RxxpBean rxxpBean;
    int RxxpType=1;
    int PzshType=2;
    int MlssType=3;
    private int itemViewType;
    LinearLayoutManager rxxpManger;
    private View inflaterxxp,inflatepszh,inflatemlss;
    private int viewType;
    RxxpAdapter rxxpAdapter;


    public ShowAdapter(MainActivity showActivity, ShowBean showBean) {
        this.context=showActivity;
        this.showBean=showBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewType = getItemViewType(i);

            inflaterxxp = LayoutInflater.from ( context ).inflate ( R.layout.show_rxxp , viewGroup , false );
            return new ViewHodelRxxp ( inflaterxxp );
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            ViewHodelRxxp viewHodelRxxp = (ViewHodelRxxp) viewHolder;
            rxxpBean = showBean.getResult ().getRxxp ();
            viewHodelRxxp.rxxptv.setText( showBean.getResult().getRxxp().getName());
            rxxpManger = new LinearLayoutManager ( context );
            rxxpManger.setOrientation ( LinearLayoutManager.HORIZONTAL );
            viewHodelRxxp.rxxprc.setLayoutManager ( rxxpManger );
            rxxpAdapter = new RxxpAdapter ( context,rxxpBean );

            viewHodelRxxp.rxxprc.setAdapter ( rxxpAdapter );


    }
    //获取条目数量
    @Override
    public int getItemCount() {
        return 1;
    }
    //获取条目类型
    @Override
    public int getItemViewType(int position) {
        if (position==1){
            return RxxpType;
        }else if(position==2){
            return PzshType;
        }else {
            return MlssType;
        }
    }
    public class ViewHodelRxxp extends RecyclerView.ViewHolder {
        private final TextView rxxptv;
        private final RecyclerView rxxprc;
        public ViewHodelRxxp(@NonNull View itemView) {
            super(itemView);
            rxxptv = itemView.findViewById(R.id.show_rxxp_tv);
            rxxprc = itemView.findViewById ( R.id.show_mlss_rc );
        }
    }
}
