import models.*;
import org.javatuples.Pair;
import utils.files.CommaSeparatedValuesFilesUtils;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        TermGroups termGroups = CommaSeparatedValuesFilesUtils.scanDirAndGroupByTerm("/Users/nir/Downloads/jungleScout");

        System.out.println(termGroups);

        for (int i = 0; i < termGroups.getTermGroupList().size(); i++) {
            TermGroup termGroup = termGroups.getTermGroupList().get(i);
            Pair<SearchTermAggregation, Listings> pair = CommaSeparatedValuesFilesUtils.parseSearchTermCSVFile(termGroup.getSearchTermFilePath());
            Pair<KeywordTermAggregation, Keywords> pair1 = CommaSeparatedValuesFilesUtils.keywordScountCSVFile(termGroup.getKeywordScountFilePath());
        }

        // finished parsing now lets play


    }
}
