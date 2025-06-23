package dev.patika.veterinary_management_system.exception;

public class DuplicateVaccineException extends RuntimeException {
    public DuplicateVaccineException(String message) {
        super(message);
    }
}

