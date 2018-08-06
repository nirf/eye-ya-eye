import models.Listings;
import models.SearchTermAggregation;
import org.javatuples.Pair;
import utils.files.CommaSeparatedValuesFilesUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String keywordScountFilePath = "/Users/nir/Downloads/Jungle Scout Keyword Scout teepee tent for kids.csv";
        String searchTermFilePath = "/Users/nir/Downloads/Search Term of teepee tent for kids.csv";

        Pair<SearchTermAggregation, Listings> pair = CommaSeparatedValuesFilesUtils.parseSearchTermCSVFile(searchTermFilePath);
    }
}
