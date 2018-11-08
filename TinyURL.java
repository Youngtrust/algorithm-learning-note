public class Codec {

    Map<Integer, String> map = new HashMap();
    String host = "http://tinyurl.com/";

    public String encode(String longUrl) {
      int key = longUrl.hashCode();
      map.put(key, longUrl);
      return host+key;
    }

    public String decode(String shortUrl) {
      int key = Integer.parseInt(shortUrl.replace(host,""));
      return map.get(key);
    }
}
