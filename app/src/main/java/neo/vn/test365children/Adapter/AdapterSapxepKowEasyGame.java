package neo.vn.test365children.Adapter;

import android.content.Context;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import neo.vn.test365children.Listener.ItemTouchHelperAdapter;
import neo.vn.test365children.Listener.ItemTouchHelperViewHolder;
import neo.vn.test365children.Listener.OnStartDragListener;
import neo.vn.test365children.Listener.RecyclerViewItemClickInterface;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.R;

public class AdapterSapxepKowEasyGame extends RecyclerView.Adapter<AdapterSapxepKowEasyGame.MyViewHolder> implements ItemTouchHelperAdapter {
    private List<DapAn> lisDapan;
    private Context mContext;
    private OnStartDragListener mDragStartListener;
    public RecyclerViewItemClickInterface delegate;

    public AdapterSapxepKowEasyGame(Context context, List<DapAn> dataModelArrayList, OnStartDragListener mDragStartListener) {
        this.mContext = context;
        this.lisDapan = dataModelArrayList;
        this.mDragStartListener = mDragStartListener;
    }


    @Override
    public AdapterSapxepKowEasyGame.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sapxep_easy, parent, false);
    /*    ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.2);
        itemView.setLayoutParams(layoutParams);*/
        return new AdapterSapxepKowEasyGame.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final DapAn dataModel = lisDapan.get(position);
        int iBg = 0;
        holder.txt_dapan.setText(Html.fromHtml(dataModel.getsContent()));
        holder.rl_item_sapxep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delegate.onItemClicked(String.valueOf(dataModel.getName()));
            }
        });
        if (dataModel.getsImage() != null && dataModel.getsImage().length() > 0) {
            iBg = Integer.parseInt(dataModel.getsImage());
        }

        switch (iBg) {
            case 0:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_toan));
                break;
            case 1:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_blue));
                break;
            case 2:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_green));
                break;
            case 3:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_red));
                break;
            case 4:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_tim));
                break;
            case 5:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_toan));
                break;
            case 6:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_blue));
                break;
            case 7:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_green));
                break;
            case 8:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_red));
                break;
            case 9:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_tim));
                break;
            case 10:
                holder.txt_dapan.setBackground(mContext.getResources().getDrawable(R.drawable.img_menu_toan));
                break;
        }
/*        if (position > 4)
            holder.img_bg.setImageResource(R.drawable.img_menu_blue);*/

        holder.rl_item_sapxep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.i("adapterSapxep", "onTouch: action dow");
                    mDragStartListener.onStartDrag(holder);
                }
              /*  if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.i("adapterSapxep", "onTouch: action up");
                    mDragStartListener.onEndDrag();
                }*/
                return false;
            }
        });


    }

    @Override
    public void onItemMove(int fromIndex, int toIndex) {
        if (fromIndex < lisDapan.size() && toIndex < lisDapan.size()) {
            if (fromIndex < toIndex) {
                for (int i = fromIndex; i < toIndex; i++) {
                    Collections.swap(lisDapan, i, i + 1);
                }
            } else {
                for (int i = fromIndex; i > toIndex; i--) {
                    Collections.swap(lisDapan, i, i - 1);
                }
            }
            notifyItemMoved(fromIndex, toIndex);
            mDragStartListener.onEndDrag();
        }
    }

    @Override
    public void onItemDismiss(int position) {
        if (lisDapan.size() < position) {
            lisDapan.remove(position);
            notifyItemRemoved(position);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        TextView txt_dapan;
        RelativeLayout rl_item_sapxep;

        public MyViewHolder(View view) {
            super(view);
            txt_dapan = view.findViewById(R.id.txt_content);
            rl_item_sapxep = view.findViewById(R.id.rl_item_sapxep);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }

    }

    @Override
    public int getItemCount() {
        return lisDapan.size();
    }

    public List<DapAn> getList() {
        return lisDapan;
    }
}
