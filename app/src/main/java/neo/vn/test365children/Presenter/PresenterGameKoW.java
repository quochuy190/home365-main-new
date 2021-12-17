package neo.vn.test365children.Presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ResponDetailKow;
import neo.vn.test365children.Models.ResponGetTopicKow;

public class PresenterGameKoW implements ImlGameKoW.Presenter {
    private static final String TAG = "PresenterGameKoW";
    ApiServiceIml mApiService;
    ImlGameKoW.View mView;

    public PresenterGameKoW(ImlGameKoW.View mView) {
        mApiService = new ApiServiceIml();
        this.mView = mView;
    }

    @Override
    public void api_get_list_topic_kow(String sUserMother, String sUserKid) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_list_kow";
        mMap.put("USER_MOTHER", sUserMother);
        mMap.put("USER_CHILD", sUserKid);
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
                    ResponGetTopicKow obj = new Gson().fromJson(objT, ResponGetTopicKow.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_list_topic(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_get_detail_kow(String sUserMother, String sUserKid, String sIdTopic) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_detail_kow";
        mMap.put("USER_MOTHER", sUserMother);
        mMap.put("USER_CHILD", sUserKid);
        mMap.put("CLASS_ID", sIdTopic);
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
                    ResponDetailKow obj = new Gson().fromJson(objT, ResponDetailKow.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_list_detail_kow(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }
}
