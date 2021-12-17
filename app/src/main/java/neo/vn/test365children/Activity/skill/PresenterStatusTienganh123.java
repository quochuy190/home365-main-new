package neo.vn.test365children.Activity.skill;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ErrorApi;

public class PresenterStatusTienganh123 implements InterfaceGetStatusTiengAnh123.Presenter {
    private static final String TAG = "PresenterBaitap";
    ApiServiceIml mApiService;
    InterfaceGetStatusTiengAnh123.View mView;

    public PresenterStatusTienganh123(InterfaceGetStatusTiengAnh123.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }

    @Override
    public void api_get_status_tienganh123(String sUserMother, String sUserKid, String ID_COURSE) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_list_lesson_skill";
        mMap.put("USER_MOTHER", sUserMother);
        mMap.put("USER_CHILD", sUserKid);
        mMap.put("SKILL_ID", ID_COURSE);

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
                    mView.api_show_status(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.api_show_error();
                }
            }
        }, sService, mMap);
    }
}
