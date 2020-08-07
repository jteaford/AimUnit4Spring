package org.aim.movie.movie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/movies")

public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(path = "")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Movie getMovie(@PathVariable (value = "id") Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.get();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateMovie(@PathVariable(value = "id") Integer id, @RequestBody Movie movieDetails) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        Movie movie = optionalMovie.get();

        movie.setMovieTitle(movieDetails.getMovieTitle());
        movie.setMovieLength(movieDetails.getMovieLength());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movieRepository.save(movie);

        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteMovie(@PathVariable(value = "id") Integer id) {
        movieRepository.deleteById(id);
        return "Deleted";
    }


    @PostMapping(path = "/")
    public Movie createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    }
