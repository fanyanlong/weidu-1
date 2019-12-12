package com.bw.movie.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/11/15
 *@Time:20:07
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class XiangqingBean {


    /**
     * message : 查询成功
     * result : {"commentNum":8,"duration":"125分钟","imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieActor":[{"name":"吴京","photo":"http://172.17.8.100/images/movie/actor/pdz/wujing.jpg","role":"方五洲"},{"name":"章子怡","photo":"http://172.17.8.100/images/movie/actor/pdz/zhangziyi.jpg","role":"徐缨"},{"name":"井柏然","photo":"http://172.17.8.100/images/movie/actor/pdz/jingboran.jpg","role":"李国梁"},{"name":"胡歌","photo":"http://172.17.8.100/images/movie/actor/pdz/huge.jpg","role":"杨光"}],"movieDirector":[{"name":"李仁港","photo":"http://172.17.8.100/images/movie/director/pdz/1.jpg"}],"movieId":25,"movieType":"冒险 / 剧情","name":"攀登者","placeOrigin":"中国大陆","posterList":["http://172.17.8.100/images/movie/stills/pdz/pdz6.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz5.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz4.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz3.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz2.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg"],"releaseTime":1569772800000,"score":9.4,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz4.jpg","videoUrl":"http://172.17.8.100/video/movie/pdz/pdz1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz5.jpg","videoUrl":"http://172.17.8.100/video/movie/pdz/pdz2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz3.jpg","videoUrl":"http://172.17.8.100/video/movie/pdz/pdz3.mp4"}],"summary":"1960年，中国登山队向珠峰发起冲刺，完成了世界首次北坡登顶这一不可能的任务。15 年后，方五洲（吴京 饰）和曲松林（张译 饰）在气象学家徐缨（章子怡 饰）的帮助下，带领李国梁（井柏然 饰）、杨光（胡歌 饰）等年轻队员再次挑战世界之巅。迎接他们的将是更加严酷的现实，也是生与死的挑战......","whetherFollow":2}
     * status : 0000
     */

    private String message;
    private ResultBean result;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * commentNum : 8
         * duration : 125分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg
         * movieActor : [{"name":"吴京","photo":"http://172.17.8.100/images/movie/actor/pdz/wujing.jpg","role":"方五洲"},{"name":"章子怡","photo":"http://172.17.8.100/images/movie/actor/pdz/zhangziyi.jpg","role":"徐缨"},{"name":"井柏然","photo":"http://172.17.8.100/images/movie/actor/pdz/jingboran.jpg","role":"李国梁"},{"name":"胡歌","photo":"http://172.17.8.100/images/movie/actor/pdz/huge.jpg","role":"杨光"}]
         * movieDirector : [{"name":"李仁港","photo":"http://172.17.8.100/images/movie/director/pdz/1.jpg"}]
         * movieId : 25
         * movieType : 冒险 / 剧情
         * name : 攀登者
         * placeOrigin : 中国大陆
         * posterList : ["http://172.17.8.100/images/movie/stills/pdz/pdz6.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz5.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz4.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz3.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz2.jpg","http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg"]
         * releaseTime : 1569772800000
         * score : 9.4
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz4.jpg","videoUrl":"http://172.17.8.100/video/movie/pdz/pdz1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz5.jpg","videoUrl":"http://172.17.8.100/video/movie/pdz/pdz2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz3.jpg","videoUrl":"http://172.17.8.100/video/movie/pdz/pdz3.mp4"}]
         * summary : 1960年，中国登山队向珠峰发起冲刺，完成了世界首次北坡登顶这一不可能的任务。15 年后，方五洲（吴京 饰）和曲松林（张译 饰）在气象学家徐缨（章子怡 饰）的帮助下，带领李国梁（井柏然 饰）、杨光（胡歌 饰）等年轻队员再次挑战世界之巅。迎接他们的将是更加严酷的现实，也是生与死的挑战......
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 吴京
             * photo : http://172.17.8.100/images/movie/actor/pdz/wujing.jpg
             * role : 方五洲
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 李仁港
             * photo : http://172.17.8.100/images/movie/director/pdz/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/pdz/pdz4.jpg
             * videoUrl : http://172.17.8.100/video/movie/pdz/pdz1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
