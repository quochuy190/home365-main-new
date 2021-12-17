package neo.vn.test365children.Presenter;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.DesExercises;

public class PresenterExeDetail implements ImlExerDetail.Presenter {
    private static final String TAG = "PresenterExeDetail";
    ApiServiceIml mApiService;
    ImlExerDetail.View mView;

    public PresenterExeDetail(ImlExerDetail.View mView) {
        this.mView = mView;
        mApiService = new ApiServiceIml();
    }

    @Override
    public void api_get_des_exercises(String sUserMe, String sUserCon, String sIdDe) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "des_excercise");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "3");
        mMap.put("P1", sUserMe);
        mMap.put("P2", sUserCon);
        mMap.put("P3", sIdDe);

        mApiService.getApiService(new CallbackData<String>() {
            JSONObject jobj;
            JSONArray jArray;

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
                    List<DesExercises> mLis = DesExercises.getList(objT);
                    mView.show_des_exercises(mLis);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, mMap);
    }

    @Override
    public void api_get_report_exercises(String sUserMe, String sUserCon, String sIdDe) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "report_excercise");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "3");
        mMap.put("P1", sUserMe);
        mMap.put("P2", sUserCon);
        mMap.put("P3", sIdDe);

        mApiService.getApiService(new CallbackData<String>() {
            JSONObject jobj;
            JSONArray jArray;

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
                    List<DesExercises> mLis = DesExercises.getList(objT);
                    mView.show_report_exercises(mLis);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, mMap);
    }
}
