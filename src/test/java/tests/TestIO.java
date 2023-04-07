package tests;

import week2.io.IOMethodContainer;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestIO {

    public static final String PATH = "C:\\Users\\VS\\IdeaProjects\\ACP2023\\src\\wh1.txt";

    public static void main(String[] args) throws FileNotFoundException {

        int[] mas = IOMethodContainer.readFileContent(PATH);

        System.out.println(Arrays.toString(mas));
        System.out.println("***");;

        String resString = IOMethodContainer.readFileCodeAsString(PATH);
        System.out.println(resString);;
        System.out.println("***");;

        System.out.println(IOMethodContainer.readFileContentSBuff(PATH));
        System.out.println("***");;

        System.out.println(IOMethodContainer.readFileCodeAsString(PATH));
    }
}
