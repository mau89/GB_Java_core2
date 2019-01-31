public class Homework3 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.task1();

        Tel tel = new Tel();
        tel.add("Иванов","555555");
        tel.add("Петров","456");
        tel.add("Сидоров","789");
        tel.add("Иванов","987");
        tel.add("Сидоров","477");

        tel.get("Иванов");
    }
}
