package com.fgchain.main.common;

/**
 * @ClassName BaseDto
 * @Description 数据模型的基类， 默认查前10条记录
 * @Author jiangxy
 * @Date 2018\11\16 0016 15:37
 * @Version 1.0.0
 */
public class BaseDto  {

    private Integer pageSize = 10;

    private Integer pageNum = 0;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
