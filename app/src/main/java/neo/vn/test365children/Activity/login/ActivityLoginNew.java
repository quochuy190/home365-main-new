package neo.vn.test365children.Activity.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import butterknife.BindView;
import butterknife.OnClick;
import neo.vn.test365children.Activity.ActivityHome;
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

public class ActivityLoginNew extends BaseActivity implements ImlLoginNew.View, ImlLogin.View {
    PresenterLoginNew mPresenter;
    PresenterLogin mPresenterLogin;
//    @BindView(R.id.img_dangnhap)
//    Button btn_login;
//    @BindView(R.id.btn_try)
//    Button btn_register;
//    @BindView(R.id.edt_user_con)
//    EditText edt_user_con;
//    @BindView(R.id.txt_hotline)
//    TextView txt_hotline;
//    @BindView(R.id.imageView)
//    ImageView imageView;
//    @BindView(R.id.imageView4)
//    ImageView img_broad;
//    @BindView(R.id.edt_user_pass)
//    EditText edt_user_pass;

    String sUserMe;
    String sUserCon;
    String sPassword;
    String phoneV = "", passV = "";
    @BindView(R.id.img_cloud)
    ImageView imgCloud;
    @BindView(R.id.edt_phone_login_vip)
    EditText edtPhoneLoginVip;
    @BindView(R.id.edt_pass_login_vip)
    EditText edtPassLoginVip;
    @BindView(R.id.button_login_vip)
    Button buttonLoginVip;
    @BindView(R.id.tv_forgot_pass_login_vip)
    TextView tvForgotPassLoginVip;
    @BindView(R.id.ic_back_login)
    ImageView icBackLogin;
    @BindView(R.id.tv_register_vip_1)
    TextView tvRegisterVip1;
    @BindView(R.id.tv_register_vip_2)
    TextView tvRegisterVip2;
    @BindView(R.id.tv_benefit_1)
    TextView tvBenefit1;
    @BindView(R.id.tv_benefit_2)
    TextView tvBenefit2;

    @Override
    public int setContentViewId() {
        return R.layout.layout_login_new_2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterLoginNew(this);
        mPresenterLogin = new PresenterLogin(this);

//        Glide.with(this).load(R.drawable.img_backround_login).into(imageView);
//        Glide.with(this).load(R.drawable.login_broad).into(img_broad);
//        initEvent();
        loadView();
    }

