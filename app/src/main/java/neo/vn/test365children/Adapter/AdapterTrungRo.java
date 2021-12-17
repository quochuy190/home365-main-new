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
import neo.vn.test365children.Models.Item_Xeptrung;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterTrungRo extends RecyclerView.Adapter<AdapterTrungRo.TopicViewHoder> {
    private List<Item_Xeptrung> list;
    private Context context;

    public AdapterTrungRo(List<Item_Xeptrung> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rotrung, parent, false);
        return new TopicViewHoder(view);
    }

    @Override
    public void onBindViewHolder(TopicViewHoder holder, int position) {
        Item_Xeptrung obj = list.get(position);
        Glide.with(context).load(R.drawable.icon_ro_trung).into(holder.img_rotrung_1);
        if (obj.getsRotrung().length() > 0) {
            holder.txt_rotrung.setText(obj.getsRotrung());
        }
        if (obj.getsTrung().length() > 0) {
            holder.txt_trung.setText(obj.getsTrung());
        }
        if (obj.getImg_Trung() != 0) {
            Glide.with(context).load(obj.getImg_Trung()).into(holder.img_trung);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_rotrung_dapan_1)
        TextView txt_rotrung;
        @BindView(R.id.img_trung_dapan_1)
        ImageView img_trung;
        @BindView(R.id.img_rotrung_1)
        ImageView img_rotrung_1;
        @BindView(R.id.txt_trung_dapan_1)
        TextView txt_trung;

        public TopicViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }


}
