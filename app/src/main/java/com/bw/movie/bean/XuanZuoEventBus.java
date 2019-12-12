package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/11/20
 *@Time:19:39
 *@Description:${DESCRIPTION}
 **/

public class XuanZuoEventBus {
    private String name;
    private String yugao;
    private String movieId;

    public XuanZuoEventBus(String name, String yugao, String movieId) {
        this.name = name;
        this.yugao = yugao;
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYugao() {
        return yugao;
    }

    public void setYugao(String yugao) {
        this.yugao = yugao;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
