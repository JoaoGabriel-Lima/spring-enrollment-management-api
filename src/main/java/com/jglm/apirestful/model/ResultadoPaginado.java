package com.jglm.apirestful.model;

import java.util.List;

public record ResultadoPaginado<T>(long totalDeItens, int totalDePagina, int paginaCorrente, List<T> itens) {
}
