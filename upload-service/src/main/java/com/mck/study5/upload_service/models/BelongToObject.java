package com.mck.study5.upload_service.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BelongToObject {
    USER_AVATAR("USER_AVATAR"),
    USER_BANNER("USER_BANNER"),
    PRODUCT_AVATAR("PRODUCT_AVATAR"),
    BLOG_IMAGE("BLOG_IMAGE"),
    QUESTION_IMAGE("QUESTION_IMAGE"),
QUESTION_AUDIO("QUESTION_AUDIO"),
    EXAM_IMAGE("EXAM_IMAGE"),
    WORD_IMAGE("WORD_IMAGE"),
    WORD_AUDIO("WORD_AUDIO"),
    FLASHCARD_IMAGE("FLASHCARD_IMAGE"),;

    private String value;

    BelongToObject(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

    @JsonCreator
    public static BelongToObject fromString(String value) {
        if(value == null) return null;
        return BelongToObject.valueOf(value.toUpperCase());
    }
}
