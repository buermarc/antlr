declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @main() {
%1 = add i32 9, 3
%2 = sub i32 %1, 1
%3 = mul i32 %2, 4
%4 = udiv i32 %3, 2
%5 = alloca i32, align 4
store i32 %4, i32* %5, align 4
%6 = load i32, i32* %5, align 4
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %6)
ret i32 0
}
