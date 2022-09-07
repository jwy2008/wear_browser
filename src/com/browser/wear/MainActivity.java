package com.browser.wear;

import android.app.*;
import android.os.*;
import android.webkit.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final WebView myWebView = findViewById(R.id.webview);
		myWebView.setWebViewClient(new WebViewClient());
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.loadUrl("https://cn.bing.com");
		SearchView mySearchView = findViewById(R.id.searchView);
		mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String queryText){
			myWebView.loadUrl(queryText);
				return false;
			}

			@Override
			public boolean onQueryTextChange(String queryText){
				return false;
			}
		});
		Button back = findViewById(R.id.button_back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v){
				myWebView.goBack();
		}});
		Button flushed = findViewById(R.id.button_flushed);
		flushed.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v){
				myWebView.reload();
			}
	});
}}
