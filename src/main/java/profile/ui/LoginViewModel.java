package profile.ui;

import profile.api.GetUsersEndpoint;
import profile.api.GetUsersEndpoint.User;
import profile.api.GetUsersEndpoint.Output;

import java.util.Collection;

public class LoginViewModel {
    private Collection<User> users;

    protected LoginViewModel() {
        // output contains both a list of users and any errors
        Output output = GetUsersEndpoint.call();
        if (!output.errors().isEmpty()) {
            // we would actually want to display an error message to the user
            // we could use the flash message functionality
            System.out.println("An error occurred when fetching users...");
            return;
        }
        // set the list of users
        // this list of users is used by the LoginView to know what profiles to
        // render on the login screen
        users = output.users();
    }

    protected Collection<User> getUsers() {
        return users;
    }
}
