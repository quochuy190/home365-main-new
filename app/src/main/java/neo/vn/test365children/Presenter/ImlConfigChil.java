package neo.vn.test365children.Presenter;

import java.util.List;

import neo.vn.test365children.Models.ConfigChildren;
import neo.vn.test365children.Models.ErrorApi;

public interface ImlConfigChil {
    interface Presenter {
        void api_get_config_children(String sUserMe, String sUserCon);

    }
    interface View {
        void show_error_api(List<ErrorApi> mLis);
        void show_config_children(List<ConfigChildren> listDepExe);
    }
}
