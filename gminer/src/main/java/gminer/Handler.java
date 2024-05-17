package gminer;

import java.util.HashSet;

import burp.api.montoya.http.handler.HttpHandler;
import burp.api.montoya.http.handler.HttpRequestToBeSent;
import burp.api.montoya.http.handler.HttpResponseReceived;
import burp.api.montoya.http.handler.RequestToBeSentAction;
import burp.api.montoya.http.handler.ResponseReceivedAction;
import burp.api.montoya.http.message.params.HttpParameterType;
import burp.api.montoya.http.message.params.ParsedHttpParameter;
import burp.api.montoya.logging.Logging;

public class Handler implements HttpHandler {
    private Logging logger;
    private HashSet<String> allParams;

    public Handler(Logging logger) {
        this.logger = logger;
    }

    @Override
    public RequestToBeSentAction handleHttpRequestToBeSent(HttpRequestToBeSent req) {
        if (!req.isInScope()) {
            return null;
        }

        for (ParsedHttpParameter param : req.parameters(HttpParameterType.URL)) {
            this.allParams.add(param.name());
        }

        for (ParsedHttpParameter param : req.parameters(HttpParameterType.BODY)) {
            this.allParams.add(param.name());
        }

        for (ParsedHttpParameter param : req.parameters(HttpParameterType.JSON)) {
            this.allParams.add(param.name());
        }

        return null;
    }

    @Override
    public ResponseReceivedAction handleHttpResponseReceived(HttpResponseReceived res) {
        return null;

    }

}
