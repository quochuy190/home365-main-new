package neo.vn.test365children.Activity.skill;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.Activity.doctruyen.Activity_Webview_Edumall;
import neo.vn.test365children.Adapter.AdapterCategoryShop;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.OnListenerItemClickObjService;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjLessonSkill;
import neo.vn.test365children.Models.ObjMenuSkill;
import neo.vn.test365children.Models.ObjUntility;
import neo.vn.test365children.Models.respon_api.ResponGetUntilities;
import neo.vn.test365children.Models.respon_api.ResponListLessonSkill;
import neo.vn.test365children.Presenter.PresenterLogActionServer;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class Activity_Menu_Skill extends BaseActivity implements InterfaceSkill.View, InterfaceGetStatusTiengAnh123.View {
    @BindView(R.id.recycle_list_lesson)
    RecyclerView list_menu_untility;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.btn_home)
    ImageView btn_home;
    @BindView(R.id.ll_description)
    ConstraintLayout ll_description;
    @BindView(R.id.btn_des_exit)
    Button btn_des_exit;
    @BindView(R.id.btn_des_watching)
    Button btn_des_watching;
    @BindView(R.id.img_des_background)
    ImageView img_des_background;
    @BindView(R.id.txt_des_name)
    TextView txt_des_name;
    @BindView(R.id.txt_des_teacher)
    TextView txt_des_teacher;
    @BindView(R.id.txt_des_supplier)
    TextView txt_des_supplier;
    @BindView(R.id.txt_des_number)
    TextView txt_des_number;
    @BindView(R.id.txt_des_time_limit)
    TextView txt_des_time_limit;
    @BindView(R.id.txt_des_description)
    TextView txt_des_description;
    /*RecyclerView.LayoutManager mLayoutManager;
    List<ObjUntility> lisMenuUntility;
    AdapterMenuSkill adapter;*/
    PresenterSkill mPresenter;
    String sUserMother, sUserChild;
    List<ObjUntility> lisMenuUntility;
    PresenterLogActionServer mPresenterLog;
    PresenterStatusTienganh123 mPresenterTienganh123;

    @Override
    public int setContentViewId() {
        return R.layout.activity_list_lesson_skill;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterSkill(this);
        mPresenterLog = new PresenterLogActionServer();
        mPresenterTienganh123 = new PresenterStatusTienganh123(this);
        Glide.with(this).load(R.drawable.icon_bang).into(img_des_background);
        init();
        initData();
        initEvent();
    }

    private void initData() {
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserChild = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        showDialogLoading();
        mPresenter.api_get_menu_skill(sUserMother, sUserChild);
        //mPresenter.api_get_list_lesson_skill(sUserMother, sUserChild, "");
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Menu_Skill.this);
                finish();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Menu_Skill.this);
                finish();
            }
        });
        btn_des_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Menu_Skill.this);
                ll_description.setVisibility(View.GONE);
                list_menu_untility.setVisibility(View.VISIBLE);
            }
        });
        btn_des_watching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Menu_Skill.this);
                if (mObj != null) {
                    Intent intent = new Intent(Activity_Menu_Skill.this, Activity_Webview_Edumall.class);
                    intent.putExtra(Constants.KEY_SEND_OBJ_LESSON_SKILL, mObj);
                    startActivity(intent);
                    ll_description.setVisibility(View.GONE);
                    list_menu_untility.setVisibility(View.VISIBLE);
                }
            }
        });
        ll_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void api_show_error() {
        hideDialogLoading();
    }

    @Override
    public void api_show_status(ErrorApi obj) {
        hideDialogLoading();
        if (obj.getsERROR().equals("0000")) {
            Intent intent = new Intent(Activity_Menu_Skill.this, Activity_Webview_Edumall.class);
            intent.putExtra(Constants.KEY_SEND_OBJ_LESSON_SKILL, mObj);
            startActivity(intent);
        } else {
            showDialogNotify("Thông báo", "Phiên đăng nhập đang quá tải, mời bạn trở lại sau");
        }
    }

    @Override
    public void api_show_menu_skill(ResponGetUntilities mLis) {
        hideDialogLoading();
        if (mLis != null && mLis.getsERROR().equals("0000")) {
            mPresenter.api_get_list_lesson_skill(sUserMother, sUserChild, "");
            if (mLis.getLisUntilities().size() > 0) {
                lisMenuUntility.clear();
                lisMenuUntility.addAll(mLis.getLisUntilities());
                // adapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    public void api_show_list_lesson_skill(ResponListLessonSkill mlis) {
        hideDialogLoading();
        if (mlis != null && mlis.getsERROR().equals("0000")) {
            mLisShop.clear();
            if (mlis.getLisLessonSkill() != null) {
                for (ObjUntility obj : lisMenuUntility) {
                    List<ObjLessonSkill> lisTemlp = new ArrayList<>();
                    for (ObjLessonSkill objSkill : mlis.getLisLessonSkill()) {
                        if (obj.getID().equals(objSkill.getKIND_ID()))
                            lisTemlp.add(objSkill);
                    }
                    if (lisTemlp.size() > 0) {
                        if (obj.getOD() != null)
                            //mLisShop.add(new ObjMenuSkill(obj.getsName(), lisTemlp), Integer.parseInt(obj.getOD()));
                            mLisShop.add(new ObjMenuSkill(obj.getsName(), lisTemlp, Integer.parseInt(obj.getOD())));
                        else
                            mLisShop.add(new ObjMenuSkill(obj.getsName(), lisTemlp, 1));
                    }
                    Collections.sort(mLisShop);
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    AdapterCategoryShop adapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<ObjMenuSkill> mLisShop;
    ObjLessonSkill mObj;

    private void init() {
        lisMenuUntility = new ArrayList<>();
        mLisShop = new ArrayList<>();
        adapter = new AdapterCategoryShop(this, mLisShop, new OnListenerItemClickObjService() {
            @Override
            public void onClickListener(ObjLessonSkill objService) {
                KeyboardUtil.play_click_button(Activity_Menu_Skill.this);
                ObjLessonSkill obj = (ObjLessonSkill) objService;
                mPresenterLog.api_log_action_server(sUserMother, sUserChild, "lesson_skill",
                        obj.getID());
               /* if (objService.getURL1().indexOf("tienganh123.com") > 0) {
                    mObj = obj;
                    showDialogLoading();
                    mPresenterTienganh123.api_get_status_tienganh123(sUserMother, sUserChild, obj.getID());
                } else {
                    Intent intent = new Intent(Activity_Menu_Skill.this, Activity_Webview_Edumall.class);
                    intent.putExtra(Constants.KEY_SEND_OBJ_LESSON_SKILL, obj);
                    startActivity(intent);
                }*/
                Intent intent = new Intent(Activity_Menu_Skill.this, Activity_Webview_Edumall.class);
                intent.putExtra(Constants.KEY_SEND_OBJ_LESSON_SKILL, obj);
                startActivity(intent);
            }

            @Override
            public void onItemXemthemClick(ObjLessonSkill objService) {
                KeyboardUtil.play_click_button(Activity_Menu_Skill.this);
                mObj = objService;
                if (mObj != null) {
                    show_description();
                    ll_description.setVisibility(View.VISIBLE);
                    ll_description.startAnimation(AnimationUtils.loadAnimation(Activity_Menu_Skill.this,
                            R.anim.animation_show_question));
                    list_menu_untility.setVisibility(View.GONE);
                }
            }
        });
        mLayoutManager = new GridLayoutManager(this, 1);
        //recycle_category.setNestedScrollingEnabled(false);
        list_menu_untility.setHasFixedSize(true);
        list_menu_untility.setLayoutManager(mLayoutManager);
        list_menu_untility.setItemAnimator(new DefaultItemAnimator());
        list_menu_untility.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void show_description() {
        if (mObj.getNAME() != null)
            txt_des_name.setText(mObj.getNAME());
        if (mObj.getNAME() != null)
            txt_des_description.setText("Mô tả: " + mObj.getDESCRIPTION());
        if (mObj.getTEACHER() != null)
            txt_des_teacher.setText("Giảng viên: " + mObj.getTEACHER());
        if (mObj.getSUPPLIER() != null)
            txt_des_supplier.setText("Nhà cung cấp: " + mObj.getSUPPLIER());
        if (mObj.getDURATION() != null)
            txt_des_time_limit.setText("Thời gian học: " + mObj.getDURATION() + " phút");
        if (mObj.getLEARN_PERTIME() != null && Integer.parseInt(mObj.getLEARN_PERTIME()) > 1)
            txt_des_number.setText("Số người học cùng lúc: nhiều HS");
        else
            txt_des_number.setText("Số người học cùng lúc: 1 HS");
    }
}
