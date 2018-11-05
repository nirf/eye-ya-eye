import models.*;
import utils.files.CommaSeparatedValuesFilesUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        TermGroups termGroups = CommaSeparatedValuesFilesUtils.scanDirAndGroupByTerm("/Users/nir/Downloads/jungleScout_v1");

        List<TermData> termDataList = new ArrayList<>();

        for (int i = 0; i < termGroups.getTermGroupList().size(); i++) {

            TermGroup termGroup = termGroups.getTermGroupList().get(i);

            SearchTermData searchTermData = CommaSeparatedValuesFilesUtils.parseSearchTermCSVFile(termGroup.getSearchTermFilePath());
            KeywordTermData keywordTermData = CommaSeparatedValuesFilesUtils.keywordScountCSVFile(termGroup.getKeywordScountFilePath());

            TermData termData = new TermData(searchTermData, keywordTermData);
            termDataList.add(termData);
        }

        TermsData termsData = new TermsData(termDataList);
        termsData.build();

        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
            @Override
            public int compare(TermData o1, TermData o2) {
                return o1.getSearchTermData().getSearchTermAggregation().getAverageSales()
                        .compareTo(o2.getSearchTermData().getSearchTermAggregation().getAverageSales());
            }
        });

        System.out.println("Order by Average sales");
        for (TermData termData : termsData.getTermDataList()) {
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getSearchTerm());
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getAverageSales());
        }


        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
            @Override
            public int compare(TermData o1, TermData o2) {
                return o1.getSearchTermData().getSearchTermAggregation().getAverageSalesRank()
                        .compareTo(o2.getSearchTermData().getSearchTermAggregation().getAverageSalesRank());
            }
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Order by Average sales Rank");
        for (TermData termData : termsData.getTermDataList()) {
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getSearchTerm());
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getAverageSalesRank());
        }

        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
            @Override
            public int compare(TermData o1, TermData o2) {
                return o1.getSearchTermData().getSearchTermAggregation().getAveragePrice()
                        .compareTo(o2.getSearchTermData().getSearchTermAggregation().getAveragePrice());
            }
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Order by Average Price");
        for (TermData termData : termsData.getTermDataList()) {
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getSearchTerm());
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getAveragePrice());
        }

        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
            @Override
            public int compare(TermData o1, TermData o2) {
                return o1.getSearchTermData().getSearchTermAggregation().getAverageReviews()
                        .compareTo(o2.getSearchTermData().getSearchTermAggregation().getAverageReviews());
            }
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Order by Average Review");
        for (TermData termData : termsData.getTermDataList()) {
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getSearchTerm());
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getAverageReviews());
        }

        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
            @Override
            public int compare(TermData o1, TermData o2) {
                return o1.getSearchTermData().getSearchTermAggregation().getAverageRevenue()
                        .compareTo(o2.getSearchTermData().getSearchTermAggregation().getAverageReviews());
            }
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Order by Average Revenue");
        for (TermData termData : termsData.getTermDataList()) {
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getSearchTerm());
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getAverageRevenue());
        }

        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
            @Override
            public int compare(TermData o1, TermData o2) {
                return o1.getSearchTermData().getSearchTermAggregation().getAverageRevenue()
                        .compareTo(o2.getSearchTermData().getSearchTermAggregation().getAverageRating());
            }
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Order by Average Rating");
        for (TermData termData : termsData.getTermDataList()) {
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getSearchTerm());
            System.out.println(termData.getSearchTermData().getSearchTermAggregation().getAverageRating());
        }

//        Collections.sort(termsData.getTermDataList(), new Comparator<TermData>() {
//            @Override
//            public int compare(TermData o1, TermData o2) {
//                return o1.getKeywordTermData().getKeywordTermAggregation().getExactMatchSearchVolume()
//                        .compareTo(o2.getKeywordTermData().getKeywordTermAggregation().getExactMatchSearchVolume());
//            }
//        });
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println("Order by Exact match search volume");
//        for (TermData termData : termsData.getTermDataList()) {
//            System.out.println(termData.getKeywordTermData().getKeywordTermAggregation().getSearchTerm());
//            System.out.println(termData.getKeywordTermData().getKeywordTermAggregation().getExactMatchSearchVolume());
//        }
    }
}
