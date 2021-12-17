package neo.vn.test365children.Presenter;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponGameTNNL;
import neo.vn.test365children.Models.ResponGetGameTPTT;

public interface ImlGetGameTptt {
    interface Presenter {
        void api_get_game_tptt(String sUserMe, String sUserCon, String sDate);

        void api_start_tptt(String sUserMe, String sUserCon, String id_part);

        void api_submit_tptt(String sUserMe, String sUserCon, String sId_part,
                             String sTime, String sAward, String sMonney);

        void api_get_game_tnll(String sUserMe, String sUserCon);

        void api_submit_game_tnnl(String sUserMe, String sUserCon, String sMonney);
    }

    interface View {
        void show_get_game_tptt(ResponGetGameTPTT objGameTPTT);

        void show_error_api(ErrorApi mLis);

        void show_start_tptt(ErrorApi mLis);

        void show_submit_tptt(ErrorApi mLis);

        void show_get_game_tnnl(ResponGameTNNL mLis);

        void show_submit_game_tnnl(ErrorApi mLis);


    }
}
