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
import neo.vn.test365children.Listener.CheckGameSudoku;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.Models.SudokuCell;
import neo.vn.test365children.R;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterGameSudoku extends RecyclerView.Adapter<AdapterGameSudoku.TopicViewHoder> {
    private List<SudokuCell> list;
    private Context context;
    private ItemClickListener OnIListener;
    private CheckGameSudoku OnCheckGameSudoku;

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public CheckGameSudoku getOnCheckGameSudoku() {
        return OnCheckGameSudoku;
    }

    public void setOnCheckGameSudoku(CheckGameSudoku onCheckGameSudoku) {
        OnCheckGameSudoku = onCheckGameSudoku;
    }

    public AdapterGameSudoku(List<SudokuCell> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_button_sudoku, parent, false);
        return new TopicViewHoder(view);
    }

    @Override
    public void onBindViewHolder(final TopicViewHoder holder, int position) {
        holder.bindData(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.button)
        ImageView button;
        @BindView(R.id.txt_value)
        TextView txt_value;

        public TopicViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bindData(SudokuCell s) {
            RecyclerView.LayoutParams params =
                    (RecyclerView.LayoutParams) itemView.getLayoutParams();
            if (!s.isHide()) {
                txt_value.setTextColor(context.getResources().getColor(R.color.black));
                txt_value.setText("" + s.getValue());
            } else {
                txt_value.setText("");
                /*txt_value.setText("" + s.getValue());
                txt_value.setTextColor(context.getResources().getColor(R.color.blue));*/
                if (s.getValue_click() > 0 && s.getValue_click() == s.getValue()) {
                    txt_value.setText("" + s.getValue_click());
                    txt_value.setTextColor(context.getResources().getColor(R.color.blue_theme_game_kow));
                } else if (s.getValue_click() > 0) {
                    txt_value.setText("" + s.getValue_click());
                    txt_value.setTextColor(context.getResources().getColor(R.color.red_test365));
                }
                if (s.isClick()) {
                    Glide.with(context).load(R.drawable.ic_sudoku_cell_click).into(button);
                }/* else {
                    Glide.with(context).load(R.drawable.ic_sudoku_cell_2).into(button);
                }*/
            }
            if (getAdapterPosition() < 27 && getAdapterPosition() >= 18) {
                params.bottomMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.item_sector);
            } else if (getAdapterPosition() < 54 && getAdapterPosition() >= 45) {
                params.bottomMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.item_sector);
            } else {
                params.bottomMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.item_sudoku);
            }
            if (getAdapterPosition() == 2 || getAdapterPosition() == 5 || getAdapterPosition() == 11
                    || getAdapterPosition() == 20 || getAdapterPosition() == 14 || getAdapterPosition() == 29
                    || getAdapterPosition() == 23 || getAdapterPosition() == 38 || getAdapterPosition() == 32
                    || getAdapterPosition() == 41 || getAdapterPosition() == 47 || getAdapterPosition() == 50
                    || getAdapterPosition() == 56 || getAdapterPosition() == 65 || getAdapterPosition() == 74
                    || getAdapterPosition() == 59 || getAdapterPosition() == 68 || getAdapterPosition() == 77
                    ) {
                params.rightMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.item_sector);
            } else {
                params.rightMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.item_sudoku);
            }
          /*  if (getAdapterPosition() == 2) {
                params.rightMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.dp3);
            } else {
                params.rightMargin = itemView.getResources().getDimensionPixelOffset(R.dimen.dp1);
            }*/
            itemView.setLayoutParams(params);
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
