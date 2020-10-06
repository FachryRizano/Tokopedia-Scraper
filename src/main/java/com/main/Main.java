package com.main;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
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
        Desktop desktop = java.awt.Desktop.getDesktop();

        doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsByClass("pcv3__container css-1bd8ct");
        List<Produk> produks = new ArrayList<Produk>();
        for(Element e:elements){
            String name = e.getElementsByClass("css-18c4yhp").text();
            int harga = Integer.parseInt(e.getElementsByClass("css-rhd610").text().substring(2).replace(".",""));
            String link = e.getElementsByClass("css-1ehqh5q").select("a").attr("href");
            Produk produk = new Produk(name,harga,link);
            produks.add(produk);
            System.out.println(link);
        }

        Collections.sort(produks);

    }

}
