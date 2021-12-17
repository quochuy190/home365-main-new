package neo.vn.test365children.ApiService;

import okhttp3.logging.HttpLoggingInterceptor;

public class ApiExceptionInterceptor {

    public HttpLoggingInterceptor getHttpLoging(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
