package com.bsimm;

public class JSONLog {
    private String[] data;
    private String[] meta;

    public JSONLog(String[] data, String[] meta) {
        this.data = data;
        this.meta = meta;
    }
    
    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }
    public String[] getMeta() {
        return meta;
    }
    public void setMeta(String[] meta) {
        this.meta = meta;
    }
}
