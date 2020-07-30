int say_hello_and_add(int a, int b) {
    println("HI");
    let int c = a;
    let int d = b;
    return c + d;
}

int main() {
    let mut int a;
    a = 2;
    let int b = 3;
    println("%d", say_hello_and_add(a, b)); 
    return 0;
}
