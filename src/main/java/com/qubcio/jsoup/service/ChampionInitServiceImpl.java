package com.qubcio.jsoup.service;

import com.qubcio.jsoup.model.entity.Champion;
import com.qubcio.jsoup.model.entity.Stat;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
class ChampionInitServiceImpl implements ChampionInitService {

    @Override
    @SneakyThrows
    public Champion createChampion(String championName) {
        Champion champion = new Champion();

        champion.setName(championName);
        String url = champion.getName().replaceAll("\\s+","")
                .replaceAll("'", "").replaceAll("\\.", "").replaceAll("Wukong", "monkeyking").toLowerCase();
        System.out.println(championName + " -> " + url);
        Document doc = Jsoup.connect("http://gameinfo.eune.leagueoflegends.com/en/game-info/champions/" + url + "/")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36").get();
        Elements elements = doc.getElementsByClass("default-1-2").get(0).child(0).getElementsByClass("default-1-2");

        Elements attributesHtmlSeparated = elements.get(0).children();
        attributesHtmlSeparated.addAll(elements.get(1).children());

        List<Stat> stats = new LinkedList<>();
        attributesHtmlSeparated.forEach(e -> {
            Stat stat = new Stat();
            String name = getAttributeNameFromElement(e);
            Double value = getAttributeValueFromElement(e);
            stat.setName(name);
            stat.setValue(value);
            stats.add(stat);
            if (e.html().contains("per level")) {
                Stat stat1 = new Stat();
                String name1 = name + " per level";
                Double value1 = getAttributeValuePerLevelFromElement(e);
                stat1.setName(name1);
                stat1.setValue(value1);
                stats.add(stat1);
            }
        });
        stats.forEach(e->e.setChampion(champion));

        champion.setStats(stats);
        return champion;
    }

    @Override
    @SneakyThrows
    public List<String> getAllChampionNames() {
        Document doc1 = Jsoup.connect("http://www.mobafire.com/league-of-legends/skins").get();
        Elements elements = doc1.getElementsByClass("footer-links").get(0).children();
        List<String> ele = new LinkedList<>();
        elements.forEach(e -> {
            if (e.html().equals("Rakan") || e.html().equals("Xayah")) {
            } else {
                ele.add(e.html());
            }
        });

        return ele;
    }


    private String getAttributeNameFromElement(Element element) {
        String text = element.child(0).html();
        return text.substring(0, text.length() - 1);
    }

    private Double getAttributeValueFromElement(Element element) {
        String s = element.child(1).html();
        String[] text = s.split(" ");
        return Double.valueOf(text[0]);
    }

    //TODO nie mam zrobionego dla wertosci per level gdzie jest %
    private Double getAttributeValuePerLevelFromElement(Element element) {
        String s = element.child(1).html();
        String[] text = s.split(" ");
        String txValue = text[1].substring(2);

        return (txValue.contains("%")) ? -1 : Double.valueOf(txValue);
    }
}
