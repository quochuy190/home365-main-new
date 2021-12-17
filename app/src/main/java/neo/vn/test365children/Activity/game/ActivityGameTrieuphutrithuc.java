package neo.vn.test365children.Activity.game;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.Adapter.AdapterPointGame;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.GameTrieuPhuTriThuc;
import neo.vn.test365children.Models.MessageEvent;
import neo.vn.test365children.Models.Point_Game_TPTT;
import neo.vn.test365children.R;
import neo.vn.test365children.Service.ServiceDownTimeGame;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.StringUtil;
import neo.vn.test365children.Untils.TimeUtils;

public class ActivityGameTrieuphutrithuc extends BaseActivity {
    private static final String TAG = "ActivityGameTrieuphutri";
    @BindView(R.id.btn_on_off_point)
    ImageView btn_on_off;
    @BindView(R.id.rl_point_game)
    RelativeLayout rl_point;
    @BindView(R.id.recycle_point_game)
    RecyclerView recycle_point_game;
    RecyclerView.LayoutManager mLayoutManager;
    List<Point_Game_TPTT> mLisPoint;
    AdapterPointGame adapter;
    @BindView(R.id.webview_question_game)
    WebView webview_game;
    @BindView(R.id.webview_anwser_A)
    WebView webview_anwser_A;
    @BindView(R.id.webview_anwser_B)
    WebView webview_anwser_B;
    @BindView(R.id.webview_anwser_C)
    WebView webview_anwser_C;
    @BindView(R.id.webview_anwser_D)
    WebView webview_anwser_D;
    @BindView(R.id.webview_anwser_A_test)
    WebView webview_anwser_A_test;
    @BindView(R.id.rl_anwser_A_test)
    RelativeLayout rl_anwser_A_test;
    @BindView(R.id.rl_anwser_A)
    RelativeLayout rl_anwser_A;
    @BindView(R.id.rl_anwser_C)
    RelativeLayout rl_anwser_C;
    @BindView(R.id.rl_anwser_B)
    RelativeLayout rl_anwser_B;
    @BindView(R.id.rl_anwser_D)
    RelativeLayout rl_anwser_D;
    boolean isOnOffPoint = false;
    List<GameTrieuPhuTriThuc> mLisGameTptt;
    int iCurrentQuestion = 0;
    String sAnwserChil = "", sAnwserChil_Two = "";
    @BindView(R.id.btn_dungcuocchoi)
    TextView btn_dungcuocchoi;
    @BindView(R.id.btn_traloi)
    TextView btn_traloi;
    Intent intent_service;
    @BindView(R.id.txt_time_game)
    TextView txt_time_game;
    @BindView(R.id.img_sp_5050)
    ImageView img_sp_5050;
    @BindView(R.id.img_sp_call)
    ImageView img_sp_call;
    @BindView(R.id.img_sp_khangia)
    ImageView img_sp_khangia;
    @BindView(R.id.img_sp_minus_monney)
    ImageView img_sp_minus_monney;
    @BindView(R.id.rl_sp_5050)
    RelativeLayout rl_sp_5050;
    @BindView(R.id.rl_sp_call)
    RelativeLayout rl_sp_call;
    @BindView(R.id.rl_sp_khangia)
    RelativeLayout rl_sp_khangia;
    @BindView(R.id.img_delete_sp_5050)
    ImageView img_delete_sp_5050;
    @BindView(R.id.img_delete_sp_call)
    ImageView img_delete_sp_call;
    @BindView(R.id.img_delete_sp_add_time)
    ImageView img_delete_sp_add_time;
    @BindView(R.id.txt_curren_question)
    TextView txt_curren_question;
    @BindView(R.id.rl_sp_minus_monney)
    RelativeLayout rl_sp_minus_monney;
    @BindView(R.id.img_delete_sp_minus_monney)
    ImageView img_delete_sp_minus_monney;
    @BindView(R.id.img_button_confirm)
    ImageView img_button_confirm;
    private boolean isAnwserIng = false;
    @BindView(R.id.img_stop_game)
    ImageView img_stop_game;
    @BindView(R.id.imageView16)
    ImageView imageView16;
    @BindView(R.id.scroll_tptt)
    NestedScrollView scroll_tptt;
//    private InterstitialAd interstitialAd;

