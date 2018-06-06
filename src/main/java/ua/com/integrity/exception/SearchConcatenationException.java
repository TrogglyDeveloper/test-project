package ua.com.integrity.exception;

public class SearchConcatenationException extends RuntimeException {
    public SearchConcatenationException() {
        super();
    }

    public SearchConcatenationException(String message) {
        super(message);
    }

    public SearchConcatenationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchConcatenationException(Throwable cause) {
        super(cause);
    }

    protected SearchConcatenationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
