package id.dimasahsan.webapp.learngraphqljava;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLlinks() {
        return linkRepository.getAllLinks();
    }
}
