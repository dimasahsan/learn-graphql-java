package id.dimasahsan.webapp.learngraphqljava;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;
import id.dimasahsan.webapp.learngraphqljava.models.*;
import id.dimasahsan.webapp.learngraphqljava.repositories.LinkRepository;
import id.dimasahsan.webapp.learngraphqljava.repositories.UserRepository;
import id.dimasahsan.webapp.learngraphqljava.repositories.VoteRepository;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Mutation implements GraphQLMutationResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository, VoteRepository voteRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
        this.voteRepository = voteRepository;
    }

    public Link createLink(String url, String description, DataFetchingEnvironment env) {
        AuthContext context = env.getContext();
        Link newLink = new Link(url, description, context.getUser().getId());
        return linkRepository.saveLink(newLink);
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

    public Vote createVote(String linkId, String userId) {
        ZonedDateTime now = Instant.now().atZone(ZoneOffset.UTC);
        return voteRepository.saveVote(new Vote(now, userId, linkId));
    }
}
