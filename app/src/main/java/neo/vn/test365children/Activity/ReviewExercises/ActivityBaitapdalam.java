package neo.vn.test365children.Activity.ReviewExercises;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.Adapter.AdapterObjBaitapTuan;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.setOnItemClickListener;
import neo.vn.test365children.Models.DETAILSItem;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ExerciseAnswer;
import neo.vn.test365children.Models.HomeworkDone;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.ResponDetailTakenExercise;
import neo.vn.test365children.Models.ResponseObjWeek;
import neo.vn.test365children.Models.TuanDamua;
import neo.vn.test365children.Presenter.ImpBaitap;
import neo.vn.test365children.Presenter.PresenterBaitap;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityBaitapdalam extends BaseActivity implements ImpBaitap.View {
    private static final String TAG = "ActivityBaitapdalam";
//    Realm mRealm;
    AdapterObjBaitapTuan adapter;
    AdapterObjBaitapTuan adapter_TV;
    AdapterObjBaitapTuan adapter_TA;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.LayoutManager mLayoutManagerTV;
    RecyclerView.LayoutManager mLayoutManagerTA;
    List<DETAILSItem> mLisTToan;
    List<DETAILSItem> mLisTV;
    List<DETAILSItem> mLisTAnh;
//    List<ExerciseAnswer> lisExercise;
    @BindView(R.id.recycle_toan)
    RecyclerView recycle_toan;
    @BindView(R.id.recycle_tv)
    RecyclerView recycle_tv;
    @BindView(R.id.recycle_tienganh)
    RecyclerView recycle_tienganh;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.txt_montoan)
    TextView txt_montoan;
    @BindView(R.id.rl_title_tv)
    RelativeLayout rl_title_tv;
    @BindView(R.id.rl_title_tienganh)
    RelativeLayout rl_title_tienganh;

    private PresenterBaitap mPresenterBaitap;

    @Override
    public int setContentViewId() {
        return R.layout.activity_ketqualambai;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenterBaitap = new PresenterBaitap(this);
//        mRealm = RealmController.with(this).getRealm();
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityBaitapdalam.this);
                finish();
            }
        });
        initData();
        init();

    }

    String sUserCon, sUserMother;

    private void initData() {
        sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        mLisTToan = new ArrayList<>();
        mLisTV = new ArrayList<>();
        mLisTAnh = new ArrayList<>();
        Glide.with(this).load(R.drawable.bg_doc_hieu).into(imageView5);
        mPresenterBaitap.get_excercise_taken(sUserMother, sUserCon);
//        lisExercise = RealmController.getInstance().getExercises();
//        if (lisExercise != null)
//            Log.i(TAG, "initData: " + lisExercise.size());
//        List<ExerciseAnswer> lisEx = new ArrayList<>();
//        lisEx = mRealm.where(ExerciseAnswer.class).equalTo("sMonhoc", "1")
//                .equalTo("sId_userMe", sUserMother)
//                .equalTo("isTrangthailambai", "3")
//                .equalTo("sId_userCon", sUserCon).findAll();
//        List<ExerciseAnswer> lisEx2 = new ArrayList<>();
//        lisEx2 = mRealm.where(ExerciseAnswer.class).equalTo("sMonhoc", "1")
//                .equalTo("sId_userMe", sUserMother)
//                .equalTo("isTrangthailambai", "2")
//                .equalTo("sId_userCon", sUserCon).findAll();
//        List<ExerciseAnswer> lisExTV = new ArrayList<>();
//        lisExTV = mRealm.where(ExerciseAnswer.class).equalTo("sMonhoc", "2")
//                .equalTo("sId_userMe", sUserMother)
//                .equalTo("isTrangthailambai", "3")
//                .equalTo("sId_userCon", sUserCon).findAll();
//        List<ExerciseAnswer> lisExTV2 = new ArrayList<>();
//        lisExTV2 = mRealm.where(ExerciseAnswer.class).equalTo("sMonhoc", "2")
//                .equalTo("sId_userMe", sUserMother)
//                .equalTo("isTrangthailambai", "2")
//                .equalTo("sId_userCon", sUserCon).findAll();
//        List<ExerciseAnswer> lisExTA = new ArrayList<>();
//        lisExTA = mRealm.where(ExerciseAnswer.class).equalTo("sMonhoc", "3")
//                .equalTo("sId_userMe", sUserMother)
//                .equalTo("isTrangthailambai", "3")
//                .equalTo("sId_userCon", sUserCon).findAll();
//        List<ExerciseAnswer> lisExTA2 = new ArrayList<>();
//        lisExTA2 = mRealm.where(ExerciseAnswer.class).equalTo("sMonhoc", "3")
//                .equalTo("sId_userMe", sUserMother)
//                .equalTo("isTrangthailambai", "2")
//                .equalTo("sId_userCon", sUserCon).findAll();
//        Log.d("my_test", Arrays.toString(lisEx.toArray()));
//        if (lisEx.size() > 0) {
//            mLisTToan.addAll(lisEx);
//        }
//        if (lisEx2.size() > 0) {
//            mLisTToan.addAll(lisEx2);
//        }
//        if (lisExTV.size() > 0) {
//            mLisTV.addAll(lisExTV);
//        }
//        if (lisExTV2.size() > 0) {
//            mLisTV.addAll(lisExTV2);
//        }
//        if (lisExTA.size() > 0) {
//            mLisTAnh.addAll(lisExTA);
//        }
//        if (lisExTA2.size() > 0) {
//            mLisTAnh.addAll(lisExTA2);
//        }

//        if (mLisTToan.size() > 0) {
//            txt_montoan.setVisibility(View.VISIBLE);
//        } else {
//            txt_montoan.setVisibility(View.INVISIBLE);
//        }
//        if (mLisTV.size() > 0) {
//            rl_title_tv.setVisibility(View.VISIBLE);
//        } else {
//            rl_title_tv.setVisibility(View.GONE);
//        }
//        if (mLisTAnh.size() > 0) {
//            rl_title_tienganh.setVisibility(View.VISIBLE);
//        } else {
//            rl_title_tienganh.setVisibility(View.GONE);
//        }
        // Log.i(TAG, "initData: " + mLisTuan);
    }

    private void init() {
        adapter = new AdapterObjBaitapTuan(this);
        adapter_TV = new AdapterObjBaitapTuan(this);
        adapter_TA = new AdapterObjBaitapTuan(this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLayoutManagerTV = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLayoutManagerTA = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //recycle_category.setNestedScrollingEnabled(false);
        recycle_toan.setHasFixedSize(true);
        recycle_toan.setLayoutManager(mLayoutManager);
        recycle_toan.setItemAnimator(new DefaultItemAnimator());
        recycle_toan.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        recycle_tv.setHasFixedSize(true);
        recycle_tv.setLayoutManager(mLayoutManagerTV);
        recycle_tv.setItemAnimator(new DefaultItemAnimator());
        recycle_tv.setAdapter(adapter_TV);
        adapter_TV.notifyDataSetChanged();

        recycle_tienganh.setHasFixedSize(true);
        recycle_tienganh.setLayoutManager(mLayoutManagerTA);
        recycle_tienganh.setItemAnimator(new DefaultItemAnimator());
        recycle_tienganh.setAdapter(adapter_TA);
        adapter_TA.notifyDataSetChanged();

        adapter.setOnIListener(new setOnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                KeyboardUtil.play_click_button(ActivityBaitapdalam.this);
                Intent intent = new Intent(ActivityBaitapdalam.this, ActivityExercisesDetail.class);
                intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL, mLisTToan.get(position).getEXERCISEID()+"");
//                intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL_STATUS, mLisTToan.get(position).getIsTrangthailambai());
//                set_obj_realm(mLisTToan.get(position));
//                App.mLisCauhoi.addAll(mLisTToan.get(position).getmLisCauhoi());
                startActivity(intent);
            }

            @Override
            public void OnLongItemClickListener(int position) {

            }
        });
        adapter_TV.setOnIListener(new setOnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                KeyboardUtil.play_click_button(ActivityBaitapdalam.this);
                Intent intent = new Intent(ActivityBaitapdalam.this, ActivityExercisesDetail.class);
                intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL, mLisTV.get(position).getEXERCISEID()+"");
