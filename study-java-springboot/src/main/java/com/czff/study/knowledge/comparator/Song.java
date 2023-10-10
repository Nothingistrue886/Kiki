package com.czff.mydemo.knowledge.comparator;

/**
 * @author cuidi
 * @date 2020/9/5 12:44
 * @description
 */
public class Song {
    private String title;
    private String authot;
    private Integer version;

    public Song() {
    }

    public Song(String title, String authot, Integer version) {
        this.title = title;
        this.authot = authot;
        this.version = version;
    }

    public String getAuthot() {
        return authot;
    }

    public void setAuthot(String authot) {
        this.authot = authot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", authot='" + authot + '\'' +
                ", version=" + version +
                '}';
    }
}
