package neo.vn.test365children.Activity.skill;

import neo.vn.test365children.Models.ErrorApi;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 07-May-2019
 * Time: 22:52
 * Version: 1.0
 */
public interface InterfaceGetStatusTiengAnh123 {
    interface Presenter{
        void api_get_status_tienganh123(String sUserMother, String sUserKid, String ID_COURSE);
    }
    interface View{
        void api_show_error();

        void api_show_status(ErrorApi obj);
    }
}
