import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_getuuid/flutter_getuuid.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_getuuid');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterGetuuid.platformVersion, '42');
  });
}
