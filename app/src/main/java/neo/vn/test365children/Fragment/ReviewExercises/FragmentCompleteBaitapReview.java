package neo.vn.test365children.Fragment.ReviewExercises;

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
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.R;


/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 8/6/2018
 * @updated 8/6/2018
 * @modified by
 * @updated on 8/6/2018
 * @since 1.0
 */
public class FragmentCompleteBaitapReview extends BaseFragment {
    @BindView(R.id.img_nopbai)
    Button img_nopbai;
    @BindView(R.id.imageView18)
    ImageView img_background;

    public static FragmentCompleteBaitapReview newInstance(CauhoiDetail restaurant) {
        FragmentCompleteBaitapReview restaurantDetailFragment = new FragmentCompleteBaitapReview();
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
        //   Log.i(TAG, "onCreateView: " + mCauhoi.getsQUESTION());
        img_nopbai.setText("Đóng");
        img_nopbai.setVisibility(View.GONE);
        initEvent();
        Glide.with(this).load(R.drawable.bg_chao_mung).into(img_background);
        return view;
    }

    private void initEvent() {
        img_nopbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }


}
