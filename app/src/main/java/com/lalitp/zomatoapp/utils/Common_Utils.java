package com.lalitp.zomatoapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common_Utils {

    private static long lastClickTime = 0;

    public static boolean isNotNullOrEmpty(String str) {

        if (str != null
                && !str.equalsIgnoreCase("null")
                && !str.isEmpty()
                //&& !str.contains("null")
                && !str.equalsIgnoreCase("")
                && !str.equalsIgnoreCase(" ")) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * Convert String into TimeStamp
     **/
    public static String getTimeStamp(String strDate) {
        String niceDateStr = "";
        if (!Common_Utils.isNotNullOrEmpty(strDate))
            return niceDateStr;

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        Date date;
        try {
            date = inputFormat.parse(strDate);
            niceDateStr = (String) DateUtils.getRelativeTimeSpanString(date.getTime(), Calendar.getInstance().getTimeInMillis(), DateUtils.MINUTE_IN_MILLIS);

            return niceDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return niceDateStr;

    }

    public static boolean isNotFrequentClick() {

        if (SystemClock.elapsedRealtime() - lastClickTime < 700) {
            return false;
        }

        lastClickTime = SystemClock.elapsedRealtime();
        return true;
    }

    public static void openUrl(Activity activity,String url) {
        if(isNotNullOrEmpty(url)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
        }
    }
}
