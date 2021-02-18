package com.galo.logstach.file;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void isCreate(String path) {
        File folder = new File(path);
        if (!folder.exists())
            folder.mkdir();
    }

    public void visualizarArquivos(String path) throws IOException {

        File file = new File(path);
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
        }
    }

    public static boolean isSizeMax(String path, Long max){
        return new File(path).length() > max;
    }


    public static boolean isExiste(String file) {
        try {
            boolean newArquivo = false;
            File f = new File(file);
            if (!f.exists())
                newArquivo = f.createNewFile();
            return newArquivo;
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return false;
    }
}
