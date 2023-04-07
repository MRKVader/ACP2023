package week3.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


public class NetUtils {

    public static void load(String url, String dest) throws URISyntaxException, IOException {

        try (InputStream irl = new URI(url).toURL().openStream();
             OutputStream outputStream = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];
            int count = 0;

            while ((count = irl.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }
        }
    }
}
