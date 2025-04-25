package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Guy Ritchie", 100, 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 22.50f);
        cart.addDigitalVideoDisc(dvd4);

        // Test the print method
        cart.print();

        // Test search by ID (index-based, starts from 1)
        System.out.println("\n--- Search by ID (Valid and Invalid) ---");
        cart.searchById(2); // Should find "Star Wars"
        cart.searchById(5); // Invalid, should notify

        // Test search by title
        System.out.println("\n--- Search by Title (Case-insensitive, partial match) ---");
        cart.searchByTitle("star");  // Should find "Star Wars"
        cart.searchByTitle("king");  // Should find "The Lion King"
        cart.searchByTitle("harry"); // Should not find
    }
}
