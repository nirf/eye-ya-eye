package utils.files;

import models.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.javatuples.Pair;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class CommaSeparatedValuesFilesUtils {

    private final static Locale locale = Locale.US;
    private final static Integer ERROR_PARSE_NUMBER = -1;

    private final static String SEARCH_TERM_FILE_PREFIX = "search term of";
    private final static String KEYWORD_FILE_PREFIX = "jungle scout keyword scout";

    public static TermGroups scanDirAndGroupByTerm(String dirPath) {
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();
        List<TermGroup> termGroupList = new ArrayList<>();
        Map<String, TermGroup> termToTermGroupMap = new HashMap<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isDirectory()) {
                continue;
            }
            String fileNameLowerCased = listOfFiles[i].getName().toLowerCase();
            String fileName = listOfFiles[i].getAbsolutePath();
            String term = "";
            if (fileNameLowerCased.startsWith(SEARCH_TERM_FILE_PREFIX)) {
                term = fileNameLowerCased.replace(SEARCH_TERM_FILE_PREFIX, "").replace(".csv", "").trim();

                if (termToTermGroupMap.containsKey(term)) {
                    TermGroup termGroup = termToTermGroupMap.get(term);
                    termGroup.setSearchTermFilePath(fileName);
                } else {
                    TermGroup termGroup = new TermGroup();
                    termGroup.setSearchTermFilePath(fileName);
                    termGroup.setTerm(term);
                    termToTermGroupMap.put(term, termGroup);
                }
            }

            if (fileNameLowerCased.startsWith(KEYWORD_FILE_PREFIX)) {
                term = fileNameLowerCased.replace(KEYWORD_FILE_PREFIX, "").replace(".csv", "").trim();

                if (termToTermGroupMap.containsKey(term)) {
                    TermGroup termGroup = termToTermGroupMap.get(term);
                    termGroup.setKeywordScountFilePath(fileName);
                } else {
                    TermGroup termGroup = new TermGroup();
                    termGroup.setKeywordScountFilePath(fileName);
                    termToTermGroupMap.put(term, termGroup);
                    termGroup.setTerm(term);
                }
            }
        }

        return new TermGroups(new ArrayList<>(termToTermGroupMap.values()));
    }


    public static Pair<SearchTermAggregation, Listings> parseSearchTermCSVFile(String filePath) throws IOException, ParseException {
        Iterable<CSVRecord> parser = CSVFormat.DEFAULT.parse(new FileReader(filePath));
        Iterator<CSVRecord> iterator = parser.iterator();

        SearchTermAggregation searchTermAggregation = parseSearchTermAggregation(iterator);
        // skip the headers
        iterator.next();

        List<Listing> listingList = parseListings(iterator);

        return Pair.with(searchTermAggregation, new Listings(listingList));
    }

    public static Pair<KeywordTermAggregation, Keywords> keywordScountCSVFile(String filePath) throws IOException {
        Iterable<CSVRecord> parser = CSVFormat.DEFAULT.parse(new FileReader(filePath));
        Iterator<CSVRecord> iterator = parser.iterator();

        KeywordTermAggregation keywordTermAggregation = parseKeywordTermAggregation(iterator);
        // skip the headers
        iterator.next();

        List<Keyword> keywordList = parseKeywords(iterator);


        return Pair.with(keywordTermAggregation, new Keywords(keywordList));
    }

    private static List<Keyword> parseKeywords(Iterator<CSVRecord> iterator) {
        List<Keyword> keywordList = new ArrayList<>();
        while (iterator.hasNext()) {
            Keyword keyword = new Keyword();
            CSVRecord csvRecord = iterator.next();

            String keywordStr = csvRecord.get(0);
            keyword.setKeyword(keywordStr);

            String exactMatchSearchVolume = csvRecord.get(1);
            keyword.setExactMatchSearchVolume(parseNumber(exactMatchSearchVolume).floatValue());

            String broadMatchSearchVolume = csvRecord.get(2);
            keyword.setBroadMatchSearchVolume(parseNumber(broadMatchSearchVolume).floatValue());

            String dominanatCategory = csvRecord.get(3);
            keyword.setDominantCategory(dominanatCategory);

            String recommendedGiveaway = csvRecord.get(4);
            keyword.setRecommendedGiveaway(parseNumber(recommendedGiveaway).floatValue());

            String hsaBid = csvRecord.get(5);
            keyword.setHSABid(parseNumberWithDollarSign(hsaBid).floatValue());

            String exactPPCBid = csvRecord.get(6);
            keyword.setExactPPCBid(parseNumberWithDollarSign(exactPPCBid).floatValue());

            String broadPPCBid = csvRecord.get(7);
            keyword.setBroadPPCBid(parseNumberWithDollarSign(broadPPCBid).floatValue());

            String relevancyScope = csvRecord.get(8);
            keyword.setRelevancyScore(parseNumber(relevancyScope).floatValue());

            keywordList.add(keyword);
        }

        return keywordList;
    }

    private static KeywordTermAggregation parseKeywordTermAggregation(Iterator<CSVRecord> iterator) {
        int i = 0;
        KeywordTermAggregation keywordTermAggregation = new KeywordTermAggregation();
        while (iterator.hasNext() && i++ < 3) {
            CSVRecord csvRecord = iterator.next();
            String content = csvRecord.get(0);

            if (content.startsWith("Report Generated")) {
                keywordTermAggregation.setReportGeneratedAt(content.substring(content.indexOf(":") + 1).trim());
            }

            if (content.startsWith("Search Term")) {
                keywordTermAggregation.setSearchTerm(content.substring(content.indexOf(":") + 1).trim());
            }
        }
        return keywordTermAggregation;
    }

    private static List<Listing> parseListings(Iterator<CSVRecord> iterator) throws ParseException {
        // parsing the listings
        List<Listing> listingList = new ArrayList<>();
        while (iterator.hasNext()) {
            Listing listing = new Listing();

            CSVRecord csvRecord = iterator.next();

            String index = csvRecord.get(0);
            listing.setIndex(index);

            String productName = csvRecord.get(1);
            listing.setProductName(productName);

            String brand = csvRecord.get(2);
            listing.setBrand(brand);

            String price = csvRecord.get(3);
            listing.setPrice(parseNumberWithDollarSign(price).floatValue());

            String category = csvRecord.get(4);
            listing.setCategory(category);

            String rank = csvRecord.get(5);
            listing.setRank(parseNumber(rank.replace(",", "")).floatValue());

            String sales = csvRecord.get(6);
            listing.setSales(parseNumber(sales).floatValue());

            String revenue = csvRecord.get(7);
            listing.setRevenue(parseNumberWithDollarSign(revenue).floatValue());

            String reviews = csvRecord.get(8);
            listing.setReviews(parseNumber(reviews).floatValue());

            String rating = csvRecord.get(9);
            listing.setRating(parseNumber(rating).floatValue());

            String seller = csvRecord.get(10);
            listing.setSeller(seller);

            String asin = csvRecord.get(11);
            listing.setAsin(asin);

            String link = csvRecord.get(12);
            listing.setLink(link);
            listingList.add(listing);
        }
        return listingList;
    }

    private static SearchTermAggregation parseSearchTermAggregation(Iterator<CSVRecord> iterator) throws ParseException {
        int i = 0;
        SearchTermAggregation searchTermAggregation = new SearchTermAggregation();
        // parsing searchTermAggregation
        while (iterator.hasNext() && i++ < 7) {
            CSVRecord csvRecord = iterator.next();

            String content = csvRecord.get(0);

            if (content.startsWith("Export date")) {
                searchTermAggregation.setExportDate(content.replace("|", ",")
                        .split(",")[0]
                        .replace("Export date: ", "")
                        .trim()
                        .replace("\"", ""));

                searchTermAggregation.setExportTime(content.replace("|", ",")
                        .split(",")[1]
                        .replace("Export time: ", "")
                        .trim()
                        .replace("\"", ""));
            }

            if (content.startsWith("Search Term")) {
                searchTermAggregation.setSearchTerm(content
                        .substring(content
                                .indexOf(":") + 1)
                        .trim()
                        .replace("\"", ""));
            }

            if (content.startsWith("Average Sales:")) {
                searchTermAggregation.setAverageSales(parseNumber(content
                        .substring(content
                                .indexOf(":") + 1, content.length())
                        .trim()
                        .replace("\"", "")).floatValue());
            }

            if (content.startsWith("Average Sales Rank:")) {
                String averageSalesRank = content.substring(content.indexOf(":") + 1, content.length())
                        .replace(",", "").trim();
                searchTermAggregation.setAverageSalesRank(parseNumber(averageSalesRank).floatValue());
            }

            if (content.startsWith("Average Price")) {
                searchTermAggregation.setAveragePrice(parseNumberWithDollarSign(content
                        .substring(content.indexOf(":") + 1, content.length())
                        .trim().replace("\"", "")).floatValue());
            }

            if (content.startsWith("Average Reviews")) {
                searchTermAggregation.setAverageReviews(parseNumber(content
                        .substring(content.indexOf(":") + 1, content.length())
                        .trim().replace("\"", "")).floatValue());
            }
        }
        return searchTermAggregation;
    }

    private static Number parseNumber(String number) {
        try {
            // "265,858"
            return NumberFormat.getNumberInstance(locale).parse(number);
        } catch (Exception e) {
            return ERROR_PARSE_NUMBER;
        }
    }

    private static Number parseNumberWithDollarSign(String number) {
        try {
            // "$123,333.45"
            return NumberFormat.getCurrencyInstance(locale).parse(number);
        } catch (Exception e) {
            return ERROR_PARSE_NUMBER;
        }
    }
}

