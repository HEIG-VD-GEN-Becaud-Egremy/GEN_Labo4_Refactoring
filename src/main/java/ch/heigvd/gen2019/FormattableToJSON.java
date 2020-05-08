package ch.heigvd.gen2019;

import java.util.List;

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
    // Source for list parameter:
    // https://stackoverflow.com/questions/10090167/how-can-you-pass-a-listobjects-that-implement-an-interface-to-a-method
    static void appendListOfFormattableToJSON(StringBuffer sb, List<? extends FormattableToJSON> list) {
        sb.append("{\"orders\": [");

        for (int i = 0; i < list.size(); i++) {
            list.get(i).toJSON(sb);
        }

        if (list.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]}");
    }
    
    void toJSON(StringBuffer sb);
}
