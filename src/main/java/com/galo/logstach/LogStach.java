package com.galo.logstach;

public interface LogStach {

    void writer(LogModel logModel);

    default String get(Class _class) { return _class.getSimpleName() + "-" + System.nanoTime(); }

}
