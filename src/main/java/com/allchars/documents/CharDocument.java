package com.allchars.documents;

import com.allchars.interfaces.json.Chars;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chars")
public class CharDocument {

  @Id
  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId _id;

  private String charName;
  private byte[] charImage;

  public CharDocument(byte[] compressZLib) {
  }


  public Chars toChars(){
    return Chars.builder()
        .charImage(this.charImage)
        .build();
  }

}
