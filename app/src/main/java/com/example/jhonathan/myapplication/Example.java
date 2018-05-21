package com.example.jhonathan.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class Example {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private String per_page;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("total_pages")
    @Expose
    private String total_pages;
    @SerializedName("data")
    @Expose
    private List<Datos> data;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<Datos> getData() {
        return data;
    }

    public void setData(List<Datos> data) {
        this.data = data;
    }
}
