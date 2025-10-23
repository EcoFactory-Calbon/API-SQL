package org.example.apisql.dto;

import java.sql.Date;

public class DauResponseDTO {
    private Integer id;
    private String email;
    private Date date;

    DauResponseDTO() {}

    public DauResponseDTO(Integer id, String email, Date date) {
        this.id = id;
        this.email = email;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
