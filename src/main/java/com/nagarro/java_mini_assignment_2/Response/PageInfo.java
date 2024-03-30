package com.nagarro.java_mini_assignment_2.Response;

public class PageInfo {

    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int total;
    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }
    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }
    public boolean isHasNextPage() {
        return hasNextPage;
    }
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public PageInfo(boolean hasPreviousPage, boolean hasNextPage, int total) {
        super();
        this.hasPreviousPage = hasPreviousPage;
        this.hasNextPage = hasNextPage;
        this.total = total;
    }
    public PageInfo() {
        super();
    }
    @Override
    public String toString() {
        return "PageInfo [hasPreviousPage=" + hasPreviousPage + ", hasNextPage=" + hasNextPage + ", total=" + total
                + "]";
    }

}