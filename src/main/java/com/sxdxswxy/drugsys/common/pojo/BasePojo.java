package com.sxdxswxy.drugsys.common.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础pojo
 *
 * @author Justdwiwt
 */
@Data
@ToString
public class BasePojo implements Serializable {

    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
