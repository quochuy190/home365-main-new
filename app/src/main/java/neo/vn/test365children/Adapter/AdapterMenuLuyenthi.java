package neo.vn.test365children.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.GoiBaitap;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterMenuLuyenthi extends RecyclerView.Adapter<AdapterMenuLuyenthi.TopicViewHoder> {
    private List<GoiBaitap> listChildren;
    private Context context;
    private ItemClickListener OnIListener;

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterMenuLuyenthi(List<GoiBaitap> listAirport, Context context) {
        this.listChildren = listAirport;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_luyenthi_menu, parent, false);
        return new TopicViewHoder(view);
    }

    @Override
    public void onBindViewHolder(final TopicViewHoder holder, int position) {
        GoiBaitap obj = listChildren.get(position);
        try {
            switch (obj.getSUBJECT_ID()) {
                case "1":
                    Glide.with(context).load(R.drawable.ic_luyenthi_orange).into(holder.icon_luyenthi);
                    break;
                case "2":
                    Glide.with(context).load(R.drawable.ic_luyenthi_purple).into(holder.icon_luyenthi);
                    break;
                case "3":
                    Glide.with(context).load(R.drawable.ic_luyenthi_blue).into(holder.icon_luyenthi);
                    break;
            }
            if (obj.getNAME() != null)
                holder.txt_name.setText(obj.getNAME());
            if (obj.getACTIVE_STATE() != null && obj.getACTIVE_STATE().equals("1")) {
                holder.ic_lock.setVisibility(View.GONE);
            } else
                holder.ic_lock.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listChildren.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_name)
        TextView txt_name;
        @BindView(R.id.icon_luyenthi)
        ImageView icon_luyenthi;
        @BindView(R.id.ic_lock)
        ImageView ic_lock;

        public TopicViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnIListener.onClickItem(getLayoutPosition(), listChildren.get(getLayoutPosition()));
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    public void updateList(List<GoiBaitap> list) {
        listChildren = list;
        notifyDataSetChanged();
    }

}
