package com.galo.logstach;

import com.galo.logstach.util.DatasUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class LogModel {

    private String data;
    private String tag;
    private String Classe;
    private String id;
    private Map<String, List<Object>> logs;

    public LogModel() {
    }

    public LogModel(String tag, String classe, String id, Map<String, List<Object>> logs) {
        this.data = DatasUtil.dataAtual("MM-dd-yyyy HH:mm:sss");
        this.tag = tag;
        Classe = classe;
        this.id = id;
        this.logs = logs;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, List<Object>> getLogs() {
        return logs;
    }

    public void setLogs(Map<String, List<Object>> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "LogModel{ \n " +
                "data:" + "\"" + data + "\", \n " +
                "tag:" + "\"" + tag + "\", \n " +
                "Classe:" + "\"" + Classe + "\", \n " +
                "id:" + "\"" + id + "\", \n " +
                "logs:" + "\"" + logs + "\", \n " +
                "}";
    }
}
