public class TextEditor {

    public static void main(String[] args) {

        SpellChecker obj1 = SpellChecker.getInstance();
        SpellChecker obj2 = SpellChecker.getInstance();
;
        System.out.println(obj1.hashCode());
        System.out.println((obj2.hashCode()));
   }
}
