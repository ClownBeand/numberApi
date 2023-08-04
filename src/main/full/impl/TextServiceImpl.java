package full.impl;

import full.PrintLetterAndAverage;
import full.TextProvider;
import full.TextService;

import java.io.IOException;

import static utils.LoggerUtils.printl;
import static utils.TextUtils.getMapChar;

public class TextServiceImpl implements TextService {
    private TextProvider textProvider;
    private PrintLetterAndAverage printLetterAndAverage;

    @Override
    public void count() throws MyException {
        var text = getText();
        var map = getMapChar(text);
        printLetterAndAverage.printMapFull(map,text);
    }

    public TextServiceImpl(TextProvider textProvider, PrintLetterAndAverage printLetterAndAverage) {
        this.textProvider = textProvider;
        this.printLetterAndAverage = printLetterAndAverage;
    }

    private String getText() throws MyException {
        try {
            String readyUrl = textProvider.getContent();

            if (readyUrl == "http://numbersapi.com//trivia") {
                throw new MyException("Exceptio%sn: url не работает!");
            }

            return readyUrl;
        } catch (IOException e) {
            printl("При получение текста произошла ошикба !");
            throw new RuntimeException();
        }
    }
}
