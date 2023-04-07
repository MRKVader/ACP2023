
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import week3.scanner.MScanner;

import java.io.ByteArrayInputStream;
import java.io.IOException;


class MScannerTest {

    public MScanner scanner;

  /*  @Before
    public void setUp() {
        String source = "1234 inds line\n next line";
        scanner = new MScanner(new ByteArrayInputStream(source.getBytes()));
    }

    @After
    public void tearDown() {
        try {
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Test
    void hasNext() {
        String source = "1234 inds line\n next line";
        scanner = new MScanner(new ByteArrayInputStream(source.getBytes()));
        boolean condition = scanner.hasNext();
        Assertions.assertTrue(condition);
    }

    @Test
    void testNext() {
        String source = "1234 inds line\n next line";
        scanner = new MScanner(new ByteArrayInputStream(source.getBytes()));
        String actual = scanner.next();
        Assertions.assertEquals("1234", actual);
    }

    @Test
    void nextInt() {
        String source = "1234 inds line\n next line";
        scanner = new MScanner(new ByteArrayInputStream(source.getBytes()));
        Assertions.assertEquals(1234, scanner.nextInt());
    }

}