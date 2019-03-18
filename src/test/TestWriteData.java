package test;

import org.junit.jupiter.api.Test;
import utils.WtriteData;

import java.io.IOException;

public class TestWriteData {

    @Test
    public void testfileOutputStream() {
        WtriteData wd = new WtriteData();
        String str = "abc";
        try {
            wd.fileOutputStream(str,"data/myq.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
