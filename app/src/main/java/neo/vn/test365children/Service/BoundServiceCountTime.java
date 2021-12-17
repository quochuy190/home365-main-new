package neo.vn.test365children.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.MessageEvent;

public class BoundServiceCountTime extends Service {
    private static final String TAG = "BoundServiceCountTime";
    private IBinder binder;
    public int TOTAL_TIME = 30 * 60 * 1000;
    CountDownTimer Timer;
    int time = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        time = intent.getIntExtra(Constants.KEY_SEND_TIME_SERVICE, 0);
        count_down_time();
        return this.binder;
    }

    // phương thức khởi tạo
    @Override
    public void onCreate() {
        binder = new MyBinder(); // do MyBinder được extends Binder
        Log.i(TAG, "onCreate: ");
        Log.i(TAG, "onCreate time: " + time);

        super.onCreate();

    }

    private void count_down_time() {
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
    }

    public class MyBinder extends Binder {
        // phương thức này trả về đối tượng MyService
        public BoundServiceCountTime getService() {
            Log.i(TAG, "getService: ");
            return BoundServiceCountTime.this;
        }
    }

    public void reststart_time() {
        if (Timer != null) {
            Timer.cancel();
        }
        count_down_time();
    }
    public void stop_time() {
        if (Timer != null) {
            Timer.cancel();
        }
        //count_down_time();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "Đã gọi onBind()");
        if (Timer != null)
            Timer.cancel();
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");

        return super.onStartCommand(intent, flags, startId);

    }
}
