package neo.vn.test365children.Fragment;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Adapter.AdapterDapan;
import neo.vn.test365children.Adapter.AdapterDapanXemanh;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.Models.MessageEvent;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.StringUtil;


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
public class FragmentXemanhtraloi extends BaseFragment {
    private static final String TAG = "FragmentCauhoi";
    private CauhoiDetail mCauhoi;
    @BindView(R.id.img_question)
    ImageView img_question;
    @BindView(R.id.recycler_dapan)
    RecyclerView recycler_dapan;
    @BindView(R.id.txt_lable)
    TextView txt_lable;
    @BindView(R.id.txt_question)
    WebView txt_question;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterDapanXemanh adapter_xemanh;
    List<DapAn> mLis;
    @BindView(R.id.btn_xemdiem)
    Button btn_xemdiem;
    private boolean isTraloi = false;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;

    public static FragmentXemanhtraloi newInstance(CauhoiDetail restaurant) {
        FragmentXemanhtraloi restaurantDetailFragment = new FragmentXemanhtraloi();
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
        mLis = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xemanhtraloi, container, false);
        ButterKnife.bind(this, view);
        init();
        btn_xemdiem.setEnabled(false);
        btn_xemdiem.setBackground(getResources().getDrawable(R.drawable.btn_gray_black));
 /*       btn_xemdiem.setEnabled(false);
        btn_xemdiem.getBackground().setAlpha(50);*/
        initData();
        initEvent();
        return view;
    }

    private boolean isClickXemdiem = false;

    private void initEvent() {
        btn_xemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClickXemdiem) {
                    img_anwser_chil.setVisibility(View.VISIBLE);
                    boolean isTrue = false;
                    if (mLis != null && isTraloi) {
                        for (DapAn obj : mLis) {
                            obj.setClick(true);
                            if (obj.getsDapan_Dung().equals(obj.getsDapan_Traloi())) {
                                isTrue = true;
                            }
                        }
                        adapter.notifyDataSetChanged();
                        if (isTrue) {
                            Glide.with(getContext()).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
                            EventBus.getDefault().post(new MessageEvent("Point_true", Float.parseFloat(mCauhoi.getsPOINT()), 0));
                        } else {
                            Glide.with(getContext()).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
                            EventBus.getDefault().post(new MessageEvent("Point_false_sau", 0, 0));
                        }
                    }
                    isClickXemdiem = true;
                    EventBus.getDefault().post(new MessageEvent(Constants.KEY_SAVE_LIST_EXER_PLAYING, 0, 0));
                }

            }
        });
    }

    AdapterDapan adapter;

    private void init() {
        adapter = new AdapterDapan(mLis, getContext());
        mLayoutManager = new GridLayoutManager(getContext(),
                1, GridLayoutManager.VERTICAL, false);
        // mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        recycler_dapan.setLayoutManager(mLayoutManager);
        recycler_dapan.setAdapter(adapter);
        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                btn_xemdiem.setEnabled(true);
                btn_xemdiem.setBackground(getResources().getDrawable(R.drawable.btn_1));
              /*  btn_xemdiem.setEnabled(true);
                btn_xemdiem.getBackground().setAlpha(255);*/
                App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                        .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setDalam(true);
                if (!mLis.get(position).isClick()) {
                    for (DapAn obj : mLis) {
                        //obj.setClick(true);
                        if (obj.getsName().equals(mLis.get(position).getsName())) {
                            if (obj.getsDapan_Dung().equals(obj.getsName())) {
                                App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                                        .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setAnserTrue(true);
                                App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                                        .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setsRESULT_CHILD("1");
                            } else {
                                App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                                        .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setAnserTrue(false);
                                App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                                        .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setsRESULT_CHILD("0");
                            }
                            App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                                    .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setsANSWER_CHILD(obj.getsName());
                            obj.setsDapan_Traloi(obj.getsName());
                        } else {
                            obj.setsDapan_Traloi("");
                        }

                    }
                    isTraloi = true;
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


    private void initData() {
        try {
            Glide.with(this).load(R.drawable.bg_nghe_nhin).into(img_background);
            if (mCauhoi != null && mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null) {
                if (mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null)
                    txt_lable.setText(Html.fromHtml("Bài " + mCauhoi.getsNumberDe() + "_Câu "
                            + mCauhoi.getsSubNumberCau() + ": " + mCauhoi.getsCauhoi_huongdan())
                            + " (" + Float.parseFloat(mCauhoi.getsPOINT()) + " đ)");
         /*   txt_question.setText(Html.fromHtml("Câu " + mCauhoi.getsSubNumberCau() + ": "
                    + mCauhoi.getsHTML_CONTENT()));*/
                StringUtil.initWebview_Batsau(txt_question, mCauhoi.getsHTML_CONTENT());
            }
            String s = Config.URL_IMAGE + mCauhoi.getsImagePath();
            Glide.with(getContext()).load(s).into(img_question);
            if (mCauhoi.isDalam()) {
                btn_xemdiem.setBackground(getResources().getDrawable(R.drawable.btn_gray_black));
                img_anwser_chil.setVisibility(View.VISIBLE);
                if (mCauhoi.isAnserTrue()) {
                    Glide.with(getContext()).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
                } else {
                    Glide.with(getContext()).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
                }
                isClickXemdiem = true;
                if (mCauhoi.getsHTML_A() != null && mCauhoi.getsHTML_A().length() > 0)
                    mLis.add(new DapAn("A", mCauhoi.getsHTML_A(), mCauhoi.getsANSWER_CHILD(),
                            mCauhoi.getsANSWER(), true, ""));
                if (mCauhoi.getsHTML_B() != null && mCauhoi.getsHTML_B().length() > 0)
                    mLis.add(new DapAn("B", mCauhoi.getsHTML_B(), mCauhoi.getsANSWER_CHILD(), mCauhoi.getsANSWER(), true, ""));
                if (mCauhoi.getsHTML_C() != null && mCauhoi.getsHTML_C().length() > 0)
                    mLis.add(new DapAn("C", mCauhoi.getsHTML_C(), mCauhoi.getsANSWER_CHILD(), mCauhoi.getsANSWER(), true, ""));
                if (mCauhoi.getsHTML_D() != null && mCauhoi.getsHTML_D().length() > 0)
                    mLis.add(new DapAn("D", mCauhoi.getsHTML_D(), mCauhoi.getsANSWER_CHILD(), mCauhoi.getsANSWER(), true, ""));

            } else {
                if (mCauhoi.getsHTML_A() != null && mCauhoi.getsHTML_A().length() > 0)
                    mLis.add(new DapAn("A", mCauhoi.getsHTML_A(), "", mCauhoi.getsANSWER(), false, ""));
                if (mCauhoi.getsHTML_B() != null && mCauhoi.getsHTML_B().length() > 0)
                    mLis.add(new DapAn("B", mCauhoi.getsHTML_B(), "", mCauhoi.getsANSWER(), false, ""));
                if (mCauhoi.getsHTML_C() != null && mCauhoi.getsHTML_C().length() > 0)
                    mLis.add(new DapAn("C", mCauhoi.getsHTML_C(), "", mCauhoi.getsANSWER(), false, ""));
                if (mCauhoi.getsHTML_D() != null && mCauhoi.getsHTML_D().length() > 0)
                    mLis.add(new DapAn("D", mCauhoi.getsHTML_D(), "", mCauhoi.getsANSWER(), false, ""));
            }
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
