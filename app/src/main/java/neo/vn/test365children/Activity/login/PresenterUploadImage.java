package neo.vn.test365children.Activity.login;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import neo.vn.test365children.ApiService.ApiServicePostImage;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ErrorApi;


public class PresenterUploadImage implements ImpUploadImage.Presenter {
    private static final String TAG = "PresenterUploadImage";
    ApiServicePostImage mApiService;
    ImpUploadImage.View mView;

    public PresenterUploadImage(ImpUploadImage.View mView) {
        mApiService = new ApiServicePostImage();
        this.mView = mView;
    }

    @Override
    public void api_upload_image(String part) {
        mApiService.api_uploadImage(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                ErrorApi obj = new ErrorApi();
                obj.setsERROR("IMAGE");
                List<ErrorApi> mLis = new ArrayList<>();
                mLis.add(obj);
                mView.show_error_api_uploadimage(mLis);
            }

            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
                try {
                    mView.show_upload_image(objT);
                } catch (Exception e) {
                    e.printStackTrace();
                    mView.show_error_api_uploadimage(null);
                    Log.i(TAG, "Log_error_api_filght: " + e);
                }
            }
        }, part);
    }
}
