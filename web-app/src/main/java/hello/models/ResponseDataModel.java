package hello.models;

/**
 * Created by silvian on 21/12/14.
 */
public class ResponseDataModel {

    private boolean isSuccessful;
    private String responseMessage;

    public ResponseDataModel() {

    }

    public ResponseDataModel(boolean isSuccessful, String responseMessage) {
        this.isSuccessful = isSuccessful;
        this.responseMessage = responseMessage;
    }


    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
