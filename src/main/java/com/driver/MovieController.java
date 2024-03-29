package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    public MovieService movieService;

    /* <------------ POST API-----------------> */
    @PostMapping("/add-movies")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>  addMovieDirectorPair(@RequestParam String movie,@RequestParam String director)
    {
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added succefully",HttpStatus.CREATED);
    }

    /* <---------------GET api's ------------------> */
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie)
    {
        Movie m=null;
        m=movieService.getMovieByname(movie);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director)
    {
        Director d=null;
        d=movieService.getDirectorByName(director);
        return  new ResponseEntity<>(d,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
    {
        List<String> movies=null;
        movies=movieService.getMoviesByDiretorName(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> movies=null;
        movies=movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
    {
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(director+" removed successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public  ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully",HttpStatus.CREATED);
    }
}