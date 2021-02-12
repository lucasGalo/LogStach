package com.galo.logstach.file;

import com.galo.logstach.LogModel;
import com.galo.logstach.util.DatasUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLog {

    private static final String MMDDYYYY = "MM-dd-yyyy";
    private static final String DIRETORY_LOG = "logs";

    public void escrever(LogModel log) {

        try (FileWriter fw = new FileWriter(FileCriarDiretorioAndFileDataAtual(), true)) {
            //fw.write(log.toString());
//            BufferedWriter buffWriter = new BufferedWriter(fw);
            fw.write(log.toString());
//            fw.newLine();
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }

    private File FileCriarDiretorioAndFileDataAtual() {
        FileUtil.isCreate(DIRETORY_LOG);
        return new File(DIRETORY_LOG + "/Projeto_" + DatasUtil.dataAtual(MMDDYYYY) + "_.log");
    }
}