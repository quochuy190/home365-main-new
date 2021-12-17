package neo.vn.test365children.Fragment.ReviewExercises;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Adapter.AdapterCauhoiCongchua;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.StringUtil;

public class FragmentReviewCauhoiCongchua extends BaseFragment {
    private static final String TAG = "ActivityCauhoiCongchua";
    CauhoiDetail mCauhoi;
    @BindView(R.id.imageView3)
    ImageView img_background;
    @BindView(R.id.img_reload_review)
    ImageView img_reload_review;
    int[] arr_image = {R.drawable.bg_congchua1, R.drawable.bg_congchua2, R.drawable.bg_congchua3,
            R.drawable.bg_congchua4, R.drawable.bg_congchua6};

    public static FragmentReviewCauhoiCongchua newInstance(CauhoiDetail restaurant) {
        FragmentReviewCauhoiCongchua restaurantDetailFragment = new FragmentReviewCauhoiCongchua();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_cauhoicongchua, container, false);
        ButterKnife.bind(this, view);
        //   Log.i(TAG, "onCreateView: " + mCauhoi.getsQUESTION());
        img_reload_review.setVisibility(View.GONE);
        init();
        initData();
        initEvent();
        return view;
    }
    boolean isTrue = false;
    private String sDapan = "";

    private void initEvent() {
        img_reload_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    boolean isLambai = false;
    List<DapAn> mLis;
    AdapterCauhoiCongchua adapter;
    @BindView(R.id.recycle_dapan)
    RecyclerView recycle_dapan;
    RecyclerView.LayoutManager mLayoutManager;
    @BindView(R.id.txt_lable)
    TextView txt_lable;

    private void init() {
        mLis = new ArrayList<>();
        adapter = new AdapterCauhoiCongchua(mLis, getContext());
        mLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        //mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recycle_dapan.setNestedScrollingEnabled(false);
        recycle_dapan.setHasFixedSize(true);
        recycle_dapan.setLayoutManager(mLayoutManager);
        recycle_dapan.setItemAnimator(new DefaultItemAnimator());
        recycle_dapan.setAdapter(adapter);
    }

    int iRandom;
    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;
    @BindView(R.id.webview_debai)
    WebView webview_debai;

    private void initData() {
        Random ran = new Random();
        iRandom = ran.nextInt(arr_image.length);
        Glide.with(this).load(arr_image[iRandom]).into(img_background);
        if (mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null)
            txt_lable.setText(Html.fromHtml("Bài " + mCauhoi.getsNumberDe() + "_Câu "
                    + mCauhoi.getsSubNumberCau() + ": " + mCauhoi.getsCauhoi_huongdan())
                    + " (" + Float.parseFloat(mCauhoi.getsPOINT()) + " đ)");
        if (mCauhoi.getsHTML_CONTENT() != null && mCauhoi.getsHTML_CONTENT().length() > 0) {
            StringUtil.initWebview_Whitetext(webview_debai, mCauhoi.getsHTML_CONTENT());
        }
        if (mCauhoi.getsRESULT_CHILD() != null && mCauhoi.getsRESULT_CHILD().equals("0")) {
            Glide.with(this).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
        } else {
            Glide.with(this).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
        }
        if (!mCauhoi.isDalam()) {
            Glide.with(this).load(R.drawable.icon_anwser_unknow).into(img_anwser_chil);
        }
        if (mCauhoi.getsA() != null && mCauhoi.getsA().length() > 0)
            mLis.add(new DapAn("A", mCauhoi.getsA(), mCauhoi.getsANSWER_CHILD(),
                    mCauhoi.getsANSWER(), true, ""));
        if (mCauhoi.getsB() != null && mCauhoi.getsB().length() > 0)
            mLis.add(new DapAn("B", mCauhoi.getsB(), mCauhoi.getsANSWER_CHILD(),
                    mCauhoi.getsANSWER(), true, ""));
        if (mCauhoi.getsC() != null && mCauhoi.getsC().length() > 0)
            mLis.add(new DapAn("C", mCauhoi.getsC(), mCauhoi.getsANSWER_CHILD(),
                    mCauhoi.getsANSWER(), true, ""));
        if (mCauhoi.getsD() != null && mCauhoi.getsD().length() > 0)
            mLis.add(new DapAn("D", mCauhoi.getsD(), mCauhoi.getsANSWER_CHILD(),
                    mCauhoi.getsANSWER(), true, ""));
        adapter.notifyDataSetChanged();

        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {

            }
        });
    }
}
