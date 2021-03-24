package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {
        List<String> records = getLine(fileName);
        List<String> result = new ArrayList<>();
        while (!records.isEmpty()) {
            result.add(getBestPlayer(records));
        }
        return null;
    }

    private List<String> getLine(String fileName) {
        List<String> records = new ArrayList<>();
        String record = "";
        int i = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            while ( (i = fileReader.read() ) > -1) {
                record += (char)i;
            }
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
        records = Arrays.asList(record.split("\n") );
        return records;
    }

    private int getPoints(String record) {
        String[] records = record.split(",");
        int result = 0;
        for (int i = 1; i < records.length; i++) {
            result += Integer.valueOf(records[i]);
        }
        return result;
    }

    private String getPlayer(String record) {
        return record.split(",")[0];
    }

    private String getBestPlayer(List<String> records) {
        int result = 0;
        String fin = "";
        for (String s : records) {
            if (getPoints(s) > result) {
                result = getPoints(s);
                fin = s;
            }
        }
        records.remove(fin);
        return getPlayer(fin);
    }

}
