int overload(mut int a, mut int b) {
    a = 3;
    b = 5;
    return a + b;
}

int main() {
    let mut int a = 4;
    let mut int b = 6;
    overload(a, b);
    println("%d", a);
    println("%d", b);
    return 0;
}
