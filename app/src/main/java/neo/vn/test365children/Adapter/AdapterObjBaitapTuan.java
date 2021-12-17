package neo.vn.test365children.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Listener.setOnItemClickListener;
import neo.vn.test365children.Models.DETAILSItem;
import neo.vn.test365children.Models.ExerciseAnswer;
import neo.vn.test365children.R;


public class AdapterObjBaitapTuan extends RecyclerView.Adapter<AdapterObjBaitapTuan.FlightInfoViewHoder> {
    private List<DETAILSItem> mLisObjService = new ArrayList<>();
    private Context context;
    private setOnItemClickListener OnIListener;


    public setOnItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(setOnItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterObjBaitapTuan(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public FlightInfoViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_obj_baitaptuan_dalam, parent, false);
        return new FlightInfoViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightInfoViewHoder holder, final int position) {
        DETAILSItem objService = mLisObjService.get(position);
        //  Glide.with(context).load(objService.getmImage()).into(holder.img_Background);
        switch (objService.getSUBJECTID()) {
            case 1:
                //  holder.txt_monhoc.setText("Môn Toán");
                Glide.with(context).load(R.drawable.img_menu_toan).into(holder.img_bg);
                break;
            case 2:
                // holder.txt_monhoc.setText("Tiếng Việt");
                Glide.with(context).load(R.drawable.img_menu_blue).into(holder.img_bg);
                break;
            case 3:
                // holder.txt_monhoc.setText("Tiếng Anh");
                Glide.with(context).load(R.drawable.img_menu_tim).into(holder.img_bg);
                break;
        }
        holder.txt_monhoc.setText(objService.getWEEKNAME() + " - "
                + objService.getPOINT() + " Đ");
        //holder.txt_diem.setText(StringUtil.format_point(Float.parseFloat(objService.getsPoint())) + " Điểm");

    }


    @Override
    public int getItemCount() {
        return mLisObjService.size();
    }

    public class FlightInfoViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_monhoc)
        TextView txt_monhoc;
        /*   @BindView(R.id.txt_diem)
           TextView txt_diem;*/
        @BindView(R.id.holder)
        RelativeLayout holder;
        @BindView(R.id.img_bg)
        ImageView img_bg;

        public FlightInfoViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            OnIListener.OnItemClickListener(getLayoutPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            OnIListener.OnLongItemClickListener(getLayoutPosition());
            return false;
        }
    }

    public void setData(List<DETAILSItem> data) {
        mLisObjService = data;
        notifyDataSetChanged();
    }

    public void updateList(List<ExerciseAnswer> list) {
        //  lis_Baocao_nam = list;
        notifyDataSetChanged();
    }

}
