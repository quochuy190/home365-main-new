package neo.vn.test365children.Activity.login;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponInitChil;

public interface ImlLoginNew {
    interface Presenter {
        void api_login_ma_hs(String USER_CHILD);

    }

    interface View {
        void show_api_login(ResponInitChil mLis);

        void show_error_api(ErrorApi mLis);
    }
}
