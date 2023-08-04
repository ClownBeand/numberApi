package properties;

public class Properties {
    private String url = "http://numbersapi.com/%s/trivia";
    private int maxNumber = 100500;
    private int minNumber = 0;
    public String getUrl() {
        return url;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMinNumber() {
        return minNumber;
    }
}
