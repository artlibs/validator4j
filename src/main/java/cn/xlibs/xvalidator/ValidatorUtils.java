package cn.xlibs.xvalidator;

import cn.xlibs.xvalidator.support.PhoneType;

import java.util.regex.Pattern;

/**
 * Xlibs Validator for phone,email,id card,bank card.
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class ValidatorUtils {
    private ValidatorUtils(){ /* NO Sonar */ }

    public static class Phone {
        private Phone(){ /* NO Sonar */ }

        public static boolean matches(String value, PhoneType type) {
            return type.getRegex().matcher(value).matches();
        }
    }

    public static class Email {
        private Email(){ /* NO Sonar */ }

        public static boolean matches(String value) {
            return Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")
                    .matcher(value).matches();
        }
    }

    public static class IdCard {
        private IdCard(){ /* NO Sonar */ }

        public static boolean matches(String value) {
            try {
                return verify(value.length() == 15 ?
                        upgrade(value) : value);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        private static boolean verify(String value) {
            return Pattern.compile("^"
                    + "\\d{6}" // 6位地区码
                    + "(18|19|([23]\\d))\\d{2}" // 4位年份
                    + "((0[1-9])|(10|11|12))" // 2位月份
                    + "(([0-2][1-9])|10|20|30|31)" // 2位日期
                    + "\\d{3}" // 3位顺序码
                    + "[0-9Xx]" // 1位校验码
                    + "$").matcher(value).matches() &&
                    value.charAt(17) == cvc(value);
        }

        private static String upgrade(String value) {
            if(Pattern.compile("^"
                    + "\\d{6}" // 6位地区码
                    + "\\d{2}" // 4位年份
                    + "((0[1-9])|(10|11|12))" // 2位月份
                    + "(([0-2][1-9])|10|20|30|31)" // 2位日期
                    + "\\d{3}"// 3位顺序码
                    + "$").matcher(value).matches()) {
                String nv = value.substring(0, 6) + "19"
                        + value.substring(6);
                return nv + cvc(nv);
            }
            throw new IllegalArgumentException("value not match");
        }

        private static char cvc(String value) {
            char[] ida = value.toCharArray();
            char[] cca = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            int[] wa = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

            int sum = 0;
            for (int i = 0; i < 17; i++) {
                if (!Character.isDigit(ida[i])) {
                    throw new IllegalArgumentException();
                }
                sum += (ida[i] - '0') * wa[i];
            }

            return cca[sum % 11];
        }
    }

    public static class BankCard {
        private BankCard(){ /* NO Sonar */ }

        public static boolean matches(String value) {
            if (value.length() < 15 || value.length() > 19) {
                return false;
            }
            char check = cvc(value.substring(0, value.length() - 1));
            if (check == 'N') {
                return false;
            }

            return value.charAt(value.length() - 1) == check;
        }

        private static char cvc(String sub) {
            if (sub == null || sub.trim().length() == 0
                    || !sub.matches("\\d+")) {
                return 'N';
            }

            int sum = 0;
            char[] chs = sub.trim().toCharArray();
            for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
                int k = chs[i] - '0';
                if (j % 2 == 0) {
                    k *= 2;
                    k = k / 10 + k % 10;
                }
                sum += k;
            }

            return (sum % 10 == 0) ? '0' : (char) ((10 - sum % 10) + '0');
        }
    }

    public static class HttpURL {
        private HttpURL(){ /* NO Sonar */ }

        public static boolean matches(String value) {
            return Pattern.compile("^https?://(?:www\\.)?[\\w.-]+\\.[a-zA-Z]{2,}(?:/\\S*)?$"
                    , Pattern.CASE_INSENSITIVE).matcher(value).matches();
        }
    }

    public static class AlphaNumber {
        private AlphaNumber(){ /* NO Sonar */ }

        public static boolean matches(String value) {
            return Pattern.compile("^[a-zA-Z][a-zA-Z0-9]*$")
                    .matcher(value).matches();
        }
    }
}
