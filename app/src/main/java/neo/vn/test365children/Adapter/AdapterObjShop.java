package neo.vn.test365children.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Listener.OnListenerItemClickObjService;
import neo.vn.test365children.Listener.setOnItemClickListener;
import neo.vn.test365children.Models.ObjLessonSkill;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterObjShop extends RecyclerView.Adapter<AdapterObjShop.FlightInfoViewHoder> {
    private List<ObjLessonSkill> mLisObjService;
    private Context context;
    private setOnItemClickListener OnIListener;
    private OnListenerItemClickObjService onListenerItemClickObjService;

    public setOnItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(setOnItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterObjShop(Context context, OnListenerItemClickObjService onListenerItemClickObjService) {
        this.context = context;
        this.onListenerItemClickObjService = onListenerItemClickObjService;
    }


    @NonNull
    @Override
    public FlightInfoViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson, parent, false);
        return new FlightInfoViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightInfoViewHoder holder, final int position) {
        ObjLessonSkill objService = mLisObjService.get(position);
        Glide.with(context).load(Config.URL_IMAGE + "/" + objService.getIMAGES()).into(holder.img_Background);
        Glide.with(context)
                .load(Config.URL_IMAGE + "/" + objService.getIMAGES())
                .asBitmap()
                .placeholder(R.color.gray)
                .into(new BitmapImageViewTarget(holder.img_Background) {
                    @Override
                    public void onResourceReady(Bitmap drawable, GlideAnimation anim) {
                        super.onResourceReady(drawable, anim);
                        //   progressBar.setVisibility(View.GONE);
                    }
                });
        if (objService.getNAME() != null)
            holder.txt_item_nem.setText(objService.getNAME());
        if (objService.getFN_COURSE() != null)
            holder.txt_count_view.setText(objService.getFN_COURSE()+" lượt xem");
        holder.img_Background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerItemClickObjService.onClickListener(mLisObjService.get(position));
            }
        });
        holder.txt_more_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerItemClickObjService.onItemXemthemClick(mLisObjService.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mLisObjService.size();
    }

    public class FlightInfoViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_item_shops_name)
        TextView txt_item_nem;
        @BindView(R.id.txt_count_view)
        TextView txt_count_view;
        @BindView(R.id.txt_more_view)
        TextView txt_more_view;
        @BindView(R.id.img_item_shops)
        ImageView img_Background;


        public FlightInfoViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //  itemView.setOnClickListener(this);

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

    public void setData(List<ObjLessonSkill> data) {
        if (mLisObjService != data) {
            mLisObjService = data;
            notifyDataSetChanged();
        }
    }
    /*public void updateList(List<BaoCao_Nam> list) {
        lis_Baocao_nam = list;
        notifyDataSetChanged();
    }*/
}
