
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private Feline feline;

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(feline.getKittens()).thenReturn(1);
        when(feline.eatMeat()).thenReturn(List.of("животные", "птицы", "рыба"));
        maleLion = new Lion(feline, "Самец");
        femaleLion = new Lion(feline, "Самка");
    }

    @Test
    public void testMaleLionHasMane() {
        assertEquals(true, maleLion.doesHaveMane());
    }

    @Test
    public void testFemaleLionDoesNotHaveMane() {
        assertEquals(false, femaleLion.doesHaveMane());
    }

    @Test
    public void testMaleLionGetKittens() {
        assertEquals(1, maleLion.getKittens());
    }

    @Test
    public void testFemaleLionGetKittens() {
        assertEquals(1, femaleLion.getKittens());
    }

    @Test
    public void testMaleLionGetFood() throws Exception {
        assertEquals(List.of("животные", "птицы", "рыба"), maleLion.getFood());
    }

    @Test
    public void testFemaleLionGetFood() throws Exception {
        assertEquals(List.of("животные", "птицы", "рыба"), femaleLion.getFood());
    }

    @Test
    public void testInvalidSexThrowsException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("используйте доступные значения пола животных - самец или самка");
        new Lion(feline, "Пол не определен"); // Неправильное значение
    }
}