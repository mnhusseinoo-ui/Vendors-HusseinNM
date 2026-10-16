import java.util.HashMap;

class Vending {
    private HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    void resetBalance() {
        this.balance = 0;
    }

    double getBalance() {
        return this.balance;
    }

    void addMoney(double amt) {
        if (amt > 0) {
            this.balance = this.balance + amt;
        }
    }

    void restock(String name, int amount, double price) {
        if (amount <= 0) {
            return;
        }
        if (Stock.containsKey(name)) {
            Stock.get(name).restock(amount);
        } else {
            Stock.put(name, new Item(price, amount));
        }
    }

    void renameItem(String oldName, String newName) {
        if (Stock.containsKey(oldName)) {
            Item item = Stock.remove(oldName);
            Stock.put(newName, item);
        }
    }

    void removeItem(String name) {
        Stock.remove(name);
    }

    int getStock(String name) {
        return Stock.get(name).stock;
    }

    boolean hasItem(String name) {
        return Stock.containsKey(name);
    }

    void printInventory() {
        for (String name : Stock.keySet()) {
            Item item = Stock.get(name);
            System.out.println(name + ": $" + item.price + " (" + item.stock + " left)");
        }
    }
    int getPurchases(String name) {
        return Stock.get(name).timesPurchased;
    }

    void select(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (item.stock > 0 && balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            } else {
                System.out.println("Gimme more money");
            }
        } else {
            System.out.println("Sorry, don't know that item");
        }
    }
}

class Examples {
}