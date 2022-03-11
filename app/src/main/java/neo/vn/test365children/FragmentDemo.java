package neo.vn.test365children;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Fragment.FragmentCompleteBaitap;
import neo.vn.test365children.Models.CauhoiDetail;

/**
 * Created 11/03/2022 at 15:56
 * Company: VHM
 */
public class FragmentDemo extends BaseFragment {
    @BindView(R.id.img_nopbai)
    Button img_nopbai;
    @BindView(R.id.imageView18)
    ImageView img_background;
    public static FragmentCompleteBaitap newInstance(CauhoiDetail restaurant) {
        FragmentCompleteBaitap restaurantDetailFragment = new FragmentCompleteBaitap();
        Bundle args = new Bundle();
        //args.putSerializable("cauhoi",restaurant);
        args.putParcelable("cauhoi", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complete_baitap, container, false);
        ButterKnife.bind(this, view);
        initEvent();
        Glide.with(getActivity()).load(R.drawable.bg_chao_mung).into(img_background);
        return view;
    }

    private void initEvent() {

    }
}
