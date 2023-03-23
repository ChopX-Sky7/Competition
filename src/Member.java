public class Member {
    public int id;
    public String name;

    public String country;

    public String time;

    public float realtime;

    public int place;


    private static int membersCount;


    public String getTime() {
        return time;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static int getMembersCount() {
        return membersCount;
    }

    public void setTime(String time) {
        this.time = time;
    }
    // 1.42.53
    public float getRealTime(String time) {
        String t[] = time.split(":");



        String m = t[0];
        String sec = t[1];
        String ms = "0." + t[2];

        if (Integer.parseInt(sec) >= 60) {
            System.out.println("Время введено с ошибкой! Попробуйте снова");
            return 0f;
        }
        if (Float.parseFloat(ms) >= 100) {
            System.out.println("Время введено с ошибкой! Попробуйте снова");
            return 0f;
        }

        float min = Float.parseFloat(m);
        float secs = Float.parseFloat(sec);
        float mss = Float.parseFloat(ms);

        secs += min * 60 + mss;
        return secs;

    }
}
