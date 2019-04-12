import 'dart:async';

import 'package:flutter/services.dart';

class FlutterGetuuid {
  static const MethodChannel _channel =
      const MethodChannel('flutter_getuuid');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> get platformUid async {
    final String uuid = await _channel.invokeMethod('getDeviceUUID');
    return uuid;
  }

  static Future<String> get platformDeviceModle async {
    final String uuid = await _channel.invokeMethod('getCurrentDeviceModel');
    return uuid;
  }

  static Future<String> get platformVersionCode async {
    final String versionCoce = await _channel.invokeMethod('getVersionCode');
    return versionCoce;
  }

  static Future<String> get platformSystemMark async {
    final String systemMark = await _channel.invokeMethod('getsystemMark');
    return systemMark;
  }

}
