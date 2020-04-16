package com.bw.movie.model.entity.detailEntity;

import java.util.List;

/**
 * data:2020/4/5
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class CinemaPinglunEntity {

    /**
     * result : [{"commentContent":"很好","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-03/20200403133212.jpg","commentId":460,"commentTime":1585899093000,"commentUserId":13837,"commentUserName":"花花公子","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"����","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-26/20200226014339.jpg","commentId":456,"commentTime":1585746977000,"commentUserId":13692,"commentUserName":"���С�ɰ�","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"sds","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":452,"commentTime":1585741916000,"commentUserId":13870,"commentUserName":"我试试","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很好","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-14/20200314191920.png","commentId":444,"commentTime":1585550552000,"commentUserId":13795,"commentUserName":"魔王","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-25/20200325103654.jfif","commentId":441,"commentTime":1584963155000,"commentUserId":13842,"commentUserName":"傲娇小公主","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-16/20200316202734.jpg","commentId":437,"commentTime":1584852467000,"commentUserId":13823,"commentUserName":"久渔*","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"朱权贵","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-21/20200221212548.jpg","commentId":421,"commentTime":1584013841000,"commentUserId":13756,"commentUserName":"水月洞天","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"nice5961","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-05/20200305151944.png","commentId":190,"commentTime":1583282457000,"commentUserId":13731,"commentUserName":"林家铭1232456","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"海星","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-15/20200315204539.jpg","commentId":186,"commentTime":1583250316000,"commentUserId":13770,"commentUserName":"I啦啦啦I","greatHeadPic":[],"greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"耐思","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-09/20200309144340.png","commentId":109,"commentTime":1583199480000,"commentUserId":13774,"commentUserName":"nice","greatHeadPic":[],"greatNum":2,"hotComment":0,"isGreat":0}]
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
         * commentContent : 很好
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-04-03/20200403133212.jpg
         * commentId : 460
         * commentTime : 1585899093000
         * commentUserId : 13837
         * commentUserName : 花花公子
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

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

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
