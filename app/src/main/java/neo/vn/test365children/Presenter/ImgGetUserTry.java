package neo.vn.test365children.Presenter;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.list_child.DataChild;
import neo.vn.test365children.Models.list_child.ResponseCreateChild;

public interface ImgGetUserTry {
    interface Presenter {
        void api_create_user_try(String sLevel, String sUUID);

        void apiGetListChildrem(String userMother,String userChild);

        void apiCreateChild(String userMother, String idLevel);
    }

    interface View {
        void show_create_user_try(ObjLogin obj);

        void show_error_api(ErrorApi objError);

        void showDataUserChild(DataChild dataChild);

        void showResposeCreateChild(ResponseCreateChild responseCreateChild);
    }
}
