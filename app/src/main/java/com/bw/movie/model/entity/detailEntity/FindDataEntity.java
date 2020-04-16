package com.bw.movie.model.entity.detailEntity;

import java.util.List;

/**
 * data:2020/4/6
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class FindDataEntity {

    /**
     * result : ["04-06","04-07","04-08","04-09","04-10","04-11","04-12"]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<String> result;

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

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
