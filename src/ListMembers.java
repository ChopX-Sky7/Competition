import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.*;
public class ListMembers {
    public static ArrayList<Member> members = new ArrayList<>();
    private final static Scanner in = new Scanner(System.in);

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
            String listname;
            listname = in.nextLine();

            System.out.println("Введите страну участника");
            String listcountry;
            listcountry = in.nextLine();

            new Member(listname, listcountry);
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
        StringBuilder dummy = new StringBuilder("Кол-во участников: " + members.size() + "\n");
        for (Member member : members) {
            dummy.append(member.getInfo()).append("\n");
        }
        System.out.println("Список подготовлен!");
        try( FileOutputStream fos = new FileOutputStream(txt); PrintStream ps = new PrintStream(fos)) {
            ps.println(dummy);
        } catch (IOException e){
            System.out.printf("Произошла ошибка при печати! \n Техническая информация: %s" , e.getMessage());
        }
    }

    public static void printCSV() {
        try( FileWriter fw = new FileWriter("data/members.csv");
             CSVWriter cs = new CSVWriter(fw)) {
            ArrayList<String[]> data = new ArrayList<>();
            for (Member m : members) {
                data.add(m.getInfoArray());
            }
            cs.writeAll(data);
        }catch (IOException e){
            System.out.printf("Возникла ошибка генерации файла! \n Техническая Информация: %s", e.getMessage());
        }
    }
}
