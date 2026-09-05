package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypesImpl {
    static void main() {
        Function<Integer, Integer> sq = x-> x*x;
        System.out.println(sq.apply(2));

        Consumer<String> consumer = (x) -> System.out.println(STR."Hi there, \{x}");
        consumer.accept("Sneha");

        Supplier<Integer> supplier = () -> Math.abs(-19);
        System.out.println(supplier.get());

        Predicate<Integer> predicate = x -> (x & 1) == 0;
        System.out.println(predicate.test(20));

        List<Integer> l = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        l.forEach(x -> System.out.println(x*x));

    }
}
