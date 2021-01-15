package com.allchars.services;

import com.allchars.domain.CharDomain;
import com.allchars.interfaces.json.Chars;
import com.allchars.interfaces.json.CharsPost;
import java.io.IOException;

public interface CharService {

  Chars postChar(CharsPost charsPost) throws IOException;

}
