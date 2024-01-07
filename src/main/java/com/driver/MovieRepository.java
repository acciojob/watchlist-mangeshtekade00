package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;
@Repository
public class MovieRepository {
    private HashMap<String,Movie>moviesDb=new HashMap<>();
    private HashMap<String,Director>directorDb=new HashMap<>();
    private HashMap<String,List<String>>pairDb=new HashMap<>();

    /* <-----------POST METHOD -------------*/
    public void addMovie(Movie m)
    {
        moviesDb.put(m.name,m);
    }
    public void addDirector(Director d)
    {
        directorDb.put(d.name,d);
    }
    /* <-----------PUT METHOD -------------*/
    public void addMovieDirectorPair(String m,String d)
    {
        if(!directorDb.containsKey(d) || !moviesDb.containsKey(m))
        {
            return ;
        }
        List<String> list=pairDb.getOrDefault(d,new ArrayList<>());
        list.add(m);
        pairDb.put(d,list);
        directorDb.get(d).setNumberOfMovies(directorDb.get(d).getNumberOfMovies()+1);
    }

    /* <-----------GET METHOD -------------*/
    public Movie getMovieByname(String m)
    {
        if(moviesDb.containsKey(m))
        {
            return moviesDb.get(m);
        }
        else {
            return null;
        }
    }
    public Director getDirectorByName(String d)
    {
        if(directorDb.containsKey(d))
        {
            return directorDb.get(d);
        }
        else
        {
            return null;
        }
    }
    public List<String> getMoviesByDiretorName(String d)
    {
        if(directorDb.containsKey(d)==false)
        {
            return null;
        }
        if(directorDb.containsKey(d) && pairDb.containsKey(d)==false)
        {
            return new ArrayList<>();
        }
        return new ArrayList<>(pairDb.get(d));
    }
    public List<String> findAllMovies()
    {
        return new ArrayList<>(moviesDb.keySet());
    }

    /* <-----------DELETE METHOD -------------*/
    public void deleteDirectorByName(String d)
    {
        directorDb.remove(d);
        if(pairDb.containsKey(d))
        {
            List<String>SL=pairDb.get(d);
            pairDb.remove(d);
            for(String s:SL)
            {
                moviesDb.remove(s);
            }
        }
    }
    public void deleteAllDirectors()
    {
        HashSet<String> mv_set = new HashSet<>();
        for(String d : pairDb.keySet()) {

            mv_set.addAll(pairDb.get(d));
        }
        for(String student : mv_set) {
            moviesDb.remove(student);
        }
    }
}