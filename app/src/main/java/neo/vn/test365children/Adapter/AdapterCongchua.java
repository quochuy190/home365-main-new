package neo.vn.test365children.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterCongchua extends RecyclerView.Adapter<AdapterCongchua.TopicViewHoder> {
    private List<DapAn> list;
    private Context context;
    private ItemClickListener OnIListener;

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterCongchua(List<DapAn> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_congchua_image, parent, false);
        return new TopicViewHoder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(TopicViewHoder holder, int position) {
        DapAn obj = list.get(position);

        if (obj.isClick()) {
            Glide.with(context).load(R.drawable.icon_lock_open).into(holder.img_box);
            // holder.img_box.setImageResource(R.drawable.icon_lock_open);
        } else if (obj.getsDapan_Dung().equals("1")) {
            Glide.with(context).load(R.drawable.door_open).into(holder.img_box);
            // holder.img_box.setImageResource(R.drawable.door_open);
        } else
            Glide.with(context).load(R.drawable.icon_lock).into(holder.img_box);
        //  holder.img_box.setImageResource(R.drawable.icon_lock);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.img_box)
        ImageView img_box;

        public TopicViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnIListener.onClickItem(getLayoutPosition(), list.get(getLayoutPosition()));
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    public void updateList(List<DapAn> list) {
        list = list;
        notifyDataSetChanged();
    }
}
