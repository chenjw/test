package emailspider.model;

public class ConnectResult {
    private boolean isSuccess;
    private String errorCode;
    private String errorMessage;
    private EmailConnection connection;
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public EmailConnection getConnection() {
        return connection;
    }
    public void setConnection(EmailConnection connection) {
        this.connection = connection;
    }
    
    
}
