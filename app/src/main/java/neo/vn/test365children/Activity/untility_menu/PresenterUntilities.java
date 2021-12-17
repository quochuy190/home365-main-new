package neo.vn.test365children.Activity.untility_menu;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.respon_api.ResponGetUntilities;

public class PresenterUntilities implements Iml_Untilities.Presenter {
    private static final String TAG = "PresenterBaitap";
    ApiServiceIml mApiService;
    Iml_Untilities.View mView;

    public PresenterUntilities(Iml_Untilities.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }

    @Override
    public void api_get_untilities(String USER_MOTHER, String USER_CHILD) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_utilities";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);


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
                    ResponGetUntilities obj = new Gson().fromJson(objT, ResponGetUntilities.class);
                    //   List<Baitap_Tuan> mLis = Baitap_Tuan.getList(objT);
                    mView.show_get_untilities(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                }
            }
        }, sService, mMap);
    }
}
