package week3.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {

    public static void parse(String path) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document documentXml = documentBuilder.parse(new File(path));

        Element elementRoot = documentXml.getDocumentElement(); //get root -> team

        System.out.printf("root %s, arr %s", elementRoot.getTagName(), elementRoot.getAttribute("id"));

        NodeList nodeList = elementRoot.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                System.out.println(el.getTagName());
            } else if (node.getNodeType() == Node.TEXT_NODE) {
            }
        }
        System.out.println("size " + nodeList.getLength());
    }

    public static String recursiveParse(Document path, List<String> list, Document root) {

        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                list.add(node.getNodeName());
                recursiveParse(path, list, root);
            }
        }
        return list.toString();
    }

    public static String findByXPath(String xml) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        Document docBuilder = DocumentBuilderFactory.newInstance().
                newDocumentBuilder().parse(new File(xml));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String getUserById = "//user[@id = '1']/address";
        String res = xPath.compile(getUserById).evaluate(docBuilder);
        System.out.println(res);
        return res;
    }
}
