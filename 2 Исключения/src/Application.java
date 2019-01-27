
public class Application {
    public static String[][] arrays;
    public static int sum = 0;

    public static void main(String[] args) {
        try {
            arrays = new String[4][5];
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
                    sumArr(i,j,arrays[i][j]);
                } catch (MyArrayDataException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void sumArr(int i,int j, String value) throws MyArrayDataException {
        try {
            int a = Integer.parseInt(value);
            sum += a;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(i,j,value);
        }
    }

    public static void checkArr(String[][] arrays) throws MyArraySizeException {
        for (int i = 0; i < arrays.length; i++) {
                if (arrays.length != 4 || arrays[i].length != 4) {
                    throw new MyArraySizeException("Массив не равен 4*4");
            }
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
