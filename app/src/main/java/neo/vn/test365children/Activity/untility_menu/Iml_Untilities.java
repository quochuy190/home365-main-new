package neo.vn.test365children.Activity.untility_menu;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponGetUntilities;

public interface Iml_Untilities {
    interface Presenter {
        void api_get_untilities(String USER_MOTHER, String USER_CHILD);

    }

    interface View {

        void show_error_api(ErrorApi mLis);

        void show_get_untilities(ResponGetUntilities mLis);
    }
}
