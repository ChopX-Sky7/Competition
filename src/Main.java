import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Это программа для регистрации участников соревнований.");
        System.out.println("Доступный функционал: \n 1. Добавить участника \t 2. Дискалифицировать участника \t 3. Вывести список участников");
    }

    private static void register(){
        System.out.println("Введите кол-во участников для регистрации: ");
        int i = new Scanner(System.in).nextInt();
        Race.add(i);
    }

    private static void remove(){
        System.out.println("Введите идентификатор участника, которого вы хотите дисквалифицировать:");
        int i = new Scanner(System.in).nextInt();
        Race.delete(i);
    }

    private static void print(){
        Race.printMembers();
    }


}
