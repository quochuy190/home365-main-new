package neo.vn.test365children.Activity.untility_menu;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.ObjUntility;
import neo.vn.test365children.Presenter.PresenterLogActionServer;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityUntitiliesDetail extends BaseActivity {
    private ObjUntility objUntilities;
    @BindView(R.id.txt_unit)
    TextView txt_unit;
    @BindView(R.id.txt_name)
    TextView txt_name;
    @BindView(R.id.txt_depcrition)
    TextView txt_description;
    @BindView(R.id.txt_time)
    TextView txt_time;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.btn_exit)
    Button btn_back;
    @BindView(R.id.icon_phone)
    ImageView btn_call;
    @BindView(R.id.btn_call)
    RelativeLayout rl_call_phone;
    @BindView(R.id.txt_phone_call)
    TextView txt_phone_call;
    public static PresenterLogActionServer mPresenter;

    @Override
    public int setContentViewId() {
        return R.layout.activity_untility_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_nghe_nhin).into(img_background);
        mPresenter = new PresenterLogActionServer();
        initData();
        Animation();
        initEvent();
    }

    private AnimationDrawable anim;

    private void Animation() {
        //  ImageView img = (ImageView)findViewById(R.id.simple_anim);
        anim = (AnimationDrawable) btn_call.getDrawable();
        btn_call.post(run);
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            anim.start();
        }
    };

    private void initEvent() {
        rl_call_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (objUntilities.getPHONE() != null) {
                    KeyboardUtil.play_click_button(ActivityUntitiliesDetail.this);
                    call_phone(ActivityUntitiliesDetail.this, objUntilities.getPHONE());
                } else {

                }

            }
        });
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (objUntilities.getPHONE() != null){

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:"+objUntilities.getPHONE()));
                    startActivity(callIntent);
                }

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityUntitiliesDetail.this);
                finish();
            }
        });


    }

    private void initData() {
        objUntilities = (ObjUntility) getIntent().getSerializableExtra(Constants.KEY_SEND_DETAIL_UNTILITIES);
/*        if (objUntilities.getsLogo() != null) {
            Glide.with(this)
                    .load(objUntilities.getsLogo())
                    .asBitmap()
                    .placeholder(R.color.gray)
                    .into(new BitmapImageViewTarget(logo_infor) {
                        @Override
                        public void onResourceReady(Bitmap drawable, GlideAnimation anim) {
                            super.onResourceReady(drawable, anim);
                            //   progressBar.setVisibility(View.GONE);
                        }
                    });
        }*/
        if (objUntilities.getPHONE() != null) {
            String styledText = "<font color='blue'><u>" + objUntilities.getPHONE() + "</u></font>";
            // txt_phone.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            //txt_phone.setText(objUntilities.getPHONE());
        }
        if (objUntilities.getURL() != null) {
            String styledText = "<font color='blue'><u>" + objUntilities.getURL() + "</u></font>";
            // txt_web.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            //txt_phone.setText(objUntilities.getPHONE());
        }
        if (objUntilities.getDESCRIPTION() != null) {
            txt_description.setText(objUntilities.getDESCRIPTION());
        }
        if (objUntilities.getUNIT() != null) {
            txt_unit.setText("Nhà cung cấp: " + objUntilities.getUNIT());
        }
        if (objUntilities.getsName() != null) {
            txt_name.setText(objUntilities.getsName());
        }
        if (objUntilities.getTTIME() != null) {
            txt_time.setText("Thời gian phục vụ: " + objUntilities.getTTIME());
        } else {
            txt_time.setText("Thời gian phục vu: Cả ngày");
        }
        if (objUntilities.getDES_PHONE() != null) {
            txt_phone_call.setText(objUntilities.getDES_PHONE());
        } else {
            txt_phone_call.setText("GỌI NGAY");
        }

    }

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
            get_api_log_action(phone);
        } else {
            Toast.makeText(mContext, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }

    private static void get_api_log_action(String sPhone) {
        String sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        String sUserKid = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        mPresenter.api_log_action_server(sUserMother, sUserKid, "UtilityCall", sPhone);
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
            phoneCall(this, sPhone);
        } else {
            Toast.makeText(this, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }
}
