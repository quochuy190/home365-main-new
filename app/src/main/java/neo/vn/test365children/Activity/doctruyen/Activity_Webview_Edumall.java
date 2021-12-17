package neo.vn.test365children.Activity.doctruyen;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EncodingUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.Models.MessageEvent;
import neo.vn.test365children.Models.ObjLessonSkill;
import neo.vn.test365children.Presenter.PresenterLogActionServer;
import neo.vn.test365children.R;
import neo.vn.test365children.Service.BoundServiceCountTime;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;
import neo.vn.test365children.Untils.TimeUtils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW;

public class Activity_Webview_Edumall extends BaseActivity {
    private static final String TAG = "Activity_Webview_Edumal";
    @BindView(R.id.webview_edumall)
    WebView webView;
    boolean isFirtLoad = false;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.btn_home)
    ImageView btn_home;
    ObjLessonSkill objLessonSkill;
    String sUserWeb = "", sPassWeb = "", sLinkWebBase;
    String sUrlCompare, url_out;
    PresenterLogActionServer mPresenter;
    String sUserMother = "", sUserKid = "";
    private boolean isBound = false;
    private Intent intent;
    private BoundServiceCountTime myService;
    int iTotalTime = 45 * 60 * 1000;
    @BindView(R.id.img_time)
    ImageView img_time;
    @BindView(R.id.txt_time)
    TextView txt_time;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundServiceCountTime.MyBinder binder = (BoundServiceCountTime.MyBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    private void start_service_downtime() {
        EventBus.getDefault().register(this);
        // Tạo đối tượng Intent cho WeatherService.
        intent = new Intent(this, BoundServiceCountTime.class);
        if (iTotalTime > 0)
            intent.putExtra(Constants.KEY_SEND_TIME_SERVICE, iTotalTime);
        else
            intent.putExtra(Constants.KEY_SEND_TIME_SERVICE, 0);
        // Gọi method bindService(..) để giàng buộc dịch vụ với giao diện.
        this.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.animation_time);
        img_time.startAnimation(animationRotale);
    }

    private void stop_service() {
        EventBus.getDefault().unregister(this);
        if (isBound) {
            // Tắt Service
            unbindService(connection);
            isBound = false;
        }
    }

    @Override
    public int setContentViewId() {
        return R.layout.activity_webview_edumall;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.message.equals("Service")) {
            if (event.point == 0) {
                if (event.time < (10 * 60 * 1000)) {
                    txt_time.setTextColor(getResources().getColor(R.color.orange));
                } else txt_time.setTextColor(getResources().getColor(R.color.white));
                if (event.time < (5 * 60 * 1000)) {
                    txt_time.setTextColor(getResources().getColor(R.color.red_test365));
                }
                txt_time.setText(TimeUtils.formatDuration((int) event.time));
            } else {
                if (objLessonSkill.getURL1().indexOf("tienganh123.com") > 0) {
                    showDialogComfirm("Thông báo", "Phiên đăng nhập của bạn hôm nay đã hết hạn",
                            false, new ClickDialog() {
                                @Override
                                public void onClickYesDialog() {
                                    mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "eg123_out", objLessonSkill.getID());
                                    isFinish = true;
                                    webView.loadUrl("https://m.tienganh123.com/logout");
                                }

                                @Override
                                public void onClickNoDialog() {

                                }
                            });
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop_service();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirtLoad = false;
        mPresenter = new PresenterLogActionServer();
        initData();
        initEvent();

        // webview_ClientPost();
        //   webview_tienganh123();
        //webview_ucan();
    }

    private void initData() {
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserKid = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        webView.clearFormData();
        webView.clearHistory();
        webView.clearCache(true);
        webView.clearMatches();
        objLessonSkill = (ObjLessonSkill) getIntent().getSerializableExtra(Constants.KEY_SEND_OBJ_LESSON_SKILL);
        if (objLessonSkill != null)
            if (objLessonSkill.getURL1() != null && objLessonSkill.getURL1().indexOf("edumall.vn") > 0) {
                url_base = objLessonSkill.getURLONLINE();
                sUserWeb = objLessonSkill.getURL_USER();
                sPassWeb = objLessonSkill.getURL_PASS();
                sLinkWebBase = objLessonSkill.getURL2();
                url_home = objLessonSkill.getURL1();
                //  sUrlCompare = sLinkWebBase.substring(0, (sLinkWebBase.length() - 9));
                sUrlCompare = objLessonSkill.getURL3();
                url_out = objLessonSkill.getURL_OUT();
                img_time.setVisibility(View.GONE);
                txt_time.setVisibility(View.GONE);
                //login_edumall();
                webview_ClientPost();
            } else if (objLessonSkill.getURL1() != null && objLessonSkill.getURL1().indexOf("tienganh123.com") > 0) {
                start_service_downtime();
                img_time.setVisibility(View.VISIBLE);
                txt_time.setVisibility(View.VISIBLE);
                sLinkWebBase = objLessonSkill.getURL2();
                sUrlCompare = objLessonSkill.getURL3();
                url_home = objLessonSkill.getURL1();
                url_base = objLessonSkill.getURLONLINE();
                sUserWeb = objLessonSkill.getURL_USER();
                sPassWeb = objLessonSkill.getURL_PASS();
                webview_tienganh123();
            } else if (objLessonSkill.getURL1() != null && objLessonSkill.getURL1().indexOf("ucan.vn") > 0) {
                sLinkWebBase = objLessonSkill.getURL2();
                sUrlCompare = objLessonSkill.getURL3();
                url_home = objLessonSkill.getURL1();
                url_base = objLessonSkill.getURLONLINE();
                sUserWeb = objLessonSkill.getURL_USER();
                sPassWeb = objLessonSkill.getURL_PASS();
                img_time.setVisibility(View.GONE);
                txt_time.setVisibility(View.GONE);
                webview_ucan();
            } else if (objLessonSkill.getURL1() != null && objLessonSkill.getURL1().indexOf("home365.online") > 0) {
                sLinkWebBase = objLessonSkill.getURL2();
                sUrlCompare = objLessonSkill.getURL3();
                url_home = objLessonSkill.getURL1();
                url_base = objLessonSkill.getURLONLINE();
                sUserWeb = objLessonSkill.getURL_USER();
                sPassWeb = objLessonSkill.getURL_PASS();
                img_time.setVisibility(View.GONE);
                txt_time.setVisibility(View.GONE);
                goUrlHome365(sLinkWebBase);
            }
        //showDialogLoading();
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Webview_Edumall.this);
                if (webView.canGoBack()) {
                    webView.goBack();
                    // txt_url.setText(webView.getUrl());
                } else {
                    sign_out();
                }
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Webview_Edumall.this);
                sign_out();
            }
        });
    }

    String url_base, url_home;

    public void webview_ClientPost() {
        CookieSyncManager.createInstance(this.getBaseContext());
        CookieSyncManager.getInstance().startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        webView.getSettings().setJavaScriptEnabled(true);
        // webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.setWebChromeClient(new MyChrome());
        webView.setWebViewClient(new WebViewClientEdumail());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(MIXED_CONTENT_ALWAYS_ALLOW);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        String url = "https://edumall.vn/users/sign_in";
        String postData = null;
        try {
            postData = "cookieexists=false" +
                    "&user[email]=" + URLEncoder.encode(sUserWeb, "UTF-8") +
                    "&user[password]=" + URLEncoder.encode(sPassWeb, "UTF-8") +
                    "&authenticity_token=" + URLEncoder.encode(sPassWeb, "UTF-8") +
                    "&login=Login";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //webView.postUrl(url_base, EncodingUtils.getBytes(postData, "BASE64"));
        webView.postUrl(url_base, EncodingUtils.getBytes(postData, "UTF-8"));
        // webView.postUrl(url_base, postData.getBytes());
        //  webView.setWebViewClient(new WebViewClientEdumail());
        //CookieSyncManager.getInstance().sync();
    }

    public void webview_tienganh123() {
        CookieSyncManager.createInstance(this.getBaseContext());
        CookieSyncManager.getInstance().startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        webView.getSettings().setJavaScriptEnabled(true);
        // webView.setWebChromeClient(new MyChrome());
        webView.setWebViewClient(new WebViewClient_tienganh123());
        String url = "https://m.tienganh123.com/login?fr=aHR0cHM6Ly9tLnRpZW5nYW5oMTIzLmNvbS8=";
        if (url_base != null && url_base.length() > 0 && sUserWeb.length() > 0 && sPassWeb.length() > 0) {
            String postData =
                    "&username=" + sUserWeb +
                            "&password=" + sPassWeb +
                            "&submit=Đăng nhập";
            webView.postUrl(url_base, EncodingUtils.getBytes(postData, "BASE64"));
        } else {
            String postData =
                    "&username=sieutienganhth" +
                            "&password=sieutienganh123@" +
                            "&submit=Đăng nhập";
            webView.postUrl(url, EncodingUtils.getBytes(postData, "BASE64"));
        }
        CookieSyncManager.getInstance().sync();

    }

    public void webview_ucan() {
        CookieSyncManager.createInstance(this.getBaseContext());
        CookieSyncManager.getInstance().startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        webView.getSettings().setJavaScriptEnabled(true);
        // webView.setWebChromeClient(new MyChrome());
        webView.setWebViewClient(new WebViewClient_ucan());
        String url = "https://www.ucan.vn/shark/public/user/authenticate";

        if (url_base != null && url_base.length() > 0 && sUserWeb.length() > 0 && sPassWeb.length() > 0) {
            String postData = "cookieexists=false" +
                    "&email=" + sUserWeb +
                    "&password=" + sPassWeb +
                    "&login=Đăng nhập";
            webView.postUrl(url_base, EncodingUtils.getBytes(postData, "BASE64"));
        } else {
            String postData = "cookieexists=false" +
                    "&email=nhungnt@neo.vn" +
                    "&password=123456a@" +
                    "&login=Đăng nhập";
            webView.postUrl(url, EncodingUtils.getBytes(postData, "BASE64"));
        }

        //CookieSyncManager.getInstance().sync();

    }

    private class WebViewClientEdumail extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        public void onPageFinished(WebView view, String url) {
            if (isFirtLoad) {
                hideDialogLoading();
            }
            if (url.toString().indexOf(sUrlCompare) > -1) {
                Log.e(TAG, "onPageFinished: loading đúng phạm vi");
            } else {
                //  webView.goBack();
                Log.e(TAG, "onPageFinished: loading ngoài phạm vi");
            }
          /*  if (isFirtLoad) {
                if (url.toString().indexOf(sUrlCompare) > -1) {
                    Log.e(TAG, "onPageFinished: loading đúng phạm vi");
                } else {
                    webView.loadUrl(sLinkWebBase);
                    Log.e(TAG, "onPageFinished: loading ngoài phạm vi");
                }
            }*/

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
           /* if (isFirtLoad)
                hideDialogLoading();*/
            Log.e(TAG, "onPageStarted: start loading " + url);
            if (!isFirtLoad) {
                // showDialogLoading();
                mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "lesson_skill_in", objLessonSkill.getID());
                webView.loadUrl(sLinkWebBase);
                isFirtLoad = true;
                return;
            }
            Log.e(TAG, "onPageStarted index url: " + url.toString().indexOf(sUrlCompare));
            Log.e(TAG, "onPageStarted index url base: " + sUrlCompare);
            if (!isFinish) {
                if (url.toString().indexOf(sUrlCompare) > -1) {
                    Log.e(TAG, "onPageStarted: loading đúng phạm vi");
                } else {
                    webView.goBack();
                    Log.e(TAG, "onPageStarted: loading ngoài phạm vi");
                }
            }
            if (isFinish) {
                if (url.equals(url_base)) {
                    finish();
                    return;
                }
            }

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (request.hasGesture()) {
                    showDialogLoading();
                }
            }
            Log.e(TAG, "shouldOverrideUrlLoading: loading");
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.e(TAG, "onReceivedError: ");
            super.onReceivedError(view, request, error);
        }

    }

    private class WebViewClient_tienganh123 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        public void onPageFinished(WebView view, String url) {
            if (isFirtLoad)
                hideDialogLoading();
            Log.e(TAG, "onPageFinished: ");
          /*  if (!isFirtLoad) {
                if (sLinkWebBase != null && sLinkWebBase.length() > 0) {
                    showDialogLoading();
                    webView.loadUrl(sLinkWebBase);
                } else {
                    webView.loadUrl("https://www.tienganh123.com/");
                }
                isFirtLoad = true;
                return;
            }*/
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.e(TAG, "onPageStarted: start loading" + url);
            //hideDialogLoading();
            if (!isFirtLoad) {
                mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "eg123_in", objLessonSkill.getID());
                if (sLinkWebBase != null && sLinkWebBase.length() > 0) {
                    webView.loadUrl(sLinkWebBase);
                } else {
                    webView.loadUrl("https://www.tienganh123.com/");
                }
                isFirtLoad = true;
                return;
            }
            if (isFirtLoad) {
                if (url.indexOf("m.tienganh123.com/login?") > 0) {
                    mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "eg123_out", objLessonSkill.getID());
                    isFinish = true;
                    webView.loadUrl("https://m.tienganh123.com/logout");
                }
            }
            if (!isFinish) {
                if (url.toString().indexOf(sUrlCompare) > -1) {
                    Log.e(TAG, "onPageStarted: loading đúng phạm vi");
                } else if (url.toString().indexOf(sLinkWebBase) > -1) {
                    Log.e(TAG, "onPageStarted: loading đúng phạm vi");
                } else {
                    webView.goBack();
                    Log.e(TAG, "onPageStarted: loading ngoài phạm vi");
                }
            }
            if (isFinish && url.equals("https://m.tienganh123.com/")) {
                finish();
                return;
            }
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (request.hasGesture()) {
                    showDialogLoading();
                }
            }
            Log.e(TAG, "shouldOverrideUrlLoading: loading");
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.e(TAG, "onReceivedError: ");
            super.onReceivedError(view, request, error);
        }

    }

    private class MyChrome extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        MyChrome() {
        }

        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout) getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) getWindow().getDecorView()).addView(this.mCustomView,
                    new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    boolean isFinish = false;

    public void call_back() {
        if (webView.canGoBack()) {
            webView.goBack();
            //  txt_url.setText(webView.getUrl());
        } else {
            sign_out();
        }
    }

    public void sign_out() {
        showDialogComfirm("Thông báo", "Bạn có chắc chắn muốn trở về trang chủ của ứng dụng",
                true, new ClickDialog() {
                    @Override
                    public void onClickYesDialog() {
                        if (objLessonSkill.getURL1().indexOf("edumall.vn") > 0) {
                            mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "lesson_skill_out", objLessonSkill.getID());
                            if (!isFinish) {
                                isFinish = true;
                                if (url_out != null && url_out.length() > 0)
                                    webView.loadUrl(url_out);
                                else
                                    finish();
                            } else {
                                finish();
                            }

                        } else if (objLessonSkill.getURL1().indexOf("tienganh123.com") > 0) {
                            mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "eg123_out", objLessonSkill.getID());
                            isFinish = true;
                            webView.loadUrl("https://m.tienganh123.com/logout");
                        } else {
                            mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "lesson_skill_out", objLessonSkill.getID());
                            finish();
                        }

                        //finish();
                    }

                    @Override
                    public void onClickNoDialog() {
                    }
                });
    }

    @Override
    public void onBackPressed() {
        call_back();
    }

    private class WebViewClient_ucan extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        public void onPageFinished(WebView view, String url) {
            if (isFirtLoad)
                hideDialogLoading();
            Log.e(TAG, "onPageFinished: ");
            if (!isFirtLoad) {
                mPresenter.api_log_web_lesson_skill(sUserMother, sUserKid, "lesson_skill_in", objLessonSkill.getID());
                webView.loadUrl("https://www.ucan.vn/hoc-tieng-anh-giao-tiep-voi-giao-vien-ban-ngu");
                isFirtLoad = true;
            }
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.e(TAG, "onPageStarted: start loading" + url);
           /* if (!isFirtLoad) {
                webView.loadUrl("https://www.ucan.vn/hoc-tieng-anh-giao-tiep-voi-giao-vien-ban-ngu");
                isFirtLoad = true;
            }*/
            //hideDialogLoading();
            if (!isFinish) {
                if (url.toString().indexOf("https://www.ucan.vn/user/account") > -1) {
                    webView.goBack();
                    Log.e(TAG, "onPageStarted: loading ngoài phạm vi");
                } else if (url.toString().indexOf("https://www.ucan.vn/tai-khoan") > -1) {
                    webView.goBack();
                } else if (url.toString().indexOf("www.ucan.vn/doi-mat-khau") > -1) {
                    webView.goBack();
                } else if (url.toString().indexOf("www.ucan.vn/thong-tin-co-ban") > -1) {
                    webView.goBack();
                } else if (url.toString().indexOf("www.ucan.vn/anh-dai-dien") > -1) {
                    webView.goBack();
                }
            }
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (request.hasGesture()) {
                    showDialogLoading();
                }
            }
            Log.e(TAG, "shouldOverrideUrlLoading: loading");
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.e(TAG, "onReceivedError: ");
            super.onReceivedError(view, request, error);
        }
    }

    public void login_edumall() {
        String url = sLinkWebBase;

        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(wvc);
        webView.loadUrl(url_base);

    }

    public WebViewClient wvc = new WebViewClient() {

        @SuppressWarnings("deprecation")
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            try {
                OkHttpClient client = new OkHttpClient();

                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody body = RequestBody.create(mediaType, "cookieexists=false&user%5Bemail%5D=0918881173&user%5Bpassword%5D=t!nhng123&authenticity_token=t!nhng123&login=Login");
                Request request = new Request.Builder()
                        .url("https://lms.edumall.vn/users/sign_in")
                        .post(body)
                        .addHeader("User-Agent", "PostmanRuntime/7.11.0")
                        .addHeader("Accept", "*/*")
                        .addHeader("cookie", "PHPSESSID=6pb9debqhqq6nr9e3s10ecd8jm; wp_customerGroup=NOT+LOGGED+IN; __cfduid=d4d0355b649612c51cc13e1a1a311e39a1557387965; remember_user_token=W1siNTlhZjZiMTkwZTEyNjY0YjQ4MDAwMGI4Il0sIiQyYSQxMCRaVG1scjJwVkt3RTUxeWIwd0kwR3llIl0%3D--7fff1028a40669f2f99eb9b8416f9beb98e0758c; EDM_sso_cookie=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiNTlhZjZiMTkwZTEyNjY0YjQ4MDAwMGI4IiwiZXhwaXJlZF9hdCI6MTU1ODU5NzQ3OX0.NHUhapcBKuNzGRSs0hBts3p-WyIX53g5r_C9T3QfBSk; _session_id=L1VObjhNKzJrUWJESERnTXpBMC9GMCtmTm9YRkhVL09OUnZoY2wvZDlQRElOMThUTDIrM1c3NE5Bb3FSY212VnZDdmVhd0FKdnJGVTNJZVVWZG5vWUV3SVB2c2p4dWtGY0VtcCtDZTYzcWtTdU1BL3U4bjM5S0hXVGhXeG9JQnhnSHh2OVFkT2hhTjZXYUtwUUc5SHR3SFdYaVdPUXRqTTRzZVBSY0FCQnA3M2o0UTRMUnRNVk43ekZRZFlpQ3V2Y050UVpkY1JNVVdrYkJUcFFJb0dyQT09LS1IK1JialhmbnNyUi8xWjBRWTB1RmZnPT0%3D--d917efd9fe68564873f0e3bcb18cc29f221306e5; _edm_ss=eXp0TENyQ2FCaytOZm9HdUkrK1RidS9rUnNhczZxWjdJdFFlSzVFMW1jUmR2WDdQMERLZENOZ0lScDB3bUpIWDVBK1BJR3NEeHg1bzFQRjlWRUZFUWliQ3NuZ3FQd05LdHpXbUtSOUNsSGhuMEdTYnplWjhrb3Z3UExsTW1kMmhkNGFlamVTbjRyaWdnMHVHbzN0a1k5VVd4NjFteFlsZE1nYVhOQS8zK0FZRnhSN202Y2x1WTNMeUR3RlhKOGs1bGlsWTlzSnVJb0x5TS9VZ0FZalpTQT09LS1XT1cwclZOVlZ5QVlRS1RkNGcrUi9nPT0%3D--e57ff341beece71ae646d33e01a5e3bd86fbe181")
                        .addHeader("accept-encoding", "gzip, deflate")
                        .addHeader("referer", "https://lms.edumall.vn/")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("Postman-Token", "a04843fa-5a6d-4e3d-b789-2780fa0dfc58")
                        .build();

                Response response = client.newCall(request).execute();
                webView.loadUrl(sLinkWebBase);
               /* return new WebResourceResponse(response.header("text/html", response.body().contentType().type()), // You can set something other as default content-type
                        response.header("content-encoding", "utf-8"),  // Again, you can set another encoding as default
                        response.body().byteStream());*/
                return null;

            } catch (ClientProtocolException e) {
                //return null to tell WebView we failed to fetch it WebView should try again.
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }

    private void goUrlHome365(String url) {
        if (url.isEmpty()) {
            Toast.makeText(this, "Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }

        //  webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new Browser_home_all());
        //  webView.setWebViewClient(new CheckServerTrustedWebViewClient());
        webView.setWebChromeClient(new MyChromeAll());
        //webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setBackgroundColor(Color.TRANSPARENT);
        /** JAVADOC QUOTE: Clears the SSL preferences table stored in response to proceeding with SSL certificate errors.*/
        webView.clearSslPreferences();
        // Added in API level 8
//Those other methods I tried out of despair just in case
        webView.clearFormData();
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearMatches();
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setDefaultFontSize(18);
        webSettings.setTextZoom((int) (webSettings.getTextZoom() * 1.1));
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.requestFocusFromTouch();
        webView.loadUrl(url);
        //webView.loadDataWithBaseURL(url,"","text/html","utf-8",null);
    }

    class MyChromeAll extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        MyChromeAll() {
        }

        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout) getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) getWindow().getDecorView()).addView(this.mCustomView,
                    new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    class Browser_home_all extends WebViewClient {
        Browser_home_all() {
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.e(TAG, "onPageStarted: start loading");
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (request.hasGesture()) {
                    showDialogLoading();
                }
            }
            Log.e(TAG, "shouldOverrideUrlLoading: loading");
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // setTitle(view.getTitle());
            Log.e(TAG, "onPageFinished: " + url);
            hideDialogLoading();
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.e(TAG, "onReceivedError: ");
            super.onReceivedError(view, request, error);
        }
    }
}
