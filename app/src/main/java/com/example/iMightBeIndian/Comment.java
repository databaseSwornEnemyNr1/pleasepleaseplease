package com.example.iMightBeIndian.PongOnParticlePhoton;


public class Comment {

    private long mId;
    private String mComment;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    @Override
    public String toString() {
        return   mComment ;
    }
}
