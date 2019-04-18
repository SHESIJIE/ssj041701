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

import shesijie.bawei.com.ssj041701.R;
import shesijie.bawei.com.ssj041701.bean.ShowBean;

class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHodel> {
    Context context;
    ShowBean.ResultBean.RxxpBean rxxpBean;
    private View inflate;
    private ShowBean.ResultBean.RxxpBean.CommodityListBean commodityListBean;

    public RxxpAdapter(Context context, ShowBean.ResultBean.RxxpBean rxxpBean) {
        this.context=context;
        this.rxxpBean=rxxpBean;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.show_rxxp_item, viewGroup, false);

        return new ViewHodel(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel viewHodel, int i) {
            commodityListBean = rxxpBean.getCommodityList().get(i);
             viewHodel.ntv.setText(commodityListBean.getCommodityName());
             viewHodel.ptv.setText(commodityListBean.getPrice());
             Glide.with(context).load(commodityListBean.getMasterPic()).into(viewHodel.imageView);
    }

    @Override
    public int getItemCount() {
        return rxxpBean.getCommodityList().size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv,ptv;

        public ViewHodel(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.show_rxxp_item_iv);
            ntv = itemView.findViewById(R.id.show_rxxp_item_ntv);
            ptv=itemView.findViewById(R.id.show_rxxp_item_ptv);
        }
    }
}
