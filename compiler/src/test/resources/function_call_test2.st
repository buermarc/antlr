int say_hello_and_add(int a, int b) {
    println("HI");
    return a + b;
}

int main() {
    int a;
    a = 2;
    int b = 3;
    println("%d", say_hello_and_add(a, b)); 
    return 0;
}
