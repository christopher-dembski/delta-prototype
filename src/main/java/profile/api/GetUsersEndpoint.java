package profile.api;

import java.util.ArrayList;
import java.util.Collection;

public class GetUsersEndpoint {
    public record User(String name, String sex) {
    }

    public record Output(Collection<User> users, Collection<String> errors) {
    }

    public static Output call() {
        Collection<User> users = new ArrayList<>();
        users.add(new User("Jim", "M"));
        users.add(new User("Sally", "F"));
        return new Output(users, new ArrayList<>());
    }
}
