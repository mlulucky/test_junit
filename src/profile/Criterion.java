package profile;

// 기준
public class Criterion {
  private Answer criteriaAnswer;
  private Weight weight; // int 가 아니라 Weight 가중치 타입의 Doncare, MustMatch

  // 기준 답변, 답변의 가중치(중요도)
  // criteriaAnswer = new Answer(question, BooleanTrue);
  // ( criteriaAnswer(질문, 기준답변), weight 가중치)
  public Criterion(Answer criteriaAnswer, Weight weight) {
    this.criteriaAnswer = criteriaAnswer;
    this.weight = weight;
  }

  // 가중치(중요도)
  public Weight getWeight() {
    return weight;
  }

  // 답변 - 질문
  // criterionAnswer 내부에 getQuestionText
  public Answer getAnswer() {
    return criteriaAnswer;
  }

}
