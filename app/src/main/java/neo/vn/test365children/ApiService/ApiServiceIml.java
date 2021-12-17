package neo.vn.test365children.ApiService;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Untils.SharedPrefs;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @description
 * @authour: $User
 * @createdate $Date
 */
public class ApiServiceIml {
    private static final String TAG = "ApiServiceIml";
    ApiSevicePost apiServicePost;
    ApiSevice apiService;
    ApiSeviceLogin apiServiceLogin;
    ApiSevicePostResfull apiRestful;
    ApiSevicePostResfullAll apiRestFul_All;
    ApiSevice_Init api_init;

    public void getApiService(final CallbackData<String> callbackData, Map<String, String> mData) {
        String sUrl = SharedPrefs.getInstance().get(Constants.KEY_URL_BASE, String.class);
        if (sUrl != null && sUrl.length() > 0)
            Config.BASE_URL = sUrl;

        apiService = ApiSevice.retrofit.create(ApiSevice.class);
        String dataPost = new Gson().toJson(mData);
        Log.d("dataPost", dataPost);
        Call<ResponseBody> getApiservice = apiService.getApiService(mData);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                        jobj = new JSONObject(jsonString);
                        String c = jobj.getString("return");
                        /*jsonString = jsonString.replaceAll("\\\\", "");
                        jsonString = jsonString.substring(11, jsonString.length() - 2);*/
                        callbackData.onGetDataSuccess(c);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }

    public void getApiServicePost(final CallbackData<String> callbackData, Map<String, String> mData) {
        apiServicePost = ApiSevicePost.retrofit.create(ApiSevicePost.class);
        Call<ResponseBody> getApiservice = apiServicePost.getApiService(mData);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                      /*  jobj = new JSONObject(jsonString);
                        String c = jobj.getString("return");*/
                        callbackData.onGetDataSuccess(jsonString);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }

    public void getApiServiceLogin(final CallbackData<String> callbackData, Map<String, String> mData) {
        apiServiceLogin = ApiSeviceLogin.retrofit2.create(ApiSeviceLogin.class);
        Call<ResponseBody> getApiservice = apiServiceLogin.getApiService(mData);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                        jobj = new JSONObject(jsonString);
                        String c = jobj.getString("return");
                        /*jsonString = jsonString.replaceAll("\\\\", "");
                        jsonString = jsonString.substring(11, jsonString.length() - 2);*/
                        callbackData.onGetDataSuccess(c);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }

    public void getApiPostResfull(final CallbackData<String> callbackData, String sService,
                                  Map<String, String> mData) {
        apiRestful = ApiSevicePostResfull.retrofit_restful.create(ApiSevicePostResfull.class);
        Call<ResponseBody> getApiservice = apiRestful.getApiServiceRest(sService, mData);
        String dataPost = new Gson().toJson(mData);
        Log.d("dataPost", sService +"/ "+ dataPost);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                      /*  jobj = new JSONObject(jsonString);
                        String c = jobj.getString("return");*/
                        callbackData.onGetDataSuccess(jsonString);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (Exception e) {
                    callbackData.onGetDataErrorFault(e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }

    public void getApiPostResfull_ALL(final CallbackData<String> callbackData, String sService,
                                      Map<String, String> mData) {
        String sToken = "";
        ObjLogin objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_CHIL, ObjLogin.class);
        if (objLogin != null && objLogin.getsTOKEN() != null) {
            sToken = objLogin.getsTOKEN();
        }
        String dataPost = new Gson().toJson(mData);
        Log.d("dataPost", sService +"/ "+ dataPost);
        apiRestFul_All = ApiSevicePostResfullAll.retrofit_restful_all.create(ApiSevicePostResfullAll.class);
        Call<ResponseBody> getApiservice = apiRestFul_All.getApiServiceRest("Bearer " + sToken, sService, mData);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                      /*  jobj = new JSONObject(jsonString);
                        String c = jobj.getString("return");*/
                        callbackData.onGetDataSuccess(jsonString);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (Exception e) {
                    callbackData.onGetDataErrorFault(e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }

    public void getApi_Init(final CallbackData<String> callbackData, String sService,
                            Map<String, String> mData) {
        api_init = ApiSevice_Init.retrofit_restful.create(ApiSevice_Init.class);
        Call<ResponseBody> getApiservice = api_init.getApiServiceRest(sService, mData);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                      /*  jobj = new JSONObject(jsonString);
                        String c = jobj.getString("return");*/
                        callbackData.onGetDataSuccess(jsonString);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (Exception e) {
                    callbackData.onGetDataErrorFault(e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }
}
