package neo.vn.test365children.Activity.luyenthi;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.respon_api.ResponGetListLuyenthi;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 14:03
 * Version: 1.0
 */
public class PresenterLuyenthi implements InterfaceLuyenthi.Presenter {
    private static final String TAG = "PresenterLuyenthi";
    ApiServiceIml mApiService;
    InterfaceLuyenthi.View mView;

    public PresenterLuyenthi(InterfaceLuyenthi.View mView) {
        mApiService = new ApiServiceIml();
        this.mView = mView;
    }

    @Override
    public void api_get_list_luyenthi(String USER_MOTHER, String USER_CHILD) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "kit/get_list";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);


        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.api_show_error();
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    ResponGetListLuyenthi obj = new Gson().fromJson(objT, ResponGetListLuyenthi.class);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.api_show_list_luyenthi(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.api_show_error();
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_active_goiluyenthi(String USER_MOTHER, String USER_CHILD, String KIT_ID, String ACTIVE_CODE) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "kit/active";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("KIT_ID", KIT_ID);
        mMap.put("ACTIVE_CODE", ACTIVE_CODE);

        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.api_show_error();
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.api_show_active(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.api_show_error();
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_get_list_luyenthi_detail(String USER_MOTHER, String USER_CHILD,
                                             String KIT_ID, String EXCERCISE_LIST) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "kit/get_list_detail";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("KIT_ID", KIT_ID);
        mMap.put("EXCERCISE_LIST", EXCERCISE_LIST);

        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.api_show_error();
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    ResponDetailExer obj = new Gson().fromJson(objT, ResponDetailExer.class);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.api_show_list_detail(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.api_show_error();
                }
            }
        }, sService, mMap);
    }
}
