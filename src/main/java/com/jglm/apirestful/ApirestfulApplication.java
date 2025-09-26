package com.jglm.apirestful;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jglm.apirestful.model.Categoria;
import com.jglm.apirestful.model.Produto;
import com.jglm.apirestful.repository.CategoriaRepository;
import com.jglm.apirestful.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@SpringBootApplication
public class ApirestfulApplication implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    // public ApirestfulApplication(ProdutoRepository produtoRepository,
    // CategoriaRepository categoriaRepository) {
    // this.produtoRepository = produtoRepository;
    // this.categoriaRepository = categoriaRepository;
    // }

    public static void main(String[] args) {
        SpringApplication.run(ApirestfulApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria fruta = new Categoria("Fruta", "fruta");
        categoriaRepository.save(fruta);

        Categoria legume = new Categoria("Legume", "legume");
        categoriaRepository.save(legume);

        Categoria verdura = new Categoria("Verdura", "verdura");
        categoriaRepository.save(verdura);

        Produto produto = new Produto(
                "abacate.png",
                "Abacate",
                "abacate",
                "1 unidade aprox. 750g",
                true,
                100,
                BigDecimal.valueOf(2.45),
                LocalDate.of(2023, 4, 26),
                fruta);
        produtoRepository.save(produto);

        produto = new Produto(
                "abobrinha.png",
                "Abobrinha",
                "abobrinha",
                "1 unidade aprox. 250g",
                false,
                500,
                BigDecimal.valueOf(1.1),
                LocalDate.of(2023, 5, 22),
                legume);
        produtoRepository.save(produto);

        produto = new Produto(
                "abobora.png",
                "Abóbora",
                "abobora",
                "1 unidade aprox. 1,9kg",
                true,
                400,
                BigDecimal.valueOf(4.7),
                LocalDate.of(2023, 3, 24),
                legume);
        produtoRepository.save(produto);

        produto = new Produto(
                "acelga.png",
                "Acelga",
                "acelga",
                "1 maço de aprox. 400g",
                true,
                120,
                BigDecimal.valueOf(4.99),
                LocalDate.of(2023, 3, 12),
                verdura);
        produtoRepository.save(produto);

        produto = new Produto(
                "agriao.png",
                "Agrião",
                "agriao",
                "1 maço de aprox. 200g",
                true,
                340,
                BigDecimal.valueOf(2.5),
                LocalDate.of(2023, 5, 17),
                verdura);
        produtoRepository.save(produto);

        produto = new Produto(
                "alface.png",
                "Alface",
                "alface",
                "1 maço de aprox. 200g",
                true,
                220,
                BigDecimal.valueOf(4.99),
                LocalDate.of(2023, 5, 14),
                verdura);
        produtoRepository.save(produto);

        produto = new Produto(
                "banana.png",
                "Banana",
                "banana",
                "1 unidade aprox. 165g",
                true,
                350,
                BigDecimal.valueOf(1.05),
                LocalDate.of(2023, 2, 22),
                fruta);
        produtoRepository.save(produto);

        produto = new Produto(
                "beringela.png",
                "Beringela",
                "beringela",
                "1 unidade aprox. 370g",
                true,
                720,
                BigDecimal.valueOf(1.85),
                LocalDate.of(2023, 2, 23),
                legume);
        produtoRepository.save(produto);

        produto = new Produto(
                "brocolis.png",
                "Brócolis",
                "brocolis",
                "1 unidade aprox. 300g",
                true,
                600,
                BigDecimal.valueOf(5.39),
                LocalDate.of(2023, 3, 28),
                verdura);
        produtoRepository.save(produto);

        produto = new Produto(
                "cebola.png",
                "Cebola",
                "cebola",
                "1 unidade aprox. 200g",
                true,
                95,
                BigDecimal.valueOf(0.56),
                LocalDate.of(2023, 4, 30),
                legume);
        produtoRepository.save(produto);

        produto = new Produto(
                "cenoura.png",
                "Cenoura",
                "cenoura",
                "1 unidade aprox. 180g",
                true,
                350,
                BigDecimal.valueOf(1.01),
                LocalDate.of(2023, 5, 29),
                legume);
        produtoRepository.save(produto);

        produto = new Produto(
                "cereja.png",
                "Cereja",
                "cereja",
                "1 unidade aprox. 250g",
                true,
                240,
                BigDecimal.valueOf(11.23),
                LocalDate.of(2023, 5, 11),
                fruta);
        produtoRepository.save(produto);
    }
}
