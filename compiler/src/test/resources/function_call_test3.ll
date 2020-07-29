declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"HI\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @say_hello_and_add(i32 %tmp0,i32 %tmp1) {
%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0))
%2 = alloca i32, align 4
store i32 %tmp0, i32* %2, align 4
%3 = alloca i32, align 4
store i32 %tmp1, i32* %3, align 4
%4 = load i32, i32* %2, align 4
%5 = load i32, i32* %3, align 4
%6 = add i32 %4, %5
ret i32 %6
}
define i32 @main() {
%1 = alloca i32, align 4
store i32 2, i32* %1, align 4
%2 = alloca i32, align 4
store i32 3, i32* %2, align 4
%3 = load i32, i32* %1, align 4
%4 = load i32, i32* %2, align 4
%5 = call i32 @say_hello_and_add(i32 %3,i32 %4)
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_2, i64 0, i64 0),i32 %5)
ret i32 0
}
