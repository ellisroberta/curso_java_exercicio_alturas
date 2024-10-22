package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int nmenores = 0;
        double alturatotal = 0.0;

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();
        sc.nextLine();  // Consumir a nova linha pendente
        Person[] vect = new Person[n];

        System.out.println();
        System.out.println("--- Pessoas ---");
        System.out.println();
        for (int i = 0; i < vect.length; i++) {
            System.out.printf("Dados da %da pessoa:\n", i + 1);
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.print("Altura: ");
            double height = sc.nextDouble();
            sc.nextLine();  // Consumir a nova linha pendente
            vect[i] = new Person(name, age, height);
        }

        for (int i = 0; i < n; i++) {
            if (vect[i].getAge() < 16) {
                nmenores++;
            }
            alturatotal += vect[i].getHeight();
        }

        double alturamedia = alturatotal / n;
        double percentualMenores = ((double) nmenores / n) * 100.0;

        System.out.printf("\nAltura media: %.2f\n", alturamedia);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentualMenores);

        if (nmenores > 0) {
            System.out.println("Nomes das pessoas com menos de 16 anos:");
            for (int i = 0; i < n; i++) {
                if (vect[i].getAge() < 16) {
                    System.out.printf("%s\n", vect[i].getName());
                }
            }
        } else {
            System.out.println("Nenhuma pessoa com menos de 16 anos.");
        }

        sc.close();
    }
}