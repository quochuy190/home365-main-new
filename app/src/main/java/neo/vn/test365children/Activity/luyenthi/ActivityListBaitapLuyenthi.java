package neo.vn.test365children.Activity.luyenthi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import neo.vn.test365children.Activity.ActivityStartBaitap;
import neo.vn.test365children.Activity.ReviewExercises.ActivityReviewExercises;
import neo.vn.test365children.Adapter.AdapterListExerLuyentap;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.DetailExercise;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ExerciseAnswer;
import neo.vn.test365children.Models.GoiBaitap;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.respon_api.ResponGetListLuyenthi;
import neo.vn.test365children.R;
import neo.vn.test365children.RealmController.RealmController;
import neo.vn.test365children.Untils.SharedPrefs;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 16:56
 * Version: 1.0
 */
public class ActivityListBaitapLuyenthi extends BaseActivity implements InterfaceLuyenthi.View {
    GoiBaitap mObjGoiLT;
    PresenterLuyenthi mPresenter;
    @BindView(R.id.rcv_list_baitap)
    RecyclerView rcv_list_baitap;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.btn_home)
    ImageView btn_home;
    @BindView(R.id.img_background)
    ImageView img_background;
    List<ExerciseAnswer> lisEx;
    Realm mRealm;

    @Override
    public int setContentViewId() {
        return R.layout.activity_listbaitap_luyenthi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterLuyenthi(this);
        mRealm = RealmController.with(this).getRealm();
        Glide.with(this).load(R.drawable.bg_nghe_nhin).into(img_background);
        lisEx = new ArrayList<>();
        initData();
        init_Listbaitap();
        initEvent();
    }

    private void initEvent() {
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        String sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        String sUserKid = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        mObjGoiLT = (GoiBaitap) getIntent().getSerializableExtra(Constants.KEY_SEND_GOI_LUYENTHI);
        showDialogLoading();
        mPresenter.api_get_list_luyenthi_detail(sUserMother, sUserKid, mObjGoiLT.getID(), mObjGoiLT.getEXCERCISE_LIST());
        lisEx = mRealm.where(ExerciseAnswer.class)
                //.equalTo("sMonhoc", "1")
                .equalTo("sId_userMe", sUserMother)
                .equalTo("sId_userCon", sUserKid)
                .findAll();
    }

    AdapterListExerLuyentap adapter;
    List<DetailExercise> listExer;
    RecyclerView.LayoutManager mLayoutManager;

    private void init_Listbaitap() {
        listExer = new ArrayList<>();
        adapter = new AdapterListExerLuyentap(listExer, this);
        mLayoutManager = new GridLayoutManager(this, 5);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        rcv_list_baitap.setHasFixedSize(true);
        rcv_list_baitap.setLayoutManager(mLayoutManager);
        rcv_list_baitap.setItemAnimator(new DefaultItemAnimator());
        rcv_list_baitap.setAdapter(adapter);

        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(final int position, Object item) {
                final DetailExercise obj = (DetailExercise) item;
                if (obj.isDalam()) {
                    showDialogComfirm_two_button("Thông báo",
                            "Bài tập này đã được làm, bạn muốn xem lại bài tập hay làm lại bài tập này",
                            false, new ClickDialog() {
                                @Override
                                public void onClickYesDialog() {
                                    // Xem lại
                                    for (ExerciseAnswer objExer : lisEx) {
                                        if (obj.getEXCERCISE_ID().equals(objExer.getsId_exercise())) {
                                            Intent intent = new Intent(ActivityListBaitapLuyenthi.this,
                                                    ActivityReviewExercises.class);
                                            intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL, objExer.getsId_exercise());
                                            intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL_STATUS, "3");
                                            set_obj_realm(objExer);
                                            App.mLisCauhoi.clear();
                                            App.mLisCauhoi.addAll(objExer.getmLisCauhoi());
                                            startActivity(intent);
                                        }
                                    }
                                }

                                @Override
                                public void onClickNoDialog() {
                                    //Làm lại
                                    Intent intent = new Intent(ActivityListBaitapLuyenthi.this, ActivityStartBaitap.class);
                                    intent.putExtra(Constants.KEY_SEND_IS_START_EXER_LUYENTHI, true);
                                    obj.setEXCERCISE_ID_LUYENTAP(mObjGoiLT.getEXCERCISE_LIST());
                                    obj.setsSUBJECT_NAME(mObjGoiLT.getSUBJECT_NAME());
                                    obj.setsSUBJECT_ID(mObjGoiLT.getSUBJECT_ID());
                                    obj.setsNAME(mObjGoiLT.getNAME());
                                    obj.setsLEVEL_NAME(mObjGoiLT.getLEVEL_NAME());
                                    obj.setsLEVEL_ID(mObjGoiLT.getLEVEL_ID());
                                    App.mExerLuyentap = obj;
                                    startActivityForResult(intent, Constants.RequestCode.GET_START_LAMBAI);
                                }
                            }, "Xem lại", "Làm lại bài");
                } else {
                    Intent intent = new Intent(ActivityListBaitapLuyenthi.this, ActivityStartBaitap.class);
                    intent.putExtra(Constants.KEY_SEND_IS_START_EXER_LUYENTHI, true);
                    obj.setEXCERCISE_ID_LUYENTAP(mObjGoiLT.getEXCERCISE_LIST());
                    obj.setsSUBJECT_NAME(mObjGoiLT.getSUBJECT_NAME());
                    obj.setsSUBJECT_ID(mObjGoiLT.getSUBJECT_ID());
                    obj.setsNAME(mObjGoiLT.getNAME());
                    obj.setsLEVEL_NAME(mObjGoiLT.getLEVEL_NAME());
                    obj.setsLEVEL_ID(mObjGoiLT.getLEVEL_ID());
                    App.mExerLuyentap = obj;
                    startActivityForResult(intent, Constants.RequestCode.GET_START_LAMBAI);
                }
            }
        });
    }

    private void set_obj_realm(ExerciseAnswer exerciseAnswer) {
        ExerciseAnswer obj = new ExerciseAnswer();
        obj.setsDetailExercise(exerciseAnswer.getsDetailExercise());
        obj.setIsTrangthailambai(exerciseAnswer.getIsTrangthailambai());
        obj.setsThoiluonglambai(exerciseAnswer.getsThoiluonglambai());
        obj.setsId_userMe(exerciseAnswer.getsId_userMe());
        obj.setsId_userCon(exerciseAnswer.getsId_userCon());
        obj.setsPoint(exerciseAnswer.getsPoint());
        obj.setsMonhoc(exerciseAnswer.getsMonhoc());
        obj.setmLisCauhoi(exerciseAnswer.getmLisCauhoi());
        obj.setsId_exercise(exerciseAnswer.getsId_exercise());
        obj.setsIdTuan(exerciseAnswer.getsIdTuan());
        obj.setsKieunopbai(exerciseAnswer.getsKieunopbai());
        obj.setsTimebatdaulambai(exerciseAnswer.getsTimebatdaulambai());
        obj.setsThoiluonglambai(exerciseAnswer.getsThoiluonglambai());
        obj.setsTimequydinh(exerciseAnswer.getsTimequydinh());
        obj.setsTimeketthuclambai(exerciseAnswer.getsTimeketthuclambai());
        obj.setsTrangthainopbai(exerciseAnswer.getsTrangthainopbai());
        App.mExerciseReview = obj;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.GET_START_LAMBAI:
                if (resultCode == RESULT_OK) {
                    initData();
                }
                break;
        }
    }

    @Override
    public void api_show_list_luyenthi(ResponGetListLuyenthi objRest) {

    }

    @Override
    public void api_show_list_detail(ResponDetailExer objRest) {
        hideDialogLoading();
        if (objRest.getsERROR().equals("0000")) {
            listExer.clear();
            if (objRest.getListExerLuyentap() != null) {
                listExer.addAll(objRest.getListExerLuyentap());
            }
            Collections.sort(listExer);
            if (lisEx.size() > 0) {
                for (DetailExercise obj : listExer) {
                    for (ExerciseAnswer objExer : lisEx) {
                        if (obj.getEXCERCISE_ID().equals(objExer.getsId_exercise())) {
                            if (objExer.getsPoint() != null) {
                                obj.setDalam(true);
                                obj.setsPOINT(objExer.getsPoint());
                                obj.setsTrangthailambai(objExer.getIsTrangthailambai());
                            }
                        }
                    }
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void api_show_active(ErrorApi objError) {

    }

    @Override
    public void api_show_error() {

    }
}
