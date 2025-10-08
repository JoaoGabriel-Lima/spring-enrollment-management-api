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

                System.out.println("Dados de exemplo criados com sucesso!");
                System.out.println("- " + disciplinaRepository.count() + " disciplinas");
                System.out.println("- " + professorRepository.count() + " professores");
                System.out.println("- " + alunoRepository.count() + " alunos");
                System.out.println("- " + turmaRepository.count() + " turmas");
                System.out.println("- " + inscricaoRepository.count() + " inscrições");
        }
}
