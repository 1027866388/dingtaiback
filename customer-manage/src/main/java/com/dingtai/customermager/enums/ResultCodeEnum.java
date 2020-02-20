package com.dingtai.customermager.enums;

/**
 * ResultCode枚举
 *
 * @author wangyanhui
 * @date 2017-09-19 9:39
 */

public enum ResultCodeEnum implements BaseEnum {

    /**
     * 操作成功
     */
    OPERATION_SUCCESS(0000, "操作成功"),


    /**
     * 被审计组织不能为空
     */
    PROJECT_NAME_REPEAT(1000, "被审计组织不能为空"),

    /**
     * 任期结束时间不能小于任期开始时间
     */
    PROJECT_ADD_TENURE_TIME(1001, "任期结束时间不能小于任期开始时间"),

    /**
     * 文件不存在
     */
    FILE_NOT_EXIT(1002, "文件不存在"),

    /**
     * 文件上传失败
     */
    FILE_UPLOAD_FAILED(1003, "文件上传失败"),

    /**
     * 导入失败
     */
    IMPORT_FAIL(1004, "导入失败"),

    /**
     * 导入成功
     */
    IMPORT_SUCCESS(1005, "导入成功"),

    /**
     * 文件格式错误
     */
    FILE_FORMAT_ERROR(1006, "文件格式错误"),

    /**
     * 文件大写限制
     */
    FILE_SIZE(1007, "文件10M以内"),
    /**
     * 文件目录不存在
     */
    FILE_FOLDER_LOSE_NON_EXISTENT(1008, "文件目录不存在"),

    /**
     * 文件格式错误
     */
    FILE_NAME_ERROR(1009, "文件命名错误"),
    /**
     * 文件存在
     */
    FILE_EXIT(1010, "文件已存在"),
    /**
     * 项目不存在
     */
    PROJECT_NOT_EXISTS(1011, "项目编号不存在"),


    /**
     * 日期格式有误(正确格式如：201909)
     */
    DATE_STR_FORMAT_ERROR(1012, "日期格式有误(正确格式如：201909)"),

    /**
     * 日期不能超过当前月份
     */
    DATE_PAST_CURRENT_DATE(1013, "日期不能超过当前月份"),


    /**
     * 请求参数不合法
     */
    REQUEST_PARAM_ERROR(3001, "请求参数不合法"),

    /**
     * 缺少请求参数
     */
    REQUEST_PARAM_LACK(3002, "缺少请求参数"),

    /**
     * 请求参数为空
     */
    REQUEST_PARAM_EMPTY(3003, "请求参数为空"),

    /**
     * 查询数据失败
     */
    QUERY_DATA_ERROR(4001, "查询数据失败"),

    /**
     * 新增数据失败
     */
    APPEND_DATA_ERROR(4002, "新增数据失败"),

    /**
     * 修改数据失败
     */
    MODIFY_DATA_ERROR(4003, "修改数据失败"),

    /**
     * 删除数据失败
     */
    DELETE_DATA_ERROR(4004, "删除数据失败"),

    /**
     * 内部调用接口错误
     */
    INSIDE_INTERFACE_INVOKE_ERROR(5001, "内部调用接口错误"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(9001, "未知错误"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(9002, "系统异常"),

    /**
     * 并发错误
     */
    CONCURRENCY_ERROR(9003, "并发错误"),

    /**
     * 未认证
     */
    UN_AUTHENED(401, "未认证"),
    /**
     * 该附件已经识别过
     */
    ALREADY_RELAIZED(4005, "该附件已经识别过"),

    /**
     * 解压失败
     */
    UNZIP_FAILURE(4006, "解压失败"),

    /**
     * 外网禁止访问
     */
    NET_FAILURE(4007, "外网禁止访问"),

    /**
     * 创建文件失败
     */
    CREATE_FILE_FALIURE(4008, "文件创建失败"),

    /**
     * 没有检测到圆
     */
    CIRCLE_CHECK_EMPTY(4009, "没有检测到圆"),

    /**
     * 调用接口失败
     */
    CALL_INTERFACE_FALIURE(4010, "调用接口失败"),

    /**
     * 文件大小超出限制
     */
    FILE_SIZE_LIMIT(4011, "文件大小超出限制"),


    /**
     * 公章插入基准库
     */
    STAMP_INSERT_INTO_BASE_LIBRARY(4012, "公章插入基准库"),

    /**
     * 批量导出失败
     */
    BATCH_EXPORT_FAILED(4013, "批量导出失败"),

    /**
     * 工商信息能力用户使用次数限制
     */
    BUSINESS_INFO_USER_COUNT(4014, "该接口每天调用次数超过最大限制"),

    /**
     * 校验失败
     */
    VALIDATE_FAIL(4015, "校验失败"),

    /**
     * 工商查询次数
     */
    QUERY_COUNT_NOT_ENOUGH(4016, "查询次数不足，请重新申请查询权限！"),

    /**
     * 输入查询次数校验
     */
    QUERY_COUNT_ERROR(4017, "查询次数格式不正确，请输入正确的数值！"),

    /**
     * 流程服务异常
     */
    PROCESS_SERICE_ERROR(4018, "流程平台服务异常"),

    /**
     * 操作失败
     */
    OPERATION_ERROR(4019, "操作失败"),
    /**
     * 基准公章已覆盖更新
     */
    STAMP_UPDATE_BASE_LIBRARY(4020, "基准公章已覆盖更新"),

    /**
     * 印章库中无该企业印章
     */
    STAMP_NOT_IN_BASE_LIBRARY(4021, "印章库中无该企业印章"),

    /**
     * 印章下载失败
     */
    STAMP_DOWNLOAD_FAILURE(4022, "印章下载失败"),

    /**
     * 查询的公司名称不能为空
     */
    STAMP_QUERY_NAME_NOT_NULL(4023, "查询的公司名称不能为空"),

    /**
     * 文件生成中...
     */
    FILE_NOT_READY(4024, "文件正在生成中..."),

    /**
     * 数据量过大
     */
    DATA_TOO_MUCH(7001, "数据量过大,建议选择地市查询"),

    /**
     * 地市信息不匹配
     */
    CITY_NOT_MATCH(7002, "无权限下载非所属地市数据");

    private Integer key;

    private String desc;

    @Override
    public Integer key() {

        return key;
    }

    @Override
    public String desc() {

        return desc;
    }

    ResultCodeEnum(final Integer key, final String desc) {

        this.key = key;
        this.desc = desc;
    }
}
