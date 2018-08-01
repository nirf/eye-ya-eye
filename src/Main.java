import models.SearchTermAggregation;
import utils.files.CommaSeparatedValuesFilesUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String keywordScountFilePath = "/Users/nir/Downloads/Jungle Scout Keyword Scout teepee tent for kids.csv";
        String searchTermFilePaht = "/Users/nir/Downloads/Search Term of teepee tent for kids.csv";

        List<List<String>> list = CommaSeparatedValuesFilesUtils.getMatrix(searchTermFilePaht);

        for (int i = 0; i < 6; i++) {
            System.out.println(list.get(i));
        }

        SearchTermAggregation searchTermAggregation = new SearchTermAggregation();

        searchTermAggregation.setExportDate(list.get(0).get(0).replace("|", ",").split(",")[0].replace("Export date: ", "").trim().replace("\"", ""));
        searchTermAggregation.setExportTime(list.get(0).get(0).replace("|", ",").split(",")[1].replace("Export time: ", "").trim().replace("\"", ""));

        searchTermAggregation.setSearchTerm(list.get(1).get(0).substring(list.get(1).get(0).indexOf(":") + 1).trim().replace("\"", ""));

        searchTermAggregation.setAverageSales(Float.valueOf(list.get(2).get(0).substring(list.get(2).get(0).indexOf(":") + 1, list.get(2).get(0).length() - 1).trim().replace("\"", "")));

        String averageSalesRank = new StringBuilder(list.get(3).get(0).substring(list.get(3).get(0).indexOf(":") + 1, list.get(3).get(0).length()).trim().replace("\"", ""))
//                .append(",")
                .append(list.get(3).get(1).trim().replace("\"", ""))
                .toString();

        System.out.println(averageSalesRank);
        searchTermAggregation.setAverageSalesRank(Float.valueOf(averageSalesRank));

        searchTermAggregation.setAveragePrice(Float.valueOf(list.get(4).get(0).substring(list.get(4).get(0).indexOf("$") + 1, list.get(4).get(0).length() - 1).trim().replace("\"", "")));

        searchTermAggregation.setAverageReviews(Float.valueOf(list.get(5).get(0).substring(list.get(5).get(0).indexOf(":") + 1, list.get(5).get(0).length() - 1).trim().replace("\"", "")));

        System.out.println(searchTermAggregation);


//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        list = CommaSeparatedValuesFilesUtils.getMatrix(keywordScountFilePath);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
