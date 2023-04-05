package week3.mapping;

import com.google.gson.Gson;
import week3.utils.NetUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class MappingTest {

    public static final String CURRENCY_API = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    public static final String DEST_CURR = "C:\\Users\\VS\\IdeaProjects\\ACP2023\\recources\\currency_api.json";

    public static void main(String[] args) throws URISyntaxException, IOException {
        
        Gson gson = new Gson();

        String currencyExchange = gson.toJson(new CurrencyExchange("usd", "uah", 27.5, 28.5));

        System.out.println(currencyExchange);

        NetUtils.load(CURRENCY_API, DEST_CURR);

        CurrencyExchange[] currency = gson.fromJson(new FileReader(DEST_CURR), CurrencyExchange[].class);
    }
}
