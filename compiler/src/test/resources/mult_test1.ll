declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @main() {
%1 = mul i32 4, 3
%2 = mul i32 %1, 8
%3 = alloca i32, align 4
store i32 %2, i32* %3, align 4
%4 = load i32, i32* %3, align 4
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %4)
ret i32 0
}
