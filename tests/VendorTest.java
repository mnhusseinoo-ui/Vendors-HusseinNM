import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendorTest {
    Vending JVend;
    @BeforeEach
    void SetUP()
    {
        JVend = new Vending(10, 10);
    }

    @Test
    void addMoney_Test()
    {
        JVend.addMoney(20.00);
        assertEquals(20,JVend.getBalance());

    }
    @Test
    void BuyingItem()
    {
       JVend.addMoney(5);
       JVend.select("Candy");
       assertEquals(3.75,JVend.getBalance());
    }

    @Test
    void NegativeNum()
    {
        JVend.addMoney(-50);
        assertEquals(0,JVend.getBalance());
    }




     @Test
    void addition() {
        assertEquals(2, 1 + 1);
}
}
