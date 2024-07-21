package backoffice_server.backoffice_server.lecture.entity;

import lombok.Getter;

@Getter
public enum LectureCategory {
    SPRING("Spring"),
    REACT("React"),
    NODE("Node");

    private final String categoryName;

    LectureCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public static LectureCategory convertStringToCategory(String category) {
        switch (category.toLowerCase()) {
            case "spring":
                return SPRING;
            case "react":
                return REACT;
            case "node":
                return NODE;
            default:
                throw new IllegalArgumentException(category + "는 존재하지 않는 카테고리입니다.");
        }
    }
}