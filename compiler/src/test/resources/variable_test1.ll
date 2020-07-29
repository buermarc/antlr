declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [21 x i8] c"a is %d and b is %d\0A\00"

define i32 @main() {
%1 = alloca i32, align 4
store i32 3, i32* %1, align 4
%2 = load i32, i32* %1, align 4
%3 = alloca i32, align 4
store i32 %2, i32* %3, align 4
%4 = load i32, i32* %3, align 4
%5 = add i32 %4, 1
store i32 %5, i32* %3, align 4
%6 = load i32, i32* %1, align 4
%7 = load i32, i32* %3, align 4
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([21 x i8], [21 x i8]* @.str_1, i64 0, i64 0),i32 %6,i32 %7)
ret i32 0
}
