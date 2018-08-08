import models.*;
import org.javatuples.Pair;
import utils.files.CommaSeparatedValuesFilesUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        TermGroups termGroups = CommaSeparatedValuesFilesUtils.scanDirAndGroupByTerm("/Users/nir/Downloads/jungleScout");
        System.out.println(termGroups);

        List<TermData> termDataList = new ArrayList<>();

        for (int i = 0; i < termGroups.getTermGroupList().size(); i++) {

            TermGroup termGroup = termGroups.getTermGroupList().get(i);

            SearchTermData searchTermData = CommaSeparatedValuesFilesUtils.parseSearchTermCSVFile(termGroup.getSearchTermFilePath());
            KeywordTermData keywordTermData = CommaSeparatedValuesFilesUtils.keywordScountCSVFile(termGroup.getKeywordScountFilePath());

            TermData termData = new TermData(searchTermData, keywordTermData);
            termDataList.add(termData);
        }

        TermsData termsData = new TermsData(termDataList);
        System.out.println(termsData);
        // finished parsing now lets play
    }
}