    @Override
    public int setContentViewId() {
        return R.layout.activity_game_trieuphutrithuc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_start_game).into(imageView16);
        Glide.with(this).load(R.drawable.ic_5050).into(img_sp_5050);
        Glide.with(this).load(R.drawable.ic_add_60).into(img_sp_khangia);
        Glide.with(this).load(R.drawable.ic_minus_1000).into(img_sp_minus_monney);
        Glide.with(this).load(R.drawable.ic_2_in_4).into(img_sp_call);
        Glide.with(this).load(R.drawable.ic_delete).into(img_delete_sp_minus_monney);
        Glide.with(this).load(R.drawable.ic_delete).into(img_delete_sp_add_time);
        Glide.with(this).load(R.drawable.ic_delete).into(img_delete_sp_5050);
        Glide.with(this).load(R.drawable.ic_delete).into(img_delete_sp_call);
        mLisGameTptt = new ArrayList<>();
        mPlayer = new MediaPlayer();
        play_start_game();
        initEvent();
        initListPoint();
        initData();
//        initAds();
    }

//    private void initAds(){
//        if (SharedPrefs.getInstance().get(Constants.IS_VIP, Boolean.class)) return;
//        MobileAds.initialize(this, initializationStatus -> {
//        });
//        interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
//    }

