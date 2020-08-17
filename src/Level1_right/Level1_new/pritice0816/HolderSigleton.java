package Level1_right.Level1_new.pritice0816;

public class HolderSigleton {
    private static class Holder{
        private static HolderSigleton instance = new HolderSigleton();
    }

    public static HolderSigleton getInstance() {
        return Holder.instance;
    }
}
