package com.galo.logstach.file;

import com.galo.logstach.Log;
import com.galo.logstach.LogModel;
import com.galo.logstach.util.DatasUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLog extends Log {

    private static final Long MAX_SIZE = 90000000L; // 90MB
    private static final String DDMMYYYY = "dd-MM-yyyy";
    private static final String HHMM = "HH:mm";
    private static final String DIRETORY_LOG = "logs";
    private static final String EXTENCION = ".log";
    private static String ultimoCriado = "";

    private File FileCriarDiretorioAndFileDataAtual() {
        FileUtil.isCreate(DIRETORY_LOG);
        File file;
        if (ultimoCriado.isEmpty()) {
            ultimoCriado = getNome();
        }
        file = new File(ultimoCriado);
        if (file.length() > MAX_SIZE) {
            if (isData(ultimoCriado)) {
                ultimoCriado = getNome();
            } else if (isTime(ultimoCriado)) {
                ultimoCriado = getNome();
            } else {
                ultimoCriado = proximoNome(ultimoCriado);
            }
            file = new File(ultimoCriado);
        }
        return file;
    }

    private String proximoNome(String pAntigo) {
        int tam = pAntigo.length();
        int diminuir = tam - 38;
        String nome = pAntigo.substring(0, tam - (diminuir + 8)) + proximo(pAntigo) + EXTENCION;
        System.out.println("nome: " + nome);
        return nome;
    }

    private boolean isData(String pArquivo) {
        int dataAtual = Integer.parseInt(DatasUtil.dataAtual(DDMMYYYY).replace("-", ""));
        int dataArquivo = Integer.parseInt(dataArquivo(pArquivo));
        if (dataAtual > dataArquivo)
            return true;
        return false;
    }

    private String dataArquivo(String pArquivo) {
        int tamUltimo = pArquivo.length();
        int diminuir = tamUltimo - 38;
        return pArquivo.substring(tamUltimo - (diminuir + 17), tamUltimo - (diminuir + 9));
    }


    private String timeArquivo(String pArquivo) {
        int tamUltimo = pArquivo.length();
        int diminuir = tamUltimo - 38;
        return pArquivo.substring(tamUltimo - (diminuir + 8), tamUltimo - 4);
    }

    private boolean isTime(String pArquivo) {
        int timeAtual = Integer.parseInt(DatasUtil.dataAtual(HHMM).replace(":", ""));
        int timeArquivo = Integer.parseInt(timeArquivo(pArquivo));
        if (timeAtual > timeArquivo)
            return true;
        return false;
    }

    private int proximo(String pArquivo) {
        return Integer.parseInt(timeArquivo(pArquivo)) + 1;
    }

    private String getNome() {
        return DIRETORY_LOG + "/projeto/projeto-" + DatasUtil.dataAtual(DDMMYYYY).replace("-", "") + "_" + DatasUtil.dataAtual(HHMM).replace(":", "") + EXTENCION;
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