//    private void loadAds(){
//        if (SharedPrefs.getInstance().get(Constants.IS_VIP, Boolean.class)) return;
//        interstitialAd.loadAd(new AdRequest.Builder().build());
//        interstitialAd.setAdListener(new AdListener(){
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                if (interstitialAd.isLoaded()){
//                    interstitialAd.show();
//                }
//            }
//        });
//    }

    public void resetTime() {
        if (intent_service != null)
            stopService(intent_service);
        intent_service = new Intent(ActivityGameTrieuphutrithuc.this, ServiceDownTimeGame.class);
        intent_service.putExtra(Constants.KEY_SEND_TIME_SERVICE, 120000);
        startService(intent_service);
        isShow_Notify_Support = false;
    }

    public void resetTime60(int time) {
        stopService(intent_service);
        intent_service = new Intent(ActivityGameTrieuphutrithuc.this, ServiceDownTimeGame.class);
        intent_service.putExtra(Constants.KEY_SEND_TIME_SERVICE, time);
        startService(intent_service);
    }

    private void initData() {
        if (App.mLisGameTPTT != null && App.mLisGameTPTT.size() > 0) {
            mLisGameTptt.addAll(App.mLisGameTPTT);
            if (mLisGameTptt.get(iCurrentQuestion) != null)
                getData(mLisGameTptt.get(iCurrentQuestion));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent_service);
        mPlayer.release();
        webview_game.clearHistory();
        webview_game.clearFormData();
        webview_game.clearCache(true);
        webview_anwser_A.clearHistory();
        webview_anwser_A.clearFormData();
        webview_anwser_A.clearCache(true);
        webview_anwser_B.clearHistory();
        webview_anwser_B.clearFormData();
        webview_anwser_B.clearCache(true);
        webview_anwser_C.clearHistory();
        webview_anwser_C.clearFormData();
        webview_anwser_C.clearCache(true);
        webview_anwser_D.clearHistory();
        webview_anwser_D.clearFormData();
        webview_anwser_D.clearCache(true);
        webview_anwser_A_test.clearHistory();
        webview_anwser_A_test.clearFormData();
        webview_anwser_A_test.clearCache(true);
    }

    int iCount = 0;
    private boolean isSupport5050 = false, isAddTime = false, isAddTwoAnwser = false,
            isTwoAnwser_ing = false, isSp_minus_monney = false;
    private String sOld_Anwser = "";

    private void initEvent() {

        rl_sp_5050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSupport5050) {
                    KeyboardUtil.animation_click_button(ActivityGameTrieuphutrithuc.this, img_sp_5050);
                    showDialogComfirm("Quyền trợ giúp 50:50", "Máy tính sẽ bỏ đi ngẫu nhiên 2 phương án trả lời sai. \n" +
                            "Bạn có chắc chắn muốn sử dụng quyền trợ giúp này không?", true, new ClickDialog() {
                        @Override
                        public void onClickYesDialog() {
                            img_delete_sp_5050.setVisibility(View.VISIBLE);
                            play_mp3_click();
                            final GameTrieuPhuTriThuc obj = mLisGameTptt.get(iCurrentQuestion);
                            if (obj.getsANSWER().equals("A") || obj.getsANSWER().equals("B")) {
                                rl_anwser_C.setVisibility(View.INVISIBLE);
                                rl_anwser_D.setVisibility(View.INVISIBLE);
                            } else {
                                rl_anwser_A.setVisibility(View.INVISIBLE);
                                rl_anwser_B.setVisibility(View.INVISIBLE);
                            }
                            isSupport5050 = true;

                        }

                        @Override
                        public void onClickNoDialog() {

                        }
                    });
                }
            }
        });


        rl_sp_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAddTwoAnwser) {
                    showDialogComfirm("Quyền trợ giúp 2/4", "Bạn được quyền chọn 2 đáp án mà bạn cho là đúng nhất.\n" +
                            "Bạn có chắc chắn muốn sử dụng quyền trợ giúp này không?", true, new ClickDialog() {
                        @Override
                        public void onClickYesDialog() {
                            KeyboardUtil.animation_click_button(ActivityGameTrieuphutrithuc.this, img_sp_call);

                            img_delete_sp_call.setVisibility(View.VISIBLE);
                            play_mp3_click();
                            isTwoAnwser_ing = true;
                            isAddTwoAnwser = !isAddTwoAnwser;

                        }

                        @Override
                        public void onClickNoDialog() {

                        }
                    });

                }
            }
        });
        rl_sp_khangia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time > 0) {
                    if (!isAddTime) {
                        KeyboardUtil.animation_click_button(ActivityGameTrieuphutrithuc.this, img_sp_khangia);
                        showDialogComfirm("Quyền trợ giúp +60s", "Bạn sẽ được cộng thêm 60s để suy nghĩ câu trả lời.\n" +
                                "Bạn có chắc chắn muốn chọn quyền trợ giúp này không?", true, new ClickDialog() {
                            @Override
                            public void onClickYesDialog() {

                                img_delete_sp_add_time.setVisibility(View.VISIBLE);
                                play_mp3_click();
                                resetTime60(time + 60000);
                                isAddTime = !isAddTime;

                            }

                            @Override
                            public void onClickNoDialog() {

                            }
                        });
                    }
                }
            }
        });
        rl_sp_minus_monney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSp_minus_monney) {
                    //    play_mp3_click();
                    KeyboardUtil.animation_click_button(ActivityGameTrieuphutrithuc.this, img_sp_minus_monney);
                    showDialogComfirm("Thông báo",
                            "Sử dụng quyền trợ giúp này giúp bạn vượt qua câu hỏi này và bị trừ 1.000đ.\n" +
                                    "Bạn có chắc chắn muốn sử dụng quyền trợ giúp này không?",
                            true, new ClickDialog() {
                                @Override
                                public void onClickYesDialog() {
                                    play_mp3_click();
                                    img_delete_sp_minus_monney.setVisibility(View.VISIBLE);
                                    isSp_minus_monney = true;
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                    /*iCurrentQuestion++;
                                    set_point_lever((iCurrentQuestion));
                                    show_lever_point();
                                    hideDialogLoading();
                                    getData(mLisGameTptt.get(iCurrentQuestion));*/
                                            //  click_anwser("" + mLisGameTptt.get(iCurrentQuestion).getsANSWER());
                                            sAnwserChil = mLisGameTptt.get(iCurrentQuestion).getsANSWER();
                                            initChamdiem();
                                  /*  new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            initChamdiem();
                                        }
                                    }, 500);*/
                                        }
                                    }, 0);

                                }

                                @Override
                                public void onClickNoDialog() {
                                }
                            });
                }

            }
        });
        btn_dungcuocchoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.animation_click_button(ActivityGameTrieuphutrithuc.this, img_stop_game);
                if (!isAnwserIng) {
                    showDialogComfirm("Thông báo", "Bạn có chắc chắn muốn dừng cuộc chơi tại đây",
                            true, new ClickDialog() {
                                @Override
                                public void onClickYesDialog() {
                                    stopService(intent_service);
                                    initAnwserFalse(iCurrentQuestion, true);
                                }

                                @Override
                                public void onClickNoDialog() {

                                }
                            });

                }
            }
        });

        btn_traloi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnwserIng) {
                    if (sAnwserChil.length() > 0) {
                        Glide.with(ActivityGameTrieuphutrithuc.this)
                                .load(R.drawable.btn_gray_black).into(img_button_confirm);
                        initChamdiem();
                    } else
                        Toast.makeText(ActivityGameTrieuphutrithuc.this, "Bạn chưa chọn đáp án nào", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_on_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOnOffPoint) {
                    btn_on_off.setImageResource(R.drawable.ic_next_game);
                    rl_point.setVisibility(View.VISIBLE);
                    isOnOffPoint = !isOnOffPoint;
                } else {
                    btn_on_off.setImageResource(R.drawable.ic_back_game);
                    rl_point.setVisibility(View.GONE);
                    isOnOffPoint = !isOnOffPoint;
                }
            }
        });
        webview_anwser_A.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (!isAnwserIng) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_UP:
                            if (!isTwoAnwser_ing)
                                click_anwser("A");
                            else {
                                click_anwser_twoanwser("A");
                            }
                            sOld_Anwser = "A";
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        default:
                    }
                }
                return false;
            }
        });
        webview_anwser_B.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (!isAnwserIng) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_UP:
                            if (!isTwoAnwser_ing)
                                click_anwser("B");
                            else {
                                click_anwser_twoanwser("B");
                            }
                            sOld_Anwser = "B";
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        default:
                    }
                }
                return false;
            }
        });
        webview_anwser_C.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (!isAnwserIng) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_UP:
                            if (!isTwoAnwser_ing)
                                click_anwser("C");
                            else {
                                click_anwser_twoanwser("C");
                            }
                            sOld_Anwser = "C";
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        default:
                    }
                }
                return false;
            }
        });
        webview_anwser_D.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (!isAnwserIng) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_UP:
                            if (!isTwoAnwser_ing)
                                click_anwser("D");
                            else {
                                click_anwser_twoanwser("D");
                            }
                            sOld_Anwser = "D";
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        default:
                    }
                }
                return false;
            }
        });
    }

    private void initChamdiem() {
        isAnwserIng = true;
        stopService(intent_service);
        play_delay_anwser();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final GameTrieuPhuTriThuc obj = mLisGameTptt.get(iCurrentQuestion);
                iCount = 0;
                set_anwser_true_background_cam(obj.getsANSWER());
                if (isTwoAnwser_ing) {
                    if (sAnwserChil.equals(obj.getsANSWER()) || sAnwserChil_Two.equals(obj.getsANSWER())) {
                        set_point_lever((iCurrentQuestion + 1));
                        play_mp3_true();
                    } else {
                        set_point_lever((iCurrentQuestion));
                        //   show_lever_point();
                        play_mp3_false();
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (sAnwserChil.equals(obj.getsANSWER()) || sAnwserChil_Two.equals(obj.getsANSWER())) {
                                iCurrentQuestion++;
                                if (iCurrentQuestion < 15) {
                                    getData(mLisGameTptt.get(iCurrentQuestion));
                                    click_anwser("refesh");
                                    set_point_lever(iCurrentQuestion);
                                } else {
                                    initAnwserFalse(15, false);
                                }
                            } else {
                                initAnwserFalse(iCurrentQuestion + 1, false);
                            }

                        }
                    }, 4000);
                } else {
                    if (sAnwserChil.equals(obj.getsANSWER())) {
                        set_point_lever((iCurrentQuestion + 1));
                        //    show_lever_point();
                        play_mp3_true();
                    } else {
                        set_point_lever((iCurrentQuestion));
                        //  show_lever_point();
                        play_mp3_false();
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (sAnwserChil.equals(obj.getsANSWER())) {
                                iCurrentQuestion++;
                                if (iCurrentQuestion < 15) {
                                    getData(mLisGameTptt.get(iCurrentQuestion));
                                    click_anwser("refesh");
                                } else {
                                    initAnwserFalse(15, false);
                                }
                            } else {
                                if (iCurrentQuestion < 15) {
                                    initAnwserFalse(iCurrentQuestion + 1, false);
                                } else {
                                    initAnwserFalse(10, false);
                                }
                            }
                        }
                    }, 4000);
                }
            }
        }, 2500);

    }

    private void show_lever_point() {
        rl_point.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rl_point.setVisibility(View.GONE);
            }
        }, 3000);
    }

    private void initListPoint() {
        mLisPoint = new ArrayList<>();
        mLisPoint.add(new Point_Game_TPTT("15. 10,000đ", false));
        mLisPoint.add(new Point_Game_TPTT("14. 9,000đ", false));
        mLisPoint.add(new Point_Game_TPTT("13. 8,000đ", false));
        mLisPoint.add(new Point_Game_TPTT("12. 7,000đ", false));
        mLisPoint.add(new Point_Game_TPTT("11. 6,000đ", false));
        mLisPoint.add(new Point_Game_TPTT("10. 5,000đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 9. 4,000đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 8. 3,000đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 7. 2,000đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 6. 1,500đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 5. 1,000đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 4. 500đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 3. 300đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 2. 200đ", false));
        mLisPoint.add(new Point_Game_TPTT(" 1. 100đ", true));

        adapter = new AdapterPointGame(mLisPoint, this);
        mLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        //mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recycle_point_game.setNestedScrollingEnabled(false);
        recycle_point_game.setHasFixedSize(true);
        recycle_point_game.setLayoutManager(mLayoutManager);
        recycle_point_game.setItemAnimator(new DefaultItemAnimator());
        recycle_point_game.setAdapter(adapter);
        recycle_point_game.scrollToPosition(mLisPoint.size() - 1);
        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                for (int i = 0; i < mLisPoint.size(); i++) {
                    if (position == i)
                        mLisPoint.get(position).setPlaying(true);
                    else
                        mLisPoint.get(position).setPlaying(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    int time = 0;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.message.equals("Service_Game")) {
            if (event.point == 0) {
                time = (int) event.time;
                if (time < (59 * 1000)) {
                    if (!isShow_Notify_Support)
                        show_notify_support();
                }
                txt_time_game.setText(TimeUtils.formatDuration((int) event.time));
            } else {
                time = (int) event.time;
                stopService(intent_service);
                if (sAnwserChil.length() > 0) {
                    initChamdiem();
                } else {
                    initAnwserFalse(iCurrentQuestion, false);
                    finish();
                }

            }
        }
    }

    boolean isShow_Notify_Support = false;

    public void show_notify_support() {
        if (!isSp_minus_monney || isAddTime || isAddTwoAnwser || isSupport5050) {
            showDialogNotify("Thông báo", "Thời gian suy nghĩ sắp hết," +
                    " bạn có muốn sử dụng quyền trợ giúp của chương trình");
            isShow_Notify_Support = true;
        }
    }

    private GameTrieuPhuTriThuc mObjGame;

    public void getData(GameTrieuPhuTriThuc obj) {
        Glide.with(ActivityGameTrieuphutrithuc.this)
                .load(R.drawable.btn_3).into(img_button_confirm);
        iHeightmax = 0;
        mObjGame = obj;
        webview_anwser_B.clearView();
        webview_anwser_A.clearView();
        webview_anwser_C.clearView();
        webview_anwser_D.clearView();
        webview_game.clearView();
        webview_anwser_A_test.clearView();
        txt_curren_question.setText("Câu " + (iCurrentQuestion + 1) + ": ");
        if (iCurrentQuestion < 4) {
            rl_sp_minus_monney.setVisibility(View.GONE);
        } else rl_sp_minus_monney.setVisibility(View.VISIBLE);
        isTwoAnwser_ing = false;
        if (isAddTime) {
            img_delete_sp_add_time.setVisibility(View.VISIBLE);
        } else
            img_delete_sp_add_time.setVisibility(View.INVISIBLE);
        if (isAddTwoAnwser) {
            img_delete_sp_call.setVisibility(View.VISIBLE);
        } else
            img_delete_sp_call.setVisibility(View.INVISIBLE);
        if (isSupport5050) {
            img_delete_sp_5050.setVisibility(View.VISIBLE);
        } else
            img_delete_sp_5050.setVisibility(View.INVISIBLE);
        if (isSp_minus_monney) {
            img_delete_sp_minus_monney.setVisibility(View.VISIBLE);
        } else
            img_delete_sp_minus_monney.setVisibility(View.INVISIBLE);
        rl_anwser_A.setVisibility(View.VISIBLE);
        rl_anwser_B.setVisibility(View.VISIBLE);
        rl_anwser_C.setVisibility(View.VISIBLE);
        rl_anwser_D.setVisibility(View.VISIBLE);
        showDialogLoading();
        if (obj.getsHTML_CONTENT().length() > 0)
            initWebview(webview_game, obj.getsHTML_CONTENT());
        if (obj.getsHTML_A().length() > 0) {
            initWebview(webview_anwser_A, obj.getsHTML_A());
            initWebview(webview_anwser_A_test, obj.getsHTML_A());
        }
        resetTime();
        isAnwserIng = false;
        if (iCurrentQuestion == 5 || iCurrentQuestion == 10 || iCurrentQuestion == 15){
//            loadAds();
        }
    }

    public void initWebview(final WebView webview, String link_web) {
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings();
        webview.clearCache(true);
        webview.clearFormData();
        webview.clearHistory();
        webview.setBackgroundColor(Color.TRANSPARENT);
        WebSettings webSettings = webview.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setDefaultFontSize(18);
        webSettings.setTextZoom((int) (webSettings.getTextZoom() * 1.2));
        String pish = "<html><body  align='center'>";
        String pas = "</body></html>";
        String text = "<html><head>"
                + "<style type=\"text/css\">body{color: #fff;}"
                + "</style></head>"
                + "<body>"
                + StringUtil.convert_html(link_web)
                + "</body></html>";
        webview.loadDataWithBaseURL("", text,
                "text/html", "UTF-8", "");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(final WebView view, String url) {
                super.onPageFinished(view, url);
                new CountDownTimer(1000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        switch (view.getId()) {
                            case R.id.webview_anwser_A:
                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        initWebview(webview_anwser_C, mObjGame.getsHTML_C());
                                        initWebview(webview_anwser_A_test, mObjGame.getsHTML_C());
                                    }
                                });
                                break;
                            case R.id.webview_anwser_C:
                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        initWebview(webview_anwser_B, mObjGame.getsHTML_B());
                                        initWebview(webview_anwser_A_test, mObjGame.getsHTML_B());
                                    }
                                });
                                break;
                            case R.id.webview_anwser_B:
                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        isSetHeight = true;
                                        initWebview(webview_anwser_D, mObjGame.getsHTML_D());
                                        initWebview(webview_anwser_A_test, mObjGame.getsHTML_D());
                                    }
                                });
                                break;
                            case R.id.webview_anwser_D:
                                hideDialogLoading();
                                break;
                            case R.id.webview_anwser_A_test:
                                scroll_tptt.scrollTo(0, 0);
                                if (iHeightmax < rl_anwser_A_test.getHeight()) {
                                    iHeightmax = rl_anwser_A_test.getHeight();
                                }
                                if (iHeightmax > 0) {
                                    setHeightAll(iHeightmax, rl_anwser_A);
                                    setHeightAll(iHeightmax, rl_anwser_C);
                                    setHeightAll(iHeightmax, rl_anwser_B);
                                    setHeightAll(iHeightmax, rl_anwser_D);
                                }
                                break;
                        }
                    }
                }.start();
            }
        });
    }

    public void click_anwser(String sClick) {
        if (sClick.equals("refesh")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                sAnwserChil = "";
            }
        } else {
            play_mp3_click();
            switch (sClick) {
                case "A":
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        sAnwserChil = "A";
                    }
                    break;
                case "B":
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        sAnwserChil = "B";
                    }
                    break;
                case "C":
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        sAnwserChil = "C";
                    }
                    break;
                case "D":
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                        rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        sAnwserChil = "D";
                    }
                    break;
            }
        }

    }

    public void click_anwser_twoanwser(String sClick) {
        play_mp3_click();
        switch (sClick) {
            case "A":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (sOld_Anwser.length() > 0) {
                        switch (sOld_Anwser) {
                            case "A":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "A";
                                break;
                            case "B":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "B";
                                sAnwserChil_Two = "A";
                                break;
                            case "C":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "C";
                                sAnwserChil_Two = "A";
                                break;
                            case "D":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "D";
                                sAnwserChil_Two = "A";
                                break;
                        }
                    } else {
                        click_anwser(sClick);
                    }
                }
                break;
            case "B":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (sOld_Anwser.length() > 0) {
                        switch (sOld_Anwser) {
                            case "A":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "A";
                                sAnwserChil_Two = "B";
                                break;
                            case "B":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "B";

                                break;
                            case "C":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "C";
                                sAnwserChil_Two = "B";
                                break;
                            case "D":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "D";
                                sAnwserChil_Two = "B";
                                break;
                        }
                    } else {
                        click_anwser(sClick);
                    }
                }
                break;
            case "C":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (sOld_Anwser.length() > 0) {
                        switch (sOld_Anwser) {
                            case "A":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "A";
                                sAnwserChil_Two = "C";
                                break;
                            case "B":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "B";
                                sAnwserChil_Two = "C";
                                break;
                            case "C":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                sAnwserChil = "C";
                                break;
                            case "D":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "D";
                                sAnwserChil_Two = "C";
                                break;
                        }
                    } else {
                        click_anwser(sClick);
                    }
                }
                break;
            case "D":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (sOld_Anwser.length() > 0) {
                        switch (sOld_Anwser) {
                            case "A":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "A";
                                sAnwserChil_Two = "D";
                                break;
                            case "B":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "B";
                                sAnwserChil_Two = "D";
                                break;
                            case "C":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "D";
                                sAnwserChil_Two = "C";
                                break;
                            case "D":
                                rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_tptt));
                                rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                                sAnwserChil = "D";
                                break;
                        }
                    } else {
                        click_anwser(sClick);
                    }
                }
                break;
        }
    }

    MediaPlayer mPlayer;

    public void play_mp3_true() {
        //mp3 = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(ActivityGameTrieuphutrithuc.this, R.raw.anwser_true_game);
        mPlayer.start();
    }

    public void play_start_game() {
        //mp3 = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(ActivityGameTrieuphutrithuc.this, R.raw.start_game_tptt);
        mPlayer.start();
    }

    public void play_mp3_click() {
        //mp3 = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(ActivityGameTrieuphutrithuc.this, R.raw.click_game);
        mPlayer.start();
    }

    public void play_mp3_false() {
        //mp3 = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(ActivityGameTrieuphutrithuc.this, R.raw.anwser_false_game);
        mPlayer.start();
    }

    public void play_delay_anwser() {
        //mp3 = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(ActivityGameTrieuphutrithuc.this, R.raw.delay_anwser_game);
        mPlayer.start();
    }

    public void set_point_lever(final int iCurrent) {
        show_lever_point();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = (mLisPoint.size() - 1); i > -1; i--) {
                    if (i == (mLisPoint.size() - iCurrent - 1)) {
                        mLisPoint.get(i).setPlaying(true);
                    } else mLisPoint.get(i).setPlaying(false);
                }
                adapter.notifyDataSetChanged();
            }
        }, 1000);


    }

    public void set_anwser_true_background_cam(final String sAnwser) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (sAnwser) {
                    case "A":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        }
                        break;
                    case "B":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        }
                        break;
                    case "C":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        }
                        break;
                    case "D":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_click));
                        }
                        break;
                }
                iCount++;
                set_anwser_true_background_green(sAnwser);

            }
        }, 300);

    }


    private void initAnwserFalse(int iLever, boolean isDungcuochoi) {
        Intent intent = new Intent(ActivityGameTrieuphutrithuc.this, ActivityGameOverTPTT.class);
        Log.i(TAG, "initAnwserFalse: start complete game");

        if (isDungcuochoi) {
            if (iLever > 0)
                intent.putExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, iLever);
            else
                intent.putExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, 0);
        } else {
            if (iLever < 4) {
                intent.putExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, 0);
            } else if (iLever >= 5 && iLever < 10) {
                intent.putExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, 5);
            } else if (iLever >= 10 && iLever < 15) {
                intent.putExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, 10);
            } else if (iLever == 15) {
                intent.putExtra(Constants.KEY_SEND_LEVER_GAME_TPTT, 15);
            }
        }
        if (isSp_minus_monney) {
            intent.putExtra(Constants.KEY_SEND_SP_MINUS_MONNEY, true);
        } else {
            intent.putExtra(Constants.KEY_SEND_SP_MINUS_MONNEY, false);
        }
        finish();
        startActivity(intent);
    }

    public void set_anwser_true_background_green(final String sAnwser) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (sAnwser) {
                    case "A":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_A.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_true));
                        }
                        break;
                    case "B":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_B.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_true));
                        }
                        break;
                    case "C":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_C.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_true));
                        }
                        break;
                    case "D":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rl_anwser_D.setBackground(getResources().getDrawable(R.drawable.spr_bg_anwser_game_true));
                        }
                        break;
                }
                iCount++;
                if (iCount <= 10)
                    set_anwser_true_background_cam(sAnwser);
            }
        }, 300);

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }

    int iHeightmax = 0;
    boolean isSetHeight = false;

    private void setHeightAll(final int iHeight, final View view) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams params = view.getLayoutParams();
                params.height = iHeight;
                view.setLayoutParams(params);
            }
        });

    }

}
