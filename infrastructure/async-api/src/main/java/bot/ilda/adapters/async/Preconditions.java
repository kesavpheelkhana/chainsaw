package bot.ilda.adapters.async;

class Preconditions {

  private Preconditions() {}

  public static void checkArgument(boolean expression, String errorMessage) {
    if (!expression) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public static <T> T checkArgument(T nonNullable, String errorMessage) {
    if (nonNullable == null) {
      throw new IllegalArgumentException(errorMessage);
    }
    return nonNullable;
  }
}
