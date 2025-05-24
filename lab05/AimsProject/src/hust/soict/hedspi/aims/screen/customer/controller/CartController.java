package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.scene.Scene;
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class CartController {
	Cart cart;
	Store store;
	private FilteredList<Media> filteredMedia;
	
	public CartController(Store store, Cart cart) {
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private Label lblTotalCost;
	
	@FXML
    private TextField tfFilter;
	
	@FXML
    private RadioButton radioBtnFilterId;
	
	@FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if(media instanceof Playable) {
			try {
				((Playable) media).play();
			} catch (PlayerException e) {
				new Alert(Alert.AlertType.ERROR, "Error playing media: " + e.getMessage()).showAndWait();
			}
		} else {
			new Alert(Alert.AlertType.WARNING, "Selected media is not playable.").showAndWait();
		}
    	
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (!cart.getItemsOrdered().isEmpty()) {
        	new Alert(Alert.AlertType.INFORMATION, "done, placing").showAndWait();
            cart.getItemsOrdered().clear();
            // Update total cost label after clearing the cart
        	lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
        } 
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();
            
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
    	
        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredMedia);
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Media> observable, Media oldValue, Media newValue) -> {updateButtonBar(newValue);});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);}
        });
    	
    	radioBtnFilterId.selectedProperty().addListener((obs, oldVal, newVal) -> {if (newVal) showFilteredMedia(tfFilter.getText());});
        radioBtnFilterTitle.selectedProperty().addListener((obs, oldVal, newVal) -> {if (newVal) showFilteredMedia(tfFilter.getText());});
        
        radioBtnFilterId.setSelected(true);
        
        // Update total cost label
    	lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
        
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                	// update total cost
                	lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
                }
            }
        });
    }
    
    void updateButtonBar(Media media) {
    	if (media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	} else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		} else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    
    
    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.trim().isEmpty()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }
        
        String lowerCaseFilter = filterText.trim().toLowerCase();
        
        if (radioBtnFilterId.isSelected()) {
            filteredMedia.setPredicate(media -> {
                if (media == null) return false;
                try {
                    boolean matches = String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter);
                    return matches;
                } catch (NullPointerException e) {
                    return false;
                }
            });
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredMedia.setPredicate(media -> { if (media == null || media.getTitle() == null) return false;
                boolean matches = media.getTitle().toLowerCase().contains(lowerCaseFilter);
                return matches;
            });
        }
    }


}
