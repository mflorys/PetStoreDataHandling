package org.example.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    @Getter
    private static class Category {
        private long id;
        private String name;
    }

    @Getter
    private static class Tag {
        private long id;
        private String name;
    }

    @Override
    public String toString() {
        return String.format("\n{id=%d, name=%s}", id, name);
    }
}
