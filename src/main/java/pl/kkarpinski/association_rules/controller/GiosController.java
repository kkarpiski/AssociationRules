package pl.kkarpinski.association_rules.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kkarpinski.association_rules.service.GiosService;

/**
 * Created by kkarp.
 */

@RestController
@RequiredArgsConstructor
public class GiosController {

    private final GiosService giosService;

    @GetMapping("/gios")
    public String getGios() throws JSONException {
        return giosService.getGiosData();
    }


}
