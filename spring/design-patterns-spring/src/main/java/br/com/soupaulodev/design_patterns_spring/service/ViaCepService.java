package br.com.soupaulodev.design_patterns_spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.soupaulodev.design_patterns_spring.model.Adress;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json")
    Adress getAddressByCep(@PathVariable("cep") String cep);
}
