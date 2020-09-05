package com.aaratechnologies.allinonewebview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.skydoves.elasticviews.ElasticFloatingActionButton;
import com.tuyenmonkey.mkloader.MKLoader;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    MKLoader progress;
    NavigationView navigationView;
    DrawerLayout drawer;
    TextView privacy,terms_and_condition,faqs,blog;
    String Url="https://fourcutts.aaratechnologies.in/";
//    ElasticFloatingActionButton fab;

    CardView home,account,order,cart,notification,contactus,paypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.progress);
        privacy = findViewById(R.id.privacy);
        terms_and_condition = findViewById(R.id.terms_and_conditions);
        faqs = findViewById(R.id.faqs);
        blog = findViewById(R.id.blogs);
        home = findViewById(R.id.home);
        account = findViewById(R.id.account);
        order = findViewById(R.id.orders);
        cart = findViewById(R.id.cart);
        notification = findViewById(R.id.notification);
        contactus = findViewById(R.id.contactus);
        paypal = findViewById(R.id.paypal);


        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
        if (myToolBar != null) {
            setSupportActionBar(myToolBar);
//            getSupportActionBar().setLogo(R.drawable.lg1);
            // myToolBar.setTitle("Dashboard");
            // requestWindowFeature(Window.FEATURE_NO_TITLE);
            myToolBar.hideOverflowMenu();
        }
        //For drawer
        navigationView = findViewById(R.id.navigation_view);

        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolBar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        myToolBar.setNavigationIcon(R.drawable.menus);
        webView = findViewById(R.id.webView);
//       fab=findViewById(R.id.fab);
        progress.setVisibility(View.GONE);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.getAllowFileAccessFromFileURLs();
        webSettings.setPluginState(WebSettings.PluginState.ON);

        MywebViewClient mywebViewClient = new MywebViewClient();

        webView.setWebViewClient(mywebViewClient);

        if (isInternetConnected()) {
            webView.loadUrl(Url);
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    SharedPreferences sharedPreferences=getSharedPreferences("url_to_send",MODE_PRIVATE);
//                    String url1=sharedPreferences.getString("Data","https://lawtrend.in/");
//                    Log.d("lateurl", "onClick: "+url1);
//                    Intent sendIntent = new Intent();
//                    sendIntent.setAction(Intent.ACTION_SEND);
//                    sendIntent.putExtra(Intent.EXTRA_TEXT, ""+url1+" https://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID);
//                    sendIntent.setType("text/plain");
//                    startActivity(sendIntent);
//                }
//            });
        } else {
//            Intent i = new Intent(getApplicationContext(), NextActivity.class);
//            startActivity(i);
//            finish();
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl(Url);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);

                webView.loadUrl("https://fourcutts.aaratechnologies.in/customer-order.php");
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl("https://fourcutts.aaratechnologies.in/dashboard.php");
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl("https://fourcutts.aaratechnologies.in/cart.php");
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl("https://fourcutts.aaratechnologies.in/privacy&policy.php");
            }
        });
        terms_and_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl("https://fourcutts.aaratechnologies.in/terms&condition.php");
            }
        });
        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl("https://fourcutts.aaratechnologies.in/faq.php");
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.getAllowFileAccessFromFileURLs();
                webSettings.setPluginState(WebSettings.PluginState.ON);

                MywebViewClient mywebViewClient = new MywebViewClient();

                webView.setWebViewClient(mywebViewClient);
                webView.loadUrl("https://fourcutts.aaratechnologies.in/blog.php");
            }
        });


    }
    private class MywebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
