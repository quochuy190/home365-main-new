package neo.vn.test365children.Activity.game.menu_game;

import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.respon_api.ResponConfigGame;

public interface ImlConfigGameRest {
    interface Presenter {
        void apirest_get_config_game(String USER_MOTHER, String USER_CHILD);
    }

    interface View {
        void show_error_api(ErrorApi mLis);

        void show_get_config_game(ResponConfigGame objRes);
    }
}
