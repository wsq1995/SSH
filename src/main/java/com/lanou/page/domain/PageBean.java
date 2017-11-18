package com.lanou.page.domain;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class PageBean<T> {
//    必选项
    private int pageNum;//第几页
    private int pageSize;//每页显示的条目
    private int totalRecord;//总的记录数

//    计算项
    private int startIndex;//开始索引
    private int totalPage;//总分页数

//    数据
    private List<T> data;//分页数据

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
