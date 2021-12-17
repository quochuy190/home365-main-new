package neo.vn.test365children.Presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponInitChil;
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
public class Presenter_Init_Login implements Iml_init.Presenter {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;
    Iml_init.View mView;

    public Presenter_Init_Login(Iml_init.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }


    @Override
    public void api_init(String APP_VERSION, String DEVICE_MODEL, String TOKEN_KEY, String DEVICE_TYPE,
                         String OS_VERSION, String UUID) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "init";
        mMap.put("APP_VERSION", APP_VERSION);
        mMap.put("DEVICE_MODEL", DEVICE_MODEL);
        mMap.put("TOKEN_KEY", TOKEN_KEY);
        mMap.put("DEVICE_TYPE", DEVICE_TYPE);
        mMap.put("OS_VERSION", OS_VERSION);
        mMap.put("UUID", UUID);
        mApiService.getApi_Init(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                ResponInitChil objLogin = new Gson().fromJson(objT, ResponInitChil.class);
                mView.show_init(objLogin);
            }
        }, sService, mMap);
    }

    @Override
    public void api_update_info_chil(String USER_MOTHER, String USER_CHILD, String ID_SCHOOL, String ID_LEVEL,
                                     String CLASS, String ID_YEAR, String CHILD_NAME, String CHILD_PASS,
                                     String LINK_AVATAR, String MOBILE, String EMAIL) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "update_info";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("ID_SCHOOL", ID_SCHOOL);
        mMap.put("ID_LEVEL", ID_LEVEL);
        mMap.put("CLASS", CLASS);
        mMap.put("ID_YEAR", ID_YEAR);
        mMap.put("CHILD_NAME", CHILD_NAME);
        mMap.put("CHILD_PASS", CHILD_PASS);
        mMap.put("LINK_AVATAR", LINK_AVATAR);
        mMap.put("MOBILE", MOBILE);
        mMap.put("EMAIL", EMAIL);
        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                    Log.i(TAG, "onGetDataSuccess: " + obj);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.show_update_infor_child(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    // mView.show_error_api(null);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_update_info_chil_2(String USER_MOTHER, String USER_CHILD, String ID_SCHOOL, String ID_LEVEL,
                                       String CLASS, String ID_YEAR, String CHILD_NAME, String CHILD_PASS, String
                                               LINK_AVATAR, String MOBILE, String EMAIL, String ISUPDATE) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "update_info2";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("ID_SCHOOL", ID_SCHOOL);
        mMap.put("ID_LEVEL", ID_LEVEL);
        mMap.put("CLASS", CLASS);
        mMap.put("ID_YEAR", ID_YEAR);
        mMap.put("CHILD_NAME", CHILD_NAME);
        mMap.put("CHILD_PASS", CHILD_PASS);
        mMap.put("LINK_AVATAR", LINK_AVATAR);
        mMap.put("MOBILE", MOBILE);
        mMap.put("EMAIL", EMAIL);
        mMap.put("ISUPDATE", ISUPDATE);
        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                    Log.i(TAG, "onGetDataSuccess: " + obj);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.show_update_infor_child(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    // mView.show_error_api(null);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_update_child_device(String USER_MOTHER, String USER_CHILD, String APP_VERSION, String DEVICE_MODEL,
                                        String TOKEN_KEY, String DEVICE_TYPE, String OS_VERSION) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "update_child_device";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("APP_VERSION", APP_VERSION);
        mMap.put("DEVICE_MODEL", DEVICE_MODEL);
        mMap.put("TOKEN_KEY", TOKEN_KEY);
        mMap.put("DEVICE_TYPE", DEVICE_TYPE);
        mMap.put("OS_VERSION", OS_VERSION);

        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.e(TAG, "onGetDataSuccess: " + objT);
                ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                if (obj.getsERROR().equals("0000")) {
                    SharedPrefs.getInstance().put(Constants.KEY_UPDATE_TOKEN, true);
                }
            }
        }, sService, mMap);
    }
}
