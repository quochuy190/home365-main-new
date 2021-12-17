package neo.vn.test365children.Presenter;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.vip.ObjLoginVip;

public interface ImlLogin {
    interface Presenter {
        void api_login(String sUserMe, String sUserCon, String sPass, String sVersion, String sDeviceModel,
                       String sDevice_type, String sOsVersion, String sTokenKey);

        void api_update_info_chil(String sUserMother,String sUserKid, String APP_VERSION, String DEVICE_MODEL,
                                  String TOKEN_KEY, String DEVICE_TYPE, String OS_VERSION);
    }

    interface View {
        void show_api_login(ObjLogin mLis);

        void show_update_infochil(ErrorApi obj);

        void show_error_api(ErrorApi mLis);

        void show_api_login_Vip(ObjLoginVip loginVip);
    }
}
