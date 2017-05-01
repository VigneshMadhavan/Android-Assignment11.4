package com.vigneshtraining.assignment114;

/**
 * Created by vimadhavan on 4/24/2017.
 */

public class LoadProgres {

    private String file;
    private String msg;
    private float percentage;
    private float loaded,totalSize;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }




    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public float getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(float totalSize) {
        this.totalSize = totalSize;
    }

    public float getLoaded() {
        return loaded;
    }

    public void setLoaded(float loaded) {
        this.loaded = loaded;
    }

    public float getPercentage() {
        this.percentage= (float) (((this.loaded*1.00)/(this.totalSize*1.00))*100.00);
        return this.percentage;
    }


}
