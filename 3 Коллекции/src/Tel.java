import java.util.HashMap;

public class Tel {
    private HashMap<String, String> hashMap = new HashMap<>();

    public void get(String value) {
        for (HashMap.Entry<String, String> hasp : this.hashMap.entrySet()) {
            if (hasp.getValue() == value) {
                System.out.printf("Телефон- %s, Фамилия - %s%n", hasp.getKey(), hasp.getValue());
            }
        }
    }

    public void add(String key, String value) {
        this.hashMap.put(key, value);
    }
}
