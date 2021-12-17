package neo.vn.test365children.Models.respon_api;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.Activity.untility_menu.Iml_Untilities;
import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;


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
public class PresenterGetUntilities implements Iml_Untilities.Presenter {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;
    Iml_Untilities.View mView;

    public PresenterGetUntilities( Iml_Untilities.View mView) {
        mApiService = new ApiServiceIml();
        this.mView = mView;
    }

    @Override
    public void api_get_untilities(String USER_MOTHER, String USER_CHILD) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "start_game_sudoku";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);

        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    ResponGetUntilities obj = new Gson().fromJson(objT, ResponGetUntilities.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_get_untilities(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    // mView.show_error_api(null);
                }
            }
        }, sService, mMap);
    }
}
