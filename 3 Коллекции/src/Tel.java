import java.util.*;

public class Tel {
    private Map<String, List<String>> hashMap = new HashMap<>();

    public void get(String key) {
        if (hashMap.containsKey(key)){
            System.out.printf("Фамилия- %s, телефон - %s%n", key, hashMap.get(key));

        } else System.out.println("Не найдено такой фамилии");
    }

    public void add(String key, String value) {
        if (hashMap.containsKey(key)){
            hashMap.get(key).add(value);
        } else {
            List<String> aaa=new ArrayList();
            aaa.add(value);
            this.hashMap.put(key, aaa);
        }
    }
}
