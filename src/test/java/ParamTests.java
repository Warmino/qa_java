import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamTests {

    private final String animalType;
    private final List<String> expectedFood;

    public ParamTests(String animalType, List<String> expectedFood) {
        this.animalType = animalType;
        this.expectedFood = expectedFood;
    }

    @Parameters(name = "{index}: {0} -> {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]
                {{ "Хищник", List.of("Животные", "Птицы", "Рыба") },
                        { "Травоядное", List.of("Трава", "Различные растения") }}
        );
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFood, feline.getFood(animalType));
    }
}