    private void loadView() {
//        Glide.with(this).load(R.drawable.login_cloud).into(imgCloud);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.register_vip_1);
        int lineHeight = tvRegisterVip1.getLineHeight();
        drawable.setBounds(0, 0, lineHeight * 3, lineHeight);

        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        String text = " ";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(imageSpan, text.length() - 1, text.length(), 0);
        tvRegisterVip1.append(spannableString);
//        tvRegisterVip1.setMovementMethod(LinkMovementMethod.getInstance());

        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.register_vip_1_1);
        int lineHeight2 = tvRegisterVip2.getLineHeight();
        drawable2.setBounds(0, 0, lineHeight2 * 3, lineHeight2);
        ImageSpan imageSpan2 = new ImageSpan(drawable2, ImageSpan.ALIGN_BASELINE);
        String text2 = " ";
        SpannableString spannableString2 = new SpannableString(text2);
        spannableString2.setSpan(imageSpan2, text2.length() - 1, text2.length(), 0);
        tvRegisterVip2.append(spannableString2);
    }

    private void login() {
        if (edtPhoneLoginVip.getText().toString().trim().length() > 0 && edtPassLoginVip.getText().toString().length() > 0) {
            showDialogLoading();
            phoneV = edtPhoneLoginVip.getText().toString().trim();
            passV = edtPassLoginVip.getText().toString();
            mPresenterLogin.apiLoginVip(phoneV, passV, "", "");
        }
    }

    @Override
    public void show_api_login(ResponInitChil mLis) {
    }

    @Override
    public void show_api_login(ObjLogin mLis) {
        hideDialogLoading();
        if (mLis != null && mLis.getsERROR().equals("0000")) {
            SharedPrefs.getInstance().put(Constants.KEY_ISLOGIN, true);
            SharedPrefs.getInstance().put(Constants.KEY_SAVE_CHIL, mLis);
            SharedPrefs.getInstance().put(Constants.KEY_USER_ME, sUserMe);
            SharedPrefs.getInstance().put(Constants.KEY_USER_CON, sUserCon);
            SharedPrefs.getInstance().put(Constants.KEY_PASSWORD, sPassword);
            showDialogComfirm("Thông báo", mLis.getsRESULT(), false, new ClickDialog() {
                @Override
                public void onClickYesDialog() {
                    startActivity(new Intent(ActivityLoginNew.this, ActivityHome.class));
                    finish();
                }

                @Override
                public void onClickNoDialog() {

                }
            });
        } else {
            showAlertDialog("Thông báo", mLis.getsRESULT());
        }

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
        if (loginVip != null) {
            if (loginVip.getERROR().equals("0000")) {
//                SharedPrefs.getInstance().put(Constants.KEY_ISLOGIN, true);
                SharedPrefs.getInstance().put(Constants.KEY_USER_ME, loginVip.getINFO().getUSERNAME());
                if (!loginVip.getINFO().getCHILDS().isEmpty()) {
                    ChildX childX = loginVip.getINFO().getCHILDS().get(0);
                    SharedPrefs.getInstance().put(Constants.KEY_USER_CON, childX.getUSERNAME());
                    SharedPrefs.getInstance().put(Constants.KEY_PASSWORD, childX.getPASSWORD());
                    SharedPrefs.getInstance().put(Constants.IS_VIP, true);
                    SharedPrefs.getInstance().put(Constants.PHONE_VIP, phoneV);
                    SharedPrefs.getInstance().put(Constants.PASSWORD_VIP, passV);
                    sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
                    sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
                    sPassword = SharedPrefs.getInstance().get(Constants.KEY_PASSWORD, String.class);
                    mPresenterLogin.api_login_restful(sUserMe, sUserCon, sPassword);
                } else {
                    Intent intent = new Intent(ActivityLoginNew.this, ActivitySelectLevelTry.class);
                    startActivityForResult(intent, Constants.RequestCode.START_USER_TRY);
                }

            } else showDialogNotify("Thông báo", loginVip.getMESSAGE());
        }
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

    private void registerVip2() {
//        String registerText = "Hãy soạn tin nhắn DK EH gửi 999 để đăng ký Gói cước EduVIP Home365 với ưu đãi cực lớn của Mobifone" +
//                " (1.5G data tốc độ cao và miễn phí tất cả các cuộc gọi < 20 phút trong ngày, giá gói 6.000đ/ngày)";
//        showDialogComfirm("Thông báo", registerText, true, new ClickDialog() {
//            @Override
//            public void onClickYesDialog() {
//            }
//
//            @Override
//            public void onClickNoDialog() {
//
//            }
//        });
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", "999");
        smsIntent.putExtra("sms_body", "DK EVH");
        try {
            startActivity(smsIntent);
        } catch (ActivityNotFoundException e) {
            // Display some sort of error message here.
        }
    }

    private void registerVip1(String content, String phoneSend) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", phoneSend);
        smsIntent.putExtra("sms_body", content);
        try {
            startActivity(smsIntent);
        } catch (ActivityNotFoundException e) {
            // Display some sort of error message here.
        }
    }

    private void forgotPass() {
        String sHotline = "Nhắn tin theo cú pháp <b><u><font color='#c21b37'>MK H1</font></u></b>" +
                " gửi <b><u><font color='#c21b37'>9285 </font></u></b> để lấy lại mật khẩu (cước SMS: Miễn phí) ";
        showDialogComfirm("Thông báo", sHotline, true, new ClickDialog() {
            @Override
            public void onClickYesDialog() {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "9285");
                smsIntent.putExtra("sms_body", "MK H1");
                try {
                    startActivity(smsIntent);
                } catch (ActivityNotFoundException e) {
                    // Display some sort of error message here.
                }
            }

            @Override
            public void onClickNoDialog() {

            }
        });
    }

    @OnClick({R.id.button_login_vip, R.id.tv_forgot_pass_login_vip, R.id.ic_back_login, R.id.tv_register_vip_1, R.id.tv_register_vip_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login_vip:
                login();
                break;
            case R.id.tv_forgot_pass_login_vip:
                forgotPass();
                break;
            case R.id.ic_back_login:
                startActivity(new Intent(ActivityLoginNew.this, ActivityHome.class));
                finish();
                break;
            case R.id.tv_register_vip_1:
                registerVip1("DK H365", "9285");
                break;
            case R.id.tv_register_vip_2:
                registerVip1("XN H365", "9285");
                break;
        }
    }
}
