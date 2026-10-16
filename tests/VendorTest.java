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
    void restockExistingItem() {
        JVend.restock("Candy", 5, 0);
        assertEquals(15, JVend.getStock("Candy"));
    }

    @Test
    void restockNewItem() {
        JVend.restock("Chips", 5, 1.00);
        assertEquals(5, JVend.getStock("Chips"));
    }
}
