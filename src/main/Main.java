import service.TextProvider;
import service.TextService;

import service.impl.ApiNumberImpl;
import service.impl.MyException;
import service.impl.PrinterServiceImpl;
import service.impl.TextServiceImpl;

import properties.Properties;

public class Main {
    public static void main(String[] args) throws MyException {
        TextProvider textProvider = new ApiNumberImpl(new Properties());
        TextService textService = new TextServiceImpl(textProvider, new PrinterServiceImpl());
        textService.count();

    }
}
