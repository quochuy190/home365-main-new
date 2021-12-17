package neo.vn.test365children.Fragment;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Adapter.AdapterSapxep;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.OnStartDragListener;
import neo.vn.test365children.Listener.RecyclerViewItemClickInterface;
import neo.vn.test365children.Listener.RecyclerViewItemTouchHelperCallback;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.Models.MessageEvent;
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
public class FragmentSapxep extends BaseFragment implements
        OnStartDragListener, RecyclerViewItemClickInterface {
    private static final String TAG = "FragmentSapxep";
    private CauhoiDetail mCauhoi;
    @BindView(R.id.txt_lable)
    TextView txt_lable;
    @BindView(R.id.txt_cauhoi)
    TextView txt_cauhoi;
    @BindView(R.id.txt_title_dapan)
    TextView txt_title_dapan;
    @BindView(R.id.txt_title_traloi)
    TextView txt_title_traloi;
    @BindView(R.id.recycle_dapan)
    RecyclerView recycle_dapan;
    @BindView(R.id.recycle_ketqua)
    RecyclerView recycle_ketqua;
    RecyclerView.LayoutManager mLayoutManager;
    List<DapAn> mLis;
    List<DapAn> mLisStart;
    @BindView(R.id.btn_xemdiem)
    Button btn_xemdiem;
    private ItemTouchHelper mItemTouchHelper;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;

    public static FragmentSapxep newInstance(CauhoiDetail restaurant) {
        FragmentSapxep restaurantDetailFragment = new FragmentSapxep();
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
        View view = inflater.inflate(R.layout.fragment_sapxep, container, false);
        ButterKnife.bind(this, view);
        mLisStart = new ArrayList<>();
        initData();
        if (mCauhoi.isDalam()) {
            isClickXemdiem = true;
            btn_xemdiem.setBackground(getResources().getDrawable(R.drawable.btn_gray_black));
            initViews(false);
            img_anwser_chil.setVisibility(View.VISIBLE);
            if (mCauhoi.isAnserTrue()) {
                Glide.with(getContext()).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
                recycle_ketqua.setVisibility(View.GONE);
            } else {
                txt_title_traloi.setVisibility(View.VISIBLE);
                txt_title_dapan.setVisibility(View.VISIBLE);
                Glide.with(getContext()).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
                recycle_ketqua.setVisibility(View.VISIBLE);
                initDapan();
            }
        } else {
            initViews(true);
        }
        initEvent();
        return view;
    }

    private boolean isClickXemdiem = false;

    private void initEvent() {
        btn_xemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] string_start = new String[mLisStart.size()];
                String[] string_sapxep = new String[adapterSapxep.getList().size()];
                for (int i = 0; i < mLisStart.size(); i++) {
                    string_start[i] = mLisStart.get(i).getsContent();
                }
                for (int i = 0; i < adapterSapxep.getList().size(); i++) {
                    string_sapxep[i] = adapterSapxep.getList().get(i).getsContent();
                }
                boolean isa = Arrays.equals(string_start, string_sapxep);
                if (!isClickXemdiem) {
                    img_anwser_chil.setVisibility(View.VISIBLE);
                    if (isa) {
                        Glide.with(getContext()).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
                        EventBus.getDefault().post(new MessageEvent("Point_true",
                                Float.parseFloat(mCauhoi.getsPOINT()), 0));
                        recycle_ketqua.setVisibility(View.GONE);
                    }
                    //  EventBus.getDefault().post(new MessageEvent("Dung", Float.parseFloat(mCauhoi.getsPOINT()), 0));
                    else {
                        txt_title_traloi.setVisibility(View.VISIBLE);
                        txt_title_dapan.setVisibility(View.VISIBLE);
                        Glide.with(getContext()).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
                        recycle_ketqua.setVisibility(View.VISIBLE);
                        EventBus.getDefault().post(new MessageEvent("Point_false", 0, 0));
                        initDapan();
                    }
                    isClickXemdiem = true;
                    for (DapAn obj : mLis) {
                        obj.setClick(true);
                    }
                    initViews(false);
                    adapterSapxep.notifyDataSetChanged();
                }
                save_anwser_chil();
                EventBus.getDefault().post(new MessageEvent(Constants.KEY_SAVE_LIST_EXER_PLAYING, 0, 0));
            }
        });
    }

    int[] arrBgItem = new int[]{R.drawable.img_menu_toan, R.drawable.img_menu_blue, R.drawable.img_menu_tim,
            R.drawable.img_menu_green, R.drawable.img_menu_red,};
    List<String> mLiDapan;
    List<String> mLiDapan_chil;

    private void initData() {
        try {
            if (mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null)
                txt_lable.setText(Html.fromHtml("Bài " + mCauhoi.getsNumberDe() + "_Câu "
                        + mCauhoi.getsSubNumberCau() + ": " + mCauhoi.getsCauhoi_huongdan())
                        + " (" + Float.parseFloat(mCauhoi.getsPOINT()) + " đ)");
            Glide.with(this).load(R.drawable.bg_nghe_nhin).into(img_background);
            Log.i(TAG, "initData: " + mCauhoi.getsHTML_CONTENT());
            // String[] debai = mCauhoi.getsQUESTION().split("<br /><br>");
            if (mCauhoi.getsHTML_CONTENT() != null)
                txt_cauhoi.setText("Đáp án: " + mCauhoi.getsHTML_CONTENT().replace("::", " "));

            txt_cauhoi.setVisibility(View.INVISIBLE);
            mLis = new ArrayList<>();
            if (mCauhoi.getsHTML_CONTENT() != null) {
                String[] dapan = mCauhoi.getsHTML_CONTENT().split("::");
                mLiDapan = new ArrayList<String>(Arrays.asList(dapan));
            }
            if (mCauhoi.getsANSWER_CHILD() != null) {
                String[] dapan_chil = mCauhoi.getsANSWER_CHILD().split("::");
                mLiDapan_chil = new ArrayList<String>(Arrays.asList(dapan_chil));
            }
            if (mLiDapan != null && mLiDapan.size() > 0) {
                for (int i = 0; i < mLiDapan.size(); i++) {
                    String s = mLiDapan.get(i);
                    mLisStart.add(new DapAn("1", s, "",
                            "agcbd", false, "" + i));
                    if (!mCauhoi.isDalam()) {
                        mLis.add(new DapAn("1", s, "",
                                "agcbd", false, "" + i));
                    }

                }
                if (!mCauhoi.isDalam()) {
                    Collections.shuffle(mLis);
                }
            }
            if (mCauhoi.isDalam() && mLiDapan_chil != null && mLiDapan_chil.size() > 0) {
                for (int i = 0; i < mLiDapan_chil.size(); i++) {
                    String s = mLiDapan_chil.get(i);
                    mLis.add(new DapAn("1", s, "",
                            "agcbd", false, "" + i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    AdapterSapxep adapterSapxep;
    AdapterSapxep adapterSapxep_ketqua;

    private void initViews(boolean ischange) {
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
  /*      mLayoutManager = new GridLayoutManager(getContext(),
                6, GridLayoutManager.VERTICAL, false);*/
        recycle_dapan.setLayoutManager(linearLayoutManager);
        adapterSapxep = new AdapterSapxep(getContext(), mLis, this);
        ItemTouchHelper.Callback callback =
                new RecyclerViewItemTouchHelperCallback(adapterSapxep, ischange);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recycle_dapan);
        adapterSapxep.delegate = this;
        recycle_dapan.setAdapter(adapterSapxep);
    }

    private void initDapan() {
        LinearLayoutManager linearLayoutManager2
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
       /* linearLayoutManager2 = new GridLayoutManager(getContext(),
                6, GridLayoutManager.VERTICAL, false);*/
        recycle_ketqua.setLayoutManager(linearLayoutManager2);
        // setData();
        adapterSapxep_ketqua = new AdapterSapxep(getContext(), mLisStart, this);
    /*    ItemTouchHelper.Callback callback_ketqua =
                new RecyclerViewItemTouchHelperCallback(adapterSapxep_ketqua, false);
        mItemTouchHelper = new ItemTouchHelper(callback_ketqua);
        mItemTouchHelper.attachToRecyclerView(recycle_ketqua);
        adapterSapxep_ketqua.delegate = this;*/
        recycle_ketqua.setAdapter(adapterSapxep_ketqua);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        if (mItemTouchHelper != null)
            mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void onEndDrag() {
        save_anwser_chil();
    }

    private void save_anwser_chil() {
        try {
            App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                    .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setDalam(true);
            String answer_chil = "";
            for (int i = 0; i < mLis.size(); i++) {
                if (i < mLis.size() - 1)
                    answer_chil = answer_chil + mLis.get(i).getsContent() + "::";
                else answer_chil = answer_chil + mLis.get(i).getsContent();
            }
            String dapan = "";
            for (int i = 0; i < mLisStart.size(); i++) {
                if (i < mLisStart.size() - 1)
                    dapan = dapan + mLisStart.get(i).getsContent() + "::";
                else dapan = dapan + mLisStart.get(i).getsContent();
            }
            dapan.trim();
            answer_chil.trim();
            if (dapan.equals(answer_chil)) {
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
                    .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).setsANSWER_CHILD(answer_chil);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onItemClicked(String name) {

    }
}
