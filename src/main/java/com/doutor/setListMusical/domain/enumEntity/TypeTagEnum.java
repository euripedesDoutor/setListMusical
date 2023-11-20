package com.doutor.setListMusical.domain.enumEntity;

public enum TypeTagEnum {
   MUSIC, SETLIST, EVENT;

   public static TypeTagEnum toTypeTag(String typeTag){
      if(typeTag.equals("MUSIC")) return MUSIC;
      if(typeTag.equals("SETLIST")) return SETLIST;
      if(typeTag.equals("EVENT")) return EVENT; else return MUSIC;
   }
}
