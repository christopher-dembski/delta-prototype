package profile.api;

import java.util.ArrayList;
import java.util.Collection;

// API endpoints provide a bridge between the frontend and backend
// we call the endpoint with certain paras
// in this case no params, but if you were fetching a particular user, you could provide an ID for example
// you get back a response containing data to render in the UI
// decouples the front end from the back end
public class GetUsersEndpoint {
    // this seems like a lot of boilerplate,
    // but I think we don't to be retuning our backend data model classes directly,
    // since that couples the backend to the frontend and violates "each class should have one reason to change"
    // this way, the front end does not need to know anything about the backend, and they are completely decoupled
    // it just gets a "dumb" immutable objects containing some data to be rendered
    // if we found this "User" record was needed in multiple places, we could share this class across the API layer
    // this is a similar approach to GraphQL https://graphql.org/learn/ for creating APIs
    // I have used a Java record class https://docs.oracle.com/en/java/javase/17/language/records.html
    // to cut down on boilerplate (all data returned by the API should be these record classes)
    public record User(int id, String name, String sex) {
    }

    // the return type of the API endpoint
    // {users: [User(id: 1, name: "John", sex: "M"), ...], errors: ["Database error occurred when fetching users."]}
    // note: we would want to create a shared APIError class instead of using strings
    // took a shortcut while prototyping
    // Error(errorCode: 1, message: "Database error occurred when fetching users.")
    //
    public record Output(Collection<User> users, Collection<String> errors) {
    }

    public static Output call() {
        // TO DO: fetch users from the database using our database models instead of hard coding
        Collection<User> users = new ArrayList<>();
        users.add(new User(1, "Jim", "M"));
        users.add(new User(2, "Sally", "F"));
        return new Output(users, new ArrayList<>());
    }
}
