package neo.vn.test365children.Presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponGameTNNL;
import neo.vn.test365children.Models.ResponGetGameTPTT;

public class PresenterGame implements ImlGetGameTptt.Presenter {
    private static final String TAG = "PresenterBaitap";
    ApiServiceIml mApiService;
    ImlGetGameTptt.View mView;

    public PresenterGame(ImlGetGameTptt.View mView) {
        mApiService = new ApiServiceIml();
        this.mView = mView;
    }

    @Override
    public void api_get_game_tptt(String sUserMe, String sUserCon, String sDate) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_tptt";
        mMap.put("USER_MOTHER", sUserMe);
        mMap.put("USER_CHILD", sUserCon);
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
                    ResponGetGameTPTT obj = new Gson().fromJson(objT, ResponGetGameTPTT.class);
                    //List<GameTrieuPhuTriThuc> mLis = GameTrieuPhuTriThuc.getList(objT);
                    mView.show_get_game_tptt(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_start_tptt(String sUserMe, String sUserCon, String id_part) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "start_tptt";
     /*   mMap.put("Service", "start_tptt");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "3");*/
        mMap.put("USER_MOTHER", sUserMe);
        mMap.put("USER_CHILD", sUserCon);
        mMap.put("PART", id_part);
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
                    //  List<ErrorApi> mLis = ErrorApi.getList(objT);
                    ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                    mView.show_start_tptt(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_submit_tptt(String sUserMe, String sUserCon, String sId_part, String sTime, String sAward,
                                String sMonney) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "submit_tptt";
      /*  mMap.put("Service", "submit_tptt");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "6");*/
        mMap.put("USER_MOTHER", sUserMe);
        mMap.put("USER_CHILD", sUserCon);
        mMap.put("PART", sId_part);
        mMap.put("TIME", sTime);
        mMap.put("AWARD", sAward);
        mMap.put("WON", sMonney);

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
                    // List<ErrorApi> mLis = ErrorApi.getList(objT);
                    ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                    mView.show_submit_tptt(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_get_game_tnll(String sUserMe, String sUserCon) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "get_tnnl";
      /*  mMap.put("Service", "get_game_tnnl");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "2");*/
        mMap.put("USER_MOTHER", sUserMe);
        mMap.put("USER_CHILD", sUserCon);

        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);
                Log.i(TAG, "onGetDataErrorFault: " + e);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                /*String sDemo = "[{\"ERROR\":\"0000\",\"MESSAGE\":\"SUCCESS\",\"RESULT\":\"Lấy game Tính Nhanh Nhớ Lâu thành công\",\"EXCERCISE_ID\":\"441\",\"ID\":\"329\",\"PART_ID\":\"935\",\"HTML_A\":\"4 + 1::5\",\"HTML_B\":\"1 + 2::3\",\"HTML_C\":\"0 + 4::4\",\"HTML_D\":\"1 + 1::2\"},{\"ERROR\":\"0000\",\"MESSAGE\":\"SUCCESS\",\"RESULT\":\"Lấy game Tính Nhanh Nhớ Lâu thành công\",\"EXCERCISE_ID\":\"442\",\"ID\":\"339\",\"PART_ID\":\"939\",\"HTML_A\":\"2 + 1::3\",\"HTML_B\":\"3 + 2::5\",\"HTML_C\":\"1 + 3:: 4\",\"HTML_D\":\"2 + 0::2\"},{\"ERROR\":\"0000\",\"MESSAGE\":\"SUCCESS\",\"RESULT\":\"Lấy game Tính Nhanh Nhớ Lâu thành công\",\"EXCERCISE_ID\":\"286\",\"ID\":\"229\",\"PART_ID\":\"775\",\"HTML_A\":\"3, 2, ......::1\",\"HTML_B\":\"4, ......, 2, 1::3\",\"HTML_C\":\"4, 3, ......, 1::2\",\"HTML_D\":\"5,....., 3::4\"}]";
                Log.i(TAG, "onGetDataSuccess: " + objT);*/
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    //List<GameTNNL> mLis = GameTNNL.getList(objT);
                    ResponGameTNNL obj = new Gson().fromJson(objT, ResponGameTNNL.class);
                    mView.show_get_game_tnnl(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, sService, mMap);
    }

    @Override
    public void api_submit_game_tnnl(String sUserMe, String sUserCon, String sMonney) {
        Map<String, String> mMap = new LinkedHashMap<>();
        String sService = "submit_tnnl";
      /*  mMap.put("Service", "submit_game_tnnl");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "3");*/
        mMap.put("USER_MOTHER", sUserMe);
        mMap.put("USER_CHILD", sUserCon);
        mMap.put("MONEY", sMonney);


        mApiService.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                ErrorApi obj = new ErrorApi();
                obj.setsERROR("submit_tnnl");
                mView.show_error_api(obj);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    //jArray = new JSONArray(c);
                    ErrorApi obj = new Gson().fromJson(objT, ErrorApi.class);
                    mView.show_submit_game_tnnl(obj);
                } catch (Exception e) {
                    ErrorApi obj = new ErrorApi();
                    obj.setsERROR("submit_tnnl");
                    mView.show_error_api(obj);
                    e.printStackTrace();
                }
            }
        }, sService, mMap);
    }
}
