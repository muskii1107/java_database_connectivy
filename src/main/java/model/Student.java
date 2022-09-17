package model;
import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String mobile;
    private String batch;
    private Date date;

    public void setId(Integer id) {
        this.id = id;
    }

//Constructor
    public Student(Integer id, String name, String mobile, String batch, Date date) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.batch = batch;
        this.date = date;
    }

//Constructor having no id
    public Student(String name, String mobile, String batch, Date date) {
        this.name = name;
        this.mobile = mobile;
        this.batch = batch;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", batch='" + batch + '\'' +
                ", date=" + date +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBatch() {
        return batch;
    }

    public Date getDate() {
        return date;
    }



}
