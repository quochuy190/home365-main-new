package neo.vn.test365children.Presenter;

import java.util.List;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.Sticker;

public interface ImlListSticker {
    interface Presenter {
        void api_get_list_sticker(String sUserMe, String sIdKhoi);

        void api_get_info_chil(String sUserMe, String sUserCon);
    }

    interface View {
        void show_error_api(List<ErrorApi> mLis);

        void show_list_sticker(List<Sticker> mList);

        void show_info_chil(List<ObjLogin> mLis);
    }
}
