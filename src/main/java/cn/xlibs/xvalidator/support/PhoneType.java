package cn.xlibs.xvalidator.support;

import lombok.Getter;
import java.util.regex.Pattern;

/**
 * 手机号码分类
 * <a href="https://github.com/VincentSit/ChinaMobilePhoneNumberRegex/blob/master/README-CN.md">...</a>
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
@Getter
public enum PhoneType {
    /**
     * <a href="https://github.com/VincentSit/ChinaMobilePhoneNumberRegex/blob/master/README-CN.md">...</a>
     */
    BASIC("11位手机卡-基础运营商,支持语音通话/短信/数据流量", Pattern.compile("^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[235-8]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|66\\d{2})\\d{6}$")),
    VIRTUAL("11位手机卡-虚拟运营商,支持语音通话/短信/数据流量", Pattern.compile("^(?:\\+?86)?1(?:7[01]|6[257])\\d{8}$")),
    NET_ONLY("11位上网卡,支持语音通话(部分)/短信/数据流量", Pattern.compile("^(?:\\+?86)?14[579]\\d{8}$")),
    IOT_ONLY("13位物联网数据卡,支持数据流量", Pattern.compile("^(?:\\+?86)?14(?:[14]0|41|[68]\\d)\\d{9}$")),
    ALL_TYPE("11或13位,支持所有号码", Pattern.compile("^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[0-35-9]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|6[2567]\\d{2}|4(?:(?:10|4[01])\\d{3}|[68]\\d{4}|[579]\\d{2}))\\d{6}$")),
    ;

    private final String desc;
    private final Pattern regex;

    PhoneType(String desc, Pattern regex) {
        this.desc = desc;
        this.regex = regex;
    }
}
