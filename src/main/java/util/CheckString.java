package util;

public class CheckString {
    public static String checkValues(String value,String ten){
        if (value.isEmpty()){
            return "Phải nhập "+ten;
        }
        return "";
    }
}
