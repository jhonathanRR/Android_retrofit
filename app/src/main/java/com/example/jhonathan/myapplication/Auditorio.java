package com.example.jhonathan.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Auditorio {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("organizator")
    @Expose
    private String organizator;
    @SerializedName("dateInit")
    @Expose
    private String dateInit;
    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("auditorio_id")
    @Expose
    private Integer auditorioId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizator() {
        return organizator;
    }

    public void setOrganizator(String organizator) {
        this.organizator = organizator;
    }

    public String getDateInit() {
        return dateInit;
    }

    public void setDateInit(String dateInit) {
        this.dateInit = dateInit;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAuditorioId() {
        return auditorioId;
    }

    public void setAuditorioId(Integer auditorioId) {
        this.auditorioId = auditorioId;
    }

}


