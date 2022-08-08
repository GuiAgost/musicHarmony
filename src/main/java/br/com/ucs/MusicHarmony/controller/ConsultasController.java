package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("consultas")
public class ConsultasController {

    @GetMapping("triade")
    public String triade(){
        return "consultas/triade";
    }

    @GetMapping("tetrade")
    public String tetrade(){
        return "consultas/tetrade";
    }

    @GetMapping("transposicao")
    public String transposicao(){
        return "consultas/transposicao";
    }

    @GetMapping("acordes")
    public String acordes(){
        return "consultas/acordes";
    }
}
