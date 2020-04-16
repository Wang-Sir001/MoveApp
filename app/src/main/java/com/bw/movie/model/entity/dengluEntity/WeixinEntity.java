package com.bw.movie.model.entity.dengluEntity;

/**
 * data:2020/3/29
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class WeixinEntity {

    /**
     * result : {"sessionId":"158548632263413865","userId":13865,"userInfo":{"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/lW78GWgKWyJZNd7tVSQ0jKkPw9SmTjHbUGbCtscOHwcoibHq8CyQhBHic8qjzopcJ1QEYqTj8vJmLBRlkUlTXccQ/132","id":13865,"lastLoginTime":1585486322000,"nickName":"。_agy","sex":1}}
     * message : 登陆成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * sessionId : 158548632263413865
         * userId : 13865
         * userInfo : {"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/lW78GWgKWyJZNd7tVSQ0jKkPw9SmTjHbUGbCtscOHwcoibHq8CyQhBHic8qjzopcJ1QEYqTj8vJmLBRlkUlTXccQ/132","id":13865,"lastLoginTime":1585486322000,"nickName":"。_agy","sex":1}
         */

        private String sessionId;
        private int userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * headPic : http://thirdwx.qlogo.cn/mmopen/vi_32/lW78GWgKWyJZNd7tVSQ0jKkPw9SmTjHbUGbCtscOHwcoibHq8CyQhBHic8qjzopcJ1QEYqTj8vJmLBRlkUlTXccQ/132
             * id : 13865
             * lastLoginTime : 1585486322000
             * nickName : 。_agy
             * sex : 1
             */

            private String headPic;
            private int id;
            private long lastLoginTime;
            private String nickName;
            private int sex;

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(long lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }
    }
}
