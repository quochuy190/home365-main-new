package neo.vn.test365children.Fragment.ReviewExercises;

import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Adapter.AdapterTrungRo;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.Models.Item_Xeptrung;
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
public class FragmentReviewTrungRo extends BaseFragment {
    private static final String TAG = "FragmentCauhoi";
    private CauhoiDetail mCauhoi;
    @BindView(R.id.txt_lable)
    TextView txt_lable;
    @BindView(R.id.recycle_egg_true)
    RecyclerView recycle_egg_true;
    @BindView(R.id.recycle_egg_anwser)
    RecyclerView recycle_egg_anwser;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.LayoutManager mLayoutManager2;
    List<Item_Xeptrung> mLisAnwser;
    List<Item_Xeptrung> mLisDapan;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;
    AdapterTrungRo adapterAnwser;
    AdapterTrungRo adapterDapan;
    @BindView(R.id.txt_title_dapan)
    TextView txt_title_dapan;
    @BindView(R.id.txt_title_dapan_be)
    TextView txt_title_dapan_be;
    @BindView(R.id.ll_anwser)
    LinearLayout ll_anwser;
    @BindView(R.id.ll_true)
    LinearLayout ll_true;


    public static FragmentReviewTrungRo newInstance(CauhoiDetail restaurant) {
        FragmentReviewTrungRo restaurantDetailFragment = new FragmentReviewTrungRo();
        Bundle args = new Bundle();
        //args.putSerializable("cauhoi",restaurant);
        args.putParcelable("cauhoi", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCauhoi = Parcels.unwrap(getArguments().getParcelable("cauhoi"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_rotrung, container, false);
        ButterKnife.bind(this, view);
        mLisAnwser = new ArrayList<>();
        mLisDapan = new ArrayList<>();
        init();
        initData();
        return view;
    }

    private void initData() {
        img_anwser_chil.setVisibility(View.VISIBLE);
        if (mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null)
            txt_lable.setText(Html.fromHtml("Bài " + mCauhoi.getsNumberDe() + "_Câu "
                    + mCauhoi.getsSubNumberCau() + ": " + mCauhoi.getsCauhoi_huongdan())
                    + " (" + Float.parseFloat(mCauhoi.getsPOINT()) + " đ)");
        Glide.with(this).load(R.drawable.bg_xep_trung).into(img_background);
        if (mCauhoi.getsRESULT_CHILD() != null && mCauhoi.getsRESULT_CHILD().length() > 0) {
            if (mCauhoi.getsRESULT_CHILD().equals("0")) {
                //  txt_cauhoi.setVisibility(View.VISIBLE);
                ll_true.setVisibility(View.VISIBLE);
                ll_anwser.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
            } else {
                txt_title_dapan_be.setVisibility(View.GONE);
                ll_true.setVisibility(View.GONE);
                Glide.with(this).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
            }
        } else {
            ll_true.setVisibility(View.VISIBLE);
            txt_title_dapan_be.setVisibility(View.GONE);
            ll_anwser.setVisibility(View.GONE);
            //txt_cauhoi.setVisibility(View.INVISIBLE);
            Glide.with(this).load(R.drawable.icon_anwser_unknow).into(img_anwser_chil);
        }

        if (!mCauhoi.isDalam()) {
            txt_title_dapan_be.setVisibility(View.GONE);
            // txt_cauhoi.setVisibility(View.INVISIBLE);
            Glide.with(this).load(R.drawable.icon_anwser_unknow).into(img_anwser_chil);
        }
        if (mCauhoi.getsEGG_2() != null && mCauhoi.getsEGG_2().length() > 0) {
            String[] mEgg2 = mCauhoi.getsEGG_2().split("::");
            if (mEgg2 != null && mEgg2.length > 0)
                mLisDapan.add(new Item_Xeptrung(mEgg2[1], R.drawable.egg_red, mEgg2[0]));
        }
        if (mCauhoi.getsEGG_3() != null && mCauhoi.getsEGG_3().length() > 0) {
            String[] mEgg3 = mCauhoi.getsEGG_3().split("::");
            if (mEgg3 != null && mEgg3.length > 0)
                mLisDapan.add(new Item_Xeptrung(mEgg3[1], R.drawable.egg_yellow, mEgg3[0]));
        }
        if (mCauhoi.getsEGG_4() != null && mCauhoi.getsEGG_4().length() > 0) {
            String[] mEgg4 = mCauhoi.getsEGG_4().split("::");
            if (mEgg4 != null && mEgg4.length > 0)
                mLisDapan.add(new Item_Xeptrung(mEgg4[1], R.drawable.egg_pink, mEgg4[0]));
        }
        if (mCauhoi.getsEGG_1() != null && mCauhoi.getsEGG_1().length() > 0) {
            String[] mEgg = mCauhoi.getsEGG_1().split("::");
            if (mEgg != null && mEgg.length > 0)
                mLisDapan.add(new Item_Xeptrung(mEgg[1], R.drawable.egg_blue, mEgg[0]));
        }

        if (mCauhoi.getsRESULT_CHILD() != null && mCauhoi.getsRESULT_CHILD().length() > 0) {
            if (mCauhoi.getsEGG_1_RESULT() != null && mCauhoi.getsEGG_1_RESULT().length() > 0) {
                String[] mEggAnwser = mCauhoi.getsEGG_1_RESULT().split("::");
                if (mEggAnwser != null && mEggAnwser.length > 0)
                    mLisAnwser.add(new Item_Xeptrung(mEggAnwser[1], R.drawable.egg_blue, mEggAnwser[0]));
            }
            if (mCauhoi.getsEGG_2_RESULT() != null && mCauhoi.getsEGG_2_RESULT().length() > 0) {
                String[] mEggAnwser2 = mCauhoi.getsEGG_2_RESULT().split("::");
                if (mEggAnwser2 != null && mEggAnwser2.length > 0)
                    mLisAnwser.add(new Item_Xeptrung(mEggAnwser2[1], R.drawable.egg_red, mEggAnwser2[0]));
            }
            if (mCauhoi.getsEGG_3_RESULT() != null && mCauhoi.getsEGG_3_RESULT().length() > 0) {
                String[] mEggAnwser3 = mCauhoi.getsEGG_3_RESULT().split("::");
                if (mEggAnwser3 != null && mEggAnwser3.length > 0)
                    mLisAnwser.add(new Item_Xeptrung(mEggAnwser3[1], R.drawable.egg_yellow, mEggAnwser3[0]));
            }
            if (mCauhoi.getsEGG_4_RESULT() != null && mCauhoi.getsEGG_4_RESULT().length() > 0) {
                String[] mEggAnwser4 = mCauhoi.getsEGG_4_RESULT().split("::");
                if (mEggAnwser4 != null && mEggAnwser4.length > 0)
                    mLisAnwser.add(new Item_Xeptrung(mEggAnwser4[1], R.drawable.egg_pink, mEggAnwser4[0]));
            }
        }

        adapterDapan.notifyDataSetChanged();
        adapterAnwser.notifyDataSetChanged();
    }


    private void init() {
        adapterAnwser = new AdapterTrungRo(mLisAnwser, getContext());
        adapterDapan = new AdapterTrungRo(mLisDapan, getContext());
        mLayoutManager = new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false);
        mLayoutManager2 = new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false);
        //mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recycle_egg_anwser.setNestedScrollingEnabled(false);
        recycle_egg_anwser.setHasFixedSize(true);
        recycle_egg_anwser.setLayoutManager(mLayoutManager);
        recycle_egg_anwser.setItemAnimator(new DefaultItemAnimator());
        recycle_egg_anwser.setAdapter(adapterAnwser);

        recycle_egg_true.setNestedScrollingEnabled(false);
        recycle_egg_true.setHasFixedSize(true);
        recycle_egg_true.setLayoutManager(mLayoutManager2);
        recycle_egg_true.setItemAnimator(new DefaultItemAnimator());
        recycle_egg_true.setAdapter(adapterDapan);
    }


}
