package cn.ws.blazefire.cloudcontrol;

/**
 * 模拟器操作
 *
 * @author : 1041-XuWeiHua
 * Date : 2023-03-23 10:04
 */
public enum BusinessTypeEnum {
    // 启动模拟器
    CREATE_EMULATOR,
    START_EMULATOR,
    // 关闭模拟器
    CLOSE_EMULATOR,
    // 重启模拟器
    RESTART_EMULATOR,
    // 重置模拟器
    RESET_EMULATOR,
    // 删除模拟器
    DELETE_EMULATOR,

    // 安装app
    INSTALL_APP,
    // 运行app
    RUN_APP,
    // 关闭app
    KILL_APP,
    // 卸载app
    UNINSTALL_APP,
    // 卸载所有app
    UNINSTALL_ALL_APP,

    // 挂载脚本
    MOUNT,
    // 运行脚本
    RUN_SCRIPT,
    // 卸载脚本
    UNINSTALL_SCRIPT,
    // 卸载所有脚本
    UNINSTALL_ALL_SCRIPT;

    // private final String businessType;
    //
    // BusinessTypeEnum(String value) {
    //     this.businessType = value;
    // }


    public static BusinessTypeEnum parseValue(String operator) {
        for (BusinessTypeEnum value : values()) {
            if (operator.equals(value.name())) {
                return value;
            }
        }
        return null;
    }

}
