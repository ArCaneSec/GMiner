package gminer;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;

//Burp will auto-detect and load any class that extends BurpExtension.
public class Main implements BurpExtension
{

    @Override
    public void initialize(MontoyaApi api)
    {
        api.extension().setName("GMiner");

        Logging logging = api.logging();

        logging.logToOutput("test output.");

        Handler myHandler = new Handler(logging);
        api.http().registerHttpHandler(myHandler);

    }
}