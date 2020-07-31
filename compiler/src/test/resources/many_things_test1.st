int say_hello_and_add(int[] a, int b) {
    println("HI");
    return a[0] + b;
}

int main() {
    let mut int[10] i;
    i[0] = 3;
    let mut int a = 4;
    let int b = 3;
    println("%d", say_hello_and_add(i, b));
    if i[0] then {
        let int a = 5;
        println("%d\n^This should be 5", a);
    } else {
            a = 6;
    }
    println("%d\n^This should be 4 again", a);
    return a + i[0];
}
