package profile;

public class Answer {
  private Question question;
  private boolean answerIsTrueOrFalse;

  // 질문 - 답(true || false)
  public Answer(Question question, boolean answerIsTrueOrFalse) {
    this.question = question;
    this.answerIsTrueOrFalse = answerIsTrueOrFalse;
  }

  public String getQuestionText() {
    // 질문
    return question.getQuestionText();
  }

  // 매칭 여부
  public boolean match(Answer answer){
    // 대답에 대한 답변이 기준답변과 일치하는지
    return this.answerIsTrueOrFalse == answer.answerIsTrueOrFalse;
  }
}
