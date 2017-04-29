package com.oil.comm.utils;
/**
 * JSON 格式化输出
 * TODO 在此写上类的相关说明.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午6:44:24<br>
 * @see 
 * @since JDK 1.7.0
 */
public final class FormatUtil {

	public static void printJson(String jsonStr){
		System.out.println(formatJson(jsonStr));
	}
	public static String getJsonFormatString(Object jsonStr){
		if(null==jsonStr) return "";
		return formatJson(jsonStr.toString());
	}
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
}