//            Toast.makeText(getApplicationContext(), ""+url, Toast.LENGTH_SHORT).show();
//            if (url.contains("aaratechnologies.in")) {
//                SharedPreferences sharedPreferences = getSharedPreferences("url_to_send", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("Data", url);
//                editor.apply();
//                editor.commit();
//            }
//

            Log.d("lasturl", "shouldOverrideUrlLoading: " + url);

            if (isInternetConnected()) {
                if (url.indexOf("aaratechnologies.in") > -1)
                    return false;
            } else {
//                Intent i = new Intent(getApplicationContext(), NextActivity.class);
//                startActivity(i);
//                finish();
                Toast.makeText(MainActivity.this, "No internet found", Toast.LENGTH_SHORT).show();
            }


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            progress.setVisibility(View.GONE);
        }

        @Override
        public void onReceivedError(WebView view, int errCode, String errDescription, String failingUrl) {
            progress.setVisibility(View.GONE);
            Log.d("TAG", "GOt Page Error: code " + errCode + "Desc: " + errDescription);
            showError(MainActivity.this, errCode);
            //TODO We can show customized HTML page when page not found/ or server not found error.
            super.onReceivedError(view, errCode, errDescription, failingUrl);
//            view.clearView();
//
//
//
////            Toast.makeText(getApplicationContext(), "Error code is "+errCode, Toast.LENGTH_SHORT).show();
//            if(errCode == -2 || errCode == -8|| errCode==-6) {
////                view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");
////                Intent i=new Intent(getApplicationContext(),NextActivity.class);
////                startActivity(i);
////                finish();
//                Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
//            }
//
//            if(errCode == -14) {
////                view.loadData("Page cannot be found on server", "text/html", "UTF-8");
////                Intent i=new Intent(getApplicationContext(),NextActivity.class);
////                startActivity(i);
////                finish();
//                Toast.makeText(MainActivity.this, "Something Broken", Toast.LENGTH_SHORT).show();
//            }
//            if (errCode==-10){
////                Intent i=new Intent(getApplicationContext(), PageNotFound.class);
////                startActivity(i);
////                finish();
//                Toast.makeText(MainActivity.this, "PNF", Toast.LENGTH_SHORT).show();
//            }
//        }

        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    public boolean isInternetConnected() {
        // At activity startup we manually check the internet status and change
        // the text status
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;

    }
//    Then using the following showError method you can understand what kind of exception has occured.

    private void showError(Context mContext, int errorCode) {
        //Prepare message
        String message = null;
        String title = null;
        if (errorCode == WebViewClient.ERROR_AUTHENTICATION) {
            message = "User authentication failed on server";
            title = "Auth Error";
        } else if (errorCode == WebViewClient.ERROR_TIMEOUT) {
            message = "The server is taking too much time to communicate. Try again later.";
            title = "Connection Timeout";
        } else if (errorCode == WebViewClient.ERROR_TOO_MANY_REQUESTS) {
            message = "Too many requests during this load";
            title = "Too Many Requests";
        } else if (errorCode == WebViewClient.ERROR_UNKNOWN) {
            message = "Generic error";
            title = "Unknown Error";
        } else if (errorCode == WebViewClient.ERROR_BAD_URL) {
            message = "Check entered URL..";
            title = "Malformed URL";
        } else if (errorCode == WebViewClient.ERROR_CONNECT) {
            message = "Failed to connect to the server";
            title = "Connection Failed";
        } else if (errorCode == WebViewClient.ERROR_FAILED_SSL_HANDSHAKE) {
            message = "Failed to perform SSL handshake";
            title = "SSL Handshake Failed";
        } else if (errorCode == WebViewClient.ERROR_HOST_LOOKUP) {
            message = "Server or proxy hostname lookup failed";
            title = "Host Lookup Error";
        } else if (errorCode == WebViewClient.ERROR_PROXY_AUTHENTICATION) {
            message = "User authentication failed on proxy";
            title = "Proxy Auth Error";
        } else if (errorCode == WebViewClient.ERROR_REDIRECT_LOOP) {
            message = "Too many redirects";
            title = "Redirect Loop Error";
        } else if (errorCode == WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME) {
            message = "Unsupported authentication scheme (not basic or digest)";
            title = "Auth Scheme Error";
        } else if (errorCode == WebViewClient.ERROR_UNSUPPORTED_SCHEME) {
            message = "Unsupported URI scheme";
            title = "URI Scheme Error";
        } else if (errorCode == WebViewClient.ERROR_FILE) {
            message = "Generic file error";
            title = "File";
        } else if (errorCode == WebViewClient.ERROR_FILE_NOT_FOUND) {
            message = "File not found";
            title = "File";
        } else if (errorCode == WebViewClient.ERROR_IO) {
            message = "The server failed to communicate. Try again later.";
            title = "IO Error";
        }

        if (message != null) {
            new AlertDialog.Builder(mContext)
                    .setMessage(message)
                    .setTitle(title)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    setResult(RESULT_CANCELED);
                                    finish();
                                }
                            }).show();
        }


    }
}