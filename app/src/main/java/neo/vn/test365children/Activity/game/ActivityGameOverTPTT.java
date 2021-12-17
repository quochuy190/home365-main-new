package neo.vn.test365children.Activity.game;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponGameTNNL;
import neo.vn.test365children.Models.ResponGetGameTPTT;
import neo.vn.test365children.Presenter.ImlFeedback;
import neo.vn.test365children.Presenter.ImlGetGameTptt;
import neo.vn.test365children.Presenter.PresenterFeedback;
import neo.vn.test365children.Presenter.PresenterGame;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;
import neo.vn.test365children.Untils.StringUtil;

public class ActivityGameOverTPTT extends BaseActivity
        implements ImlGetGameTptt.View, ImlFeedback.View {
    int iLever;
    @BindView(R.id.txt_bonus)
    TextView txt_bonus;
    @BindView(R.id.btn_exit)
    TextView btn_exit;
    @BindView(R.id.img_gameover)
    ImageView img_gameover;
    @BindView(R.id.img_background)
    ImageView img_background;
    PresenterGame mPresenter;
    @BindView(R.id.btn_dong)
    Button btn_dong;
    @BindView(R.id.btn_gui)
    Button btn_gui;
    @BindView(R.id.rb_rate_1_1)
    RadioButton rb_rate_1_1;
    @BindView(R.id.rb_rate_1_2)
    RadioButton rb_rate_1_2;
    @BindView(R.id.rb_rate_1_3)
    RadioButton rb_rate_1_3;
    @BindView(R.id.ll_ketqua)
    LinearLayout ll_ketqua;
    @BindView(R.id.rb_rate_2_3)
    RadioButton rb_rate_2_3;
    @BindView(R.id.rb_rate_2_1)
    RadioButton rb_rate_2_1;
    @BindView(R.id.rb_rate_2_2)
    RadioButton rb_rate_2_2;
    @BindView(R.id.view_danhgia)
    ConstraintLayout view_danhgia;
    @BindView(R.id.imageView27)
    ImageView img_bang;
    PresenterFeedback mPresenterFeedback;
    String rate_1 = "";
    String rate_2 = "";
    @BindView(R.id.rating_exer)
    RatingBar rating_exer;

    @Override
    public int setContentViewId() {
        return R.layout.activity_game_over;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterGame(this);
        mPresenterFeedback = new PresenterFeedback(this);
        Glide.with(this).load(R.drawable.icon_bang).into(img_bang);
        initData();
        initEvent();
        initRating();
    }

    private void initRating() {
        rating_exer.setRating(5);
    }

    private void initEvent() {
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* finish();*/
                show_feedback();
            }
        });
        btn_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });
        btn_gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityGameOverTPTT.this);
                showDialogLoading();
                int rating = (int) rating_exer.getRating();
           /*     mPresenterFeedback.api_send_feetback(objExer.getsId_userMe(), objExer.getsId_userCon(),
                        "" + rating, "1", objExer.getsId_exercise());*/
                String sPart_id = App.mLisGameTPTT.get(0).getsPART_ID();
                mPresenterFeedback.api_send_feetback(sUserMe, sUserCon, "" + rating,
                        "2", sPart_id);
            }
        });
    }

    private void show_feedback() {
        view_danhgia.setVisibility(View.VISIBLE);
        ll_ketqua.setVisibility(View.GONE);
        Animation animationRotale = AnimationUtils.loadAnimation(ActivityGameOverTPTT.this,
                R.anim.animation_show_question);
        view_danhgia.startAnimation(animationRotale);


    }

    String sUserMe, sUserCon;
    String sValueMonney = "";
    private boolean isSPMinusMonney = false;

    private void initData() {
        btn_exit.setEnabled(false);
        isSPMinusMonney = getIntent().getBooleanExtra(Constants.KEY_SEND_SP_MINUS_MONNEY, false);
        iLever = getIntent().getIntExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, -1);
        Glide.with(this).load(R.drawable.bg_start_game).into(img_background);

        Animation animationRotale = AnimationUtils.loadAnimation(ActivityGameOverTPTT.this,
                R.anim.animation_game_over);
        img_gameover.startAnimation(animationRotale);
        Animation animationRotaletxt = AnimationUtils.loadAnimation(ActivityGameOverTPTT.this,
                R.anim.animation_game_over_point);
        txt_bonus.startAnimation(animationRotaletxt);
        sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        String sPart_id = App.mLisGameTPTT.get(0).getsPART_ID();
        if (iLever > -1) {
            if (iLever == 15) {
                Glide.with(this).load(R.drawable.img_winner).into(img_gameover);
            } else {
                Glide.with(this).load(R.drawable.title_game_over).into(img_gameover);
            }
            set_bonus(iLever);
        } else {
            Glide.with(this).load(R.drawable.title_game_over).into(img_gameover);
            txt_bonus.setText("0 điểm");
        }
        if (sValueMonney.length() > 0) {
            showDialogLoading();
            mPresenter.api_submit_tptt(sUserMe, sUserCon, sPart_id, StringUtil.get_current_time(),
                    "" + iLever, sValueMonney);
        }

    }

    private void set_bonus(int iLever) {
        switch (iLever) {
            case 0:
                txt_bonus.setText("0 đ");
                sValueMonney = "0";
                break;
            case 1:
                txt_bonus.setText("100 đ");
                sValueMonney = "100";
                break;
            case 2:
                txt_bonus.setText("200 đ");
                sValueMonney = "200";
                break;
            case 3:
                txt_bonus.setText("300 đ");
                sValueMonney = "300";
                break;
            case 4:
                txt_bonus.setText("500 đ");
                sValueMonney = "500";
                break;
            case 5:
                if (isSPMinusMonney) {
                    txt_bonus.setText("0 đ");
                    sValueMonney = "0";
                } else {
                    txt_bonus.setText("1.000 đ");
                    sValueMonney = "1000";
                }

                break;
            case 6:
                if (isSPMinusMonney) {
                    txt_bonus.setText("500 đ");
                    sValueMonney = "500";
                } else {
                    txt_bonus.setText("1.500 đ");
                    sValueMonney = "1500";
                }

                break;
            case 7:
                if (isSPMinusMonney) {
                    txt_bonus.setText("1.000 đ");
                    sValueMonney = "1000";
                } else {
                    txt_bonus.setText("2.000 đ");
                    sValueMonney = "2000";
                }
                break;
            case 8:
                if (isSPMinusMonney) {
                    txt_bonus.setText("2.000 đ");
                    sValueMonney = "2000";
                } else {
                    txt_bonus.setText("3.000 đ");
                    sValueMonney = "3000";
                }
                break;
            case 9:
                if (isSPMinusMonney) {
                    txt_bonus.setText("3.000 đ");
                    sValueMonney = "3000";
                } else {
                    txt_bonus.setText("4.000 đ");
                    sValueMonney = "4000";
                }
                break;
            case 10:
                if (isSPMinusMonney) {
                    txt_bonus.setText("4.000 đ");
                    sValueMonney = "4000";
                } else {
                    txt_bonus.setText("5.000 đ");
                    sValueMonney = "5000";
                }
                break;
            case 11:
                if (isSPMinusMonney) {
                    txt_bonus.setText("5.000 đ");
                    sValueMonney = "5000";
                } else {
                    txt_bonus.setText("6.000 đ");
                    sValueMonney = "6000";
                }
                break;
            case 12:
                if (isSPMinusMonney) {
                    txt_bonus.setText("6.000 đ");
                    sValueMonney = "6000";
                } else {
                    txt_bonus.setText("7.000 đ");
                    sValueMonney = "7000";
                }
                break;
            case 13:
                if (isSPMinusMonney) {
                    txt_bonus.setText("7.000 đ");
                    sValueMonney = "7000";
                } else {
                    txt_bonus.setText("8.000 đ");
                    sValueMonney = "8000";
                }
                break;
            case 14:
                if (isSPMinusMonney) {
                    txt_bonus.setText("8.000 đ");
                    sValueMonney = "8000";
                } else {
                    txt_bonus.setText("9.000 đ");
                    sValueMonney = "9000";
                }
                break;
            case 15:
                if (isSPMinusMonney) {
                    txt_bonus.setText("9.000 đ");
                    sValueMonney = "9000";
                } else {
                    txt_bonus.setText("10.000 đ");
                    sValueMonney = "10000";
                }
                break;
        }
    }

    @Override
    public void show_get_game_tptt(ResponGetGameTPTT objGameTPTT) {
        hideDialogLoading();
    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
        if (mLis != null && mLis.getsERROR() != null && mLis.getsERROR().equals("submit_tnnl")) {
            btn_exit.setEnabled(true);
        } else {

        }
    }

    @Override
    public void show_send_feedback(ErrorApi objError) {
        hideDialogLoading();
        if (objError.getsERROR().equals("0000")) {
            showDialogComfirm("Thông báo",
                    "Đánh giá đã được gửi đi. Cảm ơn con đã đóng góp xây dựng Home365.",
                    false, new ClickDialog() {
                        @Override
                        public void onClickYesDialog() {
                            finish();
                        }

                        @Override
                        public void onClickNoDialog() {

                        }
                    });
            //  showDialogNotify("Thông báo", objError.getsRESULT());
        } else {
            showDialogNotify(objError.getMESSGE(), objError.getsRESULT());
        }
    }

    @Override
    public void show_start_tptt(ErrorApi mLis) {
        hideDialogLoading();
    }

    @Override
    public void show_submit_tptt(ErrorApi mLis) {
        hideDialogLoading();
        btn_exit.setEnabled(true);
        if (mLis != null && mLis.getsERROR().equals("0000")) {

        } else {

        }
    }

    @Override
    public void show_get_game_tnnl(ResponGameTNNL mLis) {

    }

    @Override
    public void show_submit_game_tnnl(ErrorApi mLis) {

    }
}
