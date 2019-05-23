package com.AUStoreHouse;

public class data {

    private String fileName;
    private String linkName;

    public data(String fileName,String LinkName){
        this.fileName = fileName;
        this.linkName = LinkName;

    }

    public String getFileName() {
        return fileName;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
