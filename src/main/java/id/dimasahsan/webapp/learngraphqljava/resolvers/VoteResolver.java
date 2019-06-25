package id.dimasahsan.webapp.learngraphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import id.dimasahsan.webapp.learngraphqljava.models.Link;
import id.dimasahsan.webapp.learngraphqljava.models.User;
import id.dimasahsan.webapp.learngraphqljava.models.Vote;
import id.dimasahsan.webapp.learngraphqljava.repositories.LinkRepository;
import id.dimasahsan.webapp.learngraphqljava.repositories.UserRepository;

public class VoteResolver implements GraphQLResolver<Vote> {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public VoteResolver(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public User user(Vote vote) {
        return userRepository.findById(vote.getUserId());
    }

    public Link link(Vote vote) {
        return linkRepository.findById(vote.getLinkId());
    }
}
