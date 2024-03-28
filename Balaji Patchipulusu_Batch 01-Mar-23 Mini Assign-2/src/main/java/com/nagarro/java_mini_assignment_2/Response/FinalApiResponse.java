package com.nagarro.java_mini_assignment_2.Response;

import com.nagarro.java_mini_assignment_2.Entity.UserDetailsResponse;

import java.util.List;

public class FinalApiResponse {

    private List<UserDetailsResponse> data;
    private PageInfo pageinformation;
    public List<UserDetailsResponse> getData() {
        return data;
    }
    public void setData(List<UserDetailsResponse> data) {
        this.data = data;
    }
    public PageInfo getPageinformation() {
        return pageinformation;
    }
    public void setPageinformation(PageInfo pageinformation) {
        this.pageinformation = pageinformation;
    }
    public FinalApiResponse(List<UserDetailsResponse> data, PageInfo pageinformation) {
        super();
        this.data = data;
        this.pageinformation = pageinformation;
    }
    public FinalApiResponse() {
        super();
    }
    @Override
    public String toString() {
        return "finalApiResponse [data=" + data + ", pageinformation=" + pageinformation + "]";
    }
}