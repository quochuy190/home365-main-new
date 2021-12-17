package neo.vn.test365children.ApiService;


import java.util.concurrent.TimeUnit;

import neo.vn.test365children.Config.Config;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Untils.SharedPrefs;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by QQ on 7/4/2017.
 */

public interface ApiSeviceUploadImage {
    String sURL = SharedPrefs.getInstance().get(Constants.KEY_URL_MEDIA, String.class);
    //Log info action user
    @Multipart
    @POST("/ImageUpload")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file);

    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(new ApiExceptionInterceptor().getHttpLoging())
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            //.baseUrl(sURL)
            .baseUrl(Config.BASE_URL_IMAGE_UPLOAD)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

}
