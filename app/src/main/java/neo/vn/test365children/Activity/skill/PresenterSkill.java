package neo.vn.test365children.Activity.skill;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.respon_api.ResponGetUntilities;
import neo.vn.test365children.Models.respon_api.ResponListLessonSkill;

public class PresenterSkill implements InterfaceSkill.Presenter {
    private static final String TAG = "PresenterBaitap";
    ApiServiceIml mApiService;
    InterfaceSkill.View mView;

    public PresenterSkill(InterfaceSkill.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }


    @Override
    public void api_get_menu_skill(String sUserMother, String sUserKid) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_list_menu_skill";
        mMap.put("USER_MOTHER", sUserMother);
        mMap.put("USER_CHILD", sUserKid);
        mMap.put("LEVEL_ID", sUserKid);

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
                    ResponGetUntilities obj = new Gson().fromJson(objT, ResponGetUntilities.class);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.api_show_menu_skill(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.api_show_error();
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_get_list_lesson_skill(String sUserMother, String sUserKid, String id) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_list_lesson_skill";
        mMap.put("USER_MOTHER", sUserMother);
        mMap.put("USER_CHILD", sUserKid);
        mMap.put("SKILL_ID", id);

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
                    ResponListLessonSkill obj = new Gson().fromJson(objT, ResponListLessonSkill.class);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.api_show_list_lesson_skill(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.api_show_error();
                }
            }
        }, sService, mMap);
    }
}
