package com.galo.logstach;

import com.galo.logstach.file.FileLog;
import com.galo.logstach.mongo.MongoLog;

public class LogProcess {

    public static void process(LogModel logModel) {
        new FileLog().writer(logModel);
        new MongoLog().writer(logModel);
    }
}