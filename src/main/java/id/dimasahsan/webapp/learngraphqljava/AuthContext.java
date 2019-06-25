package id.dimasahsan.webapp.learngraphqljava;

import graphql.servlet.GraphQLContext;
import id.dimasahsan.webapp.learngraphqljava.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AuthContext extends GraphQLContext {

    private final User user;

    public AuthContext(User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        super(request, response);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
