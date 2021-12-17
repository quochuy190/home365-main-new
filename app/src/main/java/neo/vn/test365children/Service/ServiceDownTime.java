package neo.vn.test365children.Service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import androidx.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.MessageEvent;

public class ServiceDownTime extends Service {
    private static final String CHANNEL_ID = "HOME365";
    public int TOTAL_TIME = 30 * 60 * 1000;
    CountDownTimer Timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int time = intent.getIntExtra(Constants.KEY_SEND_TIME_SERVICE, 0);
       /* Intent notificationIntent = new Intent(this, ActivityLambaitap.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Home365")
                .setContentText("Làm bài tập")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                //.setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);*/
        if (time > 0) {
            TOTAL_TIME = time;
        }
        Timer = new CountDownTimer(TOTAL_TIME, 1000) {
            public void onTick(long millisUntilFinished) {
                EventBus.getDefault().post(new MessageEvent("Service", 0, millisUntilFinished));
            }

            public void onFinish() {
                EventBus.getDefault().post(new MessageEvent("Service", 1, TOTAL_TIME));
            }
        }.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Timer.cancel();
        super.onDestroy();
    }

}
