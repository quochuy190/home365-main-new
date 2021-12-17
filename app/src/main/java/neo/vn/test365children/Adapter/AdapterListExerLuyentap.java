package neo.vn.test365children.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.DetailExercise;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.StringUtil;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterListExerLuyentap extends RecyclerView.Adapter<AdapterListExerLuyentap.TopicViewHoder> {
    private List<DetailExercise> listChildren;
    private Context context;
    private ItemClickListener OnIListener;

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterListExerLuyentap(List<DetailExercise> listAirport, Context context) {
        this.listChildren = listAirport;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_exer_luyentap, parent, false);
        return new TopicViewHoder(view);
    }

    @Override
    public void onBindViewHolder(final TopicViewHoder holder, int position) {
        DetailExercise obj = listChildren.get(position);
        if (position % 1 == 0) {

        } else if (position % 2 == 0) {

        }
        if (obj.isDalam()) {
            holder.txt_dalam.setVisibility(View.VISIBLE);
            holder.txt_point.setVisibility(View.VISIBLE);
            holder.txt_dalam.setTextColor(context.getResources().getColor(R.color.red_test365));
            holder.txt_dalam.setText("Đã làm");
            holder.txt_point.setText(StringUtil.format_point(Float.parseFloat(obj.getsPOINT())) + " ĐIỂM");
        } else {
            holder.txt_dalam.setVisibility(View.GONE);
            holder.txt_dalam.setTextColor(context.getResources().getColor(R.color.blue));
            holder.txt_dalam.setText("Chưa làm");
            holder.txt_point.setVisibility(View.GONE);
        }
        Glide.with(context).load(R.drawable.ic_luyenthi_orange).into(holder.img_background);
        holder.txt_name.setText(obj.getEXCERCISE_NAME());
    }

    @Override
    public int getItemCount() {
        return listChildren.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_name)
        TextView txt_name;
        @BindView(R.id.txt_dalam)
        TextView txt_dalam;
        @BindView(R.id.txt_point)
        TextView txt_point;
        @BindView(R.id.img_background)
        ImageView img_background;

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

    public void updateList(List<DetailExercise> list) {
        listChildren = list;
        notifyDataSetChanged();
    }
}
