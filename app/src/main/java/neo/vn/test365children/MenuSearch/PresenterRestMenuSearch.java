package neo.vn.test365children.MenuSearch;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.respon_api.ResponGetDistrict;
import neo.vn.test365children.Models.respon_api.ResponGetProvince;
import neo.vn.test365children.Models.respon_api.ResponGetSchool;


/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 7/11/2018
 * @updated 7/11/2018
 * @modified by
 * @updated on 7/11/2018
 * @since 1.0
 */
public class PresenterRestMenuSearch implements ImlMenuSearchRest.Presenter {
    private static final String TAG = "PresenterMenuSearch";
    ApiServiceIml mApiService;
    ImlMenuSearchRest.View mView;

    public PresenterRestMenuSearch(ImlMenuSearchRest.View view) {
        mApiService = new ApiServiceIml();
        this.mView = view;
    }

    @Override
    public void apirest_get_province(String USER_MOTHER, String USER_CHILD) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_province";
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
                    ResponGetProvince obj = new Gson().fromJson(objT, ResponGetProvince.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_get_list_province(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void apirest_get_district(String USER_MOTHER, String USER_CHILD, String ID_PROVINCE) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_district";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("ID_PROVINCE", ID_PROVINCE);
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
                    ResponGetDistrict obj = new Gson().fromJson(objT, ResponGetDistrict.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_get_list_district(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void apirest_get_school(String USER_MOTHER, String USER_CHILD, String ID_DISTRICT) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_school";
        mMap.put("USER_MOTHER", USER_MOTHER);
        mMap.put("USER_CHILD", USER_CHILD);
        mMap.put("ID_DISTRICT", ID_DISTRICT);

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
                    ResponGetSchool obj = new Gson().fromJson(objT, ResponGetSchool.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_get_list_schools(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }
}
