public class Tester
{
    public static void main(String[] args)
    {
        List135<Integer> list = new List135<>();
        System.out.println("list.isEmpty() = " + list.isEmpty());
        List135<Integer> a = list.cons(0);
        System.out.println("a = " + a);
        System.out.println("a.size() = " + a.size());

        System.out.println();
        List135<Integer> b = a.cons(1);
        System.out.println("b = " + b);
        System.out.println("b.size() = " + b.size());

        System.out.println();

        List135<Integer> c = b.cons(2);
        System.out.println("c = " + c);
        System.out.println("c.size() = " + c.size());
        System.out.println("c.first() = " + c.first());
        System.out.println("c.rest() = " + c.rest());
        System.out.println("c.get(0) = " + c.get(0));
        System.out.println("c.get(1) = " + c.get(1));
        System.out.println("c.get(2) = " + c.get(2));

        System.out.println();

        List135<Integer> d = new List135<Integer>()
                                            .cons(0)
                                            .cons(1)
                                            .cons(2);
        System.out.println("d = " + d);
        System.out.println("d.equals(a) = " + d.equals(a));
        System.out.println("d.equals(c) = " + d.equals(c));
    }
}
