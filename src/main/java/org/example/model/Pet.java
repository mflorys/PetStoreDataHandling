package org.example.service;

import java.util.List;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<PhotoUrl> photoUrls;
    private List<Tag> tags;
    private Status status;

    private class Category {
        private long id;
        private String name;
    }

    private class PhotoUrl {
        private String url;
    }

    private class Tag {
        private long id;
        private String name;
    }
}
