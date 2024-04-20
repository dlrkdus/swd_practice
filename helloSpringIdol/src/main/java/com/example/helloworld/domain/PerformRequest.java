package com.example.helloworld.domain;

public class PerformRequest {
    private String id;
    private String requester;

    public PerformRequest() {}

    public PerformRequest(String name, String requester) {
        this.id = name;
        this.requester = requester;
    }
    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }
}
