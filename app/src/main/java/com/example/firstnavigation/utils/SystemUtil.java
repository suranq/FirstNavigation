package com.example.firstnavigation.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.example.firstnavigation.global.App;
import com.example.firstnavigation.shujukuBeans.Wifi;
import com.example.firstnavigation.shujukuBeans.WifiHelep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class SystemUtil {

    private static Wifi mWifi;

    /**
     * 检查WIFI是否连接
     */
    public static boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getApp().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return wifiInfo != null;
    }

    /**
     * 检查wifi是否处开连接状态
     *
     * @return
     */
    public static boolean isWifiConnect() {
        ConnectivityManager connManager = (ConnectivityManager) App.getApp().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWifiInfo.isConnected();
    }

    /**
     * 检查手机网络(4G/3G/2G)是否连接
     */
    public static boolean isMobileNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getApp().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileNetworkInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return mobileNetworkInfo != null;
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getApp().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 保存文字到剪贴板
     *
     * @param context
     * @param text
     */
    public static void copyToClipBoard(Context context, String text) {
        ClipData clipData = ClipData.newPlainText("url", text);
        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        manager.setPrimaryClip(clipData);
//        ToastUtil.shortShow("已复制到剪贴板");
    }

    /**
     * 保存图片到本地
     * @param context
     * @param url
     * @param bitmap
     */
//    public static Uri saveBitmapToFile(Context context, String url, Bitmap bitmap, View container, boolean isShare){
//        String fileName = url.substring(url.lastIndexOf("/"),url.lastIndexOf(".")) + ".png";
//        File fileDir = new File(Constants.PATH_SDCARD);
//        if (!fileDir.exists()){
//            fileDir.mkdirs();
//        }
//        File imageFile = new File(fileDir,fileName);
//        Uri uri = Uri.fromFile(imageFile);
//        if (isShare && imageFile.exists()) {
//            if (Build.VERSION.SDK_INT >= 24) {
//                uri = FileProvider.getUriForFile(context.getApplicationContext(),
//                        Constants.FILE_PROVIDER_AUTHORITY, imageFile);
//            }
//            return uri;
//        }
//        try {
//            FileOutputStream fos = new FileOutputStream(imageFile);
//            boolean isCompress = bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
//            if (isCompress) {
//                SnackbarUtil.showShort(container,"保存妹纸成功n(*≧▽≦*)n");
//            } else {
//                SnackbarUtil.showShort(container,"保存妹纸失败ヽ(≧Д≦)ノ");
//            }
//            fos.flush();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            SnackbarUtil.showShort(container,"保存妹纸失败ヽ(≧Д≦)ノ");
//        }
//        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(), imageFile.getAbsolutePath(), fileName, null);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,uri));
//        if (Build.VERSION.SDK_INT >= 24) {
//            uri = FileProvider.getUriForFile(context.getApplicationContext(),
//                    Constants.FILE_PROVIDER_AUTHORITY, imageFile);
//        }
//        return uri;
//    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int dp2px(float dpValue) {
        final float scale = App.getApp().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = App.getApp().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static boolean isOpen(){
        List<Wifi> wifis = WifiHelep.getInsh().selectAll();
        boolean isopen;
        for (int i = 0; i < wifis.size(); i++) {
            mWifi = wifis.get(i);
        }
        if (mWifi.getIsOpen()){
            if (isWifiConnect()){
                isopen = true;
            }else {
                isopen = false;
            }
        }else {
            isopen = true;
        }
        return isopen;
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    /*
     * 获取泛型类Class对象，不是泛型类则返回null
	 */
    public static Class<?> getActualTypeArgument(Class<?> clazz) {
        Class<?> entitiClass = null;
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                entitiClass = (Class<?>) actualTypeArguments[0];
            }
        }
        return entitiClass;
    }}
