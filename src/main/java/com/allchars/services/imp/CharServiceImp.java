package com.allchars.services.imp;

import com.allchars.documents.CharDocument;
import com.allchars.domain.CharDomain;
import com.allchars.exceptions.MessageError;
import com.allchars.exceptions.UnprocessableEntityException;
import com.allchars.interfaces.Messages;
import com.allchars.interfaces.json.Chars;
import com.allchars.interfaces.json.CharsPost;
import com.allchars.repository.CharRepositoryJpa;
import com.allchars.repository.CharRepositoryMongo;
import com.allchars.services.CharService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class CharServiceImp implements CharService {

  private final CharRepositoryMongo charRepositoryMongo;
  private final CharRepositoryJpa charRepositoryJpa;
  private final MessageError messageError;

  public CharServiceImp(
      CharRepositoryMongo charRepositoryMongo,
      CharRepositoryJpa charRepositoryJpa,
      MessageError messageError) {
    this.charRepositoryMongo = charRepositoryMongo;
    this.charRepositoryJpa = charRepositoryJpa;
    this.messageError = messageError;
  }

  @Override
  public Chars postChar(CharsPost charsPost) throws IOException {

    verifyNameAndOrigin(charsPost.getCharName(), charsPost.getOrigin());
    charDocumentImage(charsPost.getCharImage());
    CharDomain charDomain = charsPost.toCharDomain();
    CharDocument charDocument = charsPost.toCharDocument();
    charRepositoryMongo.save(charDocument);
    charRepositoryJpa.save(charDomain);

    return charDocument.toChars();
  }

  private void charDocumentImage(MultipartFile file) throws IOException {

    CharDocument img;
    img = new CharDocument(compressZLib(file.getBytes()));
    charRepositoryMongo.save(img);
  }

  private static byte[] decompressZLib(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    try {
      while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
      }
      outputStream.close();
    } catch (DataFormatException | IOException e) {
      e.printStackTrace();
    }
    return outputStream.toByteArray();
  }

  private static byte[] compressZLib(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
      int count = deflater.deflate(buffer);
      outputStream.write(buffer, 0, count);
    }
    try {
      outputStream.close();
    } catch (IOException ignored) {
    }

    return outputStream.toByteArray();
  }

  private void verifyNameAndOrigin(String charName, String origin) {

    if (charRepositoryJpa.existsByCharNameAndOrigin(charName, origin)) {
      throw new UnprocessableEntityException(
          this.messageError.create(Messages.CHARACTER_ALREADY_EXISTS));
    }
  }
}
