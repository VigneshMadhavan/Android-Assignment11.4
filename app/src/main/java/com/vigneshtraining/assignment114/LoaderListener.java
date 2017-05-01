package com.vigneshtraining.assignment114;

import android.graphics.Bitmap;

/**
 * Created by vimadhavan on 4/27/2017.
 */

public interface LoaderListener {
    void onProgress(LoadProgres progres);
    void onLoaded(Bitmap bitmap);
    void onSaved(String filePath);
    void onStartLoading();
    void onError(String msg);

}
