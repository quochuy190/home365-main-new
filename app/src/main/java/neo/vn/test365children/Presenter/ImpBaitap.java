package neo.vn.test365children.Presenter;

import java.util.List;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.HomeworkDone;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.ResponDetailTakenExercise;
import neo.vn.test365children.Models.ResponseObjWeek;
import neo.vn.test365children.Models.TuanDamua;

public interface ImpBaitap {
    interface Presenter {
        void get_api_list_buy(String sUserMe, String sUserCon, String sIdMon, String sIdKhoi);

        void get_api_get_part(String sUserMe, String sUserCon, String sIdDebai);

        void get_api_get_excercise_needed(String sUserMe, String sUserCon, String sDay);

        void get_api_get_excercise_expired(String sUserMe, String sUserCon);

        void get_exe_detail_taken(String USER_MOTHER, String USER_CHILD, String ID_EXCERCISE);  //( lấy chi tiết bài tập đã làm)

        void get_api_start_taken(String sUserMe, String sUserCon, String sId_baitap, String time_lambai, String thoiluonglambai);

        void get_api_submit_execercise(String sUserMe, String sUserCon, String sId_baitap,
                                       String time_giaobai, String time_bdlambai, String time_ktlambai, String tong_time_lambai,
                                       String sKieunop, String sDiem, String sDanhsachcau);
        void get_excercise_taken(String USER_MOTHER, String USER_CHILD);
    }

    interface View {
        void show_list_list_buy(List<TuanDamua> mLis);

        void show_list_get_part(ResponDetailExer objDetailExer);

        void show_error_api(List<ErrorApi> mLis);

        void show_get_excercise_needed(ResponseObjWeek objResponWeek);

        void show_get_excercise_expired(ResponseObjWeek objResponWeek);

        void show_start_taken(ErrorApi mLis);

        void show_submit_execercise(ErrorApi mLis);

        void show_detail_taken(ResponDetailTakenExercise obj);

        void showHomeworkDone(HomeworkDone homeworkDone);
    }
}
