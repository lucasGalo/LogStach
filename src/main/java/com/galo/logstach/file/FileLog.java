package com.galo.logstach.file;

import com.galo.logstach.Log;
import com.galo.logstach.LogModel;
import com.galo.logstach.util.DatasUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLog extends Log {

    private static final String MAX_SIZE = "100";
    private static final String MMDDYYYY = "MM-dd-yyyy";
    private static final String DIRETORY_LOG = "logs";

    private File FileCriarDiretorioAndFileDataAtual() {
        FileUtil.isCreate(DIRETORY_LOG);
        return new File(DIRETORY_LOG + "/Projeto_" + DatasUtil.dataAtual(MMDDYYYY) + "_.log");
    }

    @Override
    public void writer(LogModel logModel) {

        try (FileWriter fw = new FileWriter(FileCriarDiretorioAndFileDataAtual(), true)) {
            fw.write(logModel.toString());
            fw.flush();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }
}