package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/[globalict/dsai]/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        /*
         * Add items to the store for testing
         * ...
         * For example:
         * store.addMedia(new DigitalVideoDisc("Title", "Category", "Director", 120, 19.99));
         * store.addMedia(new Book("Title", "Author", 29.99));
         * store.addMedia(new CompactDisc("Title", "Artist", 15.99));
         * store.addMedia(new Track("Title", 3.99));
         * store.addMedia(new DigitalVideoDisc("Title", "Category", "Director", 120, 19.99));
         * store.addMedia(new Book("Title", "Author", 29.99));
         * 	
         * 	
         * 	
         */
        

        launch(args);
    }
}