package week3.tests;

import week3.utils.NetUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class NetUtilsTest {
    public static void main(String[] args) throws URISyntaxException, IOException {

        NetUtils.load("https://cdn.mp3xa.cc/5ZEv3yOqnTfZBNQWJ6_1Uw/1680555614/L21wMy8yMDIzLzAzL0FsZWtzIEF0YW1hbiAmIEZpbmlrLkZpbnlhIC0g0J7QudC-0LnQvtC5ICjQotGLINCT0L7QstC-0YDQuNC70LApLm1wMw", "" +
                "C:\\Users\\VS\\IdeaProjects\\ACP2023\\recources\\audio.mp3");

    }
}
