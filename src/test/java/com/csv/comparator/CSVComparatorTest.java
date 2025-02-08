package com.csv.comparator;

import com.opencsv.exceptions.CsvException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CSVComparatorTest {

	@BeforeMethod
	public void printTestStarted() {
		System.out.println("***************Test Started***************");
	}
	
	@AfterMethod
	public void printTestComplete() {
		System.out.println("***************Test Completed***************"+"\n");
	}
    // Test comparing files with identical content
    @Test
    public void testCompareCSVFiles_SameContent() throws IOException, CsvException {
    	
    	System.out.println("Comparing file1.csv and file3.csv (Comparing files with identical content)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file3.csv");
        
    }

    // Test comparing files with a department mismatch
    @Test
    public void testCompareCSVFiles_DifferentContent() throws IOException, CsvException {
    	
        System.out.println("Comparing file1.csv and file2.csv (Comparing files with a department mismatch)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file2.csv");
        
    }

    // Test comparing files with missing rows
    @Test
    public void testCompareCSVFiles_MissingRow() throws IOException, CsvException {
    	
        System.out.println("Comparing file1.csv and file4.csv (Comparing files with missing rows)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file4.csv");
    }

    // Test comparing files with a different column order
    @Test
    public void testCompareCSVFiles_DifferentColumnOrder() throws IOException, CsvException {
    	
        System.out.println("Comparing file1.csv and file5.csv (Same data, different column order)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file5.csv");
        
    }

    // Test comparing files with extra columns in file2
    @Test
    public void testCompareCSVFiles_ExtraColumnsInFile2() throws IOException, CsvException {
    	
        System.out.println("Comparing file1.csv and file6.csv (file2 has extra columns)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file6.csv");
        
    }

    // Test comparing files with extra rows in file2
    @Test
    public void testCompareCSVFiles_ExtraRowsInFile2() throws IOException, CsvException {
        System.out.println("Comparing file1.csv and file7.csv (file2 has extra rows)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file7.csv");
        
    }

    // Test comparing files with a missing column in file2
    @Test
    public void testCompareCSVFiles_MissingColumnInFile2() throws IOException, CsvException {
        System.out.println("Comparing file1.csv and file8.csv (file2 is missing a column)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file8.csv");
        
    }

    // Test comparing files with empty rows
    @Test
    public void testCompareCSVFiles_EmptyRows() throws IOException, CsvException {
        System.out.println("Comparing file1.csv and file9.csv (file2 has empty rows)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file9.csv");
        
    }

    // Test comparing identical files
    @Test
    public void testCompareCSVFiles_IdenticalFiles() throws IOException, CsvException {
        System.out.println("Comparing file1.csv and file1.csv (Same content)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file1.csv", "src/test/resources/csv/file1.csv");
        
    }
    
    // Test Different Number Formats
    @Test
    public void testCompareCSVFiles_Different_Number_Formats() throws IOException, CsvException {
        System.out.println("Comparing file10.csv and file11.csv (Different Number Formats)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file10.csv", "src/test/resources/csv/file11.csv");
        
    }
    
    // Test Case Sensitivity Formats
    @Test
    public void testCompareCSVFiles_Case_Sensitivity_Formats() throws IOException, CsvException {
        System.out.println("Comparing file12.csv and file13.csv (Case Sensitivity Formats)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file12.csv", "src/test/resources/csv/file13.csv");
        
    }
    
    // Test Missing File
    @Test
    public void testCompareCSVFiles_Missing_File() throws IOException, CsvException {
        System.out.println("Comparing file14.csv and file151.csv (Missing File)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file14.csv", "src/test/resources/csv/file151.csv");
        
    }
    
    // Test Extra Whitespace Between Words
    @Test
    public void testCompareCSVFiles_Extra_Whitespaces_Between_Words() throws IOException, CsvException {
        System.out.println("Comparing file16.csv and file17.csv (Extra Whitespaces Between Words)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file16.csv", "src/test/resources/csv/file17.csv");
        
    }
    
    // Test Different Date Formats
    @Test
    public void testCompareCSVFiles_Different_Date_Formats() throws IOException, CsvException {
        System.out.println("Comparing file18.csv and file19.csv (Different Date Formats)");
        CSVComparatorUtil.compareCSVFiles("src/test/resources/csv/file18.csv", "src/test/resources/csv/file19.csv");
        
    }
}
