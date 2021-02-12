package com.galo.logstach;

import com.galo.logstach.file.FileLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LogstachApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogstachApplication.class, args);
        LogStach fileLog = new FileLog();
        List<LogModel> logModels = listaLogModel();
        logModels.forEach(fileLog::writer);
    }

    private static List<LogModel> listaLogModel() {

        List<LogModel> listaLogModel = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, List<Object>> logs = new HashMap<>();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + " REQUEST: ");
            stringBuilder.append(" {");
            stringBuilder.append("\"nome\": \"Lucas\" \n ");
            stringBuilder.append("\"sobrenome\": \"Galo\" \n ");
            stringBuilder.append("\"sexo\": \"M\" \n ");
            stringBuilder.append("\"dataNascimento\": \"20-08-1990\" \n ");
            stringBuilder.append("} ");
            logs.put("log", Collections.singletonList(stringBuilder));

            LogModel logModel = new LogModel("[VERISON] 1.0.1", "[TAG]", LogstachApplication.class.getName(), "[id] " + i, logs);
            listaLogModel.add(logModel);
        }
        return listaLogModel;
    }



//    public T get(Class _class) {return get(_class.getSimpleName() + "-" + System.nanoTime());}
}