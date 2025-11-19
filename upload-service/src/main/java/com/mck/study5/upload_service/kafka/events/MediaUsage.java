package com.mck.study5.upload_service.kafka.events;

import com.fasterxml.jackson.annotation.JsonCreator;

public  enum MediaUsage {
    AVATAR("AVATAR"),
    BANNER("BANNER"),
    THUMBNAIL("THUMBNAIL"),
    CONTENT("CONTENT"),
    OPTION("OPTION"),
    EXPLANATION("EXPLANATION");

    private String usage;
    MediaUsage(String usage){
        this.usage = usage;
    }
    public String getUsage() {
        return usage;
    }
    public void setUsage(String usage) {
        this.usage = usage;
    }
    @JsonCreator
    public static MediaUsage fromString(String usage) {
        if(usage == null) return null;
        return MediaUsage.valueOf(usage.toUpperCase());
    }
}
