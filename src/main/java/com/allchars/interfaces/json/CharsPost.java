package com.allchars.interfaces.json;

import com.allchars.documents.CharDocument;
import com.allchars.domain.CharDomain;
import java.io.IOException;
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
public class CharsPost {

  @NotNull private Long idChar;

  @NotNull private String charName;

  @NotNull private String origin;

  @NotNull private Integer height;

  private String weapon;

  private String armor;

  private String personality;

  @NotNull private String characterImportance;

  @NotNull private MultipartFile charImage;

  public CharDocument toCharDocument() throws IOException {
    return CharDocument.builder().charImage(this.charImage.getBytes()).charName(this.charName).build();
  }

  public CharDomain toCharDomain() {
    return CharDomain.builder()
        .idChar(this.idChar)
        .charName(this.charName)
        .origin(this.origin)
        .height(this.height)
        .weapon(this.weapon)
        .armor(this.armor)
        .personality(this.personality)
        .characterImportance(this.characterImportance)
        .build();
  }
}
