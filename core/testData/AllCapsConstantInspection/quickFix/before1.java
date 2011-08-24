// "Capitalize Constant Name" "true"
class Test {
    private static final String ALL_CAPS_CONSTANT = "";
    <caret>private static final String non_ALL_CAPS_CONSTANT = "";

    public Test() {

    }

    public void foo(final String bar, String reBar) {

    }

    public String bar(String foo, String fuey) {
        final String bat = "bar";

        return bat;
    }
}