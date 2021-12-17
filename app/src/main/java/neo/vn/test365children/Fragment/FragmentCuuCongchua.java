package neo.vn.test365children.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Adapter.AdapterCongchua;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.Cauhoi;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.Models.MessageEvent;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.SharedPrefs;


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
public class FragmentCuuCongchua extends BaseFragment {
    private static final String TAG = "FragmentCauhoi";
    private Cauhoi mCauhoi;
    List<Integer> iStart;
    int iCauhoiStart = 0;
    @BindView(R.id.img_done)
    ImageView img_done;
    @BindView(R.id.txt_lable)
    TextView txt_lable;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;

    public static FragmentCuuCongchua newInstance(Cauhoi restaurant) {
        FragmentCuuCongchua restaurantDetailFragment = new FragmentCuuCongchua();
        Bundle args = new Bundle();
        //args.putSerializable("cauhoi",restaurant);
        args.putParcelable("cauhoi", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iStart = new ArrayList<>();
        mCauhoi = Parcels.unwrap(getArguments().getParcelable("cauhoi"));
      /*  for (int i = 0; i < App.mLisCauhoi.size(); i++) {
            Cauhoi obj = App.mLisCauhoi.get(i);
            if (obj.getsKIEU().equals("10")) {
                mCauhoi = obj;
            }
        }*/

        // mCauhoi = Parcels.unwrap(getArguments().getParcelable("cauhoi"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_congchua, container, false);
        ButterKnife.bind(this, view);
        Glide.with(getContext()).load(R.drawable.done).into(img_done);
        //   Log.i(TAG, "onCreateView: " + mCauhoi.getsQUESTION());
        //     initData();
        init();
        initData();
        return view;
    }

    private void initData() {
        try {
            txt_lable.setText("Bài " + mCauhoi.getmNumber() + ": " + mCauhoi.getsHUONGDAN());
            Glide.with(this).load(R.drawable.bg_congchua).into(img_background);
            // txtSubNumber.setText("Câu hỏi: "+mCauhoi.getsSubNumberCau());
            //txtCauhoi.setText(mCauhoi.getsQUESTION());
            iStart.add(2);
            mLis.add(new DapAn("0", "", "", "0", false, ""));
            mLis.add(new DapAn("1", "", "", "0", false, ""));
            mLis.add(new DapAn("2", "", "", "1", true, ""));
            mLis.add(new DapAn("3", "", "", "0", false, ""));
            mLis.add(new DapAn("4", "", "", "0", false, ""));
            mLis.add(new DapAn("5", "", "", "0", false, ""));
            mLis.add(new DapAn("6", "", "", "0", false, ""));
            mLis.add(new DapAn("7", "", "", "0", false, ""));
            mLis.add(new DapAn("8", "", "", "0", false, ""));
            mLis.add(new DapAn("9", "", "", "0", false, ""));
            mLis.add(new DapAn("10", "", "", "0", false, ""));
            mLis.add(new DapAn("11", "", "", "0", false, ""));
            if (mCauhoi.isDalam()) {
                if (mCauhoi.isEndGame()) {
                    if (mCauhoi.isResul_chil()) {
                        txt_lable.setText("Chúc mừng công chúa đã được giải cứu");
                        img_done.setVisibility(View.VISIBLE);
                        Glide.with(getContext()).load(R.drawable.done).into(img_done);
                        recycle_dapan.setVisibility(View.GONE);
                    } else {
                        txt_lable.setText("Giải cứu công chúa thất bại");
                        Glide.with(getContext()).load(R.drawable.icon_congchua_lost)
                                .placeholder(R.drawable.icon_congchua_lost).into(img_done);
                        img_done.setVisibility(View.VISIBLE);
                        recycle_dapan.setVisibility(View.GONE);
                    }
                } else {
                    iCauhoiStart = mCauhoi.getiCount_Princess();
                    for (int i = 0; i < mCauhoi.getiCount_Princess(); i++) {
                        iStart.add(getRandom(iStart));
                    }
                    for (int j = 0; j < mLis.size(); j++) {
                        for (int k = 0; k < iStart.size(); k++) {
                            if (Integer.parseInt(mLis.get(j).getsName()) == iStart.get(k)) {
                                mLis.get(j).setsDapan_Dung("1");
                                mLis.get(j).setClick(true);
                            } else {
                                mLis.get(j).setClick(false);
                            }
                        }
                    }
                }

            }
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @BindView(R.id.recycle_dapan)
    RecyclerView recycle_dapan;
    RecyclerView.LayoutManager mLayoutManager;
    List<DapAn> mLis;
    AdapterCongchua adapter;

    private void init() {
        mLis = new ArrayList<>();
        adapter = new AdapterCongchua(mLis, getContext());
        mLayoutManager = new GridLayoutManager(getContext(),
                4, GridLayoutManager.VERTICAL, false);
        recycle_dapan.setHasFixedSize(true);
        recycle_dapan.setLayoutManager(mLayoutManager);
        recycle_dapan.setItemAnimator(new DefaultItemAnimator());
        recycle_dapan.setAdapter(adapter);

        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                DapAn obj1 = (DapAn) item;
                if (obj1.isClick()) {
                    Intent intent_schools = new Intent(getContext(), ActivityGiaiCuuCongChua.class);
                    CauhoiDetail obj = mCauhoi.getLisInfo().get(iCauhoiStart);
                    SharedPrefs.getInstance().put(Constants.KEY_SEND_TRALOI, false);
                    //  intent_schools.putExtra(Constants.KEY_SEND_CAUHOI_CONGCHUA, (Serializable) obj);
                    SharedPrefs.getInstance().put(Constants.KEY_SEND_CAUHOI_CONGCHUA, obj);
                    startActivityForResult(intent_schools, Constants.RequestCode.GET_CONGCHUA);
                }
            }
        });
    }

