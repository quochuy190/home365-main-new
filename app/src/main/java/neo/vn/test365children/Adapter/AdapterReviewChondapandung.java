package neo.vn.test365children.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterReviewChondapandung extends RecyclerView.Adapter<AdapterReviewChondapandung.TopicViewHoder> {
    private List<DapAn> list;
    private Context context;
    private ItemClickListener OnIListener;

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterReviewChondapandung(List<DapAn> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dapan, parent, false);
        return new TopicViewHoder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(TopicViewHoder holder, int position) {
        DapAn obj = list.get(position);
        holder.ll_dapan_all.removeAllViews();
        if (obj.getsContent() != null )
            if (obj.getsContent().indexOf("//") > 0) {

            } else if (obj.getsContent().indexOf("image") > 0) {
                ImageView txt_dapan = new ImageView(context);
                int hight_image = (int) context.getResources().getDimension(R.dimen.item_dapan);
                txt_dapan.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        hight_image));
                Glide.with(context).load(Config.URL_IMAGE + obj.getsContent()).into(txt_dapan);
                holder.ll_dapan_all.addView(txt_dapan);
            } else {
                TextView txt_dapan = new TextView(context);
                txt_dapan.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txt_dapan.setTextSize(16);
                txt_dapan.setTextColor(context.getResources().getColor(R.color.black));
                txt_dapan.setText(obj.getsContent());
                holder.ll_dapan_all.addView(txt_dapan);
            }

        if (obj.getsName().equals(obj.getsDapan_Traloi())) {
            holder.checkbox.setImageResource(R.drawable.ic_checked);
        }
        if (obj.getsName().equals(obj.getsDapan_Dung())) {
            holder.checkbox.setImageResource(R.drawable.ic_checked_blue);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.ll_dapan_all)
        LinearLayout ll_dapan_all;
        @BindView(R.id.checkbox_dapan)
        ImageView checkbox;

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
