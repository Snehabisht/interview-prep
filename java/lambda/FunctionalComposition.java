package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalComposition {
    static void main() {
        Function<Integer, Integer> eq = x -> ((x+2)*3);

        Function<Integer, Integer> add2 = x -> x+2;
        Function<Integer, Integer> mul3 = x -> x*3;

        int ans = add2.andThen(mul3).andThen(add2).andThen(mul3).apply(3);

        System.out.println(ans);

        int ans2 = add2.compose(mul3).apply(4);
        System.out.println(ans2);

        Predicate<Integer> isGreater = x -> x>100;
        Predicate<Integer> isEven = x -> x%2 == 0;

        System.out.println((isGreater.and(isEven).test(109)));

        Predicate<Integer> isOdd = isEven.negate();

        System.out.println(isOdd.test(57));

        Consumer<String> printName = System.out::println;
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        Consumer<String> res = printName.andThen(printUpperCase);

        res.accept("Sneha");


    }
}
