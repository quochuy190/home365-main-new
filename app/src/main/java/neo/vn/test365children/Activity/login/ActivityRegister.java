package neo.vn.test365children.Activity.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.OnClick;
import neo.vn.test365children.Activity.ActivityHome;
import neo.vn.test365children.Activity.ActivityLogin;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.respon_api.ResponInitChil;
import neo.vn.test365children.Models.vip.ChildX;
import neo.vn.test365children.Models.vip.ObjLoginVip;
import neo.vn.test365children.Presenter.ImlLogin;
import neo.vn.test365children.Presenter.PresenterLogin;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityRegister extends BaseActivity implements ImlLoginNew.View, ImlLogin.View {
    PresenterLoginNew mPresenter;
    PresenterLogin mPresenterLogin;

    String sUserMe;
    String sUserCon;
    String sPassword;
    String phoneV = "", passV = "";
    @BindView(R.id.edtFullName)
    EditText edtFullName;
    @BindView(R.id.edtPhone)
    EditText edtPhone;
    @BindView(R.id.edtPass)
    EditText edtPass;
    @BindView(R.id.edtPassConfirm)
    EditText edtPassConfirm;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.txtLogin)
    TextView txtLogin;

    @Override
    public int setContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterLoginNew(this);
        mPresenterLogin = new PresenterLogin(this);
    }


    private void login() {
        if (edtFullName.getText().toString().trim().length() > 0 && edtPhone.getText().toString().length() > 0
                && edtPass.getText().toString().length() > 0  && edtPassConfirm.getText().toString().length() > 0
        ) {
            showDialogLoading();
            phoneV = edtPhone.getText().toString().trim();
            passV = edtPass.getText().toString();
            mPresenterLogin.apiLoginVip(phoneV, passV, "", "");
        }
    }

    @Override
    public void show_api_login(ResponInitChil mLis) {
    }

    @Override
    public void show_api_login(ObjLogin mLis) {
        hideDialogLoading();

    }

    @Override
    public void show_update_infochil(ErrorApi obj) {

    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
        showAlertErrorNetwork();
    }

    @Override
    public void show_api_login_Vip(ObjLoginVip loginVip) {
        hideDialogLoading();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.START_USER_TRY:
                if (resultCode == RESULT_OK) {
//                    showDialogLoading();
                    sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
                    sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
                    sPassword = SharedPrefs.getInstance().get(Constants.KEY_PASSWORD, String.class);
                    mPresenterLogin.api_login_restful(sUserMe, sUserCon, sPassword);
//                    mPresenter_init.api_update_info_chil(sUserMe, sUserCon, "", App.sLevel, "",
//                            "", "", sPassword, "", "", "");
//                    check_update_token_push();
                }
                break;
            case Constants.RequestCode.START_UPDATE_INFOR_CHILD:
                if (resultCode == RESULT_OK) {
//                    Log.d(TAG, "onActivityResult: " + App.sLevel);
//                    initLogin();
                }
                break;
        }
    }
    

    @OnClick({R.id.btnRegister, R.id.txtLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                login();
                break;
            case R.id.txtLogin:
                startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
                finish();
                break;
            case R.id.imgBack:
                startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
                finish();
                break;
        }
    }
}
