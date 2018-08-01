package utils.files;

import models.SearchTermAggregation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommaSeparatedValuesFilesUtils {
    public static List<List<String>> getMatrix(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<List<String>> matrix = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] splittedLine = line.split(cvsSplitBy);
                List<String> list = Arrays.asList(splittedLine);
                matrix.add(list);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return matrix;
    }

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
}
