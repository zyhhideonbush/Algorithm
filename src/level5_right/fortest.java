package level5_right;
class A {
    public String show(D obj) {
        return ("A and D");
    }
    public String show(A obj) {
        return ("A and A");
    }
}
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}
class C extends B{ }
class D extends B{ }
class Demo {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));

        System.out.println("9--" + b.show(d));
    }
}
//�����
//1--A and A
//2--A and A
//ǰ��������this.show(super(0))����ת�ͣ�ֱ������Ϊֹ��
        //3--A and D
//4--B and A
//5--B and A
//6--A and D
//7--B and B
//8--B and B
//        c����ת�͡�������b�������൱��this.show(b);
//9--A and D
