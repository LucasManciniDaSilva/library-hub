package com.allchars.interfaces.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface BaseController {

  long ACCEPT_RANGE = 50;

  default ResponseEntity<Void> created(String id) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .header("id", id)
        .build();
  }

  default ResponseEntity<Void> accepted(String headerName, Object headerValue) {
    String headerStr;
    if (headerValue instanceof String) {
      headerStr = (String) headerValue;
    } else {
      headerStr = String.valueOf(headerValue);
    }
    return ResponseEntity.status(HttpStatus.ACCEPTED).header(headerName, headerStr).build();
  }

  default ResponseEntity<Void> created() {
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  default <T> ResponseEntity<T> ok(T body) {
    return ResponseEntity.ok(body);
  }

    default <T> ResponseEntity<List<T>> partialContent(Page<T> page, long acceptRange) {
    return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
        .header("content-range", String.valueOf(page.getTotalElements()))
        .header("content-pages", String.valueOf(page.getTotalPages()))
        .header("accept-range", String.valueOf(acceptRange))
        .body(page.getContent());
  }

  default ResponseEntity<Void> noContent() {
    return ResponseEntity.noContent().build();
  }
}
