package org.example.task3;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class task3 {
    public static void main(String[] args) {
        Stack<Integer> ids = new Stack<>(); //Стек, который хранит значения id
        HashMap<Integer, String> results = new HashMap<>(); //Кеш значений value для каждого id

        Scanner in = new Scanner(System.in);

        String file1 = in.next();
        String file2 = in.next();
        String file3 = in.next();


        try (BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file3))) {

            handleFirstFile(br, ids, results);

            handleSecondFileAndWrite(br2, ids, results, bw);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleSecondFileAndWrite(BufferedReader bufferedReader, Stack<Integer> stack,
                                                 HashMap<Integer, String> hashMap, BufferedWriter bufferedWriter) throws IOException {
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (line.contains("\"id\"")) {
                stack.push(Integer
                        .parseInt(line.split(":")[1]
                                .replace(',', ' ')
                                .trim()));
            }
            if(line.contains("\"value\"")){
               line = line.replace("\"\"", "%s".formatted(hashMap.get(stack.pop())));   //Вставка в value json-значения результата тестирования для последнего id
            }

            bufferedWriter.write(line+"\n");
        }
    }

    private static void handleFirstFile(BufferedReader bufferedReader, Stack<Integer> stack,
                                        HashMap<Integer, String> hashMap) throws IOException {

        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (line.contains("\"id\"")) {
                stack.push(Integer          //Запись значения id в стек
                        .parseInt(line.split(":")[1]
                                .replace(',', ' ')
                                .trim()));
            }
            if(line.contains("\"value\"")){ //Запись значения id в кеш и удаление его из стека
                hashMap.put(stack.pop(),line.split(":")[1]
                        .replace(',', ' ')
                        .trim());
            }
        }
    }
}
