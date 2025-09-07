import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        int expectedKittens = 1;
        assertEquals(expectedKittens, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        int expectedKittens = 3;
        assertEquals(expectedKittens, feline.getKittens(3));
    }
}