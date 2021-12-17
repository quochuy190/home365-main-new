package neo.vn.test365children.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import neo.vn.test365children.Activity.ReviewExercises.ActivityBaitapdalam;
import neo.vn.test365children.Adapter.AdapterBaitapQuahan;
import neo.vn.test365children.Adapter.AdapterItemMenuLambaitap;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.Baitap_Tuan;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.HomeworkDone;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.ResponDetailTakenExercise;
import neo.vn.test365children.Models.ResponseObjWeek;
import neo.vn.test365children.Models.TuanDamua;
import neo.vn.test365children.Models.vip.ObjLoginVip;
import neo.vn.test365children.Presenter.ImlLogin;
import neo.vn.test365children.Presenter.ImpBaitap;
import neo.vn.test365children.Presenter.PresenterBaitap;
import neo.vn.test365children.Presenter.PresenterLogin;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityMenuBaitap extends BaseActivity implements ImpBaitap.View, ImlLogin.View {
    @BindView(R.id.recycle_menu_baitap)
    RecyclerView recycleBaitap;
    @BindView(R.id.recycle_baitap_tuan)
    RecyclerView recycle_baitap_tuan;
    RecyclerView.LayoutManager mLayoutManager;
    List<Baitap_Tuan> lisBaitap;
    List<Baitap_Tuan> lisBaitap_quanhan;
    AdapterBaitapQuahan adapter;
    AdapterItemMenuLambaitap adapter_baitaptuan;
    @BindView(R.id.img_mute)
    ImageView img_mute;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.txt_notify_need)
    TextView txt_notify_need;
    @BindView(R.id.txt_notify_quahan)
    TextView txt_notify_quahan;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.btn_baitapdalam)
    Button btn_baitapdalam;
    PresenterLogin mPresenterLogin;

    @Override
    public int setContentViewId() {
        return R.layout.activity_menu_lambaitap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterBaitap(this);
        mPresenterLogin = new PresenterLogin(this);
        Glide.with(this).load(R.drawable.background_baitaptuan).into(img_background);
        initbaitaptuan();
        init_baitap_quahan();
        initEvent();
        //  play_mp3();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp3 != null)
            mp3.pause();
    }

    private void initEvent() {
        btn_baitapdalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityMenuBaitap.this);
                startActivity(new Intent(ActivityMenuBaitap.this, ActivityBaitapdalam.class));
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityMenuBaitap.this);
                finish();
            }
        });
        img_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityMenuBaitap.this);
                finish();
            }
        });
    }

    PresenterBaitap mPresenter;
    String sUserMe = "", sUserCon = "", sMon, sPassWord = "";

    private void initData() {
        if (isNetwork()) {
            sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
            sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
            showDialogLoading();
            mPresenter.get_api_get_excercise_needed(sUserMe, sUserCon, get_current_time());
            if (sUserMe.equals(Constants.KEY_SAVE_USER_MOTHER_TRY)) {
                recycleBaitap.setVisibility(View.INVISIBLE);
                txt_notify_quahan.setVisibility(View.VISIBLE);
                txt_notify_quahan.setText("Con đã hoàn thành hết bài tập các tuần trước");
            } else
                mPresenter.get_api_get_excercise_expired(sUserMe, sUserCon);
        }
    }

    private void init_baitap_quahan() {
        lisBaitap_quanhan = new ArrayList<>();
        adapter = new AdapterBaitapQuahan(lisBaitap_quanhan, this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        recycleBaitap.setHasFixedSize(true);
        recycleBaitap.setLayoutManager(mLayoutManager);
        recycleBaitap.setItemAnimator(new DefaultItemAnimator());
        recycleBaitap.setAdapter(adapter);

        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(ActivityMenuBaitap.this);
                Baitap_Tuan obj = (Baitap_Tuan) item;
                Intent intent = new Intent(ActivityMenuBaitap.this, ActivityStartBaitap.class);
                intent.putExtra(Constants.KEY_SEND_BAITAPTUAN, obj);
                startActivity(intent);
            }
        });
    }

    private void initbaitaptuan() {
        lisBaitap = new ArrayList<>();
        adapter_baitaptuan = new AdapterItemMenuLambaitap(lisBaitap, this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        recycle_baitap_tuan.setHasFixedSize(true);
        recycle_baitap_tuan.setLayoutManager(mLayoutManager);
        recycle_baitap_tuan.setItemAnimator(new DefaultItemAnimator());
        recycle_baitap_tuan.setAdapter(adapter_baitaptuan);
        adapter_baitaptuan.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(ActivityMenuBaitap.this);
                Baitap_Tuan obj = (Baitap_Tuan) item;
                Intent intent = new Intent(ActivityMenuBaitap.this, ActivityStartBaitap.class);
                intent.putExtra(Constants.KEY_SEND_BAITAPTUAN, obj);
                startActivity(intent);
            }
        });
    }

    MediaPlayer mp3;

    Calendar cal;
    Date date;
    SimpleDateFormat dft = null;

    private String get_current_time() {
        String date = "";
        //Set ngày giờ hiện tại khi mới chạy lần đầu
        cal = Calendar.getInstance();
        //Định dạng kiểu ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        date = dft.format(cal.getTime());
        //hiển thị lên giao diện
        return date;
    }

    @Override
    public void show_list_list_buy(List<TuanDamua> mLis) {
        hideDialogLoading();
    }

    @Override
    public void show_list_get_part(ResponDetailExer objDetailExer) {
        hideDialogLoading();
    }


    @Override
    public void show_error_api(List<ErrorApi> mLis) {
        hideDialogLoading();
        if (mLis != null && mLis.get(0).getsRESULT().equals("needed")) {
            showAlertErrorNetwork();
        }
        //showAlertErrorNetwork();
    }

    @Override
    public void show_get_excercise_needed(ResponseObjWeek obj) {
        hideDialogLoading();
        lisBaitap.clear();
        if (obj.getsERROR().equals("0000") && obj.getsINFO() != null) {
            boolean isMuabai = false;
            for (Baitap_Tuan objWeek : obj.getsINFO()) {
                if (objWeek.getsSTATE_BUY().equals("1")) {
                    lisBaitap.add(objWeek);
                }
            }
            if (lisBaitap.size() > 0) {
                recycle_baitap_tuan.setVisibility(View.VISIBLE);
                txt_notify_need.setVisibility(View.GONE);
            } else {
                txt_notify_need.setVisibility(View.VISIBLE);
                recycle_baitap_tuan.setVisibility(View.INVISIBLE);
                if (obj.getsINFO().size() > 0) {
                    txt_notify_need.setText("Bạn đã làm hết bài tập tuần này, mời bạn làm tiếp vào tuần sau nhé");
                } else {
                    txt_notify_need.setText("Bạn đã làm hết bài tập tuần này, mời bạn làm tiếp vào tuần sau nhé");
                }
                if (sUserMe.equals(Constants.KEY_SAVE_USER_MOTHER_TRY)) {
                    showDialogComfirm_two_button("Thông báo",
                            "Bài tập làm thử đã hết, con cần đăng nhập để làm bài tập tiếp nhé.",
                            false, new ClickDialog() {
                                @Override
                                public void onClickYesDialog() {
                                    Intent intent = new Intent(ActivityMenuBaitap.this,
                                            ActivityLogin.class);
                                    startActivity(intent);
                                    finish();
                                }

                                @Override
                                public void onClickNoDialog() {

                                }
                            }, "Đăng nhập", "Đóng");
                }
            }
            adapter_baitaptuan.notifyDataSetChanged();
            recycleBaitap.scrollToPosition(0);
        } else if (obj.getsERROR().equals("0002")) {
            sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
            sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
            sPassWord = SharedPrefs.getInstance().get(Constants.KEY_PASSWORD, String.class);
            showDialogLoading();
            mPresenterLogin.api_login_restful(sUserMe, sUserCon, sPassWord);
        } else {
            showDialogNotify("Thông báo", obj.getsRESULT());
        }
    }

    @Override
    public void show_get_excercise_expired(ResponseObjWeek objResponWeek) {
        hideDialogLoading();
        lisBaitap_quanhan.clear();
        if (objResponWeek.getsERROR().equals("0000")) {
            if (objResponWeek.getsINFO() != null) {
                lisBaitap_quanhan.addAll(objResponWeek.getsINFO());
            }
            if (lisBaitap_quanhan.size() > 0) {
                recycleBaitap.setVisibility(View.VISIBLE);
                txt_notify_quahan.setVisibility(View.GONE);
            } else {
                recycleBaitap.setVisibility(View.INVISIBLE);
                txt_notify_quahan.setVisibility(View.VISIBLE);
                txt_notify_quahan.setText("Con đã hoàn thành hết bài tập các tuần trước");
            }
            adapter.notifyDataSetChanged();
            recycleBaitap.scrollToPosition(0);
        }
    }

 /*   @Override
    public void show_get_excercise_expired(List<Baitap_Tuan> mLis) {
        hideDialogLoading();
        lisBaitap_quanhan.clear();
        if (mLis != null && mLis.get(0).getsERROR().equals("0000")) {
            if (sUserMe.equals("quochuy190") || sUserMe.equals("maitham123")) {
                lisBaitap_quanhan.addAll(mLis);
            } else {
                for (Baitap_Tuan obj : mLis) {
                    if (obj.getsSTATE_BUY().equals("1") && obj.getsSTATUS_TAKEN().equals("0")) {
                        lisBaitap_quanhan.add(obj);
                    }
                    // lisBaitap_quanhan.add(obj);
                }
                if (lisBaitap_quanhan.size() > 0) {
                    recycleBaitap.setVisibility(View.VISIBLE);
                    txt_notify_quahan.setVisibility(View.GONE);
                } else {
                    recycleBaitap.setVisibility(View.INVISIBLE);
                    txt_notify_quahan.setVisibility(View.VISIBLE);
                    txt_notify_quahan.setText("Con đã hoàn thành hết bài tập các tuần trước");
                }
            }
            adapter.notifyDataSetChanged();
            recycleBaitap.scrollToPosition(0);

        }
    }*/

    @Override
    public void show_start_taken(ErrorApi mLis) {
        hideDialogLoading();
    }

    @Override
    public void show_submit_execercise(ErrorApi mLis) {

    }

    @Override
    public void show_detail_taken(ResponDetailTakenExercise obj) {

    }

    @Override
    public void showHomeworkDone(HomeworkDone homeworkDone) {

    }

    @Override
    public void show_api_login(ObjLogin mLis) {
        hideDialogLoading();
        if (mLis != null) {
            if (mLis.getsERROR().equals("0000")) {
                SharedPrefs.getInstance().put(Constants.KEY_SAVE_CHIL, mLis);
                initData();
                //start_home_activity();
            } else {
                //  DialogUtil.dontDialog(this, "Lỗi", mLis.getsRESULT());
                showDialogNotify("Lỗi", mLis.getsRESULT());
            }
        }
    }

    @Override
    public void show_update_infochil(ErrorApi obj) {
        hideDialogLoading();
    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
    }

    @Override
    public void show_api_login_Vip(ObjLoginVip loginVip) {

    }
}
