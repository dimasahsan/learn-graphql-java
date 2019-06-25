package id.dimasahsan.webapp.learngraphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import id.dimasahsan.webapp.learngraphqljava.models.SignInPayload;
import id.dimasahsan.webapp.learngraphqljava.models.User;

public class SignInResolver implements GraphQLResolver<SignInPayload> {

    public User user(SignInPayload payload) {
        return payload.getUser();
    }
}
