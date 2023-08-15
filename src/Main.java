import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Paste the URL of the ticket
        String lotteryURL = "https://results.govdoc.lk/results/jayoda-1944";
        try {
            // Connect to the specified URL and retrieve the HTML document
            Document doc = Jsoup.connect(lotteryURL).get();

            // Select HTML elements with the class "result-block"
            Elements resultElements = doc.select("div.result-block");

            if (resultElements.isEmpty()) {
                System.out.println("No results.");
            } else {
                System.out.println("Lottery Results");
                // Iterate through each selected HTML element
                for (Element resultBlockElement : resultElements) {
                    // Extract the text content of the selected element
                    String resultText = resultBlockElement.text();

                    // Print the extracted text (lottery result)
                    System.out.println(resultText);
                }
            }
        } catch (IOException e) {
            // Handle exceptions related to connecting to the URL or parsing the document
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
