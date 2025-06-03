package profile.api;

import java.util.ArrayList;
import java.util.Collection;

public class GetUsersEndpoint {
    public record User(int id, String name, String sex) {
    }

    public record Output(Collection<User> users, Collection<String> errors) {
    }

    public static Output call() {
        Collection<User> users = new ArrayList<>();
        users.add(new User(1, "Jim", "M"));
        users.add(new User(2, "Sally", "F"));
        return new Output(users, new ArrayList<>());
    }
}
