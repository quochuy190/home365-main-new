package neo.vn.test365children.Presenter;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponDetailKow;
import neo.vn.test365children.Models.ResponGetTopicKow;

public interface ImlGameKoW {
    interface Presenter {
        void api_get_list_topic_kow(String sUserMother, String sUserKid);

        void api_get_detail_kow(String sUserMother, String sUserKid, String sIdTopic);
    }

    interface View {
        void show_error_api(ErrorApi objError);

        void show_list_topic(ResponGetTopicKow obj);

        void show_list_detail_kow(ResponDetailKow obj);
    }
}
