declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"HI\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @say_hello_and_add(i32 %tmp0,i32 %tmp2) {
%tmp1 = alloca i32, align 4
store i32 %tmp0, i32* %tmp1, align 4
%tmp3 = alloca i32, align 4
store i32 %tmp2, i32* %tmp3, align 4
%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0))
%2 = load i32, i32* %tmp1, align 4
%3 = load i32, i32* %tmp3, align 4
%4 = add i32 %2, %3
ret i32 %4
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
