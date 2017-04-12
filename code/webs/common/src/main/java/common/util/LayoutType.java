package common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 布局分类.
 * @author mengqingbao
 *
 */
public enum LayoutType {
    DEFAULT("default", "default.vm"),//默认带框架
    BLANK("blank","blank.vm"),//无框架
    EMPTY("empty","empty.vm"),//只内容
    UAM("uam","uam.vm"),//集成
    SELLER("seller","seller.vm"),
    AMAZEUI("amazeui","amazeui.vm"),
    BUYER("buyer","buyer.vm"),
    HOME("home","home.vm"),
    CAR("car","car.vm"),
    PAY("pay","pay.vm");


    /** 代码 */
    private final String code;
    /** 信息 */
    private final String message;

    /**
     * 构造
     * @param code
     * @param message
     */
    LayoutType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取
     * @param code
     * @return
     */
    public static LayoutType getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (LayoutType type : LayoutType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        throw new IllegalArgumentException("非法的枚举参数：" + code);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
