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
public class PageResult<I> extends BaseResult{

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

    public PageResult(Boolean success, Page<I> page, GlobalMessageEnum messageEnum) {
        this.success = success;
        this.statusCode = messageEnum.getStatus_code();
        this.datas = page.getResult();
        this.pageNum = page.getPageNum();
        this.pages = page.getPages();
        this.pageSize = page.getPageSize();
        this.recordsTotal = page.getTotal();

    }

    public PageResult(Page<I> page, Boolean success, String statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.datas = page.getResult();
        this.pageNum = page.getPageNum();
        this.pages = page.getPages();
        this.pageSize = page.getPageSize();
        this.recordsTotal = page.getTotal();

    }

    public PageResult(Boolean success, String statusCode) {
        super(success, statusCode);
    }

    public PageResult(Boolean success, String statusCode, List<I> datas) {
        super(success, statusCode);
        this.datas = datas;
    }

    public PageResult(Boolean success, String statusCode, String message, List<I> datas) {
        super(success, statusCode, message);
        this.datas = datas;
    }

    public PageResult(Boolean success, String statusCode, String message) {
        super(success, statusCode, message);
    }

    public PageResult(Boolean success, String status, String statusCode, String message) {
        super(success, status, statusCode, message);
    }

    public PageResult(Boolean success, String status, String statusCode, String message, List<I> datas) {
        super(success, status, statusCode, message);
        this.datas = datas;
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
