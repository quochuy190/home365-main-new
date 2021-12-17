package neo.vn.test365children.Activity.login;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.respon_api.ResponInitChil;


/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 7/31/2018
 * @updated 7/31/2018
 * @modified by
 * @updated on 7/31/2018
 * @since 1.0
 */
public class PresenterLoginNew implements ImlLoginNew.Presenter {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;
    ImlLoginNew.View mView;

    public PresenterLoginNew(ImlLoginNew.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }


    @Override
    public void api_login_ma_hs(String USER_CHILD) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "login_child2";
        mMap.put("USER_CHILD", USER_CHILD);

        mApiService.getApiPostResfull(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                ResponInitChil objLogin = new Gson().fromJson(objT, ResponInitChil.class);
                mView.show_api_login(objLogin);
            }
        }, sService, mMap);
    }
}
