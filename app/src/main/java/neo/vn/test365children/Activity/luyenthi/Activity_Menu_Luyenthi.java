package neo.vn.test365children.Activity.luyenthi;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.Adapter.AdapterMenuLuyenthi;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.GoiBaitap;
import neo.vn.test365children.Models.InfoListLuyenthi;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.respon_api.ResponGetListLuyenthi;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 09:52
 * Version: 1.0
 */
public class Activity_Menu_Luyenthi extends BaseActivity implements InterfaceLuyenthi.View {
    List<GoiBaitap> mListMath;
    AdapterMenuLuyenthi adapterMath;
    RecyclerView.LayoutManager mLayoutManagerMath;
    @BindView(R.id.rcv_list_math_luyenthi)
    RecyclerView rcv_list_math_luyenthi;

    List<GoiBaitap> mListLiterature;
    AdapterMenuLuyenthi adapterLiterature;
    RecyclerView.LayoutManager mLayoutManagerLiterature;
    @BindView(R.id.rcv_list_literature_luyenthi)
    RecyclerView rcv_list_literature_luyenthi;

    List<GoiBaitap> mListEng;
    AdapterMenuLuyenthi adapterEng;
    RecyclerView.LayoutManager mLayoutManagerEng;
    @BindView(R.id.rcv_list_english_luyenthi)
    RecyclerView rcv_list_english_luyenthi;
    @BindView(R.id.img_background)
    ImageView img_background;    @BindView(R.id.btn_back)
    ImageView btn_back;
    PresenterLuyenthi mPresenter;
    String sUserMe, sUserKid;

    @Override
    public int setContentViewId() {
        return R.layout.activity_menu_luyenthi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterLuyenthi(this);
        Glide.with(this).load(R.drawable.bg_nghe_nhin).into(img_background);
        initMath();
        initLiterature();
        initEnglish();
        initData();
        initEvent();
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        showDialogLoading();
        sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserKid = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        mPresenter.api_get_list_luyenthi(sUserMe, sUserKid);
    }

    private void initMath() {
        mListMath = new ArrayList<>();
        adapterMath = new AdapterMenuLuyenthi(mListMath, this);
        mLayoutManagerMath = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        rcv_list_math_luyenthi.setHasFixedSize(true);
        rcv_list_math_luyenthi.setLayoutManager(mLayoutManagerMath);
        rcv_list_math_luyenthi.setItemAnimator(new DefaultItemAnimator());
        rcv_list_math_luyenthi.setAdapter(adapterMath);
        adapterMath.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(Activity_Menu_Luyenthi.this);
                GoiBaitap obj = (GoiBaitap) item;
                if (obj.getACTIVE_STATE() != null && obj.getACTIVE_STATE().equals("1")) {
                    Intent intent = new Intent(Activity_Menu_Luyenthi.this, ActivityListBaitapLuyenthi.class);
                    intent.putExtra(Constants.KEY_SEND_GOI_LUYENTHI, obj);
                    startActivityForResult(intent, Constants.RequestCode.START_ACTIVE_LUYENTHI);
                }else {
                    Intent intent = new Intent(Activity_Menu_Luyenthi.this, ActivityActiveLuyenthi.class);
                    intent.putExtra(Constants.KEY_SEND_GOI_LUYENTHI, obj);
                    startActivityForResult(intent, Constants.RequestCode.START_ACTIVE_LUYENTHI);
                }

            }
        });
    }

    private void initLiterature() {
        mListLiterature = new ArrayList<>();
        adapterLiterature = new AdapterMenuLuyenthi(mListLiterature, this);
        mLayoutManagerLiterature = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        rcv_list_literature_luyenthi.setHasFixedSize(true);
        rcv_list_literature_luyenthi.setLayoutManager(mLayoutManagerLiterature);
        rcv_list_literature_luyenthi.setItemAnimator(new DefaultItemAnimator());
        rcv_list_literature_luyenthi.setAdapter(adapterLiterature);
        adapterLiterature.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(Activity_Menu_Luyenthi.this);
                GoiBaitap obj = (GoiBaitap) item;
                if (obj.getACTIVE_STATE() != null && obj.getACTIVE_STATE().equals("1")) {
                    Intent intent = new Intent(Activity_Menu_Luyenthi.this, ActivityListBaitapLuyenthi.class);
                    intent.putExtra(Constants.KEY_SEND_GOI_LUYENTHI, obj);
                    startActivityForResult(intent, Constants.RequestCode.START_ACTIVE_LUYENTHI);
                }else {
                    Intent intent = new Intent(Activity_Menu_Luyenthi.this, ActivityActiveLuyenthi.class);
                    intent.putExtra(Constants.KEY_SEND_GOI_LUYENTHI, obj);
                    startActivityForResult(intent, Constants.RequestCode.START_ACTIVE_LUYENTHI);
                }
            }
        });
    }

    private void initEnglish() {
        mListEng = new ArrayList<>();
        adapterEng = new AdapterMenuLuyenthi(mListEng, this);
        mLayoutManagerEng = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        rcv_list_english_luyenthi.setHasFixedSize(true);
        rcv_list_english_luyenthi.setLayoutManager(mLayoutManagerEng);
        rcv_list_english_luyenthi.setItemAnimator(new DefaultItemAnimator());
        rcv_list_english_luyenthi.setAdapter(adapterEng);
        adapterEng.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(Activity_Menu_Luyenthi.this);
                GoiBaitap obj = (GoiBaitap) item;
                if (obj.getACTIVE_STATE() != null && obj.getACTIVE_STATE().equals("1")) {
                    Intent intent = new Intent(Activity_Menu_Luyenthi.this, ActivityListBaitapLuyenthi.class);
                    intent.putExtra(Constants.KEY_SEND_GOI_LUYENTHI, obj);
                    startActivityForResult(intent, Constants.RequestCode.START_ACTIVE_LUYENTHI);
                }else {
                    Intent intent = new Intent(Activity_Menu_Luyenthi.this, ActivityActiveLuyenthi.class);
                    intent.putExtra(Constants.KEY_SEND_GOI_LUYENTHI, obj);
                    startActivityForResult(intent, Constants.RequestCode.START_ACTIVE_LUYENTHI);
                }
            }
        });
    }

    @Override
    public void api_show_list_luyenthi(ResponGetListLuyenthi objRest) {
        hideDialogLoading();
        if (objRest != null && objRest.getError().equals("0000")) {
            mListEng.clear();
            mListMath.clear();
            mListLiterature.clear();
            InfoListLuyenthi objInfoList = objRest.getInfo();
            if (objInfoList.getListENGLISH() != null)
                mListEng.addAll(objInfoList.getListENGLISH());
            if (objInfoList.getListMATHS() != null)
                mListMath.addAll(objInfoList.getListMATHS());
            if (objInfoList.getListVIETNAMESE() != null)
                mListLiterature.addAll(objInfoList.getListVIETNAMESE());
        }
        adapterEng.notifyDataSetChanged();
        adapterLiterature.notifyDataSetChanged();
        adapterMath.notifyDataSetChanged();
    }

    @Override
    public void api_show_list_detail(ResponDetailExer objRest) {

    }

    @Override
    public void api_show_active(ErrorApi objError) {
        hideDialogLoading();
    }

    @Override
    public void api_show_error() {
        hideDialogLoading();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.START_ACTIVE_LUYENTHI:
                if (resultCode == RESULT_OK) {
                    initData();
                }
                break;
        }
    }

}
