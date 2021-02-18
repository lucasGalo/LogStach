package com.galo.logstach.mongo;

import com.galo.logstach.Log;
import com.galo.logstach.LogModel;

public class MongoLog extends Log {

    @Override
    public void writer(LogModel logModel) {
        //System.out.println("Gravando no banco");
    }
}