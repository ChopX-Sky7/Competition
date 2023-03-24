import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Race {
    public static ArrayList<Member> members = new ArrayList<>();
    private final static Scanner in = new Scanner(System.in);

    public static void add(int count) throws InputMismatchException {
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
}
