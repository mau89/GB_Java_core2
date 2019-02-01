import java.util.*;

public class Task1 {
    public static void task1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        list.add("раму");
        list.add("мыла");
        list.add("с");
        list.add("мылом");
        list.add("разик");
        list.add("промахнулась");
        list.add("и");
        list.add("попала");
        list.add("мимо");
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
           if (!map.containsKey(list.get(i))){
               map.put(list.get(i),1);
           }else {
               map.put(list.get(i),map.get(list.get(i))+1);
           }
        }
        System.out.printf("%n");
        for (Map.Entry<String,Integer> finalmap : map.entrySet()) {
            System.out.printf("Cлово \"%s\" количество повторений - %d; %n", finalmap.getKey(), finalmap.getValue());
        }
    }
}
