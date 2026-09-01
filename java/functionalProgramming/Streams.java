package functionalProgramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    static void main() {
        List<Integer> list = new ArrayList<>(List.of(5, 12, 7, 14));

        // intermediate functions
        list.stream()
                .filter(x-> x>10)
                .map(x -> x*2)
                .peek(System.out::println)
                .sorted() // stateful, so all elements first collected here before proceeding
                .forEach(System.out::println);

        System.out.println(list.stream().collect(Collectors.toMap(
           x -> x,
           x->x*x
        )));

        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        System.out.println(sum.get());

        int sum2 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        list.stream().sorted((a,b) -> b-a).forEach(System.out::println);

        Stream<Integer> s = Stream.empty();

        List<List<Integer>> list2 = List.of(
                List.of(5, 12, 7, 14),
                List.of(9, 3, 8, 0)
        );
        //2-d to 1-d me klar diya flatmap ne
        list2.stream().flatMap(Collection::stream).mapToDouble(x -> x/2).forEach(System.out::println);

        System.out.println(Stream.iterate(1, x-> x+1).limit(18).skip(4).toList()); //skips first 4

        System.out.println(list2.stream().flatMap(x -> x.stream()).mapToInt(x-> x).max().getAsInt()); //OptionalInt

    }
}
