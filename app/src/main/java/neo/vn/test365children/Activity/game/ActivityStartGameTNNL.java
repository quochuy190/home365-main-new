package neo.vn.test365children.Activity.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponGameTNNL;
import neo.vn.test365children.Models.ResponGetGameTPTT;
import neo.vn.test365children.Presenter.ImlGetGameTptt;
import neo.vn.test365children.Presenter.PresenterGame;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityStartGameTNNL extends BaseActivity implements
        ImlGetGameTptt.View, View.OnClickListener {
    private static final String TAG = "ActivityStartGameTNNL";
    @BindView(R.id.img_background)
    ImageView imgBackground;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.btn_play_tnnl)
    Button btn_play_tnnl;
    @BindView(R.id.btn_easy)
    Button btn_easy;
    @BindView(R.id.btn_normal)
    Button btn_normal;
    @BindView(R.id.btn_hard)
    Button btn_hard;
    @BindView(R.id.txt_guilde)
    TextView txt_guilde;
    PresenterGame mPresenter;
    String sUserMe, sUserCon;

    @Override
    public int setContentViewId() {
        return R.layout.activity_start_tnnl;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterGame(this);
        btn_easy.setEnabled(false);
        btn_normal.setEnabled(false);
        btn_hard.setEnabled(false);
        Glide.with(this).load(R.drawable.bg_game_tnnl).into(imgBackground);
        initData();
        initEvent();
    }

    private void initEvent() {
        btn_easy.setOnClickListener(this);
        btn_normal.setOnClickListener(this);
        btn_hard.setOnClickListener(this);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartGameTNNL.this);
                finish();
            }
        });
        btn_play_tnnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartGameTNNL.this);
                Intent intent = new Intent(ActivityStartGameTNNL.this,
                        ActivityGameTinhnhanhNholau.class);
                startActivityForResult(intent, Constants.RequestCode.START_GAME_TNNL);
            }
        });
        txt_guilde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartGameTNNL.this);
                Intent intent = new Intent(ActivityStartGameTNNL.this,
                        Activity_Guild_Game.class);
                intent.putExtra(Constants.KEY_SEND_GUILD_GAME, "TNNL");
                startActivity(intent);
            }
        });
    }

    private void initData() {
        if (isNetwork()) {
            sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
            sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
            showDialogLoading();
            mPresenter.api_get_game_tnll(sUserMe, sUserCon);
        }
    }

    @Override
    public void show_get_game_tptt(ResponGetGameTPTT mLis) {

    }

    @Override
    public void show_error_api(ErrorApi mLis) {

    }

    @Override
    public void show_start_tptt(ErrorApi mLis) {

    }

    @Override
    public void show_submit_tptt(ErrorApi mLis) {

    }

    @Override
    public void show_get_game_tnnl(ResponGameTNNL mLis) {
        hideDialogLoading();
        if (mLis != null && mLis.getsERROR().equals("0000")) {
            if (mLis.getLisInfo() != null) {
                App.mLisGameTNNL.clear();
                App.mLisGameTNNL.addAll(mLis.getLisInfo());
                KeyboardUtil.button_enable(btn_hard);
                KeyboardUtil.button_enable(btn_easy);
                KeyboardUtil.button_enable(btn_normal);
            }
        } else {
            showAlertDialog("Lỗi", mLis.getsRESULT());
        }
    }

    @Override
    public void show_submit_game_tnnl(ErrorApi mLis) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ActivityStartGameTNNL.this, ActivityGameTinhnhanhNholau.class);
        switch (v.getId()) {
            case R.id.btn_easy:
                KeyboardUtil.animation_click_button(this, btn_easy);
                intent.putExtra(Constants.KEY_SEND_LEVEL, "1");
                startActivityForResult(intent, Constants.RequestCode.START_GAME_TNNL);
                break;
            case R.id.btn_normal:
                KeyboardUtil.animation_click_button(this, btn_normal);
                intent.putExtra(Constants.KEY_SEND_LEVEL, "2");
                startActivityForResult(intent, Constants.RequestCode.START_GAME_TNNL);
                break;
            case R.id.btn_hard:
                KeyboardUtil.animation_click_button(this, btn_hard);
                intent.putExtra(Constants.KEY_SEND_LEVEL, "3");
                startActivityForResult(intent, Constants.RequestCode.START_GAME_TNNL);
                break;
        }
    }
}
