package neo.vn.test365children.Presenter;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponInitChil;

public interface Iml_init {
    interface Presenter {
        void api_init(String APP_VERSION, String DEVICE_MODEL,
                      String TOKEN_KEY, String DEVICE_TYPE, String OS_VERSION, String UUID);

        void api_update_info_chil(String USER_MOTHER, String USER_CHILD, String ID_SCHOOL, String ID_LEVEL,
                                  String CLASS, String ID_YEAR, String CHILD_NAME, String CHILD_PASS,
                                  String LINK_AVATAR, String MOBILE, String EMAIL);

        void api_update_info_chil_2(String USER_MOTHER, String USER_CHILD, String ID_SCHOOL, String ID_LEVEL,
                                    String CLASS, String ID_YEAR, String CHILD_NAME, String CHILD_PASS,
                                    String LINK_AVATAR, String MOBILE, String EMAIL, String ISUPDATE);

        void api_update_child_device(String USER_MOTHER, String USER_CHILD, String APP_VERSION, String DEVICE_MODEL,
                                     String TOKEN_KEY, String DEVICE_TYPE, String OS_VERSION);
    }

    interface View {
        void show_init(ResponInitChil mLis);

        void show_error_api(ErrorApi mLis);

        void show_update_infor_child(ErrorApi mLis);

        void show_update_infor_child_2(ErrorApi mLis);
    }
}
