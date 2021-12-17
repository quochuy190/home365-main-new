package neo.vn.test365children.Presenter;

import java.util.List;

import neo.vn.test365children.Models.DesExercises;
import neo.vn.test365children.Models.ErrorApi;

public interface ImlExerDetail {
    interface Presenter{
        void api_get_des_exercises(String sUserMe, String sUserCon, String sIdDe);
        void api_get_report_exercises(String sUserMe, String sUserCon, String sIdDe);
    }
    interface View{
        void show_error_api(List<ErrorApi> mLis);
        void show_des_exercises(List<DesExercises> listDepExe);
        void show_report_exercises(List<DesExercises> listDepExe);
    }
}
