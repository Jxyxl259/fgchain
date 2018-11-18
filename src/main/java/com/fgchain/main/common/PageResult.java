package com.fgchain.main.common;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description
 * @Author jiangxy
 * @Date 2018\11\16 0016 14:41
 * @Version 1.0.0
 */
public class PageResult<I> {

    /** 总条数 */
    private Long recordsTotal;

    /** 总页数 */
    private int pages;

    /** 每页显示条目数 */
    private Integer pageSize;

    /** 当前页数 */
    private Integer pageNum;

    /** 业务数据 */
    private List<I> datas;

    public PageResult() {
    }

    public PageResult(Page<I> page) {
        this.datas = page.getResult();
        this.pageNum = page.getPageNum();
        this.pages = page.getPages();
        this.pageSize = page.getPageSize();
        this.recordsTotal = page.getTotal();

    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

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

    public List<I> getDatas() {
        return datas;
    }

    public void setDatas(List<I> datas) {
        this.datas = datas;
    }

}