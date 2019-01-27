public class MyArrayDataException extends RuntimeException {

    public int i, j;
    public String value;

    public MyArrayDataException(int i, int j, String value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public String toString() {
        return String.format("Ошибка в строке с координатами i-%s; j-%s; значение-%s.%n", i, j, value);
    }

}
