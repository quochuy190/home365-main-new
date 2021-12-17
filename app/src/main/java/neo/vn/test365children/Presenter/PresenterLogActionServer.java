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
public class PresenterLogActionServer implements Iml_Log_Server.Presenter {
    private static final String TAG = "PresenterLogActionServer";
    ApiServiceIml mApiService;


    public PresenterLogActionServer() {
        mApiService = new ApiServiceIml();
    }


    @Override
    public void api_log_action_server(String USER_MOTHER, String USER_CHILD, String ACTION, String DESCRIPTION) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "log_toserver";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("ACTION", ACTION);
        mMap.put("DESCRIPTION", DESCRIPTION);

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

    @Override
    public void api_log_web_lesson_skill(String USER_MOTHER, String USER_CHILD, String ACTION, String SKILL_ID) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "ud_status_lesson";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("ACTION", ACTION);
        mMap.put("SKILL_ID", SKILL_ID);

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
