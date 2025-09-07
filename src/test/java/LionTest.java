
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
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
    private Predator predator;

    @Mock
    private Feline feline;

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(predator.eatMeat()).thenReturn(List.of("Антилопа", "Зебра"));
        when(feline.getKittens()).thenReturn(2);
        maleLion = new Lion(predator, feline, "Самец");
        femaleLion = new Lion(predator, feline, "Самка");
    }

    @Test
    public void testHasMane() {
        assertEquals(true, maleLion.doesHaveMane());
        assertEquals(false, femaleLion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        assertEquals(2, maleLion.getKittens());
        assertEquals(2, femaleLion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        assertEquals(List.of("Антилопа", "Зебра"), maleLion.getFood());
        assertEquals(List.of("Антилопа", "Зебра"), femaleLion.getFood());
    }

    @Test
    public void testInvalidSexThrowsException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("используйте доступные значения пола животных - самец или самка");
        new Lion(predator, feline, "Пол не определен"); // Неправильное значение
    }
}