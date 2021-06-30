package com.balsikandar.crashreporter;

import android.content.Context;
import android.content.Intent;

public class CrashReporter {

  private static Context applicationContext;

  private static String crashReportPath;

  private static boolean isNotificationEnabled = true;

  private CrashReporter() {
    // This class in not publicly instantiable
  }

  public static void initialize(Context context) {
    applicationContext = context;
    setUpExceptionHandler();
  }

  public static void initialize(Context context, String crashReportSavePath) {
    applicationContext = context;
    crashReportPath = crashReportSavePath;
    setUpExceptionHandler();
  }

  private static void setUpExceptionHandler() {
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof CrashReporterExceptionHandler)) {
      Thread.setDefaultUncaughtExceptionHandler(new CrashReporterExceptionHandler());
    }
  }

  static Context getContext() {
    if (applicationContext == null) {
      try {
        throw new CrashReporterNotInitializedException(
            "Initialize CrashReporter : call CrashReporter.initialize(context, crashReportPath)");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return applicationContext;
  }

  static String getCrashReportPath() {
    return crashReportPath;
  }

  public static boolean isNotificationEnabled() {
    return isNotificationEnabled;
  }

  // LOG Exception APIs
  public static void logException(Throwable throwable) {
    CrashUtil.logException(throwable);
  }

  static Intent getLaunchIntent() {
    return new Intent(applicationContext, CrashReporterActivity.class)
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  }

  public static void disableNotification() {
    isNotificationEnabled = false;
  }

  public static void launch(Context context) {
    Intent intent = new Intent(context, CrashReporterActivity.class);
    context.startActivity(intent);
  }
}
