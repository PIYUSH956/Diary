package com.piyushjaiswal121.diary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Task implements Serializable {
    @PrimaryKey(autoGenerate =  true)
    private int id;
    @ColumnInfo(name = "task_name")
    private String task_name;
    @ColumnInfo
    private String task_desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public String getTask_comp_date() {
        return task_comp_date;
    }

    public void setTask_comp_date(String task_comp_date) {
        this.task_comp_date = task_comp_date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }


    @ColumnInfo
    private String task_comp_date;
    @ColumnInfo
    private String comment;
    @ColumnInfo
    private String activate;

}
