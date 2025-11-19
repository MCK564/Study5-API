package com.mck.study5.upload_service.kafka.events;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MediaOwnerType {
    USER("USER"),
    PRODUCT("PRODUCT"),
    COURSE("COURSE"),
    LESSON("LESSON"),
    BLOG("BLOG"),
    FLASHCARD("FLASHCARD"),
    QUESTION("QUESTION"),
    WORD("WORD"),
    EXAM("EXAM");

    private String type;
    MediaOwnerType(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @JsonCreator
    public static MediaOwnerType fromString(String type) {
        if(type == null) return null;
        return MediaOwnerType.valueOf(type.toUpperCase());
    }
}
