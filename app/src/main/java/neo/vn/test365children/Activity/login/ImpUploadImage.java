package neo.vn.test365children.Activity.login;

import java.util.List;

import neo.vn.test365children.Models.ErrorApi;

public interface ImpUploadImage {
    interface Presenter {
        void api_upload_image(String part);
    }

    interface View {
        void show_error_api_uploadimage(List<ErrorApi> mLis);

        void show_upload_image(String sUrlImage);
    }
}
