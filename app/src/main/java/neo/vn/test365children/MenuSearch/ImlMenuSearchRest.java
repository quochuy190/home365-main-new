package neo.vn.test365children.MenuSearch;


import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponGetDistrict;
import neo.vn.test365children.Models.respon_api.ResponGetProvince;
import neo.vn.test365children.Models.respon_api.ResponGetSchool;

public interface ImlMenuSearchRest {
    interface Presenter {
        void apirest_get_province(String USER_MOTHER, String USER_CHILD);

        void apirest_get_district(String USER_MOTHER, String USER_CHILD, String ID_PROVINCE);

        void apirest_get_school(String USER_MOTHER, String USER_CHILD, String ID_DISTRICT);


    }

    interface View {
        void show_error_api(ErrorApi obj);

        void show_get_list_district(ResponGetDistrict objRespon);

        void show_get_list_province(ResponGetProvince objRespon);

        void show_get_list_schools(ResponGetSchool objRespon);
    }
}
