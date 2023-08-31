package cn.ws.tools.novel;

import cn.ws.tools.WriteLog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NovelScraper {
    public static void main(String[] args) {
        String url = "https://www.qqxsnew.net/20/20221/";
        List<String> list = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements title = doc.select("div.bookname");
            String chapterTitle = title.select("h1").text();
            list.add(chapterTitle);
            Element content = doc.getElementById("content");
            Elements allElements = content.getAllElements();
            List<Node> nodes = content.childNodes();
            String text = content.text();
            String[] split = text.split("<br><br>");
            list.addAll(Arrays.asList(split));


            WriteLog.write("C:\\Users\\Host-424\\Desktop\\aaa.txt",list ,true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
