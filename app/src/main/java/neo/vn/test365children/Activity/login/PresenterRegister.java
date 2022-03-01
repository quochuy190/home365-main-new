package neo.vn.test365children.Activity.login;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.BuildConfig;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.respon_api.ResponInitChil;
import neo.vn.test365children.Models.respon_api.ResponRegister;
import neo.vn.test365children.Untils.SharedPrefs;


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
public class PresenterRegister {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;
    PresenterRegister.View mView;

    public PresenterRegister(PresenterRegister.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }


    interface View {
        void onHideProgressDialog();
        void onShowProgressDialog();
        void showErrorRegister(String error);
        void showSuccessRegister();
    }

    public void apiRegister(String fullName, String phone, String pass, String uuid) {

        final Map<String, String> mMap = new LinkedHashMap<>();
        String sTokenkey = SharedPrefs.getInstance().get(Constants.KEY_TOKEN, String.class);
        String sService = "child/init";
        mMap.put("FULL_NAME", fullName);
        mMap.put("PHONE", phone);
        mMap.put("PASSWORD", pass);
        mMap.put("CONFIRM_PASSWORD", pass);
        mMap.put("APP_VERSION", BuildConfig.VERSION_NAME);
        mMap.put("DEVICE_MODEL",  android.os.Build.BRAND + " " + android.os.Build.MODEL);
        mMap.put("DEVICE_TYPE", "2");
        mMap.put("OS_VERSION", android.os.Build.VERSION.RELEASE);
        mMap.put("TOKEN_KEY", sTokenkey);
        mMap.put("UUID", uuid);
        mView.onShowProgressDialog();
        mApiService.getApiPostResfull(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
               // mView.show_error_api(null);
                mView.onHideProgressDialog();
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                mView.onHideProgressDialog();
                ResponRegister resData = new Gson().fromJson(objT, ResponRegister.class);
                if (resData.getError().equals("0000")){

                    mView.showSuccessRegister();
                }else {
                    mView.showErrorRegister(resData.getMessage());
                }
               // mView.show_api_login(objLogin);
            }
        }, sService, mMap);
    }
}
