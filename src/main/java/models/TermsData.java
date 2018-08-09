package models;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TermsData {
    List<TermData> termDataList;

    public TermsData() {
    }

    public TermsData(List<TermData> termDataList) {
        this.termDataList = termDataList;
    }

    public List<TermData> getTermDataList() {
        return termDataList;
    }

    public void setTermDataList(List<TermData> termDataList) {
        this.termDataList = termDataList;
    }

    public void build() {
        for (TermData termData : termDataList) {
            List<Listing> listings = termData.getSearchTermData().getListings().getListings();
            // averageRevenue
            Double averageRevenueDouble = listings.stream()
                    .mapToDouble(Listing::getRevenue)
                    .average()
                    .getAsDouble();

            Float averageRevenue = BigDecimal.valueOf(averageRevenueDouble).floatValue();
            termData.getSearchTermData().getSearchTermAggregation().setAverageRevenue(averageRevenue);

            // averageRating;
            Double averageRatingDouble = listings.stream()
                    .mapToDouble(Listing::getRating)
                    .average()
                    .getAsDouble();

            Float averageRating = BigDecimal.valueOf(averageRatingDouble).floatValue();
            termData.getSearchTermData().getSearchTermAggregation().setAverageRating(averageRating);


            List<Keyword> keywordList = termData.getKeywordTermData().getKeywords().getKewords();
            List<Keyword> keywordList1 = keywordList.stream()
                    .filter(keyword -> keyword.getRelevancyScore() == 100)
                    .collect(Collectors.toList());

            if (keywordList1.size() > 0) {
                termData.getKeywordTermData().getKeywordTermAggregation().setExactMatchSearchVolume(keywordList1.get(0).getExactMatchSearchVolume());
            } else {
                termData.getKeywordTermData().getKeywordTermAggregation().setExactMatchSearchVolume(-1f);
            }
        }
    }

    @Override
    public String toString() {
        return "TermsData{" +
                "termDataList=" + termDataList +
                '}';
    }
}
