import full.TextProvider;
import full.TextService;

import full.impl.ApiNumberRandom;
import full.impl.MyException;
import full.impl.PrintMapAndService;
import full.impl.TextServiceImpl;

import properties.Properties;

public class Main {
    public static void main(String[] args) throws MyException {
        TextProvider textProvider = new ApiNumberRandom(new Properties());
        TextService textService = new TextServiceImpl(textProvider, new PrintMapAndService());
        textService.count();

    }
}
