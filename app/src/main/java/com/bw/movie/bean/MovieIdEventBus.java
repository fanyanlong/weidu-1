package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:14:40
 *@Description:${DESCRIPTION}
 **/

public class MovieIdEventBus {
    private String MovieId;

    public MovieIdEventBus(String movieId) {
        MovieId = movieId;
    }

    public String getMovieId() {
        return MovieId;
    }

    public void setMovieId(String movieId) {
        MovieId = movieId;
    }
}
