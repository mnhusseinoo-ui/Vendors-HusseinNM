import java.util.ArrayList;

class VendorSystem {
    ArrayList<Vending> vendors = new ArrayList<>();

    VendorSystem() {
        for (int i = 0; i < 5; i++) {
            vendors.add(new Vending(10, 10));
        }
    }

    void printAll() {
        for (int i = 0; i < vendors.size(); i++) {
            System.out.println("Vendor " + (i + 1) + ":");
            vendors.get(i).printInventory();
        }
    }
}