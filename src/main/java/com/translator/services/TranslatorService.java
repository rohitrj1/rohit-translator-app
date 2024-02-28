package com.translator.services;


import com.darkprograms.speech.translator.GoogleTranslate;
import com.translator.Exception.TransaltorException;
import com.translator.model.RequestTxt;
import com.translator.model.ResponseTranslate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Pattern;

@Service
@Slf4j
public class TranslatorService {

    public ResponseTranslate translateEngToFrench(RequestTxt request) throws Exception {
        if (request == null || request.getText() == null || request.getText().isEmpty()) {
            throw new TransaltorException("Input text cannot be null or empty.");
        }
        if (containsNumbers(request.getText())) {
           throw new TransaltorException("Input text contain number.give suitable input");
        }
        try {
            String trnsltr = GoogleTranslate.translate("fr", request.getText());
            return new ResponseTranslate(trnsltr);
        } catch (IOException e) {
            throw new TransaltorException("Error occurred during translation: " + e.getMessage());
        }
    }


    private boolean containsNumbers(String text) {
        // Regular expression to check for presence of at least one digit
        Pattern pattern = Pattern.compile(".*\\d.*");
        return pattern.matcher(text).find();
    }

}
