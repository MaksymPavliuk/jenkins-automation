import org.example.TestSteps;
import org.junit.jupiter.api.Test;

public class TestStringSort {

    @Test
    public void TestSort(){
        new TestSteps()
                .getRandomString()
                .sortTheRandomString()
                .verifyStringIsSorted();
    }

}
