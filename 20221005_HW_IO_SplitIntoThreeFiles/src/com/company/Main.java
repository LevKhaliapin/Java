package com.company;

import java.io.*;

public class Main {

    /*
    ДЗ
По ссылке https://drive.google.com/file/d/1XZrLLuJlHK3n35NwQAnY9t1nSwZ3-piq/view?usp=sharing находится файл file.dat .
Ваша задача скачать этот файл (можно просто через эксплоер, не из программы).
Ваша программа  должна записать в отдельный файл первые 601 байт из этого файла,
затем в отдельный файл записать следующие 57053 байта и оставшиеся 22494 байта записать в следующий файл.
Если все сделано правильно, у вас должно получиться 3 файла.
В одном из этих файлов лежит gif картина, в другом jpg картинка, еще в одном скомпилированный .class файл java программы.
Вам нужно написать программу, которая определит, в каком файле что лежит.
Сделать это можно используя так называемые сигнатуры файлов:
gif должен начинаться с шестнадцатеричной  последовательности байт 47 49 46 38 39 61
jpeg с последовательности ff d8
java .class файл с шестнадцатеричной  последовательности ca fe ba be
Сохраните файл, опознанный как .class файл под именем Main.class и запустите его из командной строки. Прочитайте кодовое слово.
 */

    public static void main(String[] args) {
        splitIntoThreeFiles("file.dat");

        File file1 = new File("file1.class");
        File file2 = new File("file2.jpeg");
        File file3 = new File("file3.gif");
        File dat = new File("file.dat");


        checkSignatureOfFile(file1);
        checkSignatureOfFile(file2);
        checkSignatureOfFile(file3);


        // код из файла .class. Кодовое слово Excellent!
        // у меня не получается запускать файлы .class из консоли. 
        System.out.println(new String(new byte[]{69, 120, 99, 101, 108, 108, 101, 110, 116, 33}));

    }


    public static void splitIntoThreeFiles(String inFile) {

        String file1 = "file1.class";
        String file2 = "file2.jpeg";
        String file3 = "file3.gif";

        try (InputStream is = new BufferedInputStream(new FileInputStream(inFile));
             OutputStream os1 = new BufferedOutputStream(new FileOutputStream(file1));
             OutputStream os2 = new BufferedOutputStream(new FileOutputStream(file2));
             OutputStream os3 = new BufferedOutputStream(new FileOutputStream(file3))) {

            int read = 0;
            int count = 0;

            while ((read = is.read()) != -1) {
                if (count < 601) {
                    os1.write(read);
                    count++;
                } else if (count < 601 + 57053) {
                    os2.write(read);
                    count++;
                } else {
                    os3.write(read);
                    count++;
                }
            }
            System.out.println("разбиение на три файла выполнено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkSignatureOfFile(File file) {

        byte[] startBytesGifFile = new byte[]{(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38, (byte) 0x39, (byte) 0x61};
        byte[] startBytesJpegFile = new byte[]{(byte) 0xFF, (byte) 0xD8};
        byte[] startBytesClassFile = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte read = (byte) in.read();

            for (byte b : startBytesGifFile) {
                if (b != read) {
                    break;
                } else {
                    System.out.println("Сигнатура файла " + "\"" + file + "\" - .gif");
                }
            }

            for (byte b : startBytesJpegFile) {
                if (b != read) {
                    break;
                } else {
                    System.out.println("Сигнатура файла " + "\"" + file + "\" - .jpeg");
                }
            }

            for (byte b : startBytesClassFile) {
                if (b != read) {
                    break;
                } else {
                    System.out.println("Сигнатура файла " + "\"" + file + "\" - .class");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readFile(String file) {                    // подсчет размера файла (проверка), хотя потом нашел у класса File метод length()
        try (InputStream is = new FileInputStream(file)) {
            byte[] data = new byte[1024];
            int read = 0;
            long allRead = 0;
            while ((read = is.read(data)) >= 0) {
                allRead += read;
            }
            System.out.println(allRead + " bytes - размер файла");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
