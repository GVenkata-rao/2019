package com.epam.uitl;

public class ResponseData {

    private String message;
    private String responseCode;
    private Object data;


    public ResponseData(){

    }
    public ResponseData(String message, String responseCode, Object data) {
        this.message = message;
        this.responseCode = responseCode;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public Object getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
