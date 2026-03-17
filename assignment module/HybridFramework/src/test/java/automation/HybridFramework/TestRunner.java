package automation.HybridFramework;

public class TestRunner {

    public static void main(String[] args) {

        KeywordEngine engine = new KeywordEngine();

        try {
            engine.startExecution();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}