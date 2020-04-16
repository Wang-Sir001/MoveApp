package com.bw.movie.model.entity.detailEntity;

import java.util.List;

/**
 * data:2020/3/29
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CommentEntity {

    /**
     * result : [{"commentContent":"aaaaaaaaaaa","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":517,"commentTime":1585556537000,"commentUserId":13698,"commentUserName":"益达","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":7},{"commentContent":"111","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/lW78GWgKWyJZNd7tVSQ0jKkPw9SmTjHbUGbCtscOHwcoibHq8CyQhBHic8qjzopcJ1QEYqTj8vJmLBRlkUlTXccQ/132","commentId":514,"commentTime":1585553702000,"commentUserId":13865,"commentUserName":"。_agy","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"好看\n","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":506,"commentTime":1585479793000,"commentUserId":13752,"commentUserName":"电竞","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"刺激、惊险、 有趣","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-25/20200325103654.jfif","commentId":494,"commentTime":1584934869000,"commentUserId":13842,"commentUserName":"傲娇小公主","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.3},{"commentContent":"1","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-11-02/20191102102933.png","commentId":492,"commentTime":1584352574000,"commentUserId":13578,"commentUserName":"w","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"\"null\"","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-21/20200221212619.webp","commentId":489,"commentTime":1584105334000,"commentUserId":13760,"commentUserName":"王黎杨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"nihao","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-03/20200303092036.jpg","commentId":455,"commentTime":1583454118000,"commentUserId":13757,"commentUserName":"safsaf时间话费卡是否","greatNum":0,"isGreat":0,"replyHeadPic":["http://mobile.bwstudent.com/images/movie/head_pic/2019-11-02/20191102102933.png"],"replyNum":1,"score":4.7},{"commentContent":"comment1","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-11-16/20191116070209.png","commentId":403,"commentTime":1583336250000,"commentUserId":13505,"commentUserName":"non","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"电影好看","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-12/20200312152749.png","commentId":221,"commentTime":1583151005000,"commentUserId":13738,"commentUserName":"示范法","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"22255222558522555555","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-23/20200223153152.jpeg","commentId":202,"commentTime":1582443351000,"commentUserId":13701,"commentUserName":"奇葩男友i_KiV","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5}]
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
         * commentContent : aaaaaaaaaaa
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg
         * commentId : 517
         * commentTime : 1585556537000
         * commentUserId : 13698
         * commentUserName : 益达
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 7
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private float score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public float getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
