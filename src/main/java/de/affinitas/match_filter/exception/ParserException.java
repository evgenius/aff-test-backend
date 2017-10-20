package de.affinitas.match_filter.exception;

public class ParserException extends Exception {
    public ParserException(Exception ex) {
        super(ex);
    }

    public ParserException(String message) {
        super(message);
    }
}
