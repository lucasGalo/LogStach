package com.galo.logstach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LogstachApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogstachApplication.class, args);

        //listaLogModel().forEach(LogProcess::process);
        listaLogModel().forEach(log -> LogProcess.process(log));

        listaLogModel().forEach(log -> LogProcess.process(log));
    }
    private static List<LogModel> listaLogModel() {

        List<LogModel> listaLogModel = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + " REQUEST: ");
            stringBuilder.append(" {");
            stringBuilder.append("\"nome\": \"Lucas\" \n ");
            stringBuilder.append("\"sobrenome\": \"Galo\" \n ");
            stringBuilder.append("\"sexo\": \"M\" \n ");
            stringBuilder.append("\"dataNascimento\": \"20-08-1990\" \n ");
            stringBuilder.append("} ");
            listaLogModel.add(LogProcess.listaLogModel(stringBuilder.toString()));
        }
        return listaLogModel;
    }

//    public T get(Class _class) {return get(_class.getSimpleName() + "-" + System.nanoTime());}
}