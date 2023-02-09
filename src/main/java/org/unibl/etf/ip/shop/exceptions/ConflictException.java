package org.unibl.etf.ip.shop.exceptions;

import org.springframework.http.HttpStatus;

// Statusni kod 409
public class ConflictException extends HttpException {

    public ConflictException() {
        super(HttpStatus.CONFLICT, null);
    }

    public ConflictException(Object data) {
        super(HttpStatus.CONFLICT, data);
    }
}
