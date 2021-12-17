package neo.vn.test365children.Activity.game.menu_game;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Activity.ActivityHome;
import neo.vn.test365children.Activity.game.ActivityStartGameTNNL;
import neo.vn.test365children.Activity.game.Activity_startgame_tptt;
import neo.vn.test365children.Activity.game.game_kow.ActivityKoWStart;
import neo.vn.test365children.Activity.game.sudoku.ActivityStartSudoku;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.ConfigGame;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponConfigGame;
import neo.vn.test365children.Presenter.PresenterLogActionServer;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityMenuGame extends BaseActivity implements View.OnClickListener, ImlConfigGameRest.View {
    private static final String TAG = "ActivityMenuGame";
    @BindView(R.id.rl_trieuphutrithuc)
    RelativeLayout rl_trieuphutrithuc;
    @BindView(R.id.rl_kingofword)
    RelativeLayout rl_kingofword;
    @BindView(R.id.rl_sodoku)
    RelativeLayout rl_sodoku;
    @BindView(R.id.rl_tinhnhanhnholau)
    RelativeLayout rl_tinhnhanhnholau;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.img_tptt)
    ImageView img_tptt;
    @BindView(R.id.img_tnnl)
    ImageView img_tnnl;
    @BindView(R.id.img_game_kow)
    ImageView img_game_kow;
    @BindView(R.id.img_game_sudoku)
    ImageView img_game_sudoku;
    @BindView(R.id.imageView12)
    ImageView imageView12;
    @BindView(R.id.img_mute)
    ImageView img_mute;
    @BindView(R.id.img_title_menugame)
    ImageView img_title_menugame;
    PresenterConfigGameRest mPresenter;
    String sUserMother, sUserKid;
    private boolean isPlaySudoku = true, isPlayKow = true, isPlayTPTT = true, isPlayTNNL = true;
    PresenterLogActionServer mPresenterLogServer;
    @Override
    public int setContentViewId() {
        return R.layout.activity_menu_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEvent();
        mPresenter = new PresenterConfigGameRest(this);
        mPresenterLogServer = new PresenterLogActionServer();
        // initData();
        Glide.with(this).load(R.drawable.bg_menu_game).into(imageView12);
        Glide.with(this).load(R.drawable.title_game).into(img_title_menugame);
    }

    private void initData() {
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserKid = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        if (sUserMother != null && sUserKid != null) {
            showDialogLoading();
            mPresenter.apirest_get_config_game(sUserMother, sUserKid);
        }

    }

    private void initEvent() {
        rl_trieuphutrithuc.setOnClickListener(this);
        rl_tinhnhanhnholau.setOnClickListener(this);
        rl_kingofword.setOnClickListener(this);
        rl_sodoku.setOnClickListener(this);
        img_back.setOnClickListener(this);
        img_mute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        KeyboardUtil.play_click_button(ActivityMenuGame.this);
        switch (v.getId()) {
            case R.id.rl_trieuphutrithuc:
                if (isPlayTPTT) {
                    Glide.with(this).load(R.drawable.btn_gray_black).into(img_tptt);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(ActivityMenuGame.this).load(R.drawable.btn_1).into(img_tptt);
                            startActivity(new Intent(ActivityMenuGame.this, Activity_startgame_tptt.class));
                        }
                    }, 1);
                } else {
                    showAlertDialog("Thông báo", "Mẹ đang tạm khoá trò chơi Triệu Phú Tri Thức nên con không chơi được. " +
                            "Con hãy xin phép mẹ mở khoá để tiếp tục trò chơi này nhé");
                }

                // KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_tptt);

                break;
            case R.id.rl_sodoku:
                if (isPlaySudoku) {
                    Glide.with(this).load(R.drawable.btn_gray_black).into(img_game_sudoku);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(ActivityMenuGame.this).load(R.drawable.btn_2).into(img_game_sudoku);
                            startActivity(new Intent(ActivityMenuGame.this, ActivityStartSudoku.class));
                        }
                    }, 1);
                } else {
                    showAlertDialog("Thông báo", "Mẹ đang tạm khoá trò chơi Sudoku nên con không chơi được. " +
                            "Con hãy xin phép mẹ mở khoá để tiếp tục trò chơi này nhé");
                }

                // KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_game_sudoku);

                // KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_game_kow);
                break;
            case R.id.rl_tinhnhanhnholau:
                if (isPlayTNNL) {
                    Glide.with(this).load(R.drawable.btn_gray_black).into(img_tnnl);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(ActivityMenuGame.this).load(R.drawable.btn_3).into(img_tnnl);
                            startActivity(new Intent(ActivityMenuGame.this, ActivityStartGameTNNL.class));
                        }
                    }, 1);
                } else {
                    showAlertDialog("Thông báo", "Mẹ đang tạm khoá trò chơi Tính Nhanh Nhớ Lâu nên con không chơi được. " +
                            "Con hãy xin phép mẹ mở khoá để tiếp tục trò chơi này nhé");
                }

                //   KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_tnnl);

                break;
            case R.id.rl_kingofword:
                if (isPlayKow) {
                    Glide.with(this).load(R.drawable.btn_gray_black).into(img_game_kow);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(ActivityMenuGame.this).load(R.drawable.btn_4).into(img_game_kow);
                            startActivity(new Intent(ActivityMenuGame.this, ActivityKoWStart.class));
                        }
                    }, 1);
                } else {
                    showAlertDialog("Thông báo", "Mẹ đang tạm khoá trò chơi King Of Word nên con không chơi được. " +
                            "Con hãy xin phép mẹ mở khoá để tiếp tục trò chơi này nhé");
                }

                //   KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_game_kow);
                break;
            case R.id.img_back:
                finish();
                break;
            case R.id.img_mute:
                finish();
                break;
        }
    }

    private NotificationChannel mChannel;
    private NotificationManager notifManager;

    private void displayCustomNotificationForOrders(String title, String description) {
        if (notifManager == null) {
            notifManager = (NotificationManager) getSystemService
                    (Context.NOTIFICATION_SERVICE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompat.Builder builder;
            Intent intent = new Intent(this, ActivityHome.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent;
            int importance = NotificationManager.IMPORTANCE_HIGH;
            if (mChannel == null) {
                mChannel = new NotificationChannel
                        ("0", title, importance);
                mChannel.setDescription(description);
                mChannel.enableVibration(true);
                notifManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(this, "0");

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(this, 1251, intent, PendingIntent.FLAG_ONE_SHOT);
            builder.setContentTitle(title)
                    .setSmallIcon(R.mipmap.ic_launcher_round) // required
                    .setContentText(description)  // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    /*.setLargeIcon(BitmapFactory.decodeResource
                            (getResources(), R.mipmap.logo))
                    .setBadgeIconType(R.mipmap.logo)*/
                    .setContentIntent(pendingIntent)
                    .setSound(RingtoneManager.getDefaultUri
                            (RingtoneManager.TYPE_NOTIFICATION));
            Notification notification = builder.build();
            notifManager.notify(0, notification);
        } else {
            Intent intent = new Intent(this, ActivityHome.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = null;
            pendingIntent = PendingIntent.getActivity(this, 1251,
                    intent, PendingIntent.FLAG_ONE_SHOT);
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setContentTitle(title)
                    .setContentText(description)
                    .setAutoCancel(true)
                    .setColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary))
                    .setSound(defaultSoundUri)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentIntent(pendingIntent)
                    .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(title).bigText(description));

            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1251, notificationBuilder.build());
        }
    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
        showAlertErrorNetwork();
    }

    @Override
    public void show_get_config_game(ResponConfigGame objRes) {
        hideDialogLoading();
        if (objRes.getsERROR().equals("0000") && objRes.getObjGame() != null) {
            ConfigGame objGame = objRes.getObjGame();
            if (objGame.getGAME_SUDOKU() != null && objGame.getGAME_SUDOKU().equals("1")) {
                isPlaySudoku = true;
            } else {
                isPlaySudoku = false;
             /*   Glide.with(this).load(R.drawable.btn_gray_black).into(img_game_sudoku);
                rl_sodoku.setEnabled(false);*/
            }
            if (objGame.getGAME_KOW() != null && objGame.getGAME_KOW().equals("1")) {
                isPlayKow = true;
            } else {
                isPlayKow = false;
              /*  Glide.with(this).load(R.drawable.btn_gray_black).into(img_game_kow);
                rl_kingofword.setEnabled(false);*/
            }
            if (objGame.getGAME_TNNL() != null && objGame.getGAME_TNNL().equals("1")) {
                isPlayTNNL = true;
            } else {
                isPlayTNNL = false;
            }
            if (objGame.getGAME_TPTT() != null && objGame.getGAME_TPTT().equals("1")) {
                isPlayTPTT = true;
            } else {
                isPlayTPTT = false;
            }
        }
    }
}
