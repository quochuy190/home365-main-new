package neo.vn.test365children.Service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.MessageEvent;

public class ServiceDownTimeGame extends Service {
    private static final String TAG = "ServiceDownTimeGame";
    public int TOTAL_TIME = 60 * 1000;
    CountDownTimer Timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int time = intent.getIntExtra(Constants.KEY_SEND_TIME_SERVICE, 0);
        if (time > 0) {
            TOTAL_TIME = time;
        }
        Timer = new CountDownTimer(TOTAL_TIME, 1000) {
            public void onTick(long millisUntilFinished) {
                EventBus.getDefault().post(new MessageEvent("Service_Game", 0, millisUntilFinished));
                Log.i(TAG, "onTick: " + millisUntilFinished);
            }

            public void onFinish() {
                Log.i(TAG, "onFinish: end time");
                EventBus.getDefault().post(new MessageEvent("Service_Game", 1, 0));
            }
        }.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        Timer.cancel();
    }
}
