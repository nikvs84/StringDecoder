package decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Admin on 12.07.2017.
 */
public class StringDecoder {
    public static void main(String[] args) {
        System.out.println("This is StringDecoder");
        String original = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                if ("-e".equals(original)) {
                    break;
                }
                original = reader.readLine();
                System.out.println(toUTF8(original));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String toUTF8(String source) {
        Charset defaultCharset = Charset.defaultCharset();
        Charset utf = StandardCharsets.UTF_8;

        System.out.println("Default charset: " + defaultCharset.displayName());

        byte[] bytes = source.getBytes(defaultCharset);

        String result = new String(bytes, utf);

        return result;
    }
}
