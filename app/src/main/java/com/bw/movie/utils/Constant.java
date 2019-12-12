package com.bw.movie.utils;

import android.os.Environment;

/**
 * Describe：Constant
 * Author：fan
 * Data：2019/11/7
 * Time:9:08
 */

public class Constant {
    public final static String APP_ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + MainApplication.getInstance().getPackageName();
    public final static String DOWNLOAD_DIR = "/downlaod/";


}
