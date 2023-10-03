package fourth;

@FunctionalInterface
public interface MyFunctionalInterface {
    public String makeUpperCase(String str);

    public static String concatnateString(String str1, String str2){
        return str1+str2;
    }

    public default int multiplyBy5(int number){
        return number * 5;
    }
}
