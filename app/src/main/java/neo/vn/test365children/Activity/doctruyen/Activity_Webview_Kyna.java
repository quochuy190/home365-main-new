package neo.vn.test365children.Activity.doctruyen;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.http.util.EncodingUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.R;

public class Activity_Webview_Kyna extends BaseActivity {
    private static final String TAG = "Activity_Webview_Edumal";
    @BindView(R.id.webview_edumall)
    WebView webView;

    @Override
    public int setContentViewId() {
        return R.layout.activity_webview_edumall;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MyAsyncTask().execute();
    }

    String token = "";

    public void webview_get_token(String token) {
        final HashMap<String, String> extraHeaders = new HashMap<String, String>();
        extraHeaders.put("authority", "kyna.vn");
        extraHeaders.put("accept", "*/*");
        extraHeaders.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        extraHeaders.put("origin", "https://kyna.vn");
        extraHeaders.put("referer", "https://kyna.vn/");
        extraHeaders.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/77.0.126 Chrome/71.0.3578.126 Safari/537.36");
        extraHeaders.put("x-csrf-token", "" + token + "");
        extraHeaders.put("x-requested-with", "XMLHttpRequest");
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url, extraHeaders);
                Log.e(TAG, "shouldOverrideUrlLoading: get");
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                webview_ClientPost();
                Log.e(TAG, "onPageStarted: get");
                super.onPageStarted(view, url, favicon);
            }
        });
        webView.loadUrl("https://kyna.vn/user/security/login", extraHeaders);
    }

    public void webview_ClientPost() {
        if (token != null) {
            CookieSyncManager.createInstance(this.getBaseContext());
            CookieSyncManager.getInstance().startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    Log.e(TAG, "shouldOverrideUrlLoading: ");
                    return false;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    Log.e(TAG, "onPageStarted: ");
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    // CookieSyncManager.getInstance().sync();
                    super.onPageFinished(view, url);
                }
            });
            String url = "https://kyna.vn/user/security/login";
            String postData = "cookieexists=false" +
                    "&_csrf=" + token +
                    "&login-form[login]=thammt@neo.vn" +
                    "&login-form[password]=123456a@" +
                    "&login-form[rememberMe]=0" +
                    "&currentUrl=https://kyna.vn/";
            webView.postUrl(url, EncodingUtils.getBytes(postData, "BASE64"));

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    Log.e(TAG, "shouldOverrideUrlLoading: " + url);
                    return false;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    Log.e(TAG, "onPageStarted: " + url);
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    // CookieSyncManager.getInstance().sync();
                    Log.e(TAG, "onPageFinished: " + url);
                    super.onPageFinished(view, url);
                }
            });
        }

        // CookieSyncManager.getInstance().sync();

    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            Connection.Response loginForm = null;
            try {
                loginForm = Jsoup.connect("https://kyna.vn/user/security/login")
                        .method(Connection.Method.GET)
                        .header("authority", "kyna.vn")
                        .header("accept", "*/*")
                        .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                        .header("origin", "https://kyna.vn")
                        .header("referer", "https://kyna.vn/")
                        .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/77.0.126 Chrome/71.0.3578.126 Safari/537.36")
                        .header("x-csrf-token", "WWRqVG0zSHE8CxxmBmARRGolWCcPdiAcYTsLYRxRASk4Kys5JlwESQ==")
                        .header("x-requested-with", "XMLHttpRequest")
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String resBody = loginForm.body();
            //  System.out.println("resBody:"+resBody);

            Document document;
            try {
                //Get Document object after parsing the html file.
                document = Jsoup.parse(resBody);

                //Get the form by id.
                Element testForm = document.getElementById("login-form");
                //  	System.out.println("PtestForm: " + testForm);
                //Get input parameters of the form.
                Elements inputElements = testForm.getElementsByTag("input");

                //Iterate parameters and print name and value.

                for (Element inputElement : inputElements) {
                    String key = inputElement.attr("name");
                    String value = inputElement.attr("value");
                    if (key.equalsIgnoreCase("_csrf")) {
                        //	System.out.println("Parameter Name: " + key);
                        //	System.out.println("Parameter Value: " + value);
                        token = value;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (token != null) {
                webview_get_token(token);
            }
            super.onPostExecute(aVoid);
        }
    }
}
