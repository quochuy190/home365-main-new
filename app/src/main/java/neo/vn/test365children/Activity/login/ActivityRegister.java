    package neo.vn.test365children.Activity.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class ActivityRegister extends BaseActivity implements PresenterRegister.View {
    PresenterRegister mPresenter;

    String sFullName;
    String sPhone;
    String sPassword;
    String sPasswordConfirm;

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
    @BindView(R.id.imgPass)
    ImageView imgPass;
    @BindView(R.id.imgPassConfirm)
    ImageView imgPassConfirm;
    Boolean isShowPw = false;
    Boolean getIsShowPwConfirm = false;

    @Override
    public int setContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterRegister(this);
        String sPhone = getIntent().getStringExtra("phone");
        edtPhone.setText(sPhone);
        imgPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShowPw) {
                    imgPass.setImageResource(R.drawable.ic_eye_hide);
                    edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edtPass.setSelection(edtPass.getText().length());
                    isShowPw = false;
                } else {
                    imgPass.setImageResource(R.drawable.ic_eye_show);
                    edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edtPass.setSelection(edtPass.getText().length());
                    isShowPw = true;
                }
            }
        });

        imgPassConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getIsShowPwConfirm) {
                    imgPassConfirm.setImageResource(R.drawable.ic_eye_hide);
                    edtPassConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edtPassConfirm.setSelection(edtPassConfirm.getText().length());
                    getIsShowPwConfirm = false;
                } else {
                    imgPassConfirm.setImageResource(R.drawable.ic_eye_show);
                    edtPassConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edtPassConfirm.setSelection(edtPassConfirm.getText().length());
                    getIsShowPwConfirm = true;
                }
            }
        });
    }


    private void register() {
        sPhone = edtPhone.getText().toString().trim();
        sPassword = edtPass.getText().toString();
        sFullName = edtFullName.getText().toString().trim();
        sPasswordConfirm = edtPassConfirm.getText().toString().trim();
        if (sFullName.isEmpty()){
            showAlertDialog(getString(R.string.notify),
                    getString(R.string.error_fullname));
            return;
        }
        if (sPhone.isEmpty()){
            showAlertDialog(getString(R.string.notify),
                    getString(R.string.error_phone));
            return;
        }
        if (sPassword.isEmpty()){
            showAlertDialog(getString(R.string.notify),
                    getString(R.string.error_pass));
            return;
        }
        if (sPasswordConfirm.isEmpty()){
            showAlertDialog(getString(R.string.notify),
                    getString(R.string.error_pass_confirm));
            return;
        }
        String id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        mPresenter.apiRegister(sFullName, sPhone, sPassword, id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.START_USER_TRY:
                if (resultCode == RESULT_OK) {

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
                register();
                break;
            case R.id.txtLogin:
                startActivity(new Intent(ActivityRegister.this, ActivityLoginNew.class));
                finish();
                break;
            case R.id.imgBack:
                startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
                finish();
                break;
        }
    }

    @Override
    public void onHideProgressDialog() {
        hideDialogLoading();
    }

    @Override
    public void onShowProgressDialog() {
        showDialogLoading();
    }

    @Override
    public void showErrorRegister(String error) {
        showAlertDialog(getString(R.string.error), error);
    }

    @Override
    public void showSuccessRegister() {
        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ActivityRegister.this, ActivityLoginNew.class));
        finish();
    }
}
