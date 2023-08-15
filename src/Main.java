import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //paste the url of the ticket
        String lotteryURL = "https://results.govdoc.lk/results/jayoda-1944";
        try {
            Document doc = Jsoup.connect(lotteryURL).get();

            //inspect and check what is the html tag that contains the lottery result
            Elements resultElements = doc.select("div.result-block");

            if (resultElements.isEmpty()) {
                System.out.println("No results.");
            } else {
                System.out.println("Lottery Results");
                for (Element resultBlockElement : resultElements) {
                    String resultText = resultBlockElement.text();

                    System.out.println(resultText);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

