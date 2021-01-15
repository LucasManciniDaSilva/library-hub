package com.allchars.exceptions;

import com.allchars.exceptions.MessageError.ApiError;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class PreconditionFailedException extends RuntimeException {

  private static final long serialVersionUID = -5398092778833864393L;

  private final List<ApiError> errors;

  public PreconditionFailedException(ApiError error, List<ApiError> errors) {
    this(Lists.newArrayList(error));
  }

  public PreconditionFailedException(List<ApiError> errors) {
    super(errors.toString());
    this.errors = errors;
  }

  public PreconditionFailedException(ApiError error, String detail) {
    super(String.format("%s - Detail: %s", error.toString(), detail));
    this.errors = Lists.newArrayList(error);
  }

}
