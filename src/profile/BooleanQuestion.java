package profile;

public class BooleanQuestion extends Question {
  // 질문번호, 질문
  private int qusetionNum;
  private String questionText;

  // 생성자
  public BooleanQuestion(int qusetionNum, String questionText) {
    this.qusetionNum = qusetionNum;
    this.questionText = questionText;
  }


  @Override
  public String getQuestionText() {
    return questionText;
  }
}
