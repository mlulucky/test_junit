package profiletest_05;

import org.junit.Before;
import org.junit.Test;
import profile.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 🐬 테스트마다 공통된 코드를 제거하자 -> 테스트코드 리팩토링
// ProfileTest 클래스의 모든 테스트코드에 포함되어 있는 공통 코드 -> 초기화 (@Before)
// Junit 테스트 실행할 때마다 @Before 메서드를 먼저 실행한다. 예) 테스트에서 공통으로 사용하는 객체 -> 초기화
public class ProfileTest {
  /**
   *   테스트 작성시 코드가 어떻게 동작하는지 깊게 이해하고 실질적인 테스트로 점점 만들어 가야 한다.
   *   profile.matches(criteria)
   *   Profile 클래스의 matches 메서드 테스트위하여 - 의도하는대로 동작하는지 검증
   *   Profile 인스턴스, Criteria 객체 필요
   *   Criteria 안에는 Criterion 이 있어야 함
   *   Criterion 에는 getAnswer(Answer 타입), getWeight 이 있다.
   *   Answer 객체 필요 -> 질문(question)과 답변(true/false)을 가지고 있다.
   *   Question 객체 필요 -> 질문번호와 질문내용을 가지고 있다.
   *   Profile 클래스의 answer 에 Answer 객체가 담아져 있어야 한다.
   *   테스트 메서드명은 테스트 의도를 담을 수 있는 이름이어야 한다.
   *   코드 실행 및 단언단계 추가
   */

  private Profile profile;
  private Question question;
  private Criteria criteria;

  // 각 테스트메서드 실행마다 각각 실행된다. // 총 테스트 메서드 n개 -> @Before n번 실행 // 모든 테스트가 독립적이다.
  // junit 테스트는 독립적이다 (의존적 x) -> 만약 의존적이라면, 테스트 실패시 어떤 의존성때문에 실패인지를 알기 어렵다.
  @Before
  public void setUp() {
    profile = new Profile("John Doe");
    question = new BooleanQuestion(1, "보너스를 받았나?");
    criteria = new Criteria();
    System.out.println("setUp 초기화 실행");
  }

  @Test
  public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
    System.out.println("matchAnswersFalseWhenMustMatchCriteriaNotMet 실행");
    // 구직자의 답변
    Answer profileAnswer = new Answer(question, Boolean.FALSE);
    profile.add(profileAnswer);

    // 기준 답변
    Answer criteriaAnswer = new Answer(question, Boolean.TRUE); // 기준에 맞는 답변 - 질문, 기대하는 정답(참)
    Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch); // 기준 - 답변, 중요성
    criteria.add(criterion);

    // 테스트 코드 실행 및 결과 단언 // profile.matches()
    boolean isMatch = profile.matches(criteria);
    // 예상되는 결과 단언 // isMatch 는 false 와 같을 것
    assertFalse(isMatch);

  }

  // 두번째 테스트 코드
  // 가중치가 DonCare 일때, 매칭 true 반환하는지
  @Test
  public void matchAnswersTrueForAnyDontCareCriteria() {
    System.out.println("matchAnswersTrueForAnyDontCareCriteria 실행");
    // 구직자의 답변
    Answer profileAnswer = new Answer(question, Boolean.FALSE);
    profile.add(profileAnswer);

    // 기준 답변
    Answer criteriaAnswer = new Answer(question, Boolean.TRUE); // 기준에 맞는 답변 - 질문, 기대하는 정답(참)
    Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare); // 기준 - 답변, 중요성
    criteria.add(criterion);

    // 테스트 코드 실행 및 결과 단언 // profile.matches()
    boolean isMatch = profile.matches(criteria);
    // 예상되는 결과 단언 // isMatch 는 false 와 같을 것
    assertTrue(isMatch);

  }



}