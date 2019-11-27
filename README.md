# flutter_getuuid

一款flutter插件用于获取android和iOS的设备信息

## 引入
####注意 ios环境需要用xcode打开项目然后

1. 找到Podfile文件在 "target 'Runner' do" 下添加 pod 'SAMKeychain'
2. 然后打开命令行工具进入项目执行pod install命令即可
- 添加位置
```yaml
target 'Runner' do
  pod 'SAMKeychain'
  Prepare symlinks folder. We use symlinks to avoid having Podfile.lock
  referring to absolute paths on developers' machines.
```
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
1.增加获取获取项目的vesionname
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
