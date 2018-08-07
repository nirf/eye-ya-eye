import models.KeywordTermAggregation;
import models.Keywords;
import models.Listings;
import models.SearchTermAggregation;
import org.javatuples.Pair;
import utils.files.CommaSeparatedValuesFilesUtils;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        String keywordScountFilePath = "/Users/nir/Downloads/jungleScout/Jungle Scout Keyword Scout teepee tent for kids.csv";
        String searchTermFilePath = "/Users/nir/Downloads/jungleScout/Search Term of teepee tent for kids.csv";

        Pair<SearchTermAggregation, Listings> pair = CommaSeparatedValuesFilesUtils.parseSearchTermCSVFile(searchTermFilePath);
        Pair<KeywordTermAggregation, Keywords> pair1 = CommaSeparatedValuesFilesUtils.keywordScountCSVFile(keywordScountFilePath);

        // finished parsing now lets play


    }
}
