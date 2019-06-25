package id.dimasahsan.webapp.learngraphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import id.dimasahsan.webapp.learngraphqljava.models.Link;
import id.dimasahsan.webapp.learngraphqljava.models.User;
import id.dimasahsan.webapp.learngraphqljava.repositories.UserRepository;

public class LinkResolver implements GraphQLResolver<Link> {

    private final UserRepository userRepository;

    public LinkResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findById(link.getUserId());
    }
}
