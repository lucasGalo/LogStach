package com.galo.logstach.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileLogTest {

    private static final String NOME_FILE = "logs/projeto/projeto-18022021_1923.log";
    private static final String NOME_FILE_2 = "logs/projeto/projeto-18022021_19235678.log";
    private static final FileLog fileLog = new FileLog();

    @Test
    void testObterDataDoArquivoPeloNome() {

        String dataArquivo = fileLog.dataArquivo(NOME_FILE);
        assertEquals("18022021", dataArquivo);

        String dataArquivo2 = fileLog.dataArquivo(NOME_FILE_2);
        assertEquals("18022021", dataArquivo2);
    }

    @Test
    void testObterHoraDoArquivoPeloNome() {

        String dataArquivo = fileLog.timeArquivo(NOME_FILE);
        assertEquals("1923", dataArquivo);

        String dataArquivo2 = fileLog.timeArquivo(NOME_FILE_2);
        assertEquals("19235678", dataArquivo2);
    }
}