// 3.1.8. Conte o número de adições necessárias para computar fib(n) para 0 <= n <=
// 10, por meio dos métodos iterativo e recursivo. Existe algum tipo de padrão?



class Main {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();

        System.out.println("-----------------------------------");
        System.out.println("        FIBONACCI RECURSIVO        ");
        System.out.println("-----------------------------------");
        System.out.println("VALOR: " + fib.fibonacciRecursiva(10));
        System.out.println("Número de Adições: " + fib.contadorRecurs);
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("        FIBONACCI ITERATIVO        ");
        System.out.println("-----------------------------------");
        System.out.println("VALOR: " + fib.fibonacciIterativo(10));
        System.out.println("Número de Adições: " + fib.contadorIterativa);



    }
}