# flutter_getuuid

一款flutter插件用于获取android和iOS的设备信息

## 使用需知
如果想用github上最新版本:

```yaml
dependencies:
  flutter_getuuid:
    git:
      url: https://github.com/wozhizhizhi/flutter_getuuid.git
```

## 如何使用

```
static netFetch() async {
    /// 获取手机的UUID
    uuid = await FlutterGetuuid.platformUid;
    /// 获取手机的型号如“iPhone7”
    phoneMark = await FlutterGetuuid.platformDeviceModle;
    /// 获取项目的版本号
    version = await FlutterGetuuid.platformVersionCode;
    /// 获取系统SDK版本
    systemMark = await FlutterGetuuid.platformSystemMark;
}
```
