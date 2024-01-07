package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    /* <-----------POST METHOD -------------*/
    public void addMovie(Movie m)
    {
        movieRepository.addMovie(m);
    }
    public void addDirector(Director d)
    {
        movieRepository.addDirector(d);
    }
    /* <-----------PUT METHOD -------------*/
    public void addMovieDirectorPair(String m,String d)
    {
        movieRepository.addMovieDirectorPair(m,d);
    }

    /* <-----------GET METHOD -------------*/
    public Movie getMovieByname(String m)
    {
        return movieRepository.getMovieByname(m);
    }
    public Director getDirectorByName(String d)
    {
        return movieRepository.getDirectorByName(d);
    }
    public List<String> getMoviesByDiretorName(String d)
    {
        return movieRepository.getMoviesByDiretorName(d);
    }
    public List<String> findAllMovies()
    {
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String d)
    {
        movieRepository.deleteDirectorByName(d);
    }
    public void deleteAllDirectors()
    {
        movieRepository.deleteAllDirectors();
    }

}