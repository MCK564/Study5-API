package com.mck.study5.user_service.kafka.events;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MediaKind {
    IMAGE("IMAGE"),
    AUDIO("AUDIO"),
    VIDEO("VIDEO");

    private String kind;

    MediaKind(String kind){
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonCreator
    public static MediaKind fromString(String kind) {
        if(kind == null) return null;
        return MediaKind.valueOf(kind.toUpperCase());
    }
}
