package neo.vn.test365children.ApiService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import neo.vn.test365children.Listener.CallbackData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @description
 * @authour: $User
 * @createdate $Date
 */
public class ApiServicePostIml {
  ApiSevicePost apiService;
  public void getApiService(final CallbackData<String> callbackData, Map<String, String> mData) {
    apiService = ApiSevicePost.retrofit.create(ApiSevicePost.class);
    Call<ResponseBody> getApiservice = apiService.getApiService( mData);
    getApiservice.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        String jsonString = null;
        JSONObject jobj;
        JSONArray jArray;
        try {
          if (response.body()!=null){
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
}
