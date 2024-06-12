package com.test.textFileUpload;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getData")
@RequiredArgsConstructor
public class CardAccountBasicInfoController {

    private final CardCastomerBasicInfoService cardCastomerBasicInfoService;

    @GetMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public String getCardData(){
        cardCastomerBasicInfoService.getTextFileData();

        return "Success";
    }

}
