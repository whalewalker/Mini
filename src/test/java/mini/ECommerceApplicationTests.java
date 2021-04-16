package mini;

import mini.services.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest

class ECommerceApplicationTests {
    @Autowired
    RegisterService registerService;

    @Test
    void contextLoads() {
    }




}
