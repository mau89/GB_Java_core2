import java.util.*;

public class Task1 {
    public static void task1() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");
        strings.add("раму");
        strings.add("мыла");
        strings.add("с");
        strings.add("мылом");
        strings.add("разик");
        strings.add("промахнулась");
        strings.add("и");
        strings.add("попала");
        strings.add("мимо");
        for (int i = 0; i < strings.size(); i++) {
            if (Collections.frequency(strings, strings.get(i)) == 1) {
                System.out.println(strings.get(i));
            }
        }
        Set<String> set = new LinkedHashSet<>(strings);
        System.out.printf("%n");
        for (String linkedHashMap : set) {
            System.out.printf("Cлово \"%s\" количество повторений - %d; %n", linkedHashMap, Collections.frequency(strings, linkedHashMap));
        }
    }
}
