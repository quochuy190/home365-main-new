package neo.vn.test365children.Presenter;

import java.util.List;

import neo.vn.test365children.Models.Chart_To_Subject;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.Item_BXH;

public interface ImlThongke {
    interface Presenter {
        void api_get_week_chart(String sUserMe, String sUserCon, String sDate);

        void api_get_month_chart(String sUserMe, String sUserCon, String sDate);

        void api_get_year_chart(String sUserMe, String sUserCon, String sDate);

        void api_get_chart_to_subject(String sUserMe, String sUserCon);

    }

    interface View {
        void show_get_week_chart(List<Item_BXH> mLis);

        void show_error_api(List<ErrorApi> mLis);

        void show_month_chart(List<Item_BXH> mLis);

        void show_year_chart(List<Item_BXH> mLis);

        void show_chart_to_subject(List<Chart_To_Subject> mLis);
    }
}
