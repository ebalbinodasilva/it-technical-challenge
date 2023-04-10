package com.challenge.voting.exception;

public class PollingSessionNotFoundException extends RuntimeException {

    public PollingSessionNotFoundException(Long id) {
        super("Polling session not found with id: " + id);
    }
}