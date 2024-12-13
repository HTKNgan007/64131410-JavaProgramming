package th.hathikieungan.th5_hashmap.th5_hashmap;

public class Word {
  private String pronunciation;
  private String meaning;
  private String example;

  public Word(String pronunciation, String meaning, String example) {
    this.pronunciation = pronunciation;
    this.meaning = meaning;
    this.example = example;
  }

  public String getPronunciation() {
    return pronunciation;
  }

  public String getMeaning() {
    return meaning;
  }

  public String getExample() {
    return example;
  }
}
