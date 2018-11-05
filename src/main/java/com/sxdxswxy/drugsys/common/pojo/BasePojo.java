package com.sxdxswxy.drugsys.common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础pojo
 *
 * @author Justdwiwt
 */
public class BasePojo implements Serializable {

    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BasePojo{" +
                "createdDate=" + createdDate +
                '}';
    }

}
