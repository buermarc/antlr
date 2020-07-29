declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @main() {
%1 = sub i32 3, 42
%2 = sub i32 %1, 5
%3 = sub i32 %2, 6
%4 = alloca i32, align 4
store i32 %3, i32* %4, align 4
%5 = load i32, i32* %4, align 4
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %5)
ret i32 0
}
