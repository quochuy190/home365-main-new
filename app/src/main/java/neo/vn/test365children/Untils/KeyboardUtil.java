package neo.vn.test365children.Untils;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import neo.vn.test365children.R;

/**
 * Created by LinhNguyen on 10/3/2015.
 */
public class KeyboardUtil {
    public static void animation_click_button(final Context activity, View view) {
       /* Animation animationRotale = AnimationUtils.loadAnimation(activity, R.anim.animation_click_buttongame);
        view.startAnimation(animationRotale);*/
    }

    public static void play_click_button(Activity activity) {
        //mp3 = new MediaPlayer();
        MediaPlayer mPlayer = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(activity, R.raw.click);
        mPlayer.setLooping(false);
        mPlayer.setVolume(10, 15);
        mPlayer.start();
    }

    public static void requestKeyboard(final Activity activity, int editViewId) {
        requestKeyboard(activity.findViewById(editViewId));
    }

    public static void button_disable(Button btn) {

        btn.setEnabled(false);
    }

    public static void button_enable(Button btn) {

        btn.setEnabled(true);
    }

    public static void requestKeyboard(final View view) {
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager keyboard = (InputMethodManager)
                        view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(view, 0);
            }
        }, 200);
    }

    public static void dismissKeyboard(final Activity activity, int viewId) {
        final View view = activity.findViewById(viewId);
        dismissKeyboard(view);
    }

    public static void dismissKeyboard(View view) {
        InputMethodManager keyboard = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            View f = activity.getCurrentFocus();
            if (null != f && null != f.getWindowToken() && EditText.class.isAssignableFrom(f.getClass()))
                imm.hideSoftInputFromWindow(f.getWindowToken(), 0);
            else
                activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        } catch (Exception ignored) {

        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void setUpTouchOutSideToHideKeyboard(final Activity activity, View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    KeyboardUtil.hideSoftKeyboard(activity);
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setUpTouchOutSideToHideKeyboard(activity, innerView);
            }
        }
    }

}
