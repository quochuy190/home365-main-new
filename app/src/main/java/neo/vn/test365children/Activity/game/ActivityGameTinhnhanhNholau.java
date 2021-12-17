package neo.vn.test365children.Activity.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.GameTNNL;
import neo.vn.test365children.Models.InfoKids;
import neo.vn.test365children.Models.ItemGameTNNL;
import neo.vn.test365children.Models.MessageEvent;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.ResponGameTNNL;
import neo.vn.test365children.Models.ResponGetGameTPTT;
import neo.vn.test365children.Presenter.ImlGetGameTptt;
import neo.vn.test365children.Presenter.PresenterGame;
import neo.vn.test365children.R;
import neo.vn.test365children.Service.ServiceDownTimeGame;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;
import neo.vn.test365children.Untils.StringUtil;
import neo.vn.test365children.Untils.TimeUtils;

public class ActivityGameTinhnhanhNholau extends BaseActivity implements View.OnClickListener,
        EasyFlipView.OnFlipAnimationListener, ImlGetGameTptt.View {
    private static final String TAG = "ActivityGameTinhnhanhNh";
    @BindView(R.id.flipView_0)
    EasyFlipView flipView_0;
    @BindView(R.id.flipView_1)
    EasyFlipView flipView_1;
    @BindView(R.id.flipView_2)
    EasyFlipView flipView_2;
    @BindView(R.id.flipView_3)
    EasyFlipView flipView_3;
    @BindView(R.id.flipView_4)
    EasyFlipView flipView_4;
    @BindView(R.id.flipView_5)
    EasyFlipView flipView_5;
    @BindView(R.id.flipView_6)
    EasyFlipView flipView_6;
    @BindView(R.id.flipView_7)
    EasyFlipView flipView_7;
    @BindView(R.id.flipView_8)
    EasyFlipView flipView_8;
    @BindView(R.id.flipView_9)
    EasyFlipView flipView_9;
    @BindView(R.id.flipView_10)
    EasyFlipView flipView_10;
    @BindView(R.id.flipView_11)
    EasyFlipView flipView_11;
    @BindView(R.id.flipView_12)
    EasyFlipView flipView_12;
    @BindView(R.id.flipView_13)
    EasyFlipView flipView_13;
    @BindView(R.id.flipView_14)
    EasyFlipView flipView_14;
    @BindView(R.id.flipView_15)
    EasyFlipView flipView_15;
    @BindView(R.id.flipView_16)
    EasyFlipView flipView_16;
    @BindView(R.id.flipView_17)
    EasyFlipView flipView_17;
    @BindView(R.id.flipView_18)
    EasyFlipView flipView_18;
    @BindView(R.id.flipView_19)
    EasyFlipView flipView_19;
    @BindView(R.id.flipView_20)
    EasyFlipView flipView_20;
    @BindView(R.id.flipView_21)
    EasyFlipView flipView_21;
    @BindView(R.id.flipView_22)
    EasyFlipView flipView_22;
    @BindView(R.id.flipView_23)
    EasyFlipView flipView_23;

    private int iPositionOne;
    private int iPositionTwo;
    List<ItemGameTNNL> mLisData;
    @BindView(R.id.txt_name_player_two)
    TextView txt_name_player_two;
    @BindView(R.id.txt_name_player_one)
    TextView txt_name_player_one;
    @BindView(R.id.img_avata_player1)
    ImageView img_avata_player1;
    @BindView(R.id.img_avata_player2)
    ImageView img_avata_player2;
    @BindView(R.id.txt_tnnl_point_one)
    TextView txt_tnnl_point_one;
    @BindView(R.id.txt_tnnl_point_two)
    TextView txt_tnnl_point_two;
    @BindView(R.id.rl_question2)
    RelativeLayout rl_question2;
    @BindView(R.id.rl_question_1)
    RelativeLayout rl_question_1;
    @BindView(R.id.txt_title_broad_1)
    TextView txt_title_broad_1;
    @BindView(R.id.txt_title_broad_2)
    TextView txt_title_broad_2;
    @BindView(R.id.webview_question_1)
    WebView webview_question_1;
    @BindView(R.id.webview_question_2)
    WebView webview_question_2;
    @BindView(R.id.img_broad_question_1)
    ImageView img_broad_question_1;
    @BindView(R.id.img_broad_question_2)
    ImageView img_broad_question_2;
    @BindView(R.id.imageView8)
    ImageView imgBackground;
    @BindView(R.id.img_bg_player_two)
    ImageView img_bg_player_two;
    @BindView(R.id.img_bg_player_one)
    ImageView img_bg_player_one;
    @BindView(R.id.btn_exit_gameover)
    Button btn_exit_gameover;
    @BindView(R.id.rl_show_gameover)
    RelativeLayout rl_show_gameover;
    List<Integer> mListBoxShow = new ArrayList<>();
    List<Integer> linkedBoxOpen = new ArrayList<>();
    PresenterGame mPresenter;
    private String sLevel = "1";
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.img_mute)
    ImageView img_mute;
    @BindView(R.id.img_gameover)
    ImageView img_gameover;
    @BindView(R.id.txt_bonus)
    TextView txt_bonus;

    @Override
    public int setContentViewId() {
        return R.layout.activity_game_tinhnhanhnholau;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show_image_bangchucai();
        mPlayer = new MediaPlayer();
        mPlayer_Click = new MediaPlayer();
        play_music_bg();
        rl_show_gameover.setVisibility(View.GONE);
        KeyboardUtil.button_enable(btn_exit_gameover);
        mPresenter = new PresenterGame(this);
        initData();
        resetTime();
        initEvent();
        initEventFlipComplete();
    }

    static boolean active = false;

    /* @Override
     public void onStart() {
         super.onStart();
         active = true;
     }

     @Override
     public void onStop() {
         super.onStop();
         active = false;
     }*/
    public void resetTime() {
        if (intent_service != null)
            stopService(intent_service);
        intent_service = new Intent(ActivityGameTinhnhanhNholau.this, ServiceDownTimeGame.class);
        intent_service.putExtra(Constants.KEY_SEND_TIME_SERVICE, 120000);
        startService(intent_service);
    }

    int time = 0;
    @BindView(R.id.txt_time_game)
    TextView txt_time_game;
    Intent intent_service;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.message.equals("Service_Game")) {
            if (event.point == 0) {
                time = (int) event.time;
                txt_time_game.setText(TimeUtils.formatDuration((int) event.time));
            } else {
                if (active) {
                    time = (int) event.time;
                    Log.i(TAG, "onMessageEvent: hết time" + time);
                    stopService(intent_service);
                    isPlayerOne = !isPlayerOne;
                    change_color(isPlayerOne);
                }

            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        active = true;
        if (mPlayer != null && !mPlayer.isPlaying() && !isMute) {
            mPlayer.start();
        }
        EventBus.getDefault().register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        active = false;
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
        }
        EventBus.getDefault().unregister(this);
    }

    List<String> mLisDebai = new ArrayList<>();

    private void initData() {
        Glide.with(this).load(R.drawable.icon_avata).into(img_avata_player2);
        sLevel = getIntent().getStringExtra(Constants.KEY_SEND_LEVEL);
        ObjLogin chil = SharedPrefs.getInstance().get(Constants.KEY_SAVE_CHIL, ObjLogin.class);
        Glide.with(this).load(R.drawable.icon_broad).into(img_broad_question_1);
        Glide.with(this).load(R.drawable.icon_broad).into(img_broad_question_2);
        Glide.with(this).load(R.drawable.bg_game_tnnl).into(imgBackground);
       /* img_bg_player_two.getBackground().setAlpha(50);
        img_bg_player_one.getBackground().setAlpha(255);*/
        Glide.with(this).load(R.drawable.btn_gray_black).into(img_bg_player_two);
        Glide.with(this).load(R.drawable.btn_3).into(img_bg_player_one);
        if (chil != null) {
            InfoKids objKid = chil.getsObjInfoKid();
            if (objKid.getsUSERNAME() != null) {
                txt_name_player_one.setText(objKid.getsUSERNAME());
            }
            if (objKid.getsAVATAR() != null && objKid.getsAVATAR().length() > 0) {
                Glide.with(this).load(Config.URL_IMAGE + objKid.getsAVATAR())
                        .into(img_avata_player1);
            } else {
                Glide.with(this).load(R.drawable.icon_avata).into(img_avata_player1);
            }
        }
        mLisData = new ArrayList<>();
        if (sLevel.equals("1")) {
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_0, "", "0"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_0, "", "0"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_1, "", "1"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_1, "", "1"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_2, "", "2"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_2, "", "2"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_3, "", "3"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_3, "", "3"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_4, "", "4"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_4, "", "4"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_5, "", "5"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_5, "", "5"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.fruit_banana, "", "6"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.fruit_banana, "", "6"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_7, "", "7"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_7, "", "7"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_8, "", "8"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_8, "", "8"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_9, "", "9"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_9, "", "9"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_10, "", "10"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_10, "", "10"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_11, "", "11"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.ic_fruit_11, "", "11"));
        } else {
            mLisData.add(new ItemGameTNNL(false, R.drawable.a, "", "0"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.b, "", "0"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.c, "", "1"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.d, "", "1"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.e, "", "2"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.w, "", "2"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.g, "", "3"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.h, "", "3"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.i, "", "4"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.j, "", "4"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.k, "", "5"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.l, "", "5"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.m, "", "6"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.n, "", "6"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.o, "", "7"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.p, "", "7"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.z, "", "8"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.r, "", "8"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.s, "", "9"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.t, "", "9"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.u, "", "10"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.v, "", "10"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.x, "", "11"));
            mLisData.add(new ItemGameTNNL(false, R.drawable.y, "", "11"));
        }
        if (App.mLisGameTNNL.size() > 0) {
            for (GameTNNL obj : App.mLisGameTNNL) {
                mLisDebai.add(obj.getsHTML_A());
                mLisDebai.add(obj.getsHTML_B());
                mLisDebai.add(obj.getsHTML_C());
                mLisDebai.add(obj.getsHTML_D());
            }
            if (mLisDebai.get(0) != null && mLisDebai.get(0).length() > 0) {
                if (mLisDebai.get(0).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(0).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(0).setsContent(arrayCauhoi[0]);
                        mLisData.get(1).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(1) != null && mLisDebai.get(1).length() > 0) {
                if (mLisDebai.get(1).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(1).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(2).setsContent(arrayCauhoi[0]);
                        mLisData.get(3).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(2) != null && mLisDebai.get(2).length() > 0) {
                if (mLisDebai.get(0).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(0).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(4).setsContent(arrayCauhoi[0]);
                        mLisData.get(5).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(3) != null && mLisDebai.get(3).length() > 0) {
                if (mLisDebai.get(3).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(3).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(6).setsContent(arrayCauhoi[0]);
                        mLisData.get(7).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(4) != null && mLisDebai.get(4).length() > 0) {
                if (mLisDebai.get(4).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(4).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(8).setsContent(arrayCauhoi[0]);
                        mLisData.get(9).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(5) != null && mLisDebai.get(5).length() > 0) {
                if (mLisDebai.get(5).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(5).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(10).setsContent(arrayCauhoi[0]);
                        mLisData.get(11).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(6) != null && mLisDebai.get(6).length() > 0) {
                if (mLisDebai.get(6).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(6).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(12).setsContent(arrayCauhoi[0]);
                        mLisData.get(13).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(7) != null && mLisDebai.get(7).length() > 0) {
                if (mLisDebai.get(7).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(7).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(14).setsContent(arrayCauhoi[0]);
                        mLisData.get(15).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(8) != null && mLisDebai.get(8).length() > 0) {
                if (mLisDebai.get(8).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(8).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(16).setsContent(arrayCauhoi[0]);
                        mLisData.get(17).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(9) != null && mLisDebai.get(9).length() > 0) {
                if (mLisDebai.get(9).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(9).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(18).setsContent(arrayCauhoi[0]);
                        mLisData.get(19).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(10) != null && mLisDebai.get(10).length() > 0) {
                if (mLisDebai.get(10).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(10).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(20).setsContent(arrayCauhoi[0]);
                        mLisData.get(21).setsContent(arrayCauhoi[1]);
                    }
                }
            }
            if (mLisDebai.get(11) != null && mLisDebai.get(0).length() > 0) {
                if (mLisDebai.get(11).indexOf("::") > -1) {
                    String[] arrayCauhoi = mLisDebai.get(0).split("::");
                    if (arrayCauhoi.length > 1) {
                        mLisData.get(22).setsContent(arrayCauhoi[0]);
                        mLisData.get(23).setsContent(arrayCauhoi[1]);
                    }
                }
            }
        }
        Collections.shuffle(mLisData);
        show_image();
    }

    boolean isMute = false;

    private void initEvent() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_btn();
            }
        });
        img_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer.isPlaying()) {
                    isMute = true;
                    Glide.with(getApplication()).load(R.drawable.icon_tat_loa).into(img_mute);
                    mPlayer.pause();
                } else {
                    isMute = false;
                    Glide.with(getApplication()).load(R.drawable.img_mute).into(img_mute);
                    mPlayer.start();
                }
            }
        });
        btn_exit_gameover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetwork()) {
                    finish();

                } else {
                    finish();
                }

            }
        });
        rl_show_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (active) {
                    if (isPlayerOne && !isFirstClick && !isAnwser) {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                isPlayerOne = !isPlayerOne;
                                change_color(isPlayerOne);
                            }
                        }, 0);
                    } else gone_question_view(true);
                }

            }
        });

    }

    private void get_api_bonus() {
        if (sLevel.equals("3")) {
            String sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
            String sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
            mPresenter.api_submit_game_tnnl(sUserMe, sUserCon, "1000");
            // finish();
        } else {

        }
    }

    private boolean isFirstClick = false;
    private boolean isTwoClick = false;
    private boolean isWating = false;
    @BindView(R.id.rl_show_question)
    RelativeLayout rl_show_question;
    @BindView(R.id.btn_exit)
    Button btn_exit;
    private int iPointPlayer_One = 0;
    private int iPointPlayer_Two = 0;
    boolean isPlayerOne = true;

    private void check_click(EasyFlipView flipView, final int possition) {
        if (active) {
            if (!isFirstClick && !isWating) {
                play_lathinh();
                isAnwser = false;
                clear_webview();
                isWating = true;
                isFirstClick = true;
                iPositionOne = possition;
                boolean flipStatus = flipView.isFlipEnabled();
                flipView.setFlipDuration(1000);
                flipView.flipTheView();
                new CountDownTimer(500, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        String s = mLisData.get(possition).getsContent();
                        txt_title_broad_1.setText("Ô số " + (iPositionOne + 1));
                        txt_title_broad_2.setText("");
                        StringUtil.initWebview_Whitetext(webview_question_1, s);
                        StringUtil.initWebview_Whitetext(webview_question_2, "");
                        rl_show_question.setVisibility(View.VISIBLE);
                        Animation animationRotale = AnimationUtils.loadAnimation(ActivityGameTinhnhanhNholau.this,
                                R.anim.animation_show_question);
                        rl_show_question.startAnimation(animationRotale);
                    }
                }.start();
            } else if (!isTwoClick && !isWating && possition != iPositionOne) {
                //KeyboardUtil.button_disable(btn_exit);
                //btn_exit.getBackground().setAlpha(50);
                btn_exit.setEnabled(false);
                if (isPlayerOne) {
                    isComputerPlay = true;
                } else {
                    isComputerPlay = true;
                }
                isWating = true;
                play_lathinh();
                String s = mLisData.get(possition).getsContent();
                StringUtil.initWebview_Whitetext(webview_question_2, s);
                txt_title_broad_1.setText("Ô số " + (iPositionOne + 1));
                txt_title_broad_2.setText("Ô số " + (possition + 1));
                isTwoClick = true;
                iPositionTwo = possition;
                boolean flipStatus = flipView.isFlipEnabled();
                flipView.setFlipDuration(1000);
                flipView.flipTheView();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rl_show_question.setVisibility(View.VISIBLE);
                        Animation animationRotale = AnimationUtils.loadAnimation(ActivityGameTinhnhanhNholau.this,
                                R.anim.animation_show_question);
                        rl_show_question.startAnimation(animationRotale);
                    }
                }, 500);
            }
        }
    }

    boolean isAnwser = false;

    @Override
    public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
        isWating = false;
        if (isTwoClick) {
            new CountDownTimer(2000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    if (active) {
                        if (linkedBoxOpen.size() > 0) {
                            if (!StringUtil.check_list_true(iPositionOne, linkedBoxOpen)) {
                                linkedBoxOpen.add(iPositionOne);
                            }
                            if (!StringUtil.check_list_true(iPositionTwo, linkedBoxOpen)) {
                                linkedBoxOpen.add(iPositionTwo);
                            }
                        } else {
                            linkedBoxOpen.add(iPositionOne);
                            linkedBoxOpen.add(iPositionTwo);
                        }
                        isTwoClick = false;
                        isFirstClick = false;

                        if (mLisData.get(iPositionOne).getsId().equals(mLisData.get(iPositionTwo).getsId())) {
                            play_anwser_true();
                            isAnwser = true;
                            mListBoxShow.add(iPositionOne);
                            mListBoxShow.add(iPositionTwo);
                            if (isPlayerOne) {
                                isComputerPlay = false;
                                iPointPlayer_One = iPointPlayer_One + 1;
                                txt_tnnl_point_one.setText("" + iPointPlayer_One);
                            } else {
                                isComputerPlay = true;
                                iPointPlayer_Two = iPointPlayer_Two + 1;
                                txt_tnnl_point_two.setText("" + iPointPlayer_Two);
                                new CountDownTimer(5000, 100) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                        gone_question_view(true);
                                        ai_lever_1();
                                    }
                                }.start();

                            }
                            new CountDownTimer(1500, 100) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    if (iPointPlayer_One >= iPointPlayer_Two) {
                                        play_gameover_win();
                                        Glide.with(ActivityGameTinhnhanhNholau.this).load(R.drawable.img_winner)
                                                .into(img_gameover);
                                        txt_bonus.setText("Thưởng: 1.000đ");
                                    } else {
                                        play_gameover_lost();
                                        Glide.with(ActivityGameTinhnhanhNholau.this).load(R.drawable.title_game_over)
                                                .into(img_gameover);
                                        txt_bonus.setText("Thưởng: 0đ");
                                    }
                                    int iTotalPoint = iPointPlayer_One + iPointPlayer_Two;
                                    if (iTotalPoint == 12) {
                                        stopService(intent_service);
                                        if (iPointPlayer_One >= iPointPlayer_Two) {
                                            rl_show_gameover.setVisibility(View.VISIBLE);
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    get_api_bonus();
                                                }
                                            }, 700);

                                        }
                                    }
                                }
                            }.start();
                        } else {
                            play_anwser_false();
                            if (!isPlayerOne) {
                                new CountDownTimer(1100, 100) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        isPlayerOne = !isPlayerOne;
                                        change_color(isPlayerOne);
                                    }
                                }.start();

                            }
                            isAnwser = false;
                        }
                        //   btn_exit.getBackground().setAlpha(255);
                        btn_exit.setEnabled(true);
                        //KeyboardUtil.button_enable(btn_exit);
                        final boolean finalIsAnwser = isAnwser;
                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                reload_flip_one(finalIsAnwser);
                            }
                        });
                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                reload_flip_two(finalIsAnwser);
                            }
                        });
                    }
                }
            }.start();

        }
    }

    public void gone_question_view(boolean isCheck) {
        if (isCheck) {
            if (rl_show_question.getVisibility() == View.VISIBLE) {
                Animation animationRotale = AnimationUtils.loadAnimation(ActivityGameTinhnhanhNholau.this,
                        R.anim.animation_show_question_close);
                rl_show_question.startAnimation(animationRotale);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rl_show_question.setVisibility(View.GONE);
                    }
                }, 1000);
            }
        }
    }

    public void clear_webview() {
        if (Build.VERSION.SDK_INT < 18) {
            webview_question_1.clearView();
        } else {
            webview_question_1.loadUrl("about:blank");
        }
        if (Build.VERSION.SDK_INT < 18) {
            webview_question_2.clearView();
        } else {
            webview_question_2.loadUrl("about:blank");
        }
    }

    boolean isComputerPlay = false;

    private void change_color(final boolean isPlayerOne) {
        gone_question_view(true);
        new CountDownTimer(100, 10) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (active) {
                    play_doiluot();
                    resetTime();
                    if (isPlayerOne) {
                        isComputerPlay = false;
                        btn_exit.setVisibility(View.VISIBLE);
                 /*   img_bg_player_two.getBackground().setAlpha(50);
                    img_bg_player_one.getBackground().setAlpha(255);*/
                        if (active) {
                            Glide.with(ActivityGameTinhnhanhNholau.this).load(R.drawable.btn_gray_black).into(img_bg_player_two);
                            Glide.with(ActivityGameTinhnhanhNholau.this).load(R.drawable.btn_3).into(img_bg_player_one);
                        }
                    } else {
                        btn_exit.setVisibility(View.INVISIBLE);
                   /* img_bg_player_one.getBackground().setAlpha(50);
                    img_bg_player_two.getBackground().setAlpha(255);*/
                        if (active) {
                            Glide.with(ActivityGameTinhnhanhNholau.this).load(R.drawable.btn_gray_black).into(img_bg_player_one);
                            Glide.with(ActivityGameTinhnhanhNholau.this).load(R.drawable.btn_4).into(img_bg_player_two);
                            ai_lever_1();
                        }
                    }
                }
            }
        }.start();
    }

    public List<Integer> get_ai_level_2(List<Integer> mListBoxShow, List<Integer> linkedBoxOpen) {
        List<Integer> mLisOutput = new ArrayList<>();
        if (linkedBoxOpen.size() > 0) {
            if (mListBoxShow.size() > 0) {
                linkedBoxOpen.removeAll(mListBoxShow);
                if (linkedBoxOpen.size() > 0) {
                    for (int i = 0; i < linkedBoxOpen.size(); i++) {
                        for (int j = 0; j < linkedBoxOpen.size(); j++) {
                            if (linkedBoxOpen.get(i) != linkedBoxOpen.get(j) && mLisData.
                                    get(linkedBoxOpen.get(i)).getsId().equals(mLisData.
                                    get(linkedBoxOpen.get(j)).getsId())) {
                                mLisOutput.add(linkedBoxOpen.get(i));
                                mLisOutput.add(linkedBoxOpen.get(j));
                                return mLisOutput;
                            }
                        }
                    }
                    List<Integer> mLisTong = new ArrayList<>();
                    mLisTong.addAll(mListBoxShow);
                    mLisTong.addAll(linkedBoxOpen);
                    int iOne = StringUtil.check_random_one(mLisTong);
                    boolean iCheck_id = false;
                    for (int iTwo : linkedBoxOpen) {
                        if (mLisData.get(iOne).getsId().equals(mLisData.get(iTwo).getsId())) {
                            iCheck_id = true;
                            mLisOutput.add(iOne);
                            mLisOutput.add(iTwo);
                            return mLisOutput;
                        }
                    }
                    if (!iCheck_id) {
                        mLisTong.add(iOne);
                        int iTwo = StringUtil.check_random_one(mLisTong);
                        mLisOutput.add(iOne);
                        mLisOutput.add(iTwo);
                        return mLisOutput;
                    }
                }
            } else {
                //Khi chưa có ô nào được mở đúng
                for (int i = 0; i < linkedBoxOpen.size(); i++) {
                    for (int j = 0; j < linkedBoxOpen.size(); j++) {
                        if (linkedBoxOpen.get(i) != linkedBoxOpen.get(j) && mLisData.
                                get(linkedBoxOpen.get(i)).getsId().equals(mLisData.
                                get(linkedBoxOpen.get(j)).getsId())) {
                            mLisOutput.add(linkedBoxOpen.get(i));
                            mLisOutput.add(linkedBoxOpen.get(j));
                            return mLisOutput;
                        }
                    }
                }
                List<Integer> mLisTong = new ArrayList<>();
                mLisTong.addAll(mListBoxShow);
                mLisTong.addAll(linkedBoxOpen);
                int iOne = StringUtil.check_random_one(mLisTong);
                boolean iCheck_id = false;
                for (int iTwo : linkedBoxOpen) {
                    if (mLisData.get(iOne).getsId().equals(mLisData.get(iTwo).getsId())) {
                        iCheck_id = true;
                        mLisOutput.add(iOne);
                        mLisOutput.add(iTwo);
                        return mLisOutput;
                    }
                }
                if (!iCheck_id) {
                    mLisTong.add(iOne);
                    int iTwo = StringUtil.check_random_one(mLisTong);
                    mLisOutput.add(iOne);
                    mLisOutput.add(iTwo);
                    return mLisOutput;
                }
            }
        } else {
            List<Integer> mLisTong = new ArrayList<>();
            int iOne = StringUtil.check_random_one(mLisTong);
            mLisTong.add(iOne);
            int iTwo = StringUtil.check_random_one(mLisTong);
            mLisOutput.add(iOne);
            mLisOutput.add(iTwo);
            return mLisOutput;
        }
        return mLisOutput;

    }

    private void ai_lever_1() {
        isWating = true;
        List<Integer> mLisClick = new ArrayList<>();
        if (sLevel.equals("1")) {
            mLisClick.addAll(StringUtil.check_random(mListBoxShow));
        } else if (sLevel.equals("2")) {
            mLisClick.addAll(StringUtil.check_random(mListBoxShow));
            //mLisClick = get_ai_level_2(mListBoxShow, linkedBoxOpen);
        } else if (sLevel.equals("3")) {
            mLisClick = get_ai_level_2(mListBoxShow, linkedBoxOpen);
        }
        if (mLisClick.size() > 0) {
            final int position_one = mLisClick.get(0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isWating = false;
                    isFirstClick = false;
                    ai_click(position_one);
                }
            }, 1000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    gone_question_view(true);
                }
            }, 6000);
            final int position_two = mLisClick.get(1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isWating = false;
                    isTwoClick = false;
                    ai_click_two(position_two);
                }
            }, 8000);
        }


    }

    @Override
    public void onBackPressed() {
        back_btn();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.flipView_0:
                if (!isComputerPlay)
                    check_click(flipView_0, 0);
                break;
            case R.id.flipView_1:
                if (!isComputerPlay)
                    check_click(flipView_1, 1);
                break;
            case R.id.flipView_2:
                if (!isComputerPlay)
                    check_click(flipView_2, 2);
                break;
            case R.id.flipView_3:
                if (!isComputerPlay)
                    check_click(flipView_3, 3);
                break;
            case R.id.flipView_4:
                if (!isComputerPlay)
                    check_click(flipView_4, 4);
                break;
            case R.id.flipView_5:
                if (!isComputerPlay)
                    check_click(flipView_5, 5);
                break;
            case R.id.flipView_6:
                if (!isComputerPlay)
                    check_click(flipView_6, 6);
                break;
            case R.id.flipView_7:
                if (!isComputerPlay)
                    check_click(flipView_7, 7);
                break;
            case R.id.flipView_8:
                if (!isComputerPlay)
                    check_click(flipView_8, 8);
                break;
            case R.id.flipView_9:
                if (!isComputerPlay)
                    check_click(flipView_9, 9);
                break;
            case R.id.flipView_10:
                if (!isComputerPlay)
                    check_click(flipView_10, 10);
                break;
            case R.id.flipView_11:
                if (!isComputerPlay)
                    check_click(flipView_11, 11);
                break;
            case R.id.flipView_12:
                if (!isComputerPlay)
                    check_click(flipView_12, 12);
                break;
            case R.id.flipView_13:
                if (!isComputerPlay)
                    check_click(flipView_13, 13);
                break;
            case R.id.flipView_14:
                if (!isComputerPlay)
                    check_click(flipView_14, 14);
                break;
            case R.id.flipView_15:
                if (!isComputerPlay)
                    check_click(flipView_15, 15);
                break;
            case R.id.flipView_16:
                if (!isComputerPlay)
                    check_click(flipView_16, 16);
                break;
            case R.id.flipView_17:
                if (!isComputerPlay)
                    check_click(flipView_17, 17);
                break;
            case R.id.flipView_18:
                if (!isComputerPlay)
                    check_click(flipView_18, 18);
                break;
            case R.id.flipView_19:
                if (!isComputerPlay)
                    check_click(flipView_19, 19);
                break;
            case R.id.flipView_20:
                if (!isComputerPlay)
                    check_click(flipView_20, 20);
                break;
            case R.id.flipView_21:
                if (!isComputerPlay)
                    check_click(flipView_21, 21);
                break;
            case R.id.flipView_22:
                if (!isComputerPlay)
                    check_click(flipView_22, 22);
                break;
            case R.id.flipView_23:
                if (!isComputerPlay)
                    check_click(flipView_23, 23);
                break;

        }
    }

    private void reload_flip_two(boolean isAnwer) {
        switch (iPositionTwo) {
            case 0:
                if (isAnwer) {
                    flipView_0.setFlipEnabled(false);
                } else {
                    flipView_0.setFlipDuration(1000);
                    flipView_0.flipTheView();
                }

                break;
            case 1:
                if (isAnwer) {
                    flipView_1.setFlipEnabled(false);
                } else {
                    flipView_1.setFlipDuration(1000);
                    flipView_1.flipTheView();
                }

                break;
            case 2:
                if (isAnwer) {
                    flipView_2.setFlipEnabled(false);
                } else {
                    flipView_2.setFlipDuration(1000);
                    flipView_2.flipTheView();
                }

                break;
            case 3:
                if (isAnwer) {
                    flipView_3.setFlipEnabled(false);
                } else {
                    flipView_3.setFlipDuration(1000);
                    flipView_3.flipTheView();
                }

                break;

            case 4:
                if (isAnwer) {
                    flipView_4.setFlipEnabled(false);
                } else {
                    flipView_4.setFlipDuration(1000);
                    flipView_4.flipTheView();
                }

                break;
            case 5:
                if (isAnwer) {
                    flipView_5.setFlipEnabled(false);
                } else {
                    flipView_5.setFlipDuration(1000);
                    flipView_5.flipTheView();
                }

                break;
            case 6:
                if (isAnwer) {
                    flipView_6.setFlipEnabled(false);
                } else {
                    flipView_6.setFlipDuration(1000);
                    flipView_6.flipTheView();
                }

                break;
            case 7:
                if (isAnwer) {
                    flipView_7.setFlipEnabled(false);
                } else {
                    flipView_7.setFlipDuration(1000);
                    flipView_7.flipTheView();
                }

                break;
            case 8:
                if (isAnwer) {
                    flipView_8.setFlipEnabled(false);
                } else {
                    flipView_8.setFlipDuration(1000);
                    flipView_8.flipTheView();
                }

                break;
            case 9:
                if (isAnwer) {
                    flipView_9.setFlipEnabled(false);
                } else {
                    flipView_9.setFlipDuration(1000);
                    flipView_9.flipTheView();
                }

                break;
            case 10:
                if (isAnwer) {
                    flipView_10.setFlipEnabled(false);
                } else {
                    flipView_10.setFlipDuration(1000);
                    flipView_10.flipTheView();
                }

                break;
            case 11:
                if (isAnwer) {
                    flipView_11.setFlipEnabled(false);
                } else {
                    flipView_11.setFlipDuration(1000);
                    flipView_11.flipTheView();
                }
                break;
            case 12:
                if (isAnwer) {
                    flipView_12.setFlipEnabled(false);
                } else {
                    flipView_12.setFlipDuration(1000);
                    flipView_12.flipTheView();
                }
                break;
            case 13:
                if (isAnwer) {
                    flipView_13.setFlipEnabled(false);
                } else {
                    flipView_13.setFlipDuration(1000);
                    flipView_13.flipTheView();
                }
                break;
            case 14:
                if (isAnwer) {
                    flipView_14.setFlipEnabled(false);
                } else {
                    flipView_14.setFlipDuration(1000);
                    flipView_14.flipTheView();
                }
                break;
            case 15:
                if (isAnwer) {
                    flipView_15.setFlipEnabled(false);
                } else {
                    flipView_15.setFlipDuration(1000);
                    flipView_15.flipTheView();
                }
                break;
            case 16:
                if (isAnwer) {
                    flipView_16.setFlipEnabled(false);
                } else {
                    flipView_16.setFlipDuration(1000);
                    flipView_16.flipTheView();
                }
                break;
            case 17:
                if (isAnwer) {
                    flipView_17.setFlipEnabled(false);
                } else {
                    flipView_17.setFlipDuration(1000);
                    flipView_17.flipTheView();
                }
                break;
            case 18:
                if (isAnwer) {
                    flipView_18.setFlipEnabled(false);
                } else {
                    flipView_18.setFlipDuration(1000);
                    flipView_18.flipTheView();
                }
                break;
            case 19:
                if (isAnwer) {
                    flipView_19.setFlipEnabled(false);
                } else {
                    flipView_19.setFlipDuration(1000);
                    flipView_19.flipTheView();
                }
                break;
            case 20:
                if (isAnwer) {
                    flipView_20.setFlipEnabled(false);
                } else {
                    flipView_20.setFlipDuration(1000);
                    flipView_20.flipTheView();
                }
                break;
            case 21:
                if (isAnwer) {
                    flipView_21.setFlipEnabled(false);
                } else {
                    flipView_21.setFlipDuration(1000);
                    flipView_21.flipTheView();
                }
                break;
            case 22:
                if (isAnwer) {
                    flipView_22.setFlipEnabled(false);
                } else {
                    flipView_22.setFlipDuration(1000);
                    flipView_22.flipTheView();
                }
                break;
            case 23:
                if (isAnwer) {
                    flipView_23.setFlipEnabled(false);
                } else {
                    flipView_23.setFlipDuration(1000);
                    flipView_23.flipTheView();
                }
                break;
        }
        iPositionTwo = -1;
    }

   /* private void reload_flipview(EasyFlipView flipView) {
        flipView.setFlipDuration(1000);
        flipView.flipTheView();
    }*/

    private void reload_flip_one(boolean isAnwer) {
        switch (iPositionOne) {
            case 0:
                if (isAnwer) {
                    flipView_0.setFlipEnabled(false);
                } else {
                    flipView_0.setFlipDuration(1000);
                    flipView_0.flipTheView();
                }

                break;
            case 1:
                if (isAnwer) {
                    flipView_1.setFlipEnabled(false);
                } else {
                    flipView_1.setFlipDuration(1000);
                    flipView_1.flipTheView();
                }

                break;
            case 2:
                if (isAnwer) {
                    flipView_2.setFlipEnabled(false);
                } else {
                    flipView_2.setFlipDuration(1000);
                    flipView_2.flipTheView();
                }

                break;
            case 3:
                if (isAnwer) {
                    flipView_3.setFlipEnabled(false);
                } else {
                    flipView_3.setFlipDuration(1000);
                    flipView_3.flipTheView();
                }

                break;

            case 4:
                if (isAnwer) {
                    flipView_4.setFlipEnabled(false);
                } else {
                    flipView_4.setFlipDuration(1000);
                    flipView_4.flipTheView();
                }

                break;
            case 5:
                if (isAnwer) {
                    flipView_5.setFlipEnabled(false);
                } else {
                    flipView_5.setFlipDuration(1000);
                    flipView_5.flipTheView();
                }

                break;
            case 6:
                if (isAnwer) {
                    flipView_6.setFlipEnabled(false);
                } else {
                    flipView_6.setFlipDuration(1000);
                    flipView_6.flipTheView();
                }

                break;
            case 7:
                if (isAnwer) {
                    flipView_7.setFlipEnabled(false);
                } else {
                    flipView_7.setFlipDuration(1000);
                    flipView_7.flipTheView();
                }

                break;
            case 8:
                if (isAnwer) {
                    flipView_8.setFlipEnabled(false);
                } else {
                    flipView_8.setFlipDuration(1000);
                    flipView_8.flipTheView();
                }

                break;
            case 9:
                if (isAnwer) {
                    flipView_9.setFlipEnabled(false);
                } else {
                    flipView_9.setFlipDuration(1000);
                    flipView_9.flipTheView();
                }

                break;
            case 10:
                if (isAnwer) {
                    flipView_10.setFlipEnabled(false);
                } else {
                    flipView_10.setFlipDuration(1000);
                    flipView_10.flipTheView();
                }

                break;
            case 11:
                if (isAnwer) {
                    flipView_11.setFlipEnabled(false);
                } else {
                    flipView_11.setFlipDuration(1000);
                    flipView_11.flipTheView();
                }
                break;
            case 12:
                if (isAnwer) {
                    flipView_12.setFlipEnabled(false);
                } else {
                    flipView_12.setFlipDuration(1000);
                    flipView_12.flipTheView();
                }
                break;
            case 13:
                if (isAnwer) {
                    flipView_13.setFlipEnabled(false);
                } else {
                    flipView_13.setFlipDuration(1000);
                    flipView_13.flipTheView();
                }
                break;
            case 14:
                if (isAnwer) {
                    flipView_14.setFlipEnabled(false);
                } else {
                    flipView_14.setFlipDuration(1000);
                    flipView_14.flipTheView();
                }
                break;
            case 15:
                if (isAnwer) {
                    flipView_15.setFlipEnabled(false);
                } else {
                    flipView_15.setFlipDuration(1000);
                    flipView_15.flipTheView();
                }
                break;
            case 16:
                if (isAnwer) {
                    flipView_16.setFlipEnabled(false);
                } else {
                    flipView_16.setFlipDuration(1000);
                    flipView_16.flipTheView();
                }
                break;
            case 17:
                if (isAnwer) {
                    flipView_17.setFlipEnabled(false);
                } else {
                    flipView_17.setFlipDuration(1000);
                    flipView_17.flipTheView();
                }
                break;
            case 18:
                if (isAnwer) {
                    flipView_18.setFlipEnabled(false);
                } else {
                    flipView_18.setFlipDuration(1000);
                    flipView_18.flipTheView();
                }
                break;
            case 19:
                if (isAnwer) {
                    flipView_19.setFlipEnabled(false);
                } else {
                    flipView_19.setFlipDuration(1000);
                    flipView_19.flipTheView();
                }
                break;
            case 20:
                if (isAnwer) {
                    flipView_20.setFlipEnabled(false);
                } else {
                    flipView_20.setFlipDuration(1000);
                    flipView_20.flipTheView();
                }
                break;
            case 21:
                if (isAnwer) {
                    flipView_21.setFlipEnabled(false);
                } else {
                    flipView_21.setFlipDuration(1000);
                    flipView_21.flipTheView();
                }
                break;
            case 22:
                if (isAnwer) {
                    flipView_22.setFlipEnabled(false);
                } else {
                    flipView_22.setFlipDuration(1000);
                    flipView_22.flipTheView();
                }
                break;
            case 23:
                if (isAnwer) {
                    flipView_23.setFlipEnabled(false);
                } else {
                    flipView_23.setFlipDuration(1000);
                    flipView_23.flipTheView();
                }
                break;
        }
        iPositionOne = -1;
    }

    private void ai_click_two(int position) {
        switch (position) {
            case 0:
                check_click(flipView_0, 0);
                break;
            case 1:
                check_click(flipView_1, 1);
                break;
            case 2:
                check_click(flipView_2, 2);
                break;
            case 3:
                check_click(flipView_3, 3);
                break;
            case 4:
                check_click(flipView_4, 4);
                break;
            case 5:
                check_click(flipView_5, 5);
                break;
            case 6:
                check_click(flipView_6, 6);
                break;
            case 7:
                check_click(flipView_7, 7);
                break;
            case 8:
                check_click(flipView_8, 8);
                break;
            case 9:
                check_click(flipView_9, 9);
                break;
            case 10:
                check_click(flipView_10, 10);
                break;
            case 11:
                check_click(flipView_11, 11);
                break;
            case 12:
                check_click(flipView_12, 12);
                break;
            case 13:
                check_click(flipView_13, 13);
                break;
            case 14:
                check_click(flipView_14, 14);
                break;
            case 15:
                check_click(flipView_15, 15);
                break;
            case 16:
                check_click(flipView_16, 16);
                break;
            case 17:
                check_click(flipView_17, 17);
                break;
            case 18:
                check_click(flipView_18, 18);
                break;
            case 19:
                check_click(flipView_19, 19);
                break;
            case 20:
                check_click(flipView_20, 20);
                break;
            case 21:
                check_click(flipView_21, 21);
                break;
            case 22:
                check_click(flipView_22, 22);
                break;
            case 23:
                check_click(flipView_23, 23);
                break;
        }
    }

    private void ai_click(int position) {
        switch (position) {
            case 0:
                check_click(flipView_0, 0);
                break;
            case 1:
                check_click(flipView_1, 1);
                break;
            case 2:
                check_click(flipView_2, 2);
                break;
            case 3:
                check_click(flipView_3, 3);
                break;
            case 4:
                check_click(flipView_4, 4);
                break;
            case 5:
                check_click(flipView_5, 5);
                break;
            case 6:
                check_click(flipView_6, 6);
                break;
            case 7:
                check_click(flipView_7, 7);
                break;
            case 8:
                check_click(flipView_8, 8);
                break;
            case 9:
                check_click(flipView_9, 9);
                break;
            case 10:
                check_click(flipView_10, 10);
                break;
            case 11:
                check_click(flipView_11, 11);
                break;
            case 12:
                check_click(flipView_12, 12);
                break;
            case 13:
                check_click(flipView_13, 13);
                break;
            case 14:
                check_click(flipView_14, 14);
                break;
            case 15:
                check_click(flipView_15, 15);
                break;
            case 16:
                check_click(flipView_16, 16);
                break;
            case 17:
                check_click(flipView_17, 17);
                break;
            case 18:
                check_click(flipView_18, 18);
                break;
            case 19:
                check_click(flipView_19, 19);
                break;
            case 20:
                check_click(flipView_20, 20);
                break;
            case 21:
                check_click(flipView_21, 21);
                break;
            case 22:
                check_click(flipView_22, 22);
                break;
            case 23:
                check_click(flipView_23, 23);
                break;
        }
    }

    @Override
    public void show_get_game_tptt(ResponGetGameTPTT objGetGameTPTT) {
        hideDialogLoading();
    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
    }

    @Override
    public void show_start_tptt(ErrorApi mLis) {
        hideDialogLoading();
    }

    @Override
    public void show_submit_tptt(ErrorApi mLis) {
        hideDialogLoading();

    }

    @Override
    public void show_get_game_tnnl(ResponGameTNNL mLis) {

    }

    @Override
    public void show_submit_game_tnnl(ErrorApi mLis) {
        hideDialogLoading();
        if (mLis.getsERROR().equals("0000")) {
            showDialogComfirm("Thông báo", "Chúc mừng con đã chiến thắng," +
                    " con được thưởng 1000đ cộng vào tài khoản mẹ!", false, new ClickDialog() {
                @Override
                public void onClickYesDialog() {
                    finish();
                }

                @Override
                public void onClickNoDialog() {

                }
            });
        }
    }

    @BindView(R.id.img_front_side_0)
    ImageView img_front_side_0;
    @BindView(R.id.img_front_side_1)
    ImageView img_front_side_1;
    @BindView(R.id.img_front_side_2)
    ImageView img_front_side_2;
    @BindView(R.id.img_front_side_3)
    ImageView img_front_side_3;
    @BindView(R.id.img_front_side_4)
    ImageView img_front_side_4;
    @BindView(R.id.img_front_side_5)
    ImageView img_front_side_5;
    @BindView(R.id.img_front_side_6)
    ImageView img_front_side_6;
    @BindView(R.id.img_front_side_7)
    ImageView img_front_side_7;
    @BindView(R.id.img_front_side_8)
    ImageView img_front_side_8;
    @BindView(R.id.img_front_side_9)
    ImageView img_front_side_9;
    @BindView(R.id.img_front_side_10)
    ImageView img_front_side_10;
    @BindView(R.id.img_front_side_11)
    ImageView img_front_side_11;
    @BindView(R.id.img_front_side_12)
    ImageView img_front_side_12;
    @BindView(R.id.img_front_side_13)
    ImageView img_front_side_13;
    @BindView(R.id.img_front_side_14)
    ImageView img_front_side_14;
    @BindView(R.id.img_front_side_15)
    ImageView img_front_side_15;
    @BindView(R.id.img_front_side_16)
    ImageView img_front_side_16;
    @BindView(R.id.img_front_side_17)
    ImageView img_front_side_17;
    @BindView(R.id.img_front_side_18)
    ImageView img_front_side_18;
    @BindView(R.id.img_front_side_19)
    ImageView img_front_side_19;
    @BindView(R.id.img_front_side_20)
    ImageView img_front_side_20;
    @BindView(R.id.img_front_side_21)
    ImageView img_front_side_21;
    @BindView(R.id.img_front_side_22)
    ImageView img_front_side_22;
    @BindView(R.id.img_front_side_23)
    ImageView img_front_side_23;

    @BindView(R.id.img_back_side_0)
    ImageView img_back_side_0;
    @BindView(R.id.img_back_side_1)
    ImageView img_back_side_1;
    @BindView(R.id.img_back_side_2)
    ImageView img_back_side_2;
    @BindView(R.id.img_back_side_3)
    ImageView img_back_side_3;
    @BindView(R.id.img_back_side_4)
    ImageView img_back_side_4;
    @BindView(R.id.img_back_side_5)
    ImageView img_back_side_5;
    @BindView(R.id.img_back_side_6)
    ImageView img_back_side_6;
    @BindView(R.id.img_back_side_7)
    ImageView img_back_side_7;
    @BindView(R.id.img_back_side_8)
    ImageView img_back_side_8;
    @BindView(R.id.img_back_side_9)
    ImageView img_back_side_9;
    @BindView(R.id.img_back_side_10)
    ImageView img_back_side_10;
    @BindView(R.id.img_back_side_11)
    ImageView img_back_side_11;
    @BindView(R.id.img_back_side_12)
    ImageView img_back_side_12;
    @BindView(R.id.img_back_side_13)
    ImageView img_back_side_13;
    @BindView(R.id.img_back_side_14)
    ImageView img_back_side_14;
    @BindView(R.id.img_back_side_15)
    ImageView img_back_side_15;
    @BindView(R.id.img_back_side_16)
    ImageView img_back_side_16;
    @BindView(R.id.img_back_side_17)
    ImageView img_back_side_17;
    @BindView(R.id.img_back_side_18)
    ImageView img_back_side_18;
    @BindView(R.id.img_back_side_19)
    ImageView img_back_side_19;
    @BindView(R.id.img_back_side_20)
    ImageView img_back_side_20;
    @BindView(R.id.img_back_side_21)
    ImageView img_back_side_21;
    @BindView(R.id.img_back_side_22)
    ImageView img_back_side_22;
    @BindView(R.id.img_back_side_23)
    ImageView img_back_side_23;

    public void show_image() {
        if (mLisData != null && mLisData.size() > 0) {
            Glide.with(this).load(mLisData.get(0).getsResoureImage()).into(img_back_side_0);
            Glide.with(this).load(mLisData.get(1).getsResoureImage()).into(img_back_side_1);
            Glide.with(this).load(mLisData.get(2).getsResoureImage()).into(img_back_side_2);
            Glide.with(this).load(mLisData.get(3).getsResoureImage()).into(img_back_side_3);
            Glide.with(this).load(mLisData.get(4).getsResoureImage()).into(img_back_side_4);
            Glide.with(this).load(mLisData.get(5).getsResoureImage()).into(img_back_side_5);
            Glide.with(this).load(mLisData.get(6).getsResoureImage()).into(img_back_side_6);
            Glide.with(this).load(mLisData.get(7).getsResoureImage()).into(img_back_side_7);
            Glide.with(this).load(mLisData.get(8).getsResoureImage()).into(img_back_side_8);
            Glide.with(this).load(mLisData.get(9).getsResoureImage()).into(img_back_side_9);
            Glide.with(this).load(mLisData.get(10).getsResoureImage()).into(img_back_side_10);
            Glide.with(this).load(mLisData.get(11).getsResoureImage()).into(img_back_side_11);
            Glide.with(this).load(mLisData.get(12).getsResoureImage()).into(img_back_side_12);
            Glide.with(this).load(mLisData.get(13).getsResoureImage()).into(img_back_side_13);
            Glide.with(this).load(mLisData.get(14).getsResoureImage()).into(img_back_side_14);
            Glide.with(this).load(mLisData.get(15).getsResoureImage()).into(img_back_side_15);
            Glide.with(this).load(mLisData.get(16).getsResoureImage()).into(img_back_side_16);
            Glide.with(this).load(mLisData.get(17).getsResoureImage()).into(img_back_side_17);
            Glide.with(this).load(mLisData.get(18).getsResoureImage()).into(img_back_side_18);
            Glide.with(this).load(mLisData.get(19).getsResoureImage()).into(img_back_side_19);
            Glide.with(this).load(mLisData.get(20).getsResoureImage()).into(img_back_side_20);
            Glide.with(this).load(mLisData.get(21).getsResoureImage()).into(img_back_side_21);
            Glide.with(this).load(mLisData.get(22).getsResoureImage()).into(img_back_side_22);
            Glide.with(this).load(mLisData.get(23).getsResoureImage()).into(img_back_side_23);

        }
    }

    public void show_image_bangchucai() {
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_0);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_1);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_2);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_3);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_4);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_5);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_6);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_7);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_8);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_9);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_10);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_11);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_12);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_13);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_14);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_15);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_16);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_17);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_18);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_19);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_20);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_21);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_22);
        Glide.with(this).load(R.drawable.bai_up).into(img_front_side_23);

    }

    private void initEventFlipComplete() {
        flipView_0.setOnClickListener(this);
        flipView_1.setOnClickListener(this);
        flipView_2.setOnClickListener(this);
        flipView_3.setOnClickListener(this);
        flipView_4.setOnClickListener(this);
        flipView_5.setOnClickListener(this);
        flipView_6.setOnClickListener(this);
        flipView_7.setOnClickListener(this);
        flipView_8.setOnClickListener(this);
        flipView_9.setOnClickListener(this);
        flipView_10.setOnClickListener(this);
        flipView_11.setOnClickListener(this);
        flipView_12.setOnClickListener(this);
        flipView_13.setOnClickListener(this);
        flipView_14.setOnClickListener(this);
        flipView_15.setOnClickListener(this);
        flipView_16.setOnClickListener(this);
        flipView_17.setOnClickListener(this);
        flipView_18.setOnClickListener(this);
        flipView_19.setOnClickListener(this);
        flipView_20.setOnClickListener(this);
        flipView_21.setOnClickListener(this);
        flipView_22.setOnClickListener(this);
        flipView_23.setOnClickListener(this);

        flipView_0.setOnFlipListener(this);
        flipView_1.setOnFlipListener(this);
        flipView_2.setOnFlipListener(this);
        flipView_3.setOnFlipListener(this);
        flipView_4.setOnFlipListener(this);
        flipView_5.setOnFlipListener(this);
        flipView_6.setOnFlipListener(this);
        flipView_7.setOnFlipListener(this);
        flipView_8.setOnFlipListener(this);
        flipView_9.setOnFlipListener(this);
        flipView_10.setOnFlipListener(this);
        flipView_11.setOnFlipListener(this);
        flipView_12.setOnFlipListener(this);
        flipView_13.setOnFlipListener(this);
        flipView_14.setOnFlipListener(this);
        flipView_15.setOnFlipListener(this);
        flipView_16.setOnFlipListener(this);
        flipView_17.setOnFlipListener(this);
        flipView_18.setOnFlipListener(this);
        flipView_19.setOnFlipListener(this);
        flipView_20.setOnFlipListener(this);
        flipView_21.setOnFlipListener(this);
        flipView_22.setOnFlipListener(this);
        flipView_23.setOnFlipListener(this);
    }

    MediaPlayer mPlayer;
    MediaPlayer mPlayer_Click;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent_service);
        mPlayer.release();
    }

    public void play_music_bg() {
        //mp3 = new MediaPlayer();
        mPlayer.release();

        mPlayer = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.home365);
        mPlayer.setLooping(true);
        mPlayer.setVolume(20, 20);
        mPlayer.start();

    }

    public void play_anwser_true() {
        //mp3 = new MediaPlayer();
        mPlayer_Click.release();
        mPlayer_Click = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.tnnl_answer_right);
        mPlayer_Click.start();

    }

    public void play_anwser_false() {
        //mp3 = new MediaPlayer();
        mPlayer_Click.release();
        mPlayer_Click = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.tnnl_answer_wrong);
        mPlayer_Click.start();

    }

    public void play_lathinh() {
        //mp3 = new MediaPlayer();
        mPlayer_Click.release();
        mPlayer_Click = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.tnnl_open_card);
        mPlayer_Click.start();

    }

    public void play_doiluot() {
        //mp3 = new MediaPlayer();
        mPlayer_Click.release();
        mPlayer_Click = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.tnnl_change_turn);
        mPlayer_Click.start();

    }

    public void play_gameover_win() {
        //mp3 = new MediaPlayer();
        mPlayer_Click.release();
        mPlayer_Click = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.yeah_mp3);
        mPlayer_Click.start();

    }

    public void play_gameover_lost() {
        //mp3 = new MediaPlayer();
        mPlayer_Click.release();
        mPlayer_Click = MediaPlayer.create(ActivityGameTinhnhanhNholau.this, R.raw.false_te);
        mPlayer_Click.start();

    }

    private void back_btn() {
        showDialogComfirm("Thông báo", "Bạn có chắc chắn muốn thoát khỏi trò chơi không?",
                true, new ClickDialog() {
                    @Override
                    public void onClickYesDialog() {
                        finish();
                    }

                    @Override
                    public void onClickNoDialog() {

                    }
                });
    }
}
