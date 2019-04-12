package com.havaid.app.flutter_getuuid;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.UUID;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterGetuuidPlugin */
public class FlutterGetuuidPlugin implements MethodCallHandler {
  private Context context;
  FlutterGetuuidPlugin(Context context){
    this.context = context;
  }
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_getuuid");
    channel.setMethodCallHandler(new FlutterGetuuidPlugin(registrar.context()));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }else if (call.method.equals("getDeviceUUID")){
      result.success(getDeviceUUID(context));
    }
    else if (call.method.equals("getVersionCode")){
      result.success(getVersionCode(context));
    }
    else if (call.method.equals("getsystemMark")){
      result.success(getsystemMark());
    }
    else if (call.method.equals("getCurrentDeviceModel")){
      result.success(getCurrentDeviceModel());
    }
    else {
      result.notImplemented();
    }
  }

  public static String getAndroidID(Context context)
  {
    String id = Settings.Secure.getString(
           context.getApplicationContext().getContentResolver(),
            Settings.Secure.ANDROID_ID
    );
    return id == null ? "" : id;
  }

  // 获取UUID
  public String getDeviceUUID(Context context)
  {
      String androidId = getAndroidID(context);
      UUID deviceUuid = new UUID(androidId.hashCode(), ((long)androidId.hashCode() << 32));
      String uuid;
      uuid = deviceUuid.toString().replace("-" , "");
      return uuid;
  }

  // 获取版本code
  public String getVersionCode(Context context)
  {
    int versionCode = 0;
    try
    {
      versionCode =  context.getPackageManager().getPackageInfo(context.getPackageName() , PackageManager.GET_CONFIGURATIONS).versionCode;
    }
    catch (PackageManager.NameNotFoundException e)
    {
      e.printStackTrace();
    }
    return versionCode+"";
  }

  // 系统使用的SDK版本
  private String getsystemMark()
  {
    return Build.VERSION.SDK;
  }

  // 手机的型号
  private String getCurrentDeviceModel()
  {
    return Build.MODEL;
  }


}
