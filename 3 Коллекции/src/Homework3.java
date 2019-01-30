public class Homework3 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.task1();

        Tel tel = new Tel();
        tel.add("123", "Иванов");
        tel.add("456", "Петров");
        tel.add("789", "Сидоров");
        tel.add("987", "Иванов");
        tel.add("477", "Сидоров");

        tel.get("Иванов");
    }
}
