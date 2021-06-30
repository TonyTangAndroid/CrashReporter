package com.balsikandar.crashreporter;

import android.content.Context;

public class CrashReporter {

  private CrashReporter() {
  }

  public static void initialize(Context context) {
  }

  public static void initialize(Context context, String crashReportSavePath) {
  }


  public static boolean isNotificationEnabled() {
    return false;
  }

  public static void logException(Throwable throwable) {
  }


  public static void disableNotification() {
  }

  public static void launch(Context context) {
  }
}
