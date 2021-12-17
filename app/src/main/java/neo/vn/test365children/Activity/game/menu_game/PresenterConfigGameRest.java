package neo.vn.test365children.Activity.game.menu_game;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.respon_api.ResponConfigGame;


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
public class PresenterConfigGameRest implements ImlConfigGameRest.Presenter {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;
    ImlConfigGameRest.View mView;

    public PresenterConfigGameRest(ImlConfigGameRest.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }

    @Override
    public void apirest_get_config_game(String USER_MOTHER, String USER_CHILD) {
        final Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_game_children";
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
                ResponConfigGame objLogin = new Gson().fromJson(objT, ResponConfigGame.class);
                Log.i(TAG, "onGetDataSuccess: " + objLogin);
                mView.show_get_config_game(objLogin);
            }
        }, sService, mMap);
    }
}
