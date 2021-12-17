package neo.vn.test365children.Presenter;

import android.util.Log;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class PresenterStartGameSudoku implements Iml_Start_Game_Sudoku.Presenter {
    private static final String TAG = "PresenterLogin";
    ApiServiceIml mApiService;


    public PresenterStartGameSudoku() {
        mApiService = new ApiServiceIml();
    }


    @Override
    public void api_start_game_sudoku(String USER_MOTHER, String USER_CHIL, String TIME) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "start_game_sudoku";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHIL);
        mMap.put("TIME", TIME);

        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                    // mView.show_error_api(null);
                }
            }
        }, sService, mMap);
    }
}
