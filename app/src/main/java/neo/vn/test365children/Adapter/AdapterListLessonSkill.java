package neo.vn.test365children.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
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
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.Models.ObjLessonSkill;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterListLessonSkill extends RecyclerView.Adapter<AdapterListLessonSkill.TopicViewHoder> {
    private List<ObjLessonSkill> list;
    private Context context;
    private ItemClickListener OnIListener;

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterListLessonSkill(List<ObjLessonSkill> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson_skill, parent, false);
        return new TopicViewHoder(view);
    }

    @Override
    public void onBindViewHolder(TopicViewHoder holder, int position) {
        ObjLessonSkill obj = list.get(position);
        if (obj.getNAME() != null) {
            holder.txt_name.setText(obj.getNAME());
        }
        if (obj.getURL1() != null) {
            holder.txt_web_lesson.setText("Nguồn: "+obj.getURL1());
        }
        // holder.txt_name.setTextSize(context.getResources().getDimension(R.dimen.txt_app));
        //    Glide.with(context).load(obj.getsLogo()).into(holder.img_logo);
        Glide.with(context)
                .load(Config.URL_IMAGE + "/" + obj.getIMAGES())
                .asBitmap()
                .placeholder(R.color.gray)
                .into(new BitmapImageViewTarget(holder.img_logo) {
                    @Override
                    public void onResourceReady(Bitmap drawable, GlideAnimation anim) {
                        super.onResourceReady(drawable, anim);
                        //   progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.img_logo_lesson)
        ImageView img_logo;
        @BindView(R.id.txt_name_lesson)
        TextView txt_name;
        @BindView(R.id.txt_web_lesson)
        TextView txt_web_lesson;

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
