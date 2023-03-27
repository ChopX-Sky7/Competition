public class Member {

    private int id;
    private String name;

    private String country;

    private String time;

    private int place;

    private static int membersCount;

    Member( String name, String country, String time){
        membersCount++;
        this.id = membersCount;
        this.name = name;
        this.country = country;
        this.time = time;
        ListMembers.members.add(this);
    }

    Member(String name, String country){
        membersCount++;
        this.name = name;
        this.country = country;
        this.id = membersCount;
        ListMembers.members.add(this);
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
    public float getRealTime(String time) {
        String[] t = time.split(":");

        String m = t[0];
        String sec = t[1];
        String ms = "0." + t[2];

        if (Integer.parseInt(sec) >= 60) {
            System.out.println("Кол-во секунд не может быть больше или равным 60! Попробуйте снова");
            return 0f;
        }
        if ((Float.parseFloat(ms) > 0.99) || ms.length() > 4) {
            System.out.println("кол-во милисекунд не может иметь больше двух знаков после запятой Попробуйте снова");
            return 0f;
        }

        float min = Float.parseFloat(m);
        float secs = Float.parseFloat(sec);
        float mss = Float.parseFloat(ms);


        return secs + (min * 60) + mss;
    }

    public String getInfo(){
        return "Идентификатор:" + this.id + "\n Имя:" +  this.getName() + "\n Страна:" +  this.getCountry();
    }

    public String[] getInfoArray(){
        String name = this.getName();
        String id = Integer.toString(this.getId());
        String country = this.getCountry();
        return new String[]{id, name, country};
    }

}
