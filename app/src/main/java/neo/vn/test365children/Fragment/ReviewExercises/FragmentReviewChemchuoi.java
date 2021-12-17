package neo.vn.test365children.Fragment.ReviewExercises;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.Models.DapAn;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.StringUtil;


/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 8/6/2018
 * @updated 8/6/2018
 * @modified by
 * @updated on 8/6/2018
 * @since 1.0
 */
public class FragmentReviewChemchuoi extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "FragmentCauhoi";
    private CauhoiDetail mCauhoi;
    @BindView(R.id.txt_lable)
    TextView txt_lable;
    @BindView(R.id.ll_cauhoi)
    LinearLayout ll_cauhoi;
    RecyclerView.LayoutManager mLayoutManager;
    List<DapAn> mLis;
    private boolean isTraloi = false;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.webview_debai)
    WebView webview_debai;
    @BindView(R.id.webview_anwser_A)
    WebView webview_anwser_A;
    @BindView(R.id.webview_anwser_B)
    WebView webview_anwser_B;
    @BindView(R.id.webview_anwser_C)
    WebView webview_anwser_C;
    @BindView(R.id.webview_anwser_D)
    WebView webview_anwser_D;

    @BindView(R.id.ll_anwser_A)
    LinearLayout ll_anwser_A;
    @BindView(R.id.ll_anwser_B)
    LinearLayout ll_anwser_B;
    @BindView(R.id.ll_anwser_C)
    LinearLayout ll_anwser_C;
    @BindView(R.id.ll_anwser_D)
    LinearLayout ll_anwser_D;

    @BindView(R.id.img_hoaqua_D)
    ImageView img_hoaqua_D;
    @BindView(R.id.img_hoaqua_C)
    ImageView img_hoaqua_C;
    @BindView(R.id.img_hoaqua_B)
    ImageView img_hoaqua_B;
    @BindView(R.id.img_hoaqua_A)
    ImageView img_hoaqua_A;
    private String sAnwser = "";

    @BindView(R.id.txt_dapan_D)
    RelativeLayout rl_dapan_D;
    @BindView(R.id.txt_dapan_B)
    RelativeLayout rl_dapan_B;
    @BindView(R.id.txt_dapan_C)
    RelativeLayout rl_dapan_C;
    @BindView(R.id.txt_dapan_A)
    RelativeLayout rl_dapan_A;
    @BindView(R.id.img_reload)
    ImageView img_reload;

    public static FragmentReviewChemchuoi newInstance(CauhoiDetail restaurant) {
        FragmentReviewChemchuoi restaurantDetailFragment = new FragmentReviewChemchuoi();
        Bundle args = new Bundle();
        //args.putSerializable("cauhoi",restaurant);
        args.putParcelable("cauhoi", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCauhoi = Parcels.unwrap(getArguments().getParcelable("cauhoi"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_chemchuoi, container, false);
        ButterKnife.bind(this, view);
        //   Log.i(TAG, "onCreateView: " + mCauhoi.getsQUESTION());
        initImage();
        initData();
        initEvent();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        webview_anwser_A.clearHistory();
        webview_anwser_A.clearFormData();
        webview_anwser_A.clearCache(true);
        webview_anwser_B.clearHistory();
        webview_anwser_B.clearFormData();
        webview_anwser_B.clearCache(true);
        webview_anwser_C.clearHistory();
        webview_anwser_C.clearFormData();
        webview_anwser_C.clearCache(true);
        webview_anwser_D.clearHistory();
        webview_anwser_D.clearFormData();
        webview_anwser_D.clearCache(true);
        webview_debai.clearHistory();
        webview_debai.clearFormData();
        webview_debai.clearCache(true);
    }

    private boolean isClickXemdiem = false;

    private void initEvent() {
        img_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview_debai.reload();
                webview_anwser_A.reload();
                webview_anwser_B.reload();
                webview_anwser_C.reload();
                webview_anwser_D.reload();

                webview_debai.setWebViewClient(new WebViewClient());
                webview_anwser_A.setWebViewClient(new WebViewClient());
                webview_anwser_B.setWebViewClient(new WebViewClient());
                webview_anwser_C.setWebViewClient(new WebViewClient());
                webview_anwser_D.setWebViewClient(new WebViewClient());
            }
        });
        ll_anwser_A.setOnClickListener(this);
        ll_anwser_B.setOnClickListener(this);
        ll_anwser_C.setOnClickListener(this);
        ll_anwser_D.setOnClickListener(this);

    }

    private void initImage() {
        Glide.with(getContext()).load(R.drawable.fruit_banana)
                .placeholder(R.drawable.fruit_banana).into(img_hoaqua_A);
        Glide.with(getContext()).load(R.drawable.fruit_berry)
                .placeholder(R.drawable.fruit_banana).into(img_hoaqua_B);
        Glide.with(getContext()).load(R.drawable.fruit_coconut)
                .placeholder(R.drawable.fruit_banana).into(img_hoaqua_C);
        Glide.with(getContext()).load(R.drawable.fruit_pineapple)
                .placeholder(R.drawable.fruit_banana).into(img_hoaqua_D);

    }

    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;
    @BindView(R.id.rr)
    RelativeLayout rr;

    private void initData() {
        rr.setVisibility(View.VISIBLE);
        if (mCauhoi.getsNumberDe() != null && mCauhoi.getsNumberDe().equals("1") && mCauhoi.getsSubNumberCau()
                != null && mCauhoi.getsSubNumberCau().equals("1")) {
            showDialogLoading();
        }
        if (mCauhoi.getsRESULT_CHILD() != null && mCauhoi.getsRESULT_CHILD().equals("0")) {
            Glide.with(this).load(R.drawable.icon_anwser_false).into(img_anwser_chil);
        } else {
            Glide.with(this).load(R.drawable.icon_anwser_true).into(img_anwser_chil);
        }
        if (!mCauhoi.isDalam()) {
            Glide.with(this).load(R.drawable.icon_anwser_unknow).into(img_anwser_chil);
        }
        if (mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null)
            txt_lable.setText(Html.fromHtml("Bài " + mCauhoi.getsNumberDe() + "_Câu "
                    + mCauhoi.getsSubNumberCau() + ": " + mCauhoi.getsCauhoi_huongdan())
                    + " (" + Float.parseFloat(mCauhoi.getsPOINT()) + " đ)");
        Glide.with(this).load(R.drawable.bg_chem_hoa_qua).into(img_background);
        initWebview_sau(webview_debai, mCauhoi.getsHTML_CONTENT());
        initWebview_sau(webview_anwser_A, mCauhoi.getsHTML_A());
        initWebview_sau(webview_anwser_B, mCauhoi.getsHTML_B());
        initWebview_sau(webview_anwser_C, mCauhoi.getsHTML_C());
        initWebview_sau(webview_anwser_D, mCauhoi.getsHTML_D());
        if (mCauhoi.getsHTML_A() != null && mCauhoi.getsHTML_A().length() > 0) {
            ll_anwser_A.setVisibility(View.VISIBLE);
        } else {
            ll_anwser_A.setVisibility(View.GONE);
        }
        if (mCauhoi.getsHTML_B() != null && mCauhoi.getsHTML_B().length() > 0) {
            ll_anwser_B.setVisibility(View.VISIBLE);
        } else {
            ll_anwser_B.setVisibility(View.GONE);
        }
        if (mCauhoi.getsHTML_C() != null && mCauhoi.getsHTML_C().length() > 0) {
            ll_anwser_C.setVisibility(View.VISIBLE);
        } else {
            ll_anwser_C.setVisibility(View.GONE);
        }
        if (mCauhoi.getsHTML_D() != null && mCauhoi.getsHTML_D().length() > 0) {
            ll_anwser_D.setVisibility(View.VISIBLE);
        } else {
            ll_anwser_D.setVisibility(View.GONE);
        }
        switch (mCauhoi.getsANSWER_CHILD()) {
            case "A":
                animation_click(img_hoaqua_A);
                break;
            case "B":
                animation_click(img_hoaqua_B);
                break;
            case "C":
                animation_click(img_hoaqua_C);
                break;
            case "D":
                animation_click(img_hoaqua_D);
                break;
        }

        switch (mCauhoi.getsANSWER()) {
            case "A":
                animation_anwsertrue(img_hoaqua_A);
                break;
            case "B":
                animation_anwsertrue(img_hoaqua_B);
                break;
            case "C":
                animation_anwsertrue(img_hoaqua_C);
                break;
            case "D":
                animation_anwsertrue(img_hoaqua_D);
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }

    private void animation_click(ImageView img) {
        Animation animationRotale = AnimationUtils.loadAnimation(getContext(), R.anim.animation_chemchuoi);
        img.startAnimation(animationRotale);

    }

    private void animation_anwsertrue(ImageView img) {
        Animation animationRotale = AnimationUtils.loadAnimation(getContext(), R.anim.animation_image_batsau_dung);
        img.startAnimation(animationRotale);

    }

    public void initWebview_sau(final WebView webview, String link_web) {
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings();
        webview.clearCache(true);
        webview.clearFormData();
        webview.clearHistory();
        webview.setBackgroundColor(Color.TRANSPARENT);
        WebSettings webSettings = webview.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setDefaultFontSize(18);
        webSettings.setTextZoom((int) (webSettings.getTextZoom() * 1.2));
        //  settings_dapan.setTextZoom((int) (settings.getTextZoom() * 1.1));
        /* <html><body  align='center'>You scored <b>192</b> points.</body></html>*/
        String pish = "<html><body  align='center'>";
        String pas = "</body></html>";

        webview.loadDataWithBaseURL("", pish + StringUtil.convert_html(link_web) + pas,
                "text/html", "UTF-8", "");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(final WebView view, String url) {
                super.onPageFinished(view, url);
                new CountDownTimer(1000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        int i = 0;
                        switch (view.getId()) {
                            case R.id.webview_debai:
                                hideDialogLoading();
                                break;
                            case R.id.webview_anwser_A:
                                i = rl_dapan_A.getHeight();
                                if (i > iHeightmax) {
                                    iHeightmax = i;
                                    setHeightAll(iHeightmax, webview_anwser_A);
                                    setHeightAll(iHeightmax, webview_anwser_B);
                                    setHeightAll(iHeightmax, webview_anwser_C);
                                    setHeightAll(iHeightmax, webview_anwser_D);
                                }
                                break;
                            case R.id.webview_anwser_B:
                                i = rl_dapan_B.getHeight();
                                if (i > iHeightmax) {
                                    iHeightmax = i;
                                    setHeightAll(iHeightmax, webview_anwser_A);
                                    setHeightAll(iHeightmax, webview_anwser_B);
                                    setHeightAll(iHeightmax, webview_anwser_C);
                                    setHeightAll(iHeightmax, webview_anwser_D);
                                }
                                break;
                            case R.id.webview_anwser_C:
                                i = rl_dapan_C.getHeight();
                                if (i > iHeightmax) {
                                    iHeightmax = i;
                                    setHeightAll(iHeightmax, webview_anwser_A);
                                    setHeightAll(iHeightmax, webview_anwser_B);
                                    setHeightAll(iHeightmax, webview_anwser_C);
                                    setHeightAll(iHeightmax, webview_anwser_D);
                                }
                                break;
                            case R.id.webview_anwser_D:
                                i = rl_dapan_D.getHeight();
                                if (i > iHeightmax) {
                                    iHeightmax = i;
                                    setHeightAll(iHeightmax, webview_anwser_A);
                                    setHeightAll(iHeightmax, webview_anwser_B);
                                    setHeightAll(iHeightmax, webview_anwser_C);
                                    setHeightAll(iHeightmax, webview_anwser_D);
                                }
                                break;
                        }
                    }
                }.

                        start();
            }
        });
    }

    int iHeightmax = 0;

    private void setHeightAll(final int iHeight, final View view) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams params = view.getLayoutParams();
                params.height = iHeight;
                view.setLayoutParams(params);
            }
        });

    }
}
