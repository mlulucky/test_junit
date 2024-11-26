package profile;

import java.util.HashMap;
import java.util.Map;

// 구인 - 프로필정보
public class Profile {
  // 구직자에게 물어볼 질문,  답변모음 (질문-답변)
  private Map<String, Answer> answers = new HashMap<>();

  // 점수
  private int score;
  // 이름
  private String name;

  // 생성자
  public Profile(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  // 답변을 전달받아, 답변모음에 저장(질문 - 대답)
  public void add(Answer answer) {
    answers.put(answer.getQuestionText(), answer);
  }

  // 기준에 적합한치 매칭 // criteria: 기준
  // 🐬 profile.matches() 테스트코드 유추
  // Profile 인스턴스 필요. matches 메서드로 전달받을 Criteria 객체 필요
  public boolean matches(Criteria criteria) {
    score = 0;
    boolean kill = false;
    boolean anyMatches = false;
    // 클래스가 자체적으로 for-each 반복문에서 사용되려면 Iterable 인터페이스를 구현해야한다.
    for (Criterion criterion : criteria) { // criteria = List<Criterion>
      // 기준의 대답의 질문값을 가져옴 == 질문
      // 🐬 테스트코드 유추
      // answers.get -> Profiles answers = new HashMap<>(); 에 값이 넣어져 있어야 한다.
      // criterion.getAnswer -> criterion 에도 answer 가 저장되어 있어야 한다.
      Answer answer = answers.get(criterion.getAnswer().getQuestionText());

      // 매칭 true: 기준의 중요도가 없거나, 매칭의 답변과 일치할때
      boolean match = criterion.getWeight() == Weight.DonCare || answer.match(criterion.getAnswer());

      // 매칭이 false 이고 기준의 중요도가 높은경우 -> matches은 false 반환
      if (!match && criterion.getWeight() == Weight.MustMatch) {
        kill = true;
      }
      // 매칭이 true 인 경우
      if (match) {
        score += criterion.getWeight().getValue();
      }

      anyMatches |= match; // anyMatches = anyMatches | match
    }
    if (kill) {
      return false;
    }

    return anyMatches;
  }

  public int getScore() {
    return score;
  }


}
