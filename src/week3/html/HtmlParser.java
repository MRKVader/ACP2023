package week3.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParser {

    public static void main(String[] args) throws IOException {

        List<String> linksList = new ArrayList<>();

        Document document = Jsoup.parse(new URL("https://warthunder.ru/ru/"), 10000);

        Element el = document.body();

        Elements elements = el.getElementsByTag("use");
        for (Element element1 : elements){
            String href = element1.attr("href");
            if(href.contains("/img")){
                linksList.add(href);
            }
        }

        el.select("a[href^=/img]");
        linksList.stream().forEach(System.out::println);

        /*System.out.println(element.getAllElements());*/

    }

}
