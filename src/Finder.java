import java.io.*;
import java.util.LinkedList;

public class Finder {
    public static void main(String[] args) {
        LinkedList<String> keywords = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();

        try {
            File keywordsFile = new File("keywords.txt");
            File targetFile = new File("target.txt");
            File resultFile = new File("result.txt");

            FileReader fr = new FileReader(keywordsFile);
            FileReader fr2 = new FileReader(targetFile);
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);
            String line;
            while ((line = br.readLine()) != null) {
                keywords.add(line);
            }
            fr.close();

            while ((line = br2.readLine()) != null) {
                for (String keyword : keywords) {
                    if (line.contains(keyword))
                        result.add(line);
                }
            }
            fr2.close();

            System.out.println("Found results:");
            StringBuilder sb = new StringBuilder();
            result.stream()
                    .forEach((e) -> {
                        sb.append(e + "\n");
                    });
            String resultingString = sb.toString();
            System.out.println(resultingString);

            FileWriter fw = new FileWriter(resultFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultingString);
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

