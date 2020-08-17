package Level1_right.Level1_new.pritice0816;

public class DCLSigleton {
    private static volatile DCLSigleton instance = null;
    private DCLSigleton() {};
    public DCLSigleton getInstance() {
        if (instance == null) {
           synchronized (DCLSigleton.class) {
               if (instance == null) {
                  instance = new DCLSigleton();
               }
           }
        }
        return instance;
    }
}
