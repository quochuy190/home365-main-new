package neo.vn.test365children.Presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.vip.ObjLoginVip;


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
public class PresenterLogin implements ImlLogin.Presenter {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;
    ImlLogin.View mView;

    public PresenterLogin(ImlLogin.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }


    @Override
    public void api_login(String sUserMe, String sUserCon, String sPass, String sVersion,
                          String sDeviceModel, String sDevice_type, String sOsVersion, String sTokenKey) {
        /*Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "login_children");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "8");
        mMap.put("P1", sUserMe);
        mMap.put("P2", sUserCon);
        mMap.put("P3", sPass);
        mMap.put("P4", sVersion);
        mMap.put("P5", sDeviceModel);
        mMap.put("P6", sDevice_type);
        mMap.put("P7", sOsVersion);
        mMap.put("P8", sTokenKey);

        mApiService.getApiServiceLogin(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    List<ObjLogin> mLis = ObjLogin.getList(objT);
                    mView.show_api_login(mLis);
                } catch (JSONException e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, mMap);*/
    }

    @Override
    public void api_update_info_chil(String sUserMother, String sUserKid, String APP_VERSION, String DEVICE_MODEL,
                                     String TOKEN_KEY, String DEVICE_TYPE, String OS_VERSION) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "update_child_device";
        mMap.put("USER_MOTHER", sUserMother);
        mMap.put("USER_CHILD", sUserKid);
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
                Log.i(TAG, "onGetDataSuccess: " + objT);
                ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                mView.show_update_infochil(obj);
            }
        }, sService, mMap);
    }

    public void api_login_restful(String sUserMe, String sUserCon, String sPass) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "login_child";
        mMap.put("USER_MOTHER", sUserMe);
        mMap.put("USER_CHILD", sUserCon);
        mMap.put("PASSWORD", sPass);
        mApiService.getApiPostResfull(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                ObjLogin objLogin = new Gson().fromJson(objT, ObjLogin.class);
                mView.show_api_login(objLogin);
            }
        }, sService, mMap);
    }

    public void apiLoginVip(String phone, String password, String idParent, String codeStudent) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "serviceLogin";
        mMap.put("MSISDN", phone);
        mMap.put("PASSWORD", password);
        mApiService.getApiPostResfull(new CallbackData<String>() {
            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                ObjLoginVip objLoginVip = new Gson().fromJson(objT, ObjLoginVip.class);
                mView.show_api_login_Vip(objLoginVip);
            }

            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }
        }, sService, mMap);
    }
}
