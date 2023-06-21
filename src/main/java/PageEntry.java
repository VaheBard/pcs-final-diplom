import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class PageEntry implements Comparable<PageEntry> {
    private final String pdfName;
    private final int page;
    private final int count;

    public PageEntry(String pdfName, int page, int count) {
        this.pdfName = pdfName;
        this.page = page;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(PageEntry o) {
        return Integer.compare(o.getCount(), this.getCount());
    }

    @Override
    public String toString() {
        Map map = new LinkedHashMap();
        map.put("pdfName", pdfName);
        map.put("page", page);
        map.put("count", count);
        JSONObject result = new JSONObject(map);
        // Для работы с json мы используем библиотеку jettison.
        // Эта библиотека использует LinkedHashMap, который поддерживает порядок атрибутов.
        // Поэтому метод toString выводит атрибуты в том порядке, в котором они добавлялись изначально.
        return result.toString();
    }
}