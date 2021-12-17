package neo.vn.test365children.Service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Untils.SharedPrefs;

/**
 * Created by QQ on 8/29/2017.
 */

public class MyFirebaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseIDService";
    String mToken;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        mToken = FirebaseInstanceId.getInstance().getToken();
        if (mToken != null) {
            Log.e("sToken", "onTokenRefresh: "+mToken);
            // SharedPrefs.getInstance().put(Constants.KEY_TOKEN, mToken);
            SharedPrefs.getInstance().put(Constants.KEY_TOKEN, mToken);
            SharedPrefs.getInstance().put(Constants.KEY_ISTOKEN, true);
        }
    }

}