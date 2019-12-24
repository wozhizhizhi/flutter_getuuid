# flutter_getuuid

一款flutter插件用于获取android和iOS的设备信息

## 引入
在你的 `pubspec.yaml` 文件中添加如下依赖:

```yaml
dependencies:
  flutter_getuuid: ^0.0.1
```

如果想用github上最新版本:

```yaml
dependencies:
  flutter_getuuid:
    git:
      url: https://github.com/wozhizhizhi/flutter_getuuid.git
```
1.增加获取项目的vesionname，如需使用这种方法请使用git集成方式，pub暂时还没上传上去
## 如何使用
```
static netFetch() async {
    /// 获取手机的UUID
    uuid = await FlutterGetuuid.platformUid;
    /// 获取手机的型号如“iPhone7”
    phoneMark = await FlutterGetuuid.platformDeviceModle;
    /// 获取项目的vesion-code
    version = await FlutterGetuuid.platformVersionCode;
    /// 获取系统SDK版本
    systemMark = await FlutterGetuuid.platformSystemMark;
    /// 获取项目的vesion-name
    version = await FlutterGetuuid.platformVersionName;
}
```
