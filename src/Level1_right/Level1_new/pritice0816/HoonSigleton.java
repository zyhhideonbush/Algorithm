package Level1_right.Level1_new.pritice0816;

public class HoonSigleton {
    private static HoonSigleton instance = null;
    private HoonSigleton() { };
    public static HoonSigleton getInstance() {
        if(instance == null) {
            instance = new HoonSigleton();
        }
        return instance;
    }
}
