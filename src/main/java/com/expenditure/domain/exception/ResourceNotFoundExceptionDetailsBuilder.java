package com.expenditure.domain.exception;

public final class ResourceNotFoundExceptionDetailsBuilder {
    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;

    private ResourceNotFoundExceptionDetailsBuilder() {
    }

    public static ResourceNotFoundExceptionDetailsBuilder aResourceNotFoundExceptionDetails() {
        return new ResourceNotFoundExceptionDetailsBuilder();
    }

    public ResourceNotFoundExceptionDetailsBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ResourceNotFoundExceptionDetailsBuilder status(int status) {
        this.status = status;
        return this;
    }

    public ResourceNotFoundExceptionDetailsBuilder detail(String detail) {
        this.detail = detail;
        return this;
    }

    public ResourceNotFoundExceptionDetailsBuilder timeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public ResourceNotFoundExceptionDetailsBuilder developerMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public ResourceNotFoundExceptionDetails build() {
        ResourceNotFoundExceptionDetails resourceNotFoundExceptionDetails = new ResourceNotFoundExceptionDetails();
        resourceNotFoundExceptionDetails.setTitle(title);
        resourceNotFoundExceptionDetails.setStatus(status);
        resourceNotFoundExceptionDetails.setDetail(detail);
        resourceNotFoundExceptionDetails.setTimeStamp(timeStamp);
        resourceNotFoundExceptionDetails.setDeveloperMessage(developerMessage);
        return resourceNotFoundExceptionDetails;
    }
}
