
class TypeClass<T>{
    T some;


}

class Parent implements Comparable<Parent>{
    int a = 0;

    @Override
    public int compareTo(Parent o){
        return 0;
    }

}

class Child extends Parent{
    int b = 0;
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        Parent p = c;
        
        System.out.println(p.getClass());


    }
}