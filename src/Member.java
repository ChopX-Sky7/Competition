public class Member {
    @SuppressWarnings("never used")
    public int id;
    public String name;

    public String country;

    public String time;

    public float realtime;

    public int place;

    private static int membersCount;

    Member( String name, String country, String time){
        membersCount++;
        this.id = membersCount;
        this.name = name;
        this.country = country;
        this.time = time;
        Race.members.add(this);
    }

    Member(String name, String country){
        membersCount++;
        this.name = name;
        this.country = country;
        this.id = membersCount;
        Race.members.add(this);
    }

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
        ms.length();

        if (Integer.parseInt(sec) >= 60) {
            System.out.println("Время введено с ошибкой! Попробуйте снова");
            return 0f;
        }
        if ((Float.parseFloat(ms) > 0.99) || ms.length() > 4) {
            System.out.println("Время введено с ошибкой! Попробуйте снова");
            return 0f;
        }

        float min = Float.parseFloat(m);
        float secs = Float.parseFloat(sec);
        float mss = Float.parseFloat(ms);

        secs += min * 60 + mss;
        this.realtime = secs;
        return secs;
    }

    public String getInfo(){
        String s = "Идентификатор:" + Integer.toString(this.id) + "\n Имя:" +  this.getName() + "\n Страна:" +  this.getCountry();
        return s;
    }

}
