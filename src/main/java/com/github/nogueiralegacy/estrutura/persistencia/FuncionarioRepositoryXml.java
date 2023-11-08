package com.github.nogueiralegacy.estrutura.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.nogueiralegacy.estrutura.domain.Funcionario;
import com.github.nogueiralegacy.estrutura.domain.repository.FuncionarioRepository;
import com.github.nogueiralegacy.estrutura.utils.Utils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class FuncionarioRepositoryXml implements FuncionarioRepository{
    static {
        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypesByWildcard(new String[] { 
            "com.nogueiralegacy.**"});
    }    

    private static final Path persistenciaPath = Paths.get(new Utils().getPath("").getParent().getParent().toString(), "persistencia");

    private static final XStream xstream = new XStream(new StaxDriver());

    static {
        xstream.allowTypesByWildcard(new String[] { 
            "com.github.**"});
    }

    @Override
    public void save(Funcionario funcionario) {
        Path filePath = Paths.get(persistenciaPath.toString(), funcionario.getCpf() + ".xml");

        String funcionarioXml = xstream.toXML(funcionario);

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath.toString()))){
            writter.write(funcionarioXml);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario findByCpf(String cpf) throws IOException {
        Path filePath = Paths.get(persistenciaPath.toString(), cpf + ".xml");
        Funcionario funcionario = null;

        StringBuilder sb = new StringBuilder();
        
        byte[] xmlBytes = Files.readAllBytes(filePath);
        sb.append(new String(xmlBytes, StandardCharsets.UTF_8));

        funcionario = (Funcionario) xstream.fromXML(sb.toString());

        
        return funcionario;
    }
    
}
