package com.csv.comparator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVComparatorUtil {

    /**
     * Compares two CSV files and prints out any differences.
     *
     * @param file1Path Path to the first CSV file.
     * @param file2Path Path to the second CSV file.
     * @throws IOException  if an I/O error occurs.
     * @throws CsvException if an error occurs while reading CSV.
     */
    public static void compareCSVFiles(String file1Path, String file2Path) {
        try {
            List<String[]> file1Data = readCSV(file1Path);
            List<String[]> file2Data = readCSV(file2Path);

            System.out.println("Comparing " + file1Path + " and " + file2Path);

            int maxRows = Math.max(file1Data.size(), file2Data.size());
            for (int i = 0; i < maxRows; i++) {
                String[] row1 = (i < file1Data.size()) ? file1Data.get(i) : new String[0];
                String[] row2 = (i < file2Data.size()) ? file2Data.get(i) : new String[0];

                int maxCols = Math.max(row1.length, row2.length);
                for (int j = 0; j < maxCols; j++) {
                    String cell1 = (j < row1.length) ? row1[j].trim() : "";
                    String cell2 = (j < row2.length) ? row2[j].trim() : "";
                    if (!cell1.equals(cell2)) {
                        System.out.println("Difference at row " + (i + 1) + ", column " + (j + 1) +
                                ": File1 value: '" + cell1 + "', File2 value: '" + cell2 + "'");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Missing file detected - " + e.getMessage());
        } catch (IOException | CsvException e) {
            System.err.println("ERROR: Unable to process CSV files - " + e.getMessage());
        }
    }

    /**
     * Reads a CSV file and returns its content as a list of string arrays.
     *
     * @param filePath Path to the CSV file.
     * @return List of String arrays representing rows in the file.
     * @throws IOException  if an I/O error occurs.
     * @throws CsvException if an error occurs while reading CSV.
     */
    private static List<String[]> readCSV(String filePath) throws IOException, CsvException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }
}
