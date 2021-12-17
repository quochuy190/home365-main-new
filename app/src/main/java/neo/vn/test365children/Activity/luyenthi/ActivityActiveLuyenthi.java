package neo.vn.test365children.Activity.luyenthi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.GoiBaitap;
import neo.vn.test365children.Models.ResponDetailExer;
import neo.vn.test365children.Models.respon_api.ResponGetListLuyenthi;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;
import neo.vn.test365children.Untils.StringUtil;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 15:03
 * Version: 1.0
 */
public class ActivityActiveLuyenthi extends BaseActivity implements InterfaceLuyenthi.View {
    GoiBaitap mObjGoiLT;
    @BindView(R.id.txt_lable_mon)
    TextView txt_lable_mon;
    @BindView(R.id.txt_subject)
    TextView txt_subject;
    @BindView(R.id.txt_description)
    TextView txt_description;
    @BindView(R.id.txt_introduct)
    TextView txt_introduct;
    @BindView(R.id.btn_active)
    Button btn_active;
    @BindView(R.id.img_mute)
    ImageView img_mute;
    @BindView(R.id.edt_code_active)
    EditText edt_code_active;
    @BindView(R.id.linear_text_center)
    LinearLayout linear_text_center;
    PresenterLuyenthi mPresenter;

    @Override
    public int setContentViewId() {
        return R.layout.activity_active_luyenthi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterLuyenthi(this);
        initData();
        initEvent();
    }

    boolean isActive = false;

    private void initEvent() {
        img_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isActive) {
                    showDialogComfirm("Thông báo", mObjGoiLT.getINSTRUCTION(), true, new ClickDialog() {
                        @Override
                        public void onClickYesDialog() {
                            KeyboardUtil.play_click_button(ActivityActiveLuyenthi.this);
                            StringUtil.sendSMS(ActivityActiveLuyenthi.this, mObjGoiLT.getSERVICE_CMC(),
                                    mObjGoiLT.getSERVICE_NUMBER());
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    isActive = true;
                                    linear_text_center.setVisibility(View.GONE);
                                    edt_code_active.setVisibility(View.VISIBLE);
                                }
                            }, 500);
                        }

                        @Override
                        public void onClickNoDialog() {

                        }
                    });
                } else {
                    if (edt_code_active.getText().toString().length() > 0) {
                        showDialogLoading();
                        String sUserMe = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
                        String sUserCon = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
                        mPresenter.api_active_goiluyenthi(sUserMe, sUserCon,
                                mObjGoiLT.getID(), edt_code_active.getText().toString());
                    } else showDialogNotify("Thông báo", "Bạn chưa nhập vào mã kích hoạt.");

                }


            }
        });
    }

    private void initData() {
        mObjGoiLT = (GoiBaitap) getIntent().getSerializableExtra(Constants.KEY_SEND_GOI_LUYENTHI);
        set_info();
    }

    private void set_info() {
        try {
            txt_lable_mon.setText(mObjGoiLT.getNAME().toUpperCase());
            txt_subject.setText(mObjGoiLT.getLEVEL_NAME() + " - " + mObjGoiLT.getSUBJECT_NAME());
            txt_description.setText(mObjGoiLT.getDESCRIPTION());
            txt_introduct.setText(mObjGoiLT.getINSTRUCTION());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void api_show_list_luyenthi(ResponGetListLuyenthi objRest) {
        hideDialogLoading();
    }

    @Override
    public void api_show_list_detail(ResponDetailExer objRest) {

    }

    @Override
    public void api_show_active(ErrorApi objError) {
        hideDialogLoading();
        if (objError.getsERROR().equals("0000")) {
            Toast.makeText(this, "Kích hoạt thành công", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, new Intent());
            finish();
        } else
            showAlertDialog("Thông báo", objError.getsRESULT());
    }

    @Override
    public void api_show_error() {
        hideDialogLoading();
    }


}
