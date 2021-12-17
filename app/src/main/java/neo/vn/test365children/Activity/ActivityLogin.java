package neo.vn.test365children.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import io.realm.Realm;
import neo.vn.test365children.Activity.login.ActivitySelectLevelTry;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.InfoKids;
import neo.vn.test365children.Models.ObjLogin;
import neo.vn.test365children.Models.vip.ObjLoginVip;
import neo.vn.test365children.Presenter.ImlLogin;
import neo.vn.test365children.Presenter.PresenterLogin;
import neo.vn.test365children.R;
import neo.vn.test365children.RealmController.RealmController;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityLogin extends BaseActivity implements View.OnClickListener, ImlLogin.View {
    @BindView(R.id.img_dangnhap)
    Button img_dangnhap;
    @BindView(R.id.btn_try)
    Button btn_try;
    @BindView(R.id.edt_user_me)
    EditText edtUserMe;
    @BindView(R.id.edt_user_con)
    EditText edtUserCon;
    @BindView(R.id.edt_pass_con)
    EditText edtPassCon;
    PresenterLogin mPresenter;
    boolean isShowpass = true;
    @BindView(R.id.img_showpass)
    ImageView img_showpass;
    String sUserMe, sUserCon, sPassWord, sTokenKey;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.img_mute)
    ImageView img_mute;
    @BindView(R.id.txt_hotline)
    TextView txt_hotline;
    @BindView(R.id.txt_dangky)
    TextView txt_dangky;
    Realm mRealm;
    private boolean isUserTry = false;

    @Override
    public int setContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = RealmController.with(this).getRealm();
        img_showpass.setImageDrawable(getResources().getDrawable(R.drawable.ic_eye_hide));
        isUserTry = SharedPrefs.getInstance().get(Constants.KEY_SAVE_IS_USER_TRY, Boolean.class);
        if (!isUserTry) {
            btn_try.setVisibility(View.VISIBLE);
        } else {
            btn_try.setVisibility(View.GONE);
        }
        loadImage();
        initData();
        initEvent();
        //  play_mp3();
        mPresenter = new PresenterLogin(this);
    }

    private void loadImage() {
        Glide.with(this).load(R.drawable.img_backround_login).into(imageView);
        Glide.with(this).load(R.drawable.login_broad).into(imageView4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.START_USER_TRY:
                if (resultCode == RESULT_OK) {
                    if (App.sObjLogin != null && App.sObjLogin.getsObjInfoKid() != null) {
                        InfoKids objInfo = App.sObjLogin.getsObjInfoKid();
                        if (objInfo.getsUSERNAME() != null) {
                            sUserCon = objInfo.getsUSERNAME();
                            SharedPrefs.getInstance().put(Constants.KEY_USER_CON, sUserCon);
                        } else return;
                        if (objInfo.getsUSER_MOTHER() != null) {
                            sUserMe = objInfo.getsUSER_MOTHER();
                            SharedPrefs.getInstance().put(Constants.KEY_USER_ME, sUserMe);
                        } else return;
                        if (objInfo.getsPASSWORD() != null) {
                            sPassWord = objInfo.getsPASSWORD();
                            SharedPrefs.getInstance().put(Constants.KEY_PASSWORD, sPassWord);
                        } else return;
                        SharedPrefs.getInstance().put(Constants.KEY_SAVE_LOGIN_TRY_FIRST, true);
                        login_api();
                    }
                }
                break;
        }
    }

    public void initData() {
        String sHotline = "<b><u><font color='#c21b37'>Quên mật khẩu</font></u></b> ";
        String sDangky = "<b><u><font color='#2E4A9F'>Đăng ký tài khoản</font></u></b> ";
        txt_hotline.setText(Html.fromHtml(sHotline));
        txt_dangky.setText(Html.fromHtml(sDangky));
        boolean isLogin = getIntent().getBooleanExtra(Constants.KEY_ISLOGIN, false);
        sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        sPassWord = SharedPrefs.getInstance().get(Constants.KEY_PASSWORD, String.class);
        if (isLogin) {
            edtUserMe.setText(sUserMe);
            edtUserCon.setText(sUserCon);
            edtPassCon.setText(sPassWord);
            // login_api();
        } else {
            if (sUserMe != null && !sUserMe.equals("mothertrial")) {
                if (sUserMe != null)
                    edtUserMe.setText(sUserMe);
                if (sUserCon != null)
                    edtUserCon.setText(sUserCon);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_dangnhap:
                startActivity(new Intent(ActivityLogin.this, ActivityHome.class));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp3 != null)
            mp3.pause();
    }

    private void initEvent() {

        btn_try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLoginTryFirst = SharedPrefs.getInstance().get(Constants.KEY_SAVE_LOGIN_TRY_FIRST, Boolean.class);

                if (isLoginTryFirst) {
                    sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
                    sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
                    sPassWord = SharedPrefs.getInstance().get(Constants.KEY_PASSWORD, String.class);
                    login_api();
                } else {
                    Intent intent = new Intent(ActivityLogin.this, ActivitySelectLevelTry.class);
                    startActivityForResult(intent, Constants.RequestCode.START_USER_TRY);
                }

            }
        });
     /*   txt_hotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call_phone(ActivityLogin.this, "1900561548");
                Intent intent = new Intent(ActivityLogin.this, Activity_Guild_Show_UserKid.class);
                startActivity(intent);

            }
        });*/
        img_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp3 != null) {
                    if (mp3.isPlaying()) {
                        img_mute.setImageResource(R.drawable.icon_tat_loa);
                        mp3.pause();
                    } else {
                        img_mute.setImageResource(R.drawable.img_mute);
                        mp3.start();
                    }
                }
            }
        });
        //img_dangnhap.setOnClickListener(this);
        img_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNetwork()) {
                 /*   showDialogNotify("Thông báo",
                            "Mất kết nối, vui long kiểm tra lại mạng để tiếp tục");*/
                } else {
                    if (edtUserMe.getText().length() > 0 && edtPassCon.getText().length() > 0
                            && edtUserCon.getText().length() > 0) {
                        sUserMe = edtUserMe.getText().toString();
                        sUserCon = edtUserCon.getText().toString();
                        sPassWord = edtPassCon.getText().toString();
                        login_api();
                    } else
                        showDialogNotify("Thông báo",
                                "Mời bạn nhập vào tài khoản và mật khẩu để đăng nhập");

                }
            }
        });
        edtPassCon.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (!isNetwork()) {

                    } else {
                        if (edtUserMe.getText().length() > 0 && edtPassCon.getText().length() > 0
                                && edtUserCon.getText().length() > 0) {
                            sUserMe = edtUserMe.getText().toString();
                            sUserCon = edtUserCon.getText().toString();
                            sPassWord = edtPassCon.getText().toString();
                            login_api();
                        } else
                            showDialogNotify("Thông báo",
                                    "Mời bạn nhập vào tài khoản và mật khẩu để đăng nhập");

                    }
                    return true;
                }
                return false;
            }
        });
        img_showpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowpass) {
                    img_showpass.setImageDrawable(getResources().getDrawable(R.drawable.ic_eye_hide));
                    //Glide.with(ActivityLogin.this).load(R.drawable.ic_eye_hide).into(img_showpass);
                    edtPassCon.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isShowpass = !isShowpass;
                } else {
                    img_showpass.setImageDrawable(getResources().getDrawable(R.drawable.ic_eye_show));
                    edtPassCon.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isShowpass = !isShowpass;
                }
            }
        });
    }

    public void login_api() {
        showDialogLoading();
        /*mPresenter.api_login(sUserMe, sUserCon, sPassWord, BuildConfig.VERSION_NAME,
                android.os.Build.BRAND + " " + android.os.Build.MODEL,
                "2", android.os.Build.VERSION.RELEASE, sTokenKey);*/
        if (!sUserMe.equals("mothertrial"))
            SharedPrefs.getInstance().put(Constants.KEY_SAVE_IS_USER_TRY, true);
        mPresenter.api_login_restful(sUserMe, sUserCon, sPassWord);
    }

    @Override
    public void show_api_login(ObjLogin mLis) {
        if (mLis != null) {
            if (mLis.getsERROR().equals("0000")) {
                SharedPrefs.getInstance().put(Constants.KEY_ISLOGIN, true);
                SharedPrefs.getInstance().put(Constants.KEY_SAVE_CHIL, mLis);
                SharedPrefs.getInstance().put(Constants.KEY_USER_ME, sUserMe);
                SharedPrefs.getInstance().put(Constants.KEY_USER_CON, sUserCon);
                SharedPrefs.getInstance().put(Constants.KEY_PASSWORD, sPassWord);
                update_info();
                //start_home_activity();
            } else {
                hideDialogLoading();
                //  DialogUtil.dontDialog(this, "Lỗi", mLis.getsRESULT());
                showDialogNotify("Lỗi", mLis.getsRESULT());
            }
        }
    }

    private void update_info() {
        sTokenKey = SharedPrefs.getInstance().get(Constants.KEY_TOKEN, String.class);
     /*   mPresenter.api_update_info_chil(sUserMe, sUserCon, sPassWord, BuildConfig.VERSION_NAME,
                android.os.Build.BRAND + " " + android.os.Build.MODEL,
                "2", android.os.Build.VERSION.RELEASE, sTokenKey);*/
//        mPresenter.api_update_info_chil(sUserMe, sUserCon, BuildConfig.VERSION_NAME, android.os.Build.BRAND + " " + android.os.Build.MODEL,
//                sTokenKey, "2", android.os.Build.VERSION.RELEASE);

    }

    private void start_home_activity() {
        // ObjLogin objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_CHIL, ObjLogin.class);
        boolean isChaomung = SharedPrefs.getInstance().get(Constants.KEY_IS_WELCOME, Boolean.class);
        Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
        Intent intent_welcom = new Intent(ActivityLogin.this, Activity_Welcome.class);
        //  intent_welcom.putExtra(Constants.KEY_SEND_OBJLOGIN, objLogin);
        intent.putExtra(Constants.KEY_SEND_LOGIN_HOME, "1");
        if (!isChaomung && !sUserMe.equals("mothertrial")) {
            startActivity(intent_welcom);
        } else
            startActivity(intent);
        finish();
    }

    @Override
    public void show_update_infochil(ErrorApi obj) {
        hideDialogLoading();
        if (obj.getsERROR().equals("0000")) {
            start_home_activity();
        } else {
            showDialogNotify(obj.getMESSGE(), obj.getsRESULT());
        }
    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
        showAlertErrorNetwork();
    }

    MediaPlayer mp3;

    public static void call_phone(Context mContext, String phone) {
        sPhone = phone;
        if (Build.VERSION.SDK_INT < 23) {
            phoneCall(mContext, phone);
        } else {
            if (ActivityCompat.checkSelfPermission(mContext,
                    Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                phoneCall(mContext, phone);
            } else {
                final String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
                //Asking request Permissions
                ActivityCompat.requestPermissions((Activity) mContext, PERMISSIONS_STORAGE, 9);
            }
        }
    }

    public static String sPhone;

    private static void phoneCall(Context mContext, String phone) {
        if (ActivityCompat.checkSelfPermission(mContext,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phone));
            mContext.startActivity(callIntent);
        } else {
            Toast.makeText(mContext, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionGranted = false;
        switch (requestCode) {
            case 9:
                permissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (permissionGranted) {
            phoneCall(this, "1900561548");
        } else {
            Toast.makeText(this, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void show_api_login_Vip(ObjLoginVip loginVip) {

    }
}
