package helper;
import org.junit.jupiter.api.BeforeEach;
import dataFactory.DynamicFactory;
public class BaseTest {
    protected DynamicFactory dynamicFactory;
    @BeforeEach
    public void baseTest(){
        dynamicFactory = new DynamicFactory();

    }
}
