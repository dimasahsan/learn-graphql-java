package id.dimasahsan.webapp.learngraphqljava;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;

public class Mutation implements GraphQLMutationResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }

    public User createUser(String name, AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.saveUser(newUser);
    }

    public SignInPayload signInUser(AuthData auth) {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SignInPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
