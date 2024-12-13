package th.hathikieungan.th5_hashmap.th5_hashmap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;

public class TuDienController {
  @FXML
  private TextField inputField, pronunciationField, meaningField, exampleField;
  @FXML
  private TextField newWordField, newPronunciationField, newMeaningField, newExampleField;

  @FXML
  private Button btnAddWord, btnSaveWord, btnCancelWord;
  @FXML
  private AnchorPane addWordPane;
  @FXML
  private Button searchButton;

  private HashMap<String, Word> dictionary = new HashMap<>();

  @FXML
  public void initialize() {
    // Dữ liệu ban đầu
    dictionary.put("hello", new Word("/həˈləʊ/", "xin chào", "Hello, how are you?"));
    dictionary.put("world", new Word("/wɜːld/", "thế giới", "The world is beautiful."));
    dictionary.put("goodbye", new Word("/ɡʊdˈbaɪ/", "tạm biệt", "Goodbye! See you tomorrow."));
    dictionary.put("love", new Word("/lʌv/", "tình yêu", "I love you so much."));
    dictionary.put("friend", new Word("/frɛnd/", "bạn bè", "She is my best friend."));
    dictionary.put("family", new Word("/ˈfæmɪli/", "gia đình", "I spend time with my family every weekend."));
    dictionary.put("school", new Word("/skuːl/", "trường học", "I go to school by bus."));
    dictionary.put("food", new Word("/fuːd/", "thức ăn", "Pizza is my favorite food."));
    dictionary.put("water", new Word("/ˈwɔːtə/", "nước", "Drink more water to stay healthy."));
    dictionary.put("beautiful", new Word("/ˈbjuːtəfəl/", "xinh đẹp", "This flower is so beautiful."));
    dictionary.put("happy", new Word("/ˈhæpi/", "hạnh phúc", "I am very happy today."));
    dictionary.put("sad", new Word("/sæd/", "buồn", "He felt sad after hearing the news."));
    dictionary.put("cat", new Word("/kæt/", "con mèo", "The cat is sleeping on the sofa."));
    dictionary.put("dog", new Word("/dɒg/", "con chó", "The dog is barking loudly."));
    dictionary.put("elephant", new Word("/ˈɛlɪfənt/", "con voi", "Elephants are very intelligent animals."));
    dictionary.put("rain", new Word("/reɪn/", "mưa", "It is raining heavily outside."));
    dictionary.put("sunny", new Word("/ˈsʌni/", "nắng", "Today is a sunny day."));
    dictionary.put("storm", new Word("/stɔːm/", "bão", "A big storm is coming tomorrow."));
    dictionary.put("hotel", new Word("/həʊˈtɛl/", "khách sạn", "We stayed at a luxury hotel."));
    dictionary.put("airport", new Word("/ˈeəpɔːt/", "sân bay", "The taxi took us to the airport."));
    dictionary.put("computer", new Word("/kəmˈpjuːtə/", "máy tính", "I bought a new computer last week."));
    dictionary.put("internet", new Word("/ˈɪntəˌnɛt/", "mạng internet", "The internet is very slow today."));
    dictionary.put("office", new Word("/ˈɒfɪs/", "văn phòng", "She works in an office downtown."));
    dictionary.put("meeting", new Word("/ˈmiːtɪŋ/", "cuộc họp", "We have a meeting at 10 a.m."));
    //Xử lí sự kiện các nút
    searchButton.setOnAction(event -> handleSearch());
    btnAddWord.setOnAction(event -> showAddWordPane());
    btnSaveWord.setOnAction(event -> saveNewWord());
    btnCancelWord.setOnAction(event -> hideAddWordPane());
  }

  private void handleSearch() {
    String inputWord = inputField.getText().trim().toLowerCase();
    if (dictionary.containsKey(inputWord)) {
      Word result = dictionary.get(inputWord);
      pronunciationField.setText(result.getPronunciation());
      meaningField.setText(result.getMeaning());
      exampleField.setText(result.getExample());
    } else {
      pronunciationField.setText("Không tìm thấy!");
      meaningField.setText("Không tìm thấy! Từ này hiện không có trong từ điển");
      exampleField.setText("Không tìm thấy! Từ này hiện không có trong từ điển");
    }
  }

  private void showAddWordPane() {
    addWordPane.setVisible(true);
  }

  private void hideAddWordPane() {
    newWordField.clear();
    newPronunciationField.clear();
    newMeaningField.clear();
    newExampleField.clear();
    addWordPane.setVisible(false);
  }

  private void saveNewWord() {
    String word = newWordField.getText().trim();
    String pronunciation = newPronunciationField.getText().trim();
    String meaning = newMeaningField.getText().trim();
    String example = newExampleField.getText().trim();

    if (word.isEmpty() || pronunciation.isEmpty() || meaning.isEmpty() || example.isEmpty()) {
      showAlert("Vui lòng nhập đủ thông tin!");
      return;
    }

    // Thêm từ mới vào từ điển
    dictionary.put(word, new Word(pronunciation, meaning, example));
    showAlert("Từ mới đã được thêm vào từ điển!");
    hideAddWordPane();
  }

  private void showAlert( String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText(content);
    alert.showAndWait();
  }
}
