package profile;

import org.junit.Test;

public class ProfileTest {
  // 테스트 작성시 코드가 어떻게 동작하는지 깊게 이해하고 실질적인 테스트로 점점 만들어 가야 한다.

  // profile.matches(criteria)
  // Profile 클래스의 matches 메서드 테스트위하여 - 의도하는대로 동작하는지 검증
  // Profile 인스턴스, Criteria 객체 필요
  // Criteria 안에는 Criterion 이 있어야 함
  // Criterion 에는 getAnswer(Answer 타입), getWeight 이 있다.
  // Answer 객체 필요 -> 질문(question)과 답변(true/false)을 가지고 있다.
  // Question 객체 필요 -> 질문번호와 질문내용을 가지고 있다.
  @Test
  public void test() {

    Profile profile = new Profile("John Doe"); // 프로필: 구직자명, 답변, 점수, 매칭여부
    Criteria criteria = new Criteria(); // 기준모음- 답변의 질문을 가지고있음, 중요도

    Question question = new BooleanQuestion(1, "보너스를 받았나?");

    // 기준 답변
    Answer criteriaAnswer = new Answer(question, Boolean.TRUE); // 기준에 맞는 답변 - 질문, 기대하는 정답(참)
    Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch); // 기준 - 답변, 중요성
    criteria.add(criterion);
  }

}