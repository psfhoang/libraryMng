package com.example.demo.entityResponse;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class EntityResponse {
    private HttpStatus status;
    private Timestamp time;
    private String message;
    private Object data;


    public EntityResponse(HttpStatus status, Timestamp time, String message, Object data) {
        this.status = status;
        this.time = time;
        this.message = message;
        this.data = data;
    }
    public EntityResponse(HttpStatus status, String message, Object data) {
        this.status = status;
        this.time = new Timestamp(System.currentTimeMillis());
        this.message = message;
        this.data = data;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

