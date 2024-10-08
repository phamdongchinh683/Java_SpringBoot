package com.springboot.backend.exception;

public enum ErrorCode {
        INVALID_KEY(400, "Invalid key"),
        USER_EXISTED(400, "User existed"),
        UNCATEGORIZED_EXCEPTION(500, "Uncategorized exception"),
        USERNAME_INVALID(400, "username must be at least 6 characters"),
        INVALID_PASSWORD(400, "username must be at least 10 characters\""),
        USER_NOT_EXISTED(1005, "User not existed"),
        UNAUTHENTICATED(1006, "Unauthenticated"),
        UNAUTHORIZED(1007, "You do not have permission"),
        INVALID_DOB(1008, "Your age must be at least {min}"),
        ;

        private final int code;
        private final String message;

        private ErrorCode(int code, String message) {
                this.code = code;
                this.message = message;
        }

        public int getCode() {
                return code;
        }

        public String getMessage() {
                return message;
        }
}
