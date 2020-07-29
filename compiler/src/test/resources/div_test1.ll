declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str_3 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @main() {
%1 = udiv i32 10, 2
%2 = alloca i32, align 4
store i32 %1, i32* %2, align 4
%3 = udiv i32 10, 3
%4 = alloca i32, align 4
store i32 %3, i32* %4, align 4
%5 = udiv i32 10, 4
%6 = alloca i32, align 4
store i32 %5, i32* %6, align 4
%7 = load i32, i32* %2, align 4
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %7)
%9 = load i32, i32* %4, align 4
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_2, i64 0, i64 0),i32 %9)
%11 = load i32, i32* %6, align 4
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_3, i64 0, i64 0),i32 %11)
ret i32 0
}
