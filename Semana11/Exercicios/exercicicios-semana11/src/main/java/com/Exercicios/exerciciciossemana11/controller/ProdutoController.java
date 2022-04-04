package com.Exercicios.exerciciciossemana11.controller;

import com.Exercicios.exerciciciossemana11.controller.dto.ProdutoFormDTO;
import com.Exercicios.exerciciciossemana11.model.Produto;
import com.Exercicios.exerciciciossemana11.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoService produtoService;


    @GetMapping
    public ModelAndView index(Model model) {
        List<Produto> produtos = produtoService.findAll();
        ModelAndView mv = new ModelAndView("produtos/todos");
        model.addAttribute("produtos", produtos);
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novo(ProdutoFormDTO produtoFormDTO) {
        return new ModelAndView("produtos/novo");
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id, ProdutoFormDTO produtoFormDTO) {
        Optional<Produto> produto = this.produtoService.findById(id);
        if (produto.isEmpty()) {
            return new ModelAndView("redirect:/produtos");
        }
        Long idProduto = produto.get().getId();

        produtoFormDTO.fromProduto(produto.get());
        ModelAndView mv = new ModelAndView("produtos/edit");
        mv.addObject(produtoFormDTO);
        mv.addObject("produtoId", idProduto);
        return mv;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        Optional<Produto> produto = this.produtoService.findById(id);
        if (produto.isEmpty()) {
            return "redirect:/produtos";
        }

        this.produtoService.deleteById(id);
        return "redirect:/produtos";
    }

    @PostMapping()
    public String create(@Valid ProdutoFormDTO produtoFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "produtos/novo";
        }
        this.produtoService.adiciona(produtoFormDTO.toProduto());
        return "redirect:/produtos";
    }


    @PostMapping("/{id}")
    public String update(@Valid ProdutoFormDTO produtoFormDTO, @PathVariable Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "produtos/edit";
        }
        Optional<Produto> produto = this.produtoService.findById(id);
        if (produto.isEmpty()) {
            return "redirect:/produtos";
        }
        this.produtoService.update(id, produtoFormDTO.toProduto());
        return "redirect:/produtos";
    }


}
