import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Test
    void emptyInventory() {
        JVend.addMoney(20.00);
        for (int i = 0; i < 10; i++) {
            JVend.select("Candy");
        }
        assertEquals(0, JVend.getStock("Candy"));

        JVend.select("Candy");
        assertEquals(0, JVend.getStock("Candy"));
        assertEquals(7.50, JVend.getBalance());
    }

    @Test
    void renameItem() {
        JVend.renameItem("Candy", "Chocolate");
        assertEquals(10, JVend.getStock("Chocolate"));
    }

    @Test
    void removeItem() {
        JVend.removeItem("Gum");
        assertFalse(JVend.hasItem("Gum"));
    }

    @Test
    void vendorsAreSeparate() {
        Vending other = new Vending(10, 10);
        JVend.restock("Candy", 5, 0);
        assertEquals(15, JVend.getStock("Candy"));
        assertEquals(10, other.getStock("Candy"));
    }

    @Test
    void fiveVendors() {
        VendorSystem system = new VendorSystem();
        assertEquals(5, system.vendors.size());
        system.printAll();
    }
}
