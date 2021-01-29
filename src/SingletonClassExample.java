/**
 * Singleton is a design pattern by which you create a singleton class that has only one instance
 * at any time
 *
 */
public class SingletonClassExample {

    private static SingletonClassExample single_instance = null;

    public String s;

    private SingletonClassExample() {
        s= "Hello World!";
    }

    public static SingletonClassExample getInstance() {

        if (single_instance == null)
            single_instance = new SingletonClassExample();
            return single_instance;
        }

    public static void main(String[] args) {

        SingletonClassExample x = SingletonClassExample.getInstance();

        System.out.println(x.s);

    }

}
