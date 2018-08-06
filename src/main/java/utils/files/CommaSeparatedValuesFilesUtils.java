package utils.files;

import models.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.javatuples.Pair;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CommaSeparatedValuesFilesUtils {


    public static Pair<SearchTermAggregation, Listings> parseSearchTermCSVFile(String filePath) {
        Pair.with(1, 2);
        return null;
    }

    public static Pair<KeywordTermAggregation, Keywords> keywordScountCSVFile(String filePath) {
        Pair.with(1, 2);
        return null;
    }

    /// bla

    public static SearchTermAggregation parseSearchTermAggregation(List<List<String>> list) {
        SearchTermAggregation searchTermAggregation = new SearchTermAggregation();
        searchTermAggregation.setExportDate(list.get(0).get(0).replace("|", ",").split(",")[0].replace("Export date: ", "").trim().replace("\"", ""));
        searchTermAggregation.setExportTime(list.get(0).get(0).replace("|", ",").split(",")[1].replace("Export time: ", "").trim().replace("\"", ""));

        searchTermAggregation.setSearchTerm(list.get(1).get(0).substring(list.get(1).get(0).indexOf(":") + 1).trim().replace("\"", ""));

        searchTermAggregation.setAverageSales(Float.valueOf(list.get(2).get(0).substring(list.get(2).get(0).indexOf(":") + 1, list.get(2).get(0).length() - 1).trim().replace("\"", "")));

        String averageSalesRank = new StringBuilder(list.get(3).get(0).substring(list.get(3).get(0).indexOf(":") + 1, list.get(3).get(0).length()).trim().replace("\"", ""))
                .append(list.get(3).get(1).trim().replace("\"", ""))
                .toString();

        searchTermAggregation.setAverageSalesRank(Float.valueOf(averageSalesRank));

        searchTermAggregation.setAveragePrice(Float.valueOf(list.get(4).get(0).substring(list.get(4).get(0).indexOf("$") + 1, list.get(4).get(0).length() - 1).trim().replace("\"", "")));

        searchTermAggregation.setAverageReviews(Float.valueOf(list.get(5).get(0).substring(list.get(5).get(0).indexOf(":") + 1, list.get(5).get(0).length() - 1).trim().replace("\"", "")));

        return searchTermAggregation;
    }

    public static void parseCsvFile(String fileName) throws IOException {

        Iterable<CSVRecord> parser = CSVFormat.DEFAULT.parse(new FileReader(fileName));

        Iterator<CSVRecord> iterator = parser.iterator();
        int i = 0;
        while (i++ < 8) {
            if (iterator.hasNext()) {
                iterator.next();
            }
        }

        CSVRecord csvRecord = iterator.next();
        System.out.println(csvRecord.getRecordNumber());
        System.out.println(csvRecord.get(0));
    }
}

