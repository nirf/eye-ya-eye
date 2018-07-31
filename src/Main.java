import utils.files.CommaSeparatedValuesFilesUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String keywordScountFilePath = "/Users/nir/Downloads/Jungle Scout Keyword Scout teepee tent for kids.csv";
        String searchTermFilePaht = "/Users/nir/Downloads/Search Term of teepee tent for kids.csv";

        List<List<String>> list = CommaSeparatedValuesFilesUtils.getMatrix(searchTermFilePaht);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list = CommaSeparatedValuesFilesUtils.getMatrix(keywordScountFilePath);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
