package service.impl;

import service.PrinterService;
import service.TextProvider;
import service.TextService;

import java.io.IOException;

import static utils.LoggerUtils.printl;
import static utils.TextUtils.getMapChar;

public class TextServiceImpl implements TextService {
    private final TextProvider textProvider;
    private final PrinterService printerService;

    @Override
    public void count() throws MyException {
        var text = getText();
        var map = getMapChar(text);
        printerService.printAverageMap(map,text);
    }

    public TextServiceImpl(TextProvider textProvider, PrinterService printerService) {
        this.textProvider = textProvider;
        this.printerService = printerService;
    }

    private String getText() throws MyException {
        try {
            String readyUrl = textProvider.getContent();

            if (readyUrl.equals("http://numbersapi.com//trivia")) {
                throw new MyException("Exception: url не работает!");
            }

            return readyUrl;
        } catch (IOException e) {
            printl("При получение текста произошла ошикба !");
            throw new RuntimeException();
        }
    }
}
