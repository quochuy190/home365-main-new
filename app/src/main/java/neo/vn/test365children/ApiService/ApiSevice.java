package neo.vn.test365children.ApiService;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Untils.SharedPrefs;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by QQ on 7/4/2017.
 */

public interface ApiSevice {
    String sUrl = SharedPrefs.getInstance().get(Constants.KEY_URL_BASE, String.class);
    //Log info action user
    @GET("365/services/SqlServices/ref?response=application/json")
    Call<ResponseBody> getApiService(@QueryMap Map<String, String> data);
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(new ApiExceptionInterceptor().getHttpLoging())
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

}
