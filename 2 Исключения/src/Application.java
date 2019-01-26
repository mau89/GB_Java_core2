
public class Application {
    public static String[][] arrays;
    public static int sum = 0;

    public static void main(String[] args) {
        try {
            arrays = new String[4][4];
            sizeArr(arrays);
        } catch (NegativeArraySizeException e) {
            System.out.println("Нельзя создавать массив отрицательного размера");
        }
        try {
            checkArr(arrays);
        } catch (MyArraySizeException e) {
            System.out.println(e + "");
        }
        try {
            sumArr(arrays);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
        System.out.println("Сумма массива равна " + sum);
    }

    public static void sumArr(String[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                try {
                    sumArr(arrays[i][j]);
                } catch (MyArrayDataException e) {
                    System.out.println("координаты i " + i + " координаты j " + j + " значение в ячейке " + arrays[i][j]);
                    System.out.println(e);
                }
            }
        }
    }

    public static void sumArr(String i) throws MyArrayDataException {
        try {
            int a = Integer.parseInt(i);
            sum += a;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Ошибка числа в массиве ");
        }
    }

    public static void checkArr(String[][] arrays) throws MyArraySizeException {
        if (arrays.length != 4 || arrays[0].length != 4) {
            throw new MyArraySizeException("Массив не равен 4*4");
        }
    }

    public static void sizeArr(String[][] arrays) throws MyArraySizeException, MyArrayDataException {
        for (int x = 0; x < arrays.length; x++) {
            for (int y = 0; y < arrays[0].length; y++) {
                if (x == 1 && y == 3) {
                    arrays[x][y] = "f";
                } else if (x == 2 && y == 3) {
                    arrays[x][y] = "r";
                } else {
                    arrays[x][y] = x + y + "";
                }
            }
        }
    }
}
