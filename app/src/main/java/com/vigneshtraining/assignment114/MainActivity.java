package com.vigneshtraining.assignment114;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderListener,View.OnClickListener {

    private ProgressBar progreessBar;
    private ImageView image;
    private Button downloadBtn,cancelBtn;
    private DownloadFileFromURL downloadFile;
    private Toast toast;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView) findViewById(R.id.txt);
        progreessBar= (ProgressBar) findViewById(R.id.progressBar);
        image= (ImageView) findViewById(R.id.imageHolder);
        downloadBtn= (Button) findViewById(R.id.downloadBtn);
        cancelBtn= (Button) findViewById(R.id.cancelBtn);

        downloadBtn.setOnClickListener(this);

        cancelBtn.setOnClickListener(this);


    }

    @Override
    public void onProgress(LoadProgres progres) {
        progreessBar.setProgress((int) progres.getPercentage());
    }

    @Override
    public void onLoaded(Bitmap bitmap) {
        downloadFile.cancel(true);
        downloadFile=null;
        progreessBar.setVisibility(View.GONE);
        //image.setImageBitmap(bitmap);

        cancelBtn.setVisibility(View.GONE);
        downloadBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaved(String filePath) {
        onError("Save::"+filePath);
       image.setImageDrawable(Drawable.createFromPath(filePath));
    }

    @Override
    public void onStartLoading() {
        progreessBar.setProgress(0);
        progreessBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onError(String msg) {
        progreessBar.setVisibility(View.GONE);
        if(toast!=null){
            toast.cancel();
        }
        toast=Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.downloadBtn:
                downloadAction();
                break;

            case R.id.cancelBtn:
                cancelAction();
                break;
        }

    }

    private void downloadAction(){


        if(downloadFile!=null){
            downloadFile.cancel(false);
            downloadFile=null;
        }
        downloadFile=new DownloadFileFromURL(this);

        downloadBtn.setVisibility(View.GONE);

        cancelBtn.setVisibility(View.VISIBLE);
        downloadFile.execute(txt.getText().toString());

    }

    private void cancelAction(){
        progreessBar.setVisibility(View.GONE);

        cancelBtn.setVisibility(View.GONE);
        downloadBtn.setVisibility(View.VISIBLE);
        downloadFile.cancel(true);
        downloadFile=null;
    }


}
