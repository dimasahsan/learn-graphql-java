package id.dimasahsan.webapp.learngraphqljava;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class SignInResolver implements GraphQLResolver<SignInPayload> {

    public User user(SignInPayload payload) {
        return payload.getUser();
    }
}
