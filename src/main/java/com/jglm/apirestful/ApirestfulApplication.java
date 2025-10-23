package com.jglm.apirestful;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jglm.apirestful.model.Aluno;
import com.jglm.apirestful.model.Disciplina;
import com.jglm.apirestful.model.Professor;
import com.jglm.apirestful.model.Turma;
import com.jglm.apirestful.model.Inscricao;
import com.jglm.apirestful.repository.AlunoRepository;
import com.jglm.apirestful.repository.DisciplinaRepository;
import com.jglm.apirestful.repository.ProfessorRepository;
import com.jglm.apirestful.repository.TurmaRepository;
import com.jglm.apirestful.repository.InscricaoRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@SpringBootApplication
public class ApirestfulApplication implements CommandLineRunner {

        private final AlunoRepository alunoRepository;
        private final ProfessorRepository professorRepository;
        private final TurmaRepository turmaRepository;
        private final InscricaoRepository inscricaoRepository;
        private final DisciplinaRepository disciplinaRepository;

        // Construtor comentado removido para usar @RequiredArgsConstructor

        public static void main(String[] args) {
                SpringApplication.run(ApirestfulApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                // Criar disciplinas
                Disciplina disc1 = new Disciplina();
                disc1.setNome("Desenvolvimento Web");
                disc1.setCargaHoraria(60);
                disciplinaRepository.save(disc1);

                Disciplina disc2 = new Disciplina();
                disc2.setNome("Interação Humano-Computador");
                disc2.setCargaHoraria(60);
                disciplinaRepository.save(disc2);

                Disciplina disc3 = new Disciplina();
                disc3.setNome("Programação de Computadores II");
                disc3.setCargaHoraria(80);
                disciplinaRepository.save(disc3);

                Disciplina disc4 = new Disciplina();
                disc4.setNome("Estruturas de Dados");
                disc4.setCargaHoraria(80);
                disciplinaRepository.save(disc4);

                Disciplina disc5 = new Disciplina();
                disc5.setNome("Sistemas Operacionais");
                disc5.setCargaHoraria(60);
                disciplinaRepository.save(disc5);

                Disciplina disc6 = new Disciplina();
                disc6.setNome("Banco de Dados");
                disc6.setCargaHoraria(60);
                disciplinaRepository.save(disc6);

                Disciplina disc7 = new Disciplina();
                disc7.setNome("Engenharia de Software");
                disc7.setCargaHoraria(80);
                disciplinaRepository.save(disc7);

                Disciplina disc8 = new Disciplina();
                disc8.setNome("Redes de Computadores");
                disc8.setCargaHoraria(60);
                disciplinaRepository.save(disc8);

                // Criar professores
                Professor prof1 = new Professor();
                prof1.setNome("Carlos Alberto Soares Ribeiro");
                prof1.setEmail("casr@dcc.ic.uff.br");
                professorRepository.save(prof1);

                Professor prof2 = new Professor();
                prof2.setNome("Luciana Salgado");
                prof2.setEmail("luciana.salgado@ic.uff.br");
                professorRepository.save(prof2);

                Professor prof3 = new Professor();
                prof3.setNome("Lucia Maria de Assumpcao Drummond");
                prof3.setEmail("lucia.drummond@ic.uff.br");
                professorRepository.save(prof3);

                Professor prof4 = new Professor();
                prof4.setNome("Maria Cristina Boeres");
                prof4.setEmail("boeres@ic.uff.br");
                professorRepository.save(prof4);

                Professor prof5 = new Professor();
                prof5.setNome("Vinod Rebello");
                prof5.setEmail("vinod@ic.uff.br");
                professorRepository.save(prof5);

                Professor prof6 = new Professor();
                prof6.setNome("Simone Martins");
                prof6.setEmail("simone@ic.uff.br");
                professorRepository.save(prof6);

                Professor prof7 = new Professor();
                prof7.setNome("Isabel Rosseti");
                prof7.setEmail("isabel.rosseti@ic.uff.br");
                professorRepository.save(prof7);

                Professor prof8 = new Professor();
                prof8.setNome("Célio Neves");
                prof8.setEmail("celio.neves@ic.uff.br");
                professorRepository.save(prof8);

                // Criar alunos
                Aluno aluno1 = new Aluno();
                aluno1.setNome("João Gabriel Lima Marinho");
                aluno1.setEmail("jglimamarinh0@id.uff.br");
                alunoRepository.save(aluno1);

                Aluno aluno2 = new Aluno();
                aluno2.setNome("Rafael Amparo");
                aluno2.setEmail("rvamparo@id.uff.br");
                alunoRepository.save(aluno2);

                Aluno aluno3 = new Aluno();
                aluno3.setNome("David Kaio");
                aluno3.setEmail("davidkssantos@id.uff.br");
                alunoRepository.save(aluno3);

                Aluno aluno4 = new Aluno();
                aluno4.setNome("Thales Abranches");
                aluno4.setEmail("thales.abranches@id.uff.br");
                alunoRepository.save(aluno4);

                Aluno aluno5 = new Aluno();
                aluno5.setNome("Diogo Serafim");
                aluno5.setEmail("diogo.serafim@id.uff.br");
                alunoRepository.save(aluno5);

                Aluno aluno6 = new Aluno();
                aluno6.setNome("Ana Lívia Barata Ribeiro");
                aluno6.setEmail("analivia@id.uff.br");
                alunoRepository.save(aluno6);

                Aluno aluno7 = new Aluno();
                aluno7.setNome("Larissa Yumi Nakashima");
                aluno7.setEmail("larissa.nakashima@id.uff.br");
                alunoRepository.save(aluno7);

                Aluno aluno8 = new Aluno();
                aluno8.setNome("Luciano Andrade");
                aluno8.setEmail("luciano.andrade@id.uff.br");
                alunoRepository.save(aluno8);

                Aluno aluno9 = new Aluno();
                aluno9.setNome("Gabriel Panza");
                aluno9.setEmail("gabriel.panza@id.uff.br");
                alunoRepository.save(aluno9);

                Aluno aluno10 = new Aluno();
                aluno10.setNome("João Moraes");
                aluno10.setEmail("joao.moraes@id.uff.br");
                alunoRepository.save(aluno10);

                // Criar turmas
                Turma turma1 = new Turma();
                turma1.setAno("2024");
                turma1.setPeriodo("2024.1");
                turma1.setProfessor(prof1);
                turma1.setDisciplina(disc1);
                turmaRepository.save(turma1);

                Turma turma2 = new Turma();
                turma2.setAno("2024");
                turma2.setPeriodo("2024.1");
                turma2.setProfessor(prof2);
                turma2.setDisciplina(disc2);
                turmaRepository.save(turma2);

                Turma turma3 = new Turma();
                turma3.setAno("2024");
                turma3.setPeriodo("2024.2");
                turma3.setProfessor(prof3);
                turma3.setDisciplina(disc3);
                turmaRepository.save(turma3);

                Turma turma4 = new Turma();
                turma4.setAno("2024");
                turma4.setPeriodo("2024.2");
                turma4.setProfessor(prof4);
                turma4.setDisciplina(disc4);
                turmaRepository.save(turma4);

                Turma turma5 = new Turma();
                turma5.setAno("2024");
                turma5.setPeriodo("2024.2");
                turma5.setProfessor(prof5);
                turma5.setDisciplina(disc5);
                turmaRepository.save(turma5);

                Turma turma6 = new Turma();
                turma6.setAno("2025");
                turma6.setPeriodo("2025.1");
                turma6.setProfessor(prof6);
                turma6.setDisciplina(disc6);
                turmaRepository.save(turma6);

                Turma turma7 = new Turma();
                turma7.setAno("2025");
                turma7.setPeriodo("2025.1");
                turma7.setProfessor(prof7);
                turma7.setDisciplina(disc7);
                turmaRepository.save(turma7);

                Turma turma8 = new Turma();
                turma8.setAno("2025");
                turma8.setPeriodo("2025.1");
                turma8.setProfessor(prof8);
                turma8.setDisciplina(disc8);
                turmaRepository.save(turma8);

                // Criar inscrições
                Inscricao inscricao1 = new Inscricao();
                inscricao1.setDataHora(LocalDateTime.now().minusDays(30));
                inscricao1.setAluno(aluno1);
                inscricao1.setTurma(turma1);
                inscricaoRepository.save(inscricao1);

                Inscricao inscricao2 = new Inscricao();
                inscricao2.setDataHora(LocalDateTime.now().minusDays(25));
                inscricao2.setAluno(aluno2);
                inscricao2.setTurma(turma1);
                inscricaoRepository.save(inscricao2);

                Inscricao inscricao3 = new Inscricao();
                inscricao3.setDataHora(LocalDateTime.now().minusDays(20));
                inscricao3.setAluno(aluno1);
                inscricao3.setTurma(turma2);
                inscricaoRepository.save(inscricao3);

                Inscricao inscricao4 = new Inscricao();
                inscricao4.setDataHora(LocalDateTime.now().minusDays(15));
                inscricao4.setAluno(aluno3);
                inscricao4.setTurma(turma2);
                inscricaoRepository.save(inscricao4);

                Inscricao inscricao5 = new Inscricao();
                inscricao5.setDataHora(LocalDateTime.now().minusDays(10));
                inscricao5.setAluno(aluno4);
                inscricao5.setTurma(turma3);
                inscricaoRepository.save(inscricao5);

                // Turma 4 - com mais de 5 alunos
                Inscricao inscricao6 = new Inscricao();
                inscricao6.setDataHora(LocalDateTime.now().minusDays(5));
                inscricao6.setAluno(aluno1);
                inscricao6.setTurma(turma4);
                inscricaoRepository.save(inscricao6);

                Inscricao inscricao7 = new Inscricao();
                inscricao7.setDataHora(LocalDateTime.now().minusDays(5));
                inscricao7.setAluno(aluno2);
                inscricao7.setTurma(turma4);
                inscricaoRepository.save(inscricao7);

                Inscricao inscricao8 = new Inscricao();
                inscricao8.setDataHora(LocalDateTime.now().minusDays(4));
                inscricao8.setAluno(aluno5);
                inscricao8.setTurma(turma4);
                inscricaoRepository.save(inscricao8);

                Inscricao inscricao9 = new Inscricao();
                inscricao9.setDataHora(LocalDateTime.now().minusDays(4));
                inscricao9.setAluno(aluno6);
                inscricao9.setTurma(turma4);
                inscricaoRepository.save(inscricao9);

                Inscricao inscricao10 = new Inscricao();
                inscricao10.setDataHora(LocalDateTime.now().minusDays(3));
                inscricao10.setAluno(aluno7);
                inscricao10.setTurma(turma4);
                inscricaoRepository.save(inscricao10);

                Inscricao inscricao11 = new Inscricao();
                inscricao11.setDataHora(LocalDateTime.now().minusDays(3));
                inscricao11.setAluno(aluno8);
                inscricao11.setTurma(turma4);
                inscricaoRepository.save(inscricao11);

                // Turma 5
                Inscricao inscricao12 = new Inscricao();
                inscricao12.setDataHora(LocalDateTime.now().minusDays(8));
                inscricao12.setAluno(aluno3);
                inscricao12.setTurma(turma5);
                inscricaoRepository.save(inscricao12);

                Inscricao inscricao13 = new Inscricao();
                inscricao13.setDataHora(LocalDateTime.now().minusDays(7));
                inscricao13.setAluno(aluno9);
                inscricao13.setTurma(turma5);
                inscricaoRepository.save(inscricao13);

                // Turma 6
                Inscricao inscricao14 = new Inscricao();
                inscricao14.setDataHora(LocalDateTime.now().minusDays(2));
                inscricao14.setAluno(aluno4);
                inscricao14.setTurma(turma6);
                inscricaoRepository.save(inscricao14);

                Inscricao inscricao15 = new Inscricao();
                inscricao15.setDataHora(LocalDateTime.now().minusDays(2));
                inscricao15.setAluno(aluno10);
                inscricao15.setTurma(turma6);
                inscricaoRepository.save(inscricao15);

                // Turma 7
                Inscricao inscricao16 = new Inscricao();
                inscricao16.setDataHora(LocalDateTime.now().minusDays(1));
                inscricao16.setAluno(aluno5);
                inscricao16.setTurma(turma7);
                inscricaoRepository.save(inscricao16);

                Inscricao inscricao17 = new Inscricao();
                inscricao17.setDataHora(LocalDateTime.now().minusDays(1));
                inscricao17.setAluno(aluno6);
                inscricao17.setTurma(turma7);
                inscricaoRepository.save(inscricao17);

                // Turma 8
                Inscricao inscricao18 = new Inscricao();
                inscricao18.setDataHora(LocalDateTime.now());
                inscricao18.setAluno(aluno7);
                inscricao18.setTurma(turma8);
                inscricaoRepository.save(inscricao18);

                Inscricao inscricao19 = new Inscricao();
                inscricao19.setDataHora(LocalDateTime.now());
                inscricao19.setAluno(aluno8);
                inscricao19.setTurma(turma8);
                inscricaoRepository.save(inscricao19);

                Inscricao inscricao20 = new Inscricao();
                inscricao20.setDataHora(LocalDateTime.now());
                inscricao20.setAluno(aluno9);
                inscricao20.setTurma(turma8);
                inscricaoRepository.save(inscricao20);

                System.out.println("Dados de exemplo criados com sucesso!");
                System.out.println("- " + disciplinaRepository.count() + " disciplinas");
                System.out.println("- " + professorRepository.count() + " professores");
                System.out.println("- " + alunoRepository.count() + " alunos");
                System.out.println("- " + turmaRepository.count() + " turmas");
                System.out.println("- " + inscricaoRepository.count() + " inscrições");
        }
}
