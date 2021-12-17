package neo.vn.test365children.Presenter;

public interface Iml_Log_Server {
    interface Presenter {
        void api_log_action_server(String USER_MOTHER, String USER_CHILD, String ACTION, String DESCRIPTION);

        void api_log_web_lesson_skill(String USER_MOTHER, String USER_CHILD, String ACTION, String SKILL_ID);
    }

}
