package ch.heigvd.gen2019;

public interface FormattableToJSON {

    static void appendField(StringBuffer sb, String fieldName, Object object) {
        sb.append('\"');
        sb.append(fieldName);
        sb.append("\": ");
        sb.append(object);
    }

    static void appendField(StringBuffer sb, String fieldName, String str) {
        sb.append('\"');
        sb.append(fieldName);
        sb.append("\": \"");
        sb.append(str);
        sb.append("\"");
    }
    
    void toJSON(StringBuffer sb);
}
