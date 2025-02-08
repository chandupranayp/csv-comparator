package com.csv.comparator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVComparatorUtil {

    /**
     * Compares two CSV files and prints out any differences.
     * Missing rows or columns are reported.
     *
     * @param file1Path Path to the first CSV file.
     * @param file2Path Path to the second CSV file.
     * @throws IOException  if an I/O error occurs.
     * @throws CsvException if an error occurs while reading CSV.
     */
    public static void compareCSVFiles(String file1Path, String file2Path) throws IOException, CsvException {
        List<String[]> file1Data = readCSV(file1Path);
        List<String[]> file2Data = readCSV(file2Path);

        // Determine the maximum number of rows between both files.
        int maxRows = Math.max(file1Data.size(), file2Data.size());
        for (int i = 0; i < maxRows; i++) {
            String[] row1;
            String[] row2;

            // If one file is missing the row, report it and use an empty array.
            if (i >= file1Data.size()) {
                System.out.println("Row " + (i + 1) + " is missing in the first file.");
                row1 = new String[0];
            } else {
                row1 = file1Data.get(i);
            }

            if (i >= file2Data.size()) {
                System.out.println("Row " + (i + 1) + " is missing in the second file.");
                row2 = new String[0];
            } else {
                row2 = file2Data.get(i);
            }

            // Determine the maximum number of columns for this row.
            int maxCols = Math.max(row1.length, row2.length);
            for (int j = 0; j < maxCols; j++) {
                // If one file is missing a column, default its cell value to an empty string.
                String cell1 = (j < row1.length) ? row1[j].trim() : "";
                String cell2 = (j < row2.length) ? row2[j].trim() : "";
                if (!cell1.equals(cell2)) {
                    System.out.println("Difference at row " + (i + 1) + ", column " + (j + 1) +
                            ": File1 value: '" + cell1 + "', File2 value: '" + cell2 + "'");
                }
            }
        }
    }

    private static List<String[]> readCSV(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }
}
