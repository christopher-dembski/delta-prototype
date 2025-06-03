package profile.ui;

import profile.api.GetUsersEndpoint;
import profile.api.GetUsersEndpoint.User;
import profile.api.GetUsersEndpoint.Output;

import java.util.Collection;

public class LoginViewModel {
    private Collection<User> users;

    protected LoginViewModel() {
        Output output = GetUsersEndpoint.call();
        if (!output.errors().isEmpty()) {
            System.out.println("An error occurred when fetching users...");
            return;
        }
        users = output.users();
    }

    protected Collection<User> getUsers() {
        return users;
    }
}
