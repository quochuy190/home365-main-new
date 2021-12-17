package neo.vn.test365children.MenuSearch;

import android.util.Log;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.City;
import neo.vn.test365children.Models.District;
import neo.vn.test365children.Models.Schools;


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
public class PresenterMenuSearch implements ImlMenuSearch.Presenter {
    private static final String TAG = "PresenterMenuSearch";
    ApiServiceIml mApiService;
    ImlMenuSearch.View view;

    public PresenterMenuSearch(ImlMenuSearch.View view) {
        mApiService = new ApiServiceIml();
        this.view = view;
    }

    @Override
    public void api_get_list_district(String mUserId, String mCityId) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "getquan");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "2");
        mMap.put("P1", mUserId);
        mMap.put("P2", mCityId);


        mApiService.getApiService(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                view.show_get_api_error();
                Log.i(TAG, "onGetDataErrorFault: " + e.getMessage());
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    List<District> mLisFlight = District.getList(objT);
                    if (mLisFlight.size() > 0 && mLisFlight.get(0).getsERROR().equals("0000")) {
                        view.show_get_list_district(mLisFlight);
                    } else {
                        view.show_get_list_district(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    view.show_get_api_error();
                    Log.i(TAG, "Log_error_api_filght: " + e.getMessage());
                }
            }
        }, mMap);
    }

    @Override
    public void api_get_list_city(String mUser) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "gettinh");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "1");
        mMap.put("P1", mUser);

        mApiService.getApiService(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                view.show_get_api_error();
                Log.i(TAG, "onGetDataErrorFault: " + e.getMessage());
            }
            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    List<City> mLisFlight = City.getList(objT);
                    if (mLisFlight.size() > 0 && mLisFlight.get(0).getsERROR().equals("0000")) {
                        view.show_get_list_citys(mLisFlight);
                    } else {
                        view.show_get_list_district(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    view.show_get_api_error();
                    Log.i(TAG, "Log_error_api_filght: " + e.getMessage());
                }
            }
        }, mMap);
    }

    @Override
    public void api_get_list_schools(String mUser, String sDistrictId) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "getschool");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "2");
        mMap.put("P1", mUser);
        mMap.put("P2", sDistrictId);

        mApiService.getApiService(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                view.show_get_api_error();
                Log.i(TAG, "onGetDataErrorFault: " + e.getMessage());
            }
            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    List<Schools> mLisFlight = Schools.getList(objT);
                    if (mLisFlight.size() > 0 && mLisFlight.get(0).getsERROR().equals("0000")) {
                        view.show_get_list_schools(mLisFlight);
                    } else {
                        view.show_get_list_district(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    view.show_get_api_error();
                    Log.i(TAG, "Log_error_api_filght: " + e.getMessage());
                }
            }
        }, mMap);
    }

}
