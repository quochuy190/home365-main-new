package neo.vn.test365children.Listener;

import androidx.recyclerview.widget.RecyclerView;

public interface OnStartDragListener {
  void onStartDrag(RecyclerView.ViewHolder viewHolder);
  void onEndDrag();
}