package com.github.nogueiralegacy.estrutura.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.nogueiralegacy.estrutura.domain.Funcionario;
import com.github.nogueiralegacy.estrutura.domain.repository.FuncionarioRepository;
import com.github.nogueiralegacy.estrutura.utils.Utils;
import com.google.gson.Gson;
public class FuncionarioRepositoryJson implements FuncionarioRepository {
    Gson gson = new Gson();
    private static final Path persistenciaPath = Paths.get(new Utils().getPath("").getParent().getParent().toString(), "persistencia");

    @Override
    public void save(Funcionario funcionario) {
    Path filePath = Paths.get(persistenciaPath.toString(), funcionario.getCpf() + ".json");

    String funcionarioJson = gson.toJson(funcionario);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString()))) {
        writer.write(funcionarioJson);
    } catch (IOException e) {
        e.printStackTrace();
    }    
}



    @Override
    public Funcionario findByCpf(String cpf) throws IOException {
        Path filePath = Paths.get(persistenciaPath.toString(), cpf + ".json");
        Funcionario funcionario = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()))) {
            // Converter JSON para objeto Java
            funcionario = gson.fromJson(reader, Funcionario.class);

        } catch (IOException e) {
            e.printStackTrace();
        }    
        
        return funcionario;
    }
}
