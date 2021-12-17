package neo.vn.test365children.Activity.skill;

import neo.vn.test365children.Models.respon_api.ResponGetUntilities;
import neo.vn.test365children.Models.respon_api.ResponListLessonSkill;

public interface InterfaceSkill {
    interface Presenter {
        void api_get_menu_skill(String sUserMother, String sUserKid);

        void api_get_list_lesson_skill(String sUserMother, String sUserKid, String id);
    }

    interface View {
        void api_show_error();

        void api_show_menu_skill(ResponGetUntilities mLis);

        void api_show_list_lesson_skill(ResponListLessonSkill mlis);
    }
}
