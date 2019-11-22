import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String hamString = "Hamlet is a play about Hamlet.";
                String actual = hamletParser.changeNames("Hamlet", "Leon", hamString);
                String expected = "Leon is a play about Leon.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {

        String horaString = "Horatio rhymes with Horatio and Poratio";
        String actual = hamletParser.changeNames("Horatio", "Tariq", horaString);
        String expected = "Tariq rhymes with Tariq and Poratio";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
        String value = hamletText;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(value);
        Assert.assertTrue(matcher.find());
    }

    @Test
    public void testFindHamlet() {
        String value = hamletText;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(value);
        Assert.assertTrue(matcher.find());
    }
}