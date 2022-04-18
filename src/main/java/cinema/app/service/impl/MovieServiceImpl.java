package cinema.app.service.impl;

import cinema.app.dao.MovieDao;
import cinema.app.lib.Inject;
import cinema.app.lib.Service;
import cinema.app.model.Movie;
import cinema.app.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
