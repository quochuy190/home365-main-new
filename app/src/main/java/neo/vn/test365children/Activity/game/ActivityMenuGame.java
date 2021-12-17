package neo.vn.test365children.Activity.game;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Activity.ActivityHome;
import neo.vn.test365children.Activity.game.game_kow.ActivityKoWStart;
import neo.vn.test365children.Activity.game.sudoku.ActivityStartSudoku;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;

public class ActivityMenuGame extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.img_title_menugame)
    ImageView img_title_menugame;

    @Override
    public int setContentViewId() {
        return R.layout.activity_menu_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEvent();
        Glide.with(this).load(R.drawable.bg_menu_game).into(imageView12);
        Glide.with(this).load(R.drawable.title_game).into(img_title_menugame);
    }

    private void initEvent() {
        rl_trieuphutrithuc.setOnClickListener(this);
        rl_tinhnhanhnholau.setOnClickListener(this);
        rl_kingofword.setOnClickListener(this);
        rl_sodoku.setOnClickListener(this);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_trieuphutrithuc:
                KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_tptt);
                startActivity(new Intent(ActivityMenuGame.this, Activity_startgame_tptt.class));
                break;
            case R.id.rl_sodoku:
                KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_game_sudoku);
                startActivity(new Intent(ActivityMenuGame.this, ActivityStartSudoku.class));
               // KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_game_kow);
                break;
            case R.id.rl_tinhnhanhnholau:
                KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_tnnl);
                startActivity(new Intent(ActivityMenuGame.this, ActivityStartGameTNNL.class));
                break;
            case R.id.rl_kingofword:
                KeyboardUtil.animation_click_button(ActivityMenuGame.this, img_game_kow);
                startActivity(new Intent(ActivityMenuGame.this, ActivityKoWStart.class));
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }

    private NotificationChannel mChannel;
    private NotificationManager notifManager;

    private void test_linkedlist() {
        Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
        }
    }

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
}
