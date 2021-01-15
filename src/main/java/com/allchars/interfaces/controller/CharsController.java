package com.allchars.interfaces.controller;

import com.allchars.domain.CharDomain;
import com.allchars.interfaces.json.Chars;
import com.allchars.interfaces.json.CharsPost;
import com.allchars.services.CharService;
import java.io.IOException;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chars")
@AllArgsConstructor
@Validated
public class CharsController implements BaseController {

 private CharService charService;

  @PostMapping
  public ResponseEntity<Chars> PostChar(@RequestBody @Valid CharsPost charsPost) throws IOException {

    final Chars charResponse = this.charService.postChar(charsPost);


    return ResponseEntity.status(HttpStatus.CREATED).body(charResponse);
  }

}
