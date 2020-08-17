package Level1_right.Level1_new.pritice0816;

public class HungrySigleton {
    private static HungrySigleton instance = new HungrySigleton();
    private HungrySigleton() {};
    public static HungrySigleton getInstance() {
        return instance;
    }
}
