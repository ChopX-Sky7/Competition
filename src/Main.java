import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Это программа для регистрации участников соревнований.");
        System.out.println("Доступный функционал: \n 1. Добавить участника \t 2. Дискалифицировать участника");
        String select = new Scanner(System.in).nextLine();
        switch (select) {
            case "1":
                register();
                break;
            case "2":
                remove();
                break;
        }
    }

    private static void register() {
        System.out.println("Введите кол-во участников для регистрации: ");
        int i = new Scanner(System.in).nextInt();
        ListMembers.add(i);
        System.out.println("Хотите вывести список участников в консоли или в файле?");
        System.out.println("1. В консоли \t 2. В файл");
        String s = new Scanner(System.in).nextLine();
        switch (s) {
            case "1":
                print();
                break;
            case "2":
                ListMembers.printTXT();
                break;
        }
    }

    private static void remove() {
        System.out.println("Введите идентификатор участника, которого вы хотите дисквалифицировать:");
        int i = new Scanner(System.in).nextInt();
        ListMembers.delete(i);
    }

    private static void print() {
        ListMembers.printMembers();
    }


}
