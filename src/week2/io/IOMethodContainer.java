package week2.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class IOMethodContainer {

    public static int[] readFileContent(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);

        int[] res = new int[1024];
        int count = 0;
        try {
            int temp = 0;
            while ((temp = is.read()) != -1) {
                if (count >= res.length) {
                    res = Arrays.copyOf(res, res.length * 2);
                }
                res[count++] = temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String readFileCodeAsString(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        String res = "";

        try {
            int temp = 0;
            while ((temp = is.read()) != -1) {
                res += temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String readFileContentAsString(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        String res = "";

        try {
            int temp = 0;
            while ((temp = is.read()) != -1) {
                res += (char) temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String readFileContentSBuff(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        byte[] buff = new byte[1024];
        String res = "";

        try {
            int lenght = 0;
            while ((lenght = is.read(buff)) != -1) {
                res += new String(buff, 0, lenght);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}


