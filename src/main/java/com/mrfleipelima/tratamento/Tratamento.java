/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mrfleipelima.tratamento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Lima - https://github.com/mrfelipelima
 */

public class Tratamento {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ALUNO\\Documents\\Felipe\\Teste.txt"));
            PrintWriter pw = new PrintWriter("C:\\Users\\ALUNO\\Documents\\Felipe\\Tratado.txt");
            String string = "";
            
            while(br.ready()) {
                String line = br.readLine();
                // Todas as vezes que a linha começar com o caractere ">"
                if (line.startsWith(">")) {
                    // Vai salvar o conteúdo da varável 'string', adicionar uma quebra de linha
                    // e salvar o cabeçalho da string
                    pw.println(string + "\n" + line);
                    // Depois limpa o conteúdo da variável 'string'
                    string = "";
                  // Senão começar com o caractere ">"
                } else {
                    // Concatena as linhas na variável 'string'
                    string = string.concat(line);
                }
            }
            
            // Ao final do loop ainda resta na variável 'string' as últimas
            // linhas do arquivo que não foram salvas, por isso pedimos para salvar
            // o conteúdo da variável 'string' pela última vez
            pw.println(string);
            
            // Então fechamos o arquivo
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tratamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tratamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
