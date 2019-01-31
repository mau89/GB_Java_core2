import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Tel {
    private HashMap<String, String> hashMap = new HashMap<>();

    public void get(String key) {
        if (hashMap.containsKey(key)){
            System.out.printf("Телефон- %s, Фамилия - %s%n", key, hashMap.get(key));

        } else System.out.println("Не найдено такой фамилии");
    }

    public void add(String key, String value) {
        if (hashMap.containsKey(key)){
            hashMap.put(key,hashMap.get(key)+", "+value);
        } else this.hashMap.put(key, value);
    }
}
