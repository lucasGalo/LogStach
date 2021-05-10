package com.galo.logstach;

import com.galo.logstach.file.FileLog;
import com.galo.logstach.mongo.MongoLog;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogProcess<L extends Less> {

    public static void process(LogModel logModel) {
        new FileLog().writer(logModel);
        new MongoLog().writer(logModel);
    }

    public static LogModel listaLogModel(String msg) {

        Map<String, List<Object>> logs = new HashMap<>();
        logs.put("log", Collections.singletonList(msg));
        LogModel logModel = new LogModel("[VERISON] 1.0.1", "[TAG]", LogstachApplication.class.getName(), "[id] 120", logs);
        return logModel;
    }
}