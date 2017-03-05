    package com.example.gourav.piddebug;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.webkit.WebView;
    import android.widget.EditText;
    import android.widget.SeekBar;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        private EditText ekproll, ekpyaw, ekiroll, ekiyaw, ekdroll, ekdyaw ;
        private SeekBar seekBar;
        private TextView textView;
        public void Seekbar(){
            seekBar = (SeekBar)findViewById(R.id.seekBar);
            textView = (TextView) findViewById(R.id.textView6);
            seekBar.setOnSeekBarChangeListener(
                    new SeekBar.OnSeekBarChangeListener() {

                        float progress_value;
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            progress_value = progress;
                            progress_value=progress_value*250/100;
                            textView.setText("Covered : " + progress_value + " / " +250);
                            thrust(progress_value);
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
//                        Toast.makeText(MainActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            textView.setText("Covered : " + progress_value + " / " +250);
                            thrust(progress_value);
//                        Toast.makeText(MainActivity.this,"SeekBar in StopTracking",Toast.LENGTH_LONG).show();
                        }
                    }
            );

        }
        public void thrust(float thrust){
            int th = (int)thrust;
            String s= Integer.toString( th ) ;
            String http = "http://192.168.43.1:8080?command= 000" ;
            int n = s.length();
            if( n == 1 ){
                http = "http://192.168.43.1:8080?command= 000" ;
            }
            if( n == 2 ){
                http = "http://192.168.43.1:8080?command= 00" ;
            }
            if( n == 3 ){
                http = "http://192.168.43.1:8080?command= 0" ;
            }
            if( n == 4 ){
                http = "http://192.168.43.1:8080?command= " ;
            }
            String url = http + s ;
            WebView browser = (WebView)findViewById(R.id.webview);
            browser.getSettings().setLoadsImagesAutomatically(true);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.loadUrl(url);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Seekbar();
    }

       public void start(View view){
        WebView browser = (WebView)findViewById(R.id.webview);
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
        browser.loadUrl("http://192.168.43.1:8080/?command=start");
    }
        public void stop(View view){
            WebView browser = (WebView)findViewById(R.id.webview);
            browser.getSettings().setLoadsImagesAutomatically(true);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
            browser.loadUrl("http://192.168.43.1:8080/?command=sstop");
        }
        public void estop(View view){
            WebView browser = (WebView)findViewById(R.id.webview);
            browser.getSettings().setLoadsImagesAutomatically(true);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
            browser.loadUrl("http://192.168.43.1:8080/?command=estop");
        }
        public void zero(View view){
            WebView browser = (WebView)findViewById(R.id.webview);
            browser.getSettings().setLoadsImagesAutomatically(true);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
            browser.loadUrl("http://192.168.43.1:8080/?command=szero");
        }
        public void send(View view){
            ekproll = (EditText)findViewById(R.id.kproll);
            ekpyaw = (EditText)findViewById(R.id.kpyaw);
            ekiroll = (EditText)findViewById(R.id.kiroll);
            ekiyaw = (EditText)findViewById(R.id.kiyaw);
            ekdroll = (EditText)findViewById(R.id.kdroll);
            ekdyaw = (EditText)findViewById(R.id.kdyaw);
            String kproll = ekproll.getText().toString();
            String kpyaw  = ekpyaw.getText().toString();
            String kiroll = ekiroll.getText().toString();
            String kiyaw = ekiyaw.getText().toString();
            String kdroll = ekdroll.getText().toString();
            String kdyaw = ekdyaw.getText().toString();
            WebView browser = (WebView)findViewById(R.id.webview);
            browser.getSettings().setLoadsImagesAutomatically(true);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
            String url = "http://192.168.43.1:8080?command=constants&kp="+kproll+"&ki="+kiroll+"&kd="+kdroll+"&ykp="+kpyaw+"&yki="+kiyaw+"&ykd="+kdyaw;
            browser.loadUrl(url);
        }
        public void reset(View view){
            WebView browser = (WebView)findViewById(R.id.webview);
            browser.getSettings().setLoadsImagesAutomatically(true);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
            browser.loadUrl("http://192.168.43.1:8080/?command=reset");
        }
}
