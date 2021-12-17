package neo.vn.test365children.Presenter;

import org.json.JSONException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import neo.vn.test365children.ApiService.ApiServiceIml;
import neo.vn.test365children.Listener.CallbackData;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.Sticker;

public class PresenterSticker implements ImlListSticker.Presenter {
    ApiServiceIml mApiService;
    ImlListSticker.View mView;

    public PresenterSticker(ImlListSticker.View mView) {
        mApiService = new ApiServiceIml();
        this.mView = mView;
    }

    @Override
    public void api_get_list_sticker(String sUserMe, String sIdKhoi) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "get_sticker");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "2");
        mMap.put("P1", sUserMe);
        mMap.put("P2", sIdKhoi);

        mApiService.getApiService(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);

            }

            @Override
            public void onGetDataSuccess(String objT) {

                try {
                    List<Sticker> mLis = Sticker.getList(objT);
                    mView.show_list_sticker(mLis);
                } catch (JSONException e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                }
            }
        }, mMap);
    }

    @Override
    public void api_get_info_chil(String sUserMe, String sUserCon) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("Service", "get_info_children");
        mMap.put("Provider", "default");
        mMap.put("ParamSize", "2");
        mMap.put("P1", sUserMe);
        mMap.put("P2", sUserCon);

        mApiService.getApiService(new CallbackData<String>() {
            @Override
            public void onGetDataErrorFault(Exception e) {
                mView.show_error_api(null);

            }

            @Override
            public void onGetDataSuccess(String objT) {

                try {
                    List<ObjLogin> mLis = ObjLogin.getList(objT);
                    mView.show_info_chil(mLis);
                } catch (JSONException e) {
                    e.printStackTrace();
                    mView.show_error_api(null);
                }
            }
        }, mMap);
    }
}
