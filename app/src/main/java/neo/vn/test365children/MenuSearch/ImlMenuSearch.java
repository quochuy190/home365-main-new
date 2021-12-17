package neo.vn.test365children.MenuSearch;

import java.util.List;

import neo.vn.test365children.Models.City;
import neo.vn.test365children.Models.District;
import neo.vn.test365children.Models.Schools;


/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 7/11/2018
 * @updated 7/11/2018
 * @modified by
 * @updated on 7/11/2018
 * @since 1.0
 */
public interface ImlMenuSearch {
    interface Presenter {
        void api_get_list_district(String mUser, String mCityId);

        void api_get_list_city(String mUser);

        void api_get_list_schools(String mUser, String sDistrictId);

    }

    interface View {
        void show_get_api_error();

        void show_get_list_district(List<District> mList);

        void show_get_list_citys(List<City> mList);

        void show_get_list_schools(List<Schools> mList);
    }
}
