package com.netcracker.taskOOP1.enterprise;

public enum Gender {
    MALE, FEMALE, UNKNOWN;

    private static final Gender[] VAL = values();

    public String nameLowerCase() {
        return name().toLowerCase();
    }

    public static Gender setGender(String gender) {
        char detectGender = gender.toLowerCase().charAt(0);

        return switch (detectGender) {
            case 'm' -> MALE;
            case 'f' -> FEMALE;
            default -> UNKNOWN;
        };
    }
}
