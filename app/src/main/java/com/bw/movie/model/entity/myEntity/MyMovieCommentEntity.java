package com.bw.movie.model.entity.myEntity;

import java.util.List;

/**
 * data:2020/4/10
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MyMovieCommentEntity {

    /**
     * result : [{"commentTime":1585713500000,"director":"曾国祥","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","movieScore":0,"myCommentContent":"1","myCommentScore":0,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"commentTime":1585639646000,"director":"林德禄","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieId":17,"movieName":"反贪风暴3","movieScore":0,"myCommentContent":"第三方大法","myCommentScore":2,"starring":"古天乐,张智霖,郑嘉颖,邓丽欣,谢天华"},{"commentTime":1585576026000,"director":"克里斯托弗·麦奎里","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"第三方大法","myCommentScore":2,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentTime : 1585713500000
         * director : 曾国祥
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg
         * movieId : 22
         * movieName : 少年的你
         * movieScore : 0
         * myCommentContent : 1
         * myCommentScore : 0
         * starring : 周冬雨,易烊千玺,张耀,周也,尹昉
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private float myCommentScore;
        private String starring;

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
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

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public float getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(int myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
