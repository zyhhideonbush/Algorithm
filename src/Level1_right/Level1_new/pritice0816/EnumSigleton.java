package Level1_right.Level1_new.pritice0816;

public class EnumSigleton {
    private EnumSigleton(){};
    private enum EnumHolder {
        INSTANCE;
        private EnumSigleton instance = null;
        EnumHolder (){
            instance = new EnumSigleton();
        }
    }
    public static EnumSigleton getInstance() {
        return EnumHolder.INSTANCE.instance;
    }
}