    private String sDapan = "";

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.GET_CONGCHUA:
                try {
                    boolean isTraloi = SharedPrefs.getInstance().get(Constants.KEY_SEND_TRALOI, Boolean.class);
                    sDapan = SharedPrefs.getInstance().get(Constants.KEY_SEND_CAUHOI_CONGCHUA, String.class);
                    if (isTraloi) {
                   /* EventBus.getDefault().post(new MessageEvent("Point_true",
                            Float.parseFloat(mCauhoi.getLisInfo().get(iCauhoiStart).getsPOINT()), 0));*/
                        iCauhoiStart++;
                        if (iCauhoiStart < mCauhoi.getLisInfo().size()) {
                            EventBus.getDefault().post(new MessageEvent("pr_win1",
                                    Float.parseFloat(mCauhoi.getLisInfo().get(iCauhoiStart).getsPOINT()), 0));
                            img_done.setVisibility(View.GONE);
                            int value = getRandom(iStart);
                            iStart.add(value);
                            for (DapAn obj : mLis) {
                                if (Integer.parseInt(obj.getsName()) == value) {
                                    for (int i : iStart) {
                                        if (obj.getsName().equals("" + i))
                                            obj.setsDapan_Dung("1");
                                    }
                                    obj.setClick(true);
                                } else obj.setClick(false);
                            }
                            for (int i = 0; i < App.mLisCauhoi.size(); i++) {
                                Cauhoi obj = App.mLisCauhoi.get(i);
                                if (obj.getsID().equals(mCauhoi.getsID())) {
                                    App.mLisCauhoi.get(i).setiCount_Princess(iCauhoiStart);
                                    App.mLisCauhoi.get(i).setDalam(true);
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setAnserTrue(true);
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setDalam(true);
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setsRESULT_CHILD("1");
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setsANSWER_CHILD(sDapan);
                                }
                            }
                            EventBus.getDefault().post(new MessageEvent(Constants.KEY_SAVE_LIST_EXER_PLAYING, 0, 0));
                            adapter.notifyDataSetChanged();
                        } else {
                            EventBus.getDefault().post(new MessageEvent("pr_win2",
                                    Float.parseFloat(mCauhoi.getLisInfo().get(iCauhoiStart - 1).getsPOINT()), 0));
                            txt_lable.setText("Chúc mừng công chúa đã được giải cứu");
                            img_done.setVisibility(View.VISIBLE);
                            recycle_dapan.setVisibility(View.GONE);
                            for (DapAn obj : mLis) {
                                obj.setClick(false);
                            }
                            adapter.notifyDataSetChanged();
                            for (int i = 0; i < App.mLisCauhoi.size(); i++) {
                                Cauhoi obj = App.mLisCauhoi.get(i);
                                if (obj.getsID().equals(mCauhoi.getsID())) {
                                    App.mLisCauhoi.get(i).setiCount_Princess(iCauhoiStart);
                                    App.mLisCauhoi.get(i).setDalam(true);
                                    App.mLisCauhoi.get(i).setResul_chil(true);
                                    App.mLisCauhoi.get(i).setEndGame(true);
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setAnserTrue(true);
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setDalam(true);
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setsRESULT_CHILD("1");
                                    App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setsANSWER_CHILD(sDapan);
                                }
                            }
                            EventBus.getDefault().post(new MessageEvent(Constants.KEY_SAVE_LIST_EXER_PLAYING, 0, 0));
                        }
                    } else {
                        iCauhoiStart++;
                        for (DapAn obj : mLis) {
                            obj.setClick(false);
                        }
                        img_done.setVisibility(View.VISIBLE);
                        EventBus.getDefault().post(new MessageEvent("pr_lost", 0, 0));
                        txt_lable.setText("Giải cứu công chúa thất bại");
                        Glide.with(getContext()).load(R.drawable.icon_congchua_lost)
                                .placeholder(R.drawable.icon_congchua_lost).into(img_done);
                        recycle_dapan.setVisibility(View.GONE);
                        for (int i = 0; i < App.mLisCauhoi.size(); i++) {
                            Cauhoi obj = App.mLisCauhoi.get(i);
                            if (obj.getsID().equals(mCauhoi.getsID())) {
                                App.mLisCauhoi.get(i).setiCount_Princess(iCauhoiStart);
                                App.mLisCauhoi.get(i).setDalam(true);
                                App.mLisCauhoi.get(i).setResul_chil(false);
                                App.mLisCauhoi.get(i).setEndGame(true);
                                App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setAnserTrue(false);
                                App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setDalam(true);
                                App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setsRESULT_CHILD("0");
                                App.mLisCauhoi.get(i).getLisInfo().get(iCauhoiStart - 1).setsANSWER_CHILD(sDapan);
                          /*  App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe())-1).getLisInfo()
                                    .get(Integer.parseInt(mCauhoi.getsSubNumberCau())-1).setsANSWER_CHILD(obj.getsContent());*/
                            }
                        }
                        EventBus.getDefault().post(new MessageEvent(Constants.KEY_SAVE_LIST_EXER_PLAYING, 0, 0));
                        adapter.notifyDataSetChanged();
                        //  EventBus.getDefault().post(new MessageEvent("Point_false", 0, 0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public int getRandom(List<Integer> start) {
        int value = 1;
        do {
            Random rand = new Random();
            value = rand.nextInt(9);
        } while (get_door(value, start));
        return value;
    }

    public boolean get_door(int value, List<Integer> start) {
        for (int i = 0; i < start.size(); i++) {
            if (start.get(i) == value)
                return true;
        }
        return false;
    }
}
