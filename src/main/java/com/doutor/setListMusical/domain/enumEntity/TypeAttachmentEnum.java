package com.doutor.setListMusical.domain.enumEntity;

public enum TypeAttachmentEnum {
    PDF, VIDEO, IMAGE;

    public static TypeAttachmentEnum toTypeAttachment(String typeAttachment){
        if(typeAttachment.equals("PDF")) return PDF;
        if(typeAttachment.equals("VIDEO")) return VIDEO;
        if(typeAttachment.equals("IMAGE")) return IMAGE; else return IMAGE;
    }
}
