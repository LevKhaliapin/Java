import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        startProgram();

        /*

        !!! Проблемы (Программа вроде работает, но оформление что то не очень оптимальное)

        1. В методах addEntry() строка 60, readEntry() строка 93, deleteEntry() строка 135 - дублирование части кода.
        Этого можно избежать с помощью создания классов и интерфейсов?

        2. Пришлось задублировать строчки 36 и 40. Если не добавлять строчку 40, то 0 не завершает программу.

        3. И в общем получилось совсем не 5 строчек кода:))

         */

    }

    public static void startProgram() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        System.out.println("=================================================");
        System.out.println("Запущена работа с БД. \n1 - Добавить запись, 2 - Получить данные по ключу, 3 - Удалить запись, 0 - выход из программы");
        System.out.println("Введите число от 0 до 3:");
        do {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num == 1) addEntry();
                else if (num == 2) readEntry();
                else if (num == 3) deleteEntry();
                else if (num == 0) {
                    System.out.println("Вы вышли из программы");
                    return;
                } else System.out.println("Введите число от 0 до 3!:");
            } else if (num == 0){
                System.out.println("Вы вышли из программы");
                return;}
            else {
                System.out.println("Неверный формат.");
                startProgram();
            }
        } while ((num < 0 || num > 3));
    }

    public static void addEntry() {
        System.out.println("Выбрано \"добавить запись\".");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите key:");
        int key = sc.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите value");
        String value = sc2.nextLine();
        createFile(String.valueOf(key), value);

        int num = 0;
        Scanner continuation = new Scanner(System.in);
        System.out.println("Для продолжения введите 1, для возврата в главное меню - любой символ");
        if (continuation.hasNextInt()) {
            num = continuation.nextInt();
            if (num == 1) addEntry();
            else {
                System.out.println("Вы вышли в главное меню");
                startProgram();
            }
        } else {
            System.out.println("Вы вышли в главное меню");
            startProgram();
        }

    }

    public static void createFile(String fileName, String text) {
        try (Writer writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text + "\n");
            System.out.println("Запись добавлена.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readEntry() {
        System.out.println("Выбрано \"получить запись\".");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите key:");
        int key = scanner.nextInt();
        readFile(String.valueOf(key));

        int num = 0;
        Scanner continuation = new Scanner(System.in);
        System.out.println("Для продолжения введите 1, для возврата в главное меню - любой символ");
        if (continuation.hasNextInt()) {
            num = continuation.nextInt();
            if (num == 1) readEntry();
            else {
                System.out.println("Вы вышли в главное меню");
                startProgram();
            }
        } else {
            System.out.println("Вы вышли в главное меню");
            startProgram();
        }

    }

    public static void readFile(String file) {
        try (Reader reader = new BufferedReader(new FileReader(file))) {
            int data = 0;
            StringBuilder str = new StringBuilder();
            while ((data = reader.read()) != -1) {
                str.append((char) data);
            }
            System.out.println("Запись: " + str.toString());
        } catch (IOException e) {
            System.out.println("Запись под указанным номером отсутствует");
        }
    }

    public static void deleteEntry() {
        System.out.println("Выбрано \"удалить запись\". \nВведите значения ключа для удаления записи: ");
        Scanner cs = new Scanner(System.in);
        String s = String.valueOf(cs.nextInt());
        File f = new File(s);
        if (f.exists() && f.isFile()) {
            f.delete();
            System.out.println("Запись удалена");
        } else {
            System.out.println("Запись не найдена.");
        }

        int num = 0;
        Scanner continuation = new Scanner(System.in);
        System.out.println("Для продолжения введите 1, для возврата в главное меню - любой символ");
        if (continuation.hasNextInt()) {
            num = continuation.nextInt();
            if (num == 1) deleteEntry();
            else {
                System.out.println("Вы вышли в главное меню");
                startProgram();
            }
        } else {
            System.out.println("Вы вышли в главное меню");
            startProgram();
        }
    }
}


