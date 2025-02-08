package model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    @Test
    public void testGetNome() {
        // Cria uma instância de Pessoa
        Pessoa pessoa = new Pessoa("João", LocalDate.of(1990, 5, 15));

        // Verifica se o nome está correto
        assertEquals("João", pessoa.getNome());
    }

    @Test
    public void testGetDataNascimento() {
        // Cria uma instância de Pessoa
        LocalDate dataNascimento = LocalDate.of(1990, 5, 15);
        Pessoa pessoa = new Pessoa("João", dataNascimento);

        // Verifica se a data de nascimento está correta
        assertEquals(dataNascimento, pessoa.getDataNascimento());
    }

    @Test
    public void testSetNome() {
        // Cria uma instância de Pessoa
        Pessoa pessoa = new Pessoa("João", LocalDate.of(1990, 5, 15));

        // Altera o nome
        pessoa.setNome("Maria");

        // Verifica se o nome foi alterado corretamente
        assertEquals("Maria", pessoa.getNome());
    }

    @Test
    public void testSetDataNascimento() {
        // Cria uma instância de Pessoa
        Pessoa pessoa = new Pessoa("João", LocalDate.of(1990, 5, 15));

        // Altera a data de nascimento
        LocalDate novaDataNascimento = LocalDate.of(2000, 10, 20);
        pessoa.setIdade(novaDataNascimento);

        // Verifica se a data de nascimento foi alterada corretamente
        assertEquals(novaDataNascimento, pessoa.getDataNascimento());
    }
}