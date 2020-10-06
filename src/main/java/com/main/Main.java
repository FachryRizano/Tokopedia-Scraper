package com.main;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Apa yang anda cari?");
        String input= scan.nextLine();
        String barang = input.replaceAll("\\s","%20");
        String url = "https://www.tokopedia.com/search?st=product&q=" +barang;

        doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsByClass("pcv3__container css-1bd8ct");
        Elements anchor_link = doc.getElementsByAttribute("a");
        System.out.println(anchor_link);
//        List<Produk> produks = new ArrayList<Produk>();
//        for(Element e:elements){
//            String name = e.getElementsByClass("css-18c4yhp").text();
//            int harga = Integer.parseInt(e.getElementsByClass("css-rhd610").text().substring(2).replace(".",""));
//            String link = e.getElementsByClass("pcv3_info-content css-gwkf0u").text();
//            Produk produk = new Produk(name,harga,link);
//            produks.add(produk);
//            System.out.println();
//        }
//
//        Collections.sort(produks);
    }

}
