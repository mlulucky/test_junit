package profile;

public enum Weight {
  DonCare,
  MustMatch;

  // getWeight 구현
  public int getValue() {
    return switch (this) {
      case DonCare -> 0;
      case MustMatch -> 1;
    };
  }
}
