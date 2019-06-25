package id.dimasahsan.webapp.learngraphqljava;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import id.dimasahsan.webapp.learngraphqljava.models.Link;
import id.dimasahsan.webapp.learngraphqljava.models.LinkFilter;
import id.dimasahsan.webapp.learngraphqljava.repositories.LinkRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks(LinkFilter filter) {
        return linkRepository.getAllLinks(filter);
    }
}
