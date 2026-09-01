package functionalProgramming;

import java.util.Optional;

class User {
    public Optional<Address> address;
}

class Address {
    public String city;
}

public class OptionalImpl {
    static void main() {
        Optional<User> user = getUser();
                user
                .flatMap(x -> x.address)
                .map(x -> x.city)
                .ifPresent(System.out::println);

        Optional<String> name = Optional.of("Sneha");

        Optional<String> res = name.filter(x -> x.length()>9);

        res.ifPresentOrElse(System.out::println, () -> System.out.println("unknown"));

    }

    private static Optional<User> getUser() {
        Address a = new Address();
        a.city = "Delhi";

        User u = new User();
        u.address = Optional.of(a);

        return Optional.of(u);
    }
}