//                intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL_STATUS, mLisTV.get(position).getIsTrangthailambai());
//                set_obj_realm(mLisTV.get(position));
//                App.mLisCauhoi.addAll(mLisTV.get(position).getmLisCauhoi());
                startActivity(intent);
            }

            @Override
            public void OnLongItemClickListener(int position) {

            }
        });
        adapter_TA.setOnIListener(new setOnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                KeyboardUtil.play_click_button(ActivityBaitapdalam.this);
                Intent intent = new Intent(ActivityBaitapdalam.this, ActivityExercisesDetail.class);
                intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL, mLisTAnh.get(position).getEXERCISEID()+"");
//                intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL_STATUS, mLisTAnh.get(position).getIsTrangthailambai());
//                //intent.putExtra(Constants.KEY_SEND_EXERCISES_DETAIL_CONTENT, mLisTAnh.get(position).getsDetailExercise());
//                set_obj_realm(mLisTAnh.get(position));
//                App.mLisCauhoi.addAll(mLisTAnh.get(position).getmLisCauhoi());
                startActivity(intent);
            }

            @Override
            public void OnLongItemClickListener(int position) {

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
    public void show_list_list_buy(List<TuanDamua> mLis) {

    }

    @Override
    public void show_list_get_part(ResponDetailExer objDetailExer) {

    }

    @Override
    public void show_error_api(List<ErrorApi> mLis) {

    }

    @Override
    public void show_get_excercise_needed(ResponseObjWeek objResponWeek) {

    }

    @Override
    public void show_get_excercise_expired(ResponseObjWeek objResponWeek) {

    }

    @Override
    public void show_start_taken(ErrorApi mLis) {

    }

    @Override
    public void show_submit_execercise(ErrorApi mLis) {

    }

    @Override
    public void show_detail_taken(ResponDetailTakenExercise obj) {

    }

    @Override
    public void showHomeworkDone(HomeworkDone homeworkDone) {
        Log.d("my_test", homeworkDone.toString());
        if (homeworkDone.getERROR().equals("0000")){
            for (DETAILSItem item: homeworkDone.getDETAILS()){
                switch (item.getSUBJECTID()){
                    case 1:
                        mLisTToan.add(item);
                        break;
                    case 2:
                        mLisTV.add(item);
                        break;
                    case 3:
                        mLisTAnh.add(item);
                        break;
                }
            }
            adapter.setData(mLisTToan);
            adapter_TV.setData(mLisTV);
            adapter_TA.setData(mLisTAnh);
        }
    }
}
