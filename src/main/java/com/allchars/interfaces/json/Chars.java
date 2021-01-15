package com.allchars.interfaces.json;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chars {

  private Long idChar;

  private String charName;

  private String origin;

  private Integer height;

  private String weapon;

  private String armor;

  private String personality;

  private String characterImportance;

  private byte[] charImage;
}
