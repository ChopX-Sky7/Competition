import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListMembers {
    public static ArrayList<Member> members = new ArrayList<>();
    private final static Scanner in = new Scanner(System.in);

    private static String dummy ="";
    public static void add(int count) {
        if (count == 0) {
            System.out.println("Число участников не может быть равным нулю!");
            return;
        }
        if (count < 0) {
            count = Math.abs(count);
        }
        for (int j = 0; j < count; j++) {
            System.out.println("Введите имя участника");
            String name;
            name = in.nextLine();

            System.out.println("Введите страну участника");
            String country;
            country = in.nextLine();

            new Member(name, country);
            System.out.println("`````````````````````````````````````````");
        }
    }

    public static void delete(int id) {
        members.remove((id-1));
    }

    public static void printMembers() {
        System.out.printf("Количество участников: %d", members.size());
        for (Member m : members) {
            System.out.println(m.getInfo());
            System.out.println("-------------------------");
        }
        System.out.println("*************************");
    }

    public static void printTXT() {
        File txt = new File("data/members.txt");
        dummy = "Кол-во участников: " + Integer.toString(members.size()) + "\n";
        for (Member member : members) {
            dummy += member.getInfo() + "\n";
        }
        System.out.println("Список подготовлен!");
        try( FileOutputStream fos = new FileOutputStream(txt); PrintStream ps = new PrintStream(fos)) {
            ps.println(dummy);
        } catch (IOException e){
            System.out.printf("Произошла ошибка при печати! \n Техническая информация: %s" , e.getMessage());
        }
    }
}
