package neo.vn.test365children.Activity.luyenthi;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.respon_api.ResponGetListLuyenthi;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 11:23
 * Version: 1.0
 */
public interface InterfaceLuyenthi {
    interface Presenter {
        void api_get_list_luyenthi(String USER_MOTHER, String USER_CHILD);

        void api_active_goiluyenthi(String USER_MOTHER, String USER_CHILD, String KIT_ID, String ACTIVE_CODE);

        void api_get_list_luyenthi_detail(String USER_MOTHER, String USER_CHILD, String KIT_ID, String EXCERCISE_LIST);
    }

    interface View {
        void api_show_list_luyenthi(ResponGetListLuyenthi objRest);

        void api_show_list_detail(ResponDetailExer objRest);

        void api_show_active(ErrorApi objError);

        void api_show_error();
    }
}